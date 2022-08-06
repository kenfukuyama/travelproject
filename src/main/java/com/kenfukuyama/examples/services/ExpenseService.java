package com.kenfukuyama.examples.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.kenfukuyama.examples.models.Expense;
import com.kenfukuyama.examples.repositories.ExpenseRepo;

@Service
public class ExpenseService {
	private final ExpenseRepo expenseRepo;
	
	public ExpenseService(ExpenseRepo expenseRepo) {
		this.expenseRepo = expenseRepo;
	}
	
	public List<Expense> allExpenses() {
		return expenseRepo.findAll();
	}	
	
    public Expense createExpense(Expense expense) {
        return expenseRepo.save(expense);
    }
    
    
    // retrieves a expense
    public Expense findExpense(Long id) {
    	// Optional Expense that may or may not conatin Expense
        Optional<Expense> optionalExpense = expenseRepo.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }
    
    

    // udpated
    public Expense updateExpense(Expense expense) {
        return expenseRepo.save(expense);
    }
    
    
    // Delete a expense
    public void deleteExpense(Long id) {
    	expenseRepo.deleteById(id);
    	return;
    }
    
    
	
	
	

}
