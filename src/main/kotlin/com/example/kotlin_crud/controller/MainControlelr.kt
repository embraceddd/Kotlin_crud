package com.example.kotlin_crud.controller

import com.example.kotlin_crud.dto.EntityDTO
import com.example.kotlin_crud.service.EntityService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("kotlin/api")
class MainController(
    private val entityService: EntityService
) {

    @GetMapping
    fun getAll(): List<EntityDTO> =
        entityService.getAll()

    @PostMapping
    fun create(@RequestBody dto: EntityDTO): Int =
        entityService.create(dto)

    @PatchMapping("/update")
    fun update(@RequestParam("id") id: Int, @RequestBody dto: EntityDTO) =
        entityService.update(id, dto)

    @DeleteMapping("/delete")
    fun delete(@RequestParam("id") id: Int) =
        entityService.delete(id)
}