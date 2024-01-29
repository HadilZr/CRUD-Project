package com.prog.springbootmongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog.springbootmongodb.model.Expense;
import com.prog.springbootmongodb.repository.ExpenseRepository;

@Service
public class ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;
	
	public void addExpense (Expense expense) {
		expenseRepository.insert(expense);
	}
	public void updateExpense(Expense expense) {
        Expense savedExpense = expenseRepository.findById(expense.getId()).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Expense by ID %s", expense.getId())));
        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());
        savedExpense.setExpenseAmount(expense.getExpenseAmount());
 
        expenseRepository.save(expense);
    }
	public List<Expense> getAllExpenses(){
		return expenseRepository.findAll();
	}
	public void deleteExpense(String id) {
        expenseRepository.deleteById(id);
    }
}
