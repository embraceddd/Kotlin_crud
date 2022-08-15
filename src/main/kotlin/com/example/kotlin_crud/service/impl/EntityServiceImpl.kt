package com.example.kotlin_crud.service.impl

import com.example.kotlin_crud.dto.DictionaryDTO
import com.example.kotlin_crud.dto.DocumentDTO
import com.example.kotlin_crud.dto.EntityDTO
import com.example.kotlin_crud.entity.DictionaryEntity
import com.example.kotlin_crud.entity.DocumentEntity
import com.example.kotlin_crud.entity.TestEntity
import com.example.kotlin_crud.repository.DictionaryRepository
import com.example.kotlin_crud.repository.DocumentRepository
import com.example.kotlin_crud.repository.EntityRepository
import com.example.kotlin_crud.service.EntityService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EntityServiceImpl(
    private val entityRepository: EntityRepository,
    private val documentRepository: DocumentRepository,
    private val dictionaryRepository: DictionaryRepository
) : EntityService {

    override fun getAll(): List<EntityDTO> =
        entityRepository.findAll().map { it.toDto() }

    @Transactional
    override fun create(dto: EntityDTO): Int {
        val entity = entityRepository.save(dto.toEntity())
        documentRepository.saveAll(dto.documents.map { it.toEntity(entity) })
        dictionaryRepository.saveAll(dto.dictionary.map { it.toEntity(entity) })
        return entity.id
    }

    @Transactional
    override fun update(id: Int, dto: EntityDTO): Int {
        val currentEntity = entityRepository.findById(id).get()
        val documents = dto.documents.map { it.toEntity(currentEntity) }
        val dictionary = dto.dictionary.map { it.toEntity(currentEntity) }
        documentRepository.deleteAllByOwnerEntity(currentEntity)
        dictionaryRepository.deleteAllByOwnerId(currentEntity)

        documentRepository.saveAll(documents)
        dictionaryRepository.saveAll(dictionary)
        return id
    }

    @Transactional
    override fun delete(id: Int): Int {
        entityRepository.deleteById(id);
        return id
    }

    private fun EntityDTO.toEntity(): TestEntity =
        TestEntity(
            id = 0,
        )

    private fun TestEntity.toDto(): EntityDTO =
        EntityDTO(
            id = 0,
            documents = this.documents.map { it.toDto() },
            dictionary = this.dictionary.map { it.toDto() }
        )

    private fun DocumentEntity.toDto(): DocumentDTO =
        DocumentDTO(
            id = 0,
            date = this.date
        )

    private fun DictionaryEntity.toDto(): DictionaryDTO =
        DictionaryDTO(
            id = 0,
            dictionaryValueName = this.dictionaryValueName
        )

    private fun DocumentDTO.toEntity(owner: TestEntity): DocumentEntity =
        DocumentEntity(
            id = 0,
            date = this.date,
            ownerEntity = owner
        )

    private fun DictionaryDTO.toEntity(owner: TestEntity): DictionaryEntity =
        DictionaryEntity(
            id = 0,
            dictionaryValueName = this.dictionaryValueName,
            ownerId = owner
        )
}