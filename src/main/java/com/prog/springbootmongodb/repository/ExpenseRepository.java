package com.prog.springbootmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.prog.springbootmongodb.model.Expense;

public interface ExpenseRepository extends MongoRepository<Expense, String>{

}
