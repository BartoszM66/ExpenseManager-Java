import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        return "Opis: " + description + " | Kwota: " + amount + " | Kategoria: " + category;
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
        Scanner sc = new Scanner(System.in);
        ExpenseManager expenseManager = new ExpenseManager();

        while(true){
            System.out.println("Podaj opis: ");
            String opis = sc.nextLine();
            if(opis.equals("X")){
                break;
            }
            System.out.println("Podaj kwotę: ");
            double kwota = sc.nextDouble();
            System.out.println("Podaj kategorię: ");
            String kategoria = sc.nextLine();

            expenseManager.addExpense(new Expense(opis, kwota, kategoria));
        }

    }
}
