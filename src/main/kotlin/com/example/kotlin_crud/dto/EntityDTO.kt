package com.example.kotlin_crud.dto

data class EntityDTO(
    val id: Int,
    var documents: List<DocumentDTO> = emptyList(),
    var dictionary: List<DictionaryDTO> = emptyList()
)