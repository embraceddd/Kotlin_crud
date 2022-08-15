package com.example.kotlin_crud.entity

import javax.persistence.*

@Entity
@Table(name = "entity")
class TestEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    var sortedOrder: String? = null,

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "ownerEntity")
    var documents: List<DocumentEntity> = emptyList(),

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "ownerId")
    var dictionary: List<DictionaryEntity> = emptyList()
)