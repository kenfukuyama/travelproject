package com.kenfukuyama.examples.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kenfukuyama.examples.models.Expense;
import com.kenfukuyama.examples.services.ExpenseService;

@Controller
public class ExpenseController {

    // ! intialization of service
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }


    // ! home route
    @GetMapping("")
    public String index() {
        return "redirect:/expenses";
    }

    // ! GetExpenses
    @GetMapping("/expenses")
    public String expenses(@ModelAttribute("expense") Expense expense, Model model) {
        List<Expense> expenses = expenseService.allExpenses();
        model.addAttribute("expenses", expenses);
        return "expenses.jsp";

    }

    // ! POST expenses
    @PostMapping("/expenses")
    public String expenseCreate(@Valid @ModelAttribute("expense") Expense expense,
            BindingResult result) {

        if (result.hasErrors()) {
            return "expenses.jsp";
        }

        expenseService.createExpense(expense);
        return "redirect:/expenses";

    }

    // ! edit show page
    @GetMapping("/expenses/{id}/edit")
    public String ExpenseEdit(@PathVariable("id") Long id, Model model) {
        Expense expense = expenseService.findExpense(id);
        model.addAttribute("expense", expense);
        System.out.println(model.getAttribute("expense"));
        return "expenseEdit.jsp";
    }

    // ! GET show route
    @GetMapping("/expenses/{id}")
    public String expenseShow(@PathVariable("id") Long id, Model model) {

        Expense expense = expenseService.findExpense(id);

        model.addAttribute("expense", expense);
        return "expenseShow.jsp";
    }

    // ! PUT nedit  request
    @RequestMapping(value = "/expenses/{id}", method = RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
        if (result.hasErrors()) {
            return "expenseEdit.jsp";
        } else {
            expenseService.updateExpense(expense);
            return "redirect:/expenses";
        }

    }

    // ! DELETE delte route
    @RequestMapping(value = "/expenses/{id}", method = RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        expenseService.deleteExpense(id);
        return "redirect:/expenses";
    }

}
