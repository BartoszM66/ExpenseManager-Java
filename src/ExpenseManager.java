import java.util.List;

public class ExpenseManager{
    private ExpenseRepository expenseRepository;
    
    public ExpenseManager(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    public void addExpense(Expense expense){
        expenseRepository.save(expense);
    }

    public void displayAllExpenses(){
        List<Expense> expenses = expenseRepository.findAll();
        for(Expense expense : expenses){
            System.out.println(expense);
        }
    }

    public double sumTotalExpenses(){
        List<Expense> expenses = expenseRepository.findAll();
        double total = 0;
        for(Expense expense : expenses){
            total += expense.getAmount();
        }
        return total;
    }
}
