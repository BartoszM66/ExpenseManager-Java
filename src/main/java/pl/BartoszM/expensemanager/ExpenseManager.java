package pl.BartoszM.expensemanager;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ExpenseManager{
    private ExpenseRepository expenseRepository;
    
    public ExpenseManager(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    public void addExpense(Expense expense){
        expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    }

    public double sumTotalExpenses(){
        List<Expense> expenses = expenseRepository.findAll();
        double total = 0;
        for(Expense expense : expenses){
            total += expense.getAmount();
        }
        return total;
    }

    public void deleteExpense(Long id){
        expenseRepository.deleteById(id);
    }

    public void updateExpense(Long id, Expense updatedExpense){
        Expense existingExpense = expenseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Nie znaleziono wydatku o ID: " + id));

        existingExpense.setDescription(updatedExpense.getDescription());
        existingExpense.setAmount(updatedExpense.getAmount());
        existingExpense.setCategory(updatedExpense.getCategory());

        expenseRepository.save(existingExpense);
    }
}
