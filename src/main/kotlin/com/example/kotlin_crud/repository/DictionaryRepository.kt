package com.example.kotlin_crud.repository;

import com.example.kotlin_crud.entity.DictionaryEntity
import com.example.kotlin_crud.entity.TestEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

interface DictionaryRepository : CrudRepository<DictionaryEntity, Int> {
    fun deleteAllByOwnerId(entity: TestEntity)
}