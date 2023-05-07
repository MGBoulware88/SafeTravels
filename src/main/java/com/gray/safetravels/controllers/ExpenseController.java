package com.gray.safetravels.controllers;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gray.safetravels.models.Expense;
import com.gray.safetravels.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {
	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("")
	public String index(Model model, @ModelAttribute("expense") Expense expense) {
		List<Expense> allExpenses = expenseService.findAllExpenses();
		//format the amount to two decimal places using DecimalFormat
		DecimalFormat df = new DecimalFormat("#.00");
		model.addAttribute("df", df);
		model.addAttribute("allExpenses", allExpenses);
		return "index.jsp";
	}
	//POST for adding a new Expense
	@PostMapping("/create")
	public String createExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("expense", expense);
			List<Expense> allExpenses = expenseService.findAllExpenses();
			//format the amount to two decimal places using DecimalFormat
			DecimalFormat df = new DecimalFormat("#.00");
			model.addAttribute("df", df);
			model.addAttribute("allExpenses", allExpenses);
			return "index.jsp";
		}
		expenseService.createExpense(expense);
		return "redirect:/expenses";
	}
	//VIEW an Expense
	@GetMapping("/{id}")
	public String showExpense(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		//format the amount to two decimal places using DecimalFormat
		DecimalFormat df = new DecimalFormat("#.00");
		model.addAttribute("df", df);
		model.addAttribute("expense", expense);
		return "show.jsp";
	}
	
	//DELETE an Expense
	@DeleteMapping("/delete/{id}")
	public String deleteExpense(@PathVariable("id") Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/expenses";
	}
	// form to edit an Expense 
	@GetMapping("/edit/{id}")
	public String editForm(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
		}
	//PUT to update an existing Expense
	@PutMapping("/{id}")
	public String editExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("expense", expense);
			return "edit.jsp";
		} else {
			expenseService.updateExpense(expense);
			return "redirect:/expenses";
		}
		
	}
}
