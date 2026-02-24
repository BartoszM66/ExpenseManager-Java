import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;

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
        String sformatowanaKwota = String.format("%.2f", amount);
        return "Opis: " + description + " | Kwota: " + sformatowanaKwota + " | Kategoria: " + category;
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
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        ExpenseManager expenseManager = new ExpenseManager();

        while(true){
            System.out.println("Podaj opis (lub 'X' aby zakończyć): ");
            String opis = sc.nextLine();
            if(opis.equalsIgnoreCase("X")){
                break;
            }
            System.out.println("Podaj kwotę: ");
            String kwotaTekst = sc.nextLine();
            double kwota = Double.parseDouble(kwotaTekst.replace(',','.'));
            System.out.println("Podaj kategorię: ");
            String kategoria = sc.nextLine();

            expenseManager.addExpense(new Expense(opis, kwota, kategoria));
            System.out.println("--- Dodano wydatek ---");
        }

        System.out.println("--- Lista wydatków ---");
        expenseManager.displayAllExpenses();
        System.out.println("\n--- Całkowita kwota ---");
        double suma = expenseManager.sumTotalExpenses();
        System.out.println(String.format(Locale.US,"Suma: %.2f PLN", suma));
    }
}
