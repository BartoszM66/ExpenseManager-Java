import java.util.Scanner;
import java.util.Locale;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        ExpenseRepository repository = new InMemoryExpenseRepository();
        ExpenseManager expenseManager = new ExpenseManager(repository);

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
