package com.example.kotlin_crud.service

import com.example.kotlin_crud.dto.EntityDTO

interface EntityService {
    fun getAll(): List<EntityDTO>
    fun create(dto: EntityDTO): Int
    fun update(id: Int, dto: EntityDTO): Int
    fun delete(id: Int): Int
}