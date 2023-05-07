package com.gray.safetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gray.safetravels.models.Expense;

@Repository
public interface ExpenseRepository  extends CrudRepository<Expense, Long>{
	//grab all
	List<Expense> findAll();
	//all other methods needed come from CrudRepository for free

}
