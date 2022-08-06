package com.kenfukuyama.examples.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kenfukuyama.examples.models.Expense;

public interface ExpenseRepo extends CrudRepository<Expense, Long>{
	List<Expense> findAll();

	

}
