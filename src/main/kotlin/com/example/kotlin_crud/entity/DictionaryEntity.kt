package com.example.kotlin_crud.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "dictionary")
class DictionaryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    val dictionaryValueName: UUID,

    @ManyToOne
    @JoinColumn(name = "entity_id")
    val ownerId: TestEntity
)