package com.gray.safetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gray.safetravels.models.Expense;
import com.gray.safetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	/*
	 ********************************
	 **************DATA**************
	 ********************************
	 */
	//get all
	public List<Expense> findAllExpenses() {
		return expenseRepository.findAll();
	}
	//get one by ID
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else return null;
	}
	//create one
	public Expense createExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	//update one by ID
	public Expense updateExpense(Expense expense) {	
		return expenseRepository.save(expense);
	}
	//delete one by ID
	public void deleteExpense(Long id) {
		expenseRepository.deleteById(id);
	}
}
