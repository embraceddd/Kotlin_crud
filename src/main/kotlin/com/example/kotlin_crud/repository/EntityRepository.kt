package com.example.kotlin_crud.repository;

import com.example.kotlin_crud.entity.TestEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

interface EntityRepository : CrudRepository<TestEntity, Int>