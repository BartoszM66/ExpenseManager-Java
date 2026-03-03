package pl.BartoszM.expensemanager;

import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
public class ExpenseController {
    private final ExpenseManager expenseManager;

    public ExpenseController(ExpenseManager expenseManager) {
        this.expenseManager = expenseManager;
    }

    @GetMapping("/expenses")
    public List<Expense> getExpenses() {
        return expenseManager.getAllExpenses();
    }

    @PostMapping("/expenses")
    public void addExpense(@Valid @RequestBody Expense expense) {
        expenseManager.addExpense(expense);
    }

    @DeleteMapping("/expenses/{id}")
    public void deleteExpense(@PathVariable Long id){
        expenseManager.deleteExpense(id);
    }

    @PutMapping("/expenses/{id}")
    public void updateExpense(@PathVariable Long id, @Valid @RequestBody Expense expense) {
        expenseManager.updateExpense(id, expense);
    }
}
