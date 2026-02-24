import java.util.ArrayList;
import java.util.List;

class Expense {
    private String description;
    private double amount;
    private String category;

    public Expense(String description, double amount, String category) {
        this.description = description;
        this.amount = amount;
        this.category = category;
    }

    public double getAmount(){
        return amount;
    }

    @Override
    public String toString(){
        return "Opis: " + description + "| Kwota: " + amount + "| Kategoria: " + category;
    }
}

class ExpenseManager{
    private List<Expense> expenses = new ArrayList<>();

    public void addExpense(Expense expense){
        expenses.add(expense);
    }

    public void displayAllExpenses(){
        for(Expense expense : expenses){
            System.out.println(expense);
        }
    }

    public double sumTotalExpenses(){
        double total = 0;
        for(Expense expense : expenses){
            total += expense.getAmount();
        }
        return total;
    }
}
public class Main{
    public static void main(String[] args){
        ExpenseManager expenseManager = new ExpenseManager();

        expenseManager.addExpense(new Expense("Paliwo", 124.40, "Wydatki"));
        expenseManager.addExpense(new Expense("Strój", 550.00, "Wydatki"));
        expenseManager.addExpense(new Expense("Samochód", 12050.00, "Wydatki"));
        expenseManager.addExpense(new Expense("Narzędzia", 970.00 , "Wydatki"));

        System.out.println("--- Lista wydatków ---");
        expenseManager.displayAllExpenses();

        System.out.println("\n--- Podsumowanie ---");
        System.out.println("Suma całkowita: " + expenseManager.sumTotalExpenses());
    }
}
