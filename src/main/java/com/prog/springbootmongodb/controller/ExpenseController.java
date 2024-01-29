package com.prog.springbootmongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prog.springbootmongodb.model.Expense;
import com.prog.springbootmongodb.service.ExpenseService;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {
	@Autowired
	private ExpenseService expenseService;

	@PostMapping
	public ResponseEntity addExpense(@RequestBody Expense expense) {
		expenseService.addExpense(expense);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping
	public ResponseEntity updateExpense(@RequestBody Expense expense) {
		expenseService.updateExpense(expense);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Expense>> getAllExpenses() {
		return ResponseEntity.ok(expenseService.getAllExpenses());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteExpense(@PathVariable String id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }
	
}
