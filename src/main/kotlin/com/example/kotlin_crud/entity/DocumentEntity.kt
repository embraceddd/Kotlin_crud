package com.example.kotlin_crud.entity

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "documents")
class DocumentEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    var date: Date? = null,

    @ManyToOne
    @JoinColumn(name = "entity_id")
    val ownerEntity: TestEntity
    )