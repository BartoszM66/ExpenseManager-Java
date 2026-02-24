import java.util.Scanner;
import java.util.Locale;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        ExpenseRepository repository = new FileExpenseRepository();
        ExpenseManager expenseManager = new ExpenseManager(repository);
        Integer opcjaInt;

        while(true) {
            System.out.println("\n--- MENU ---");
            System.out.println("Wybierz numer, aby wybrać działanie!");
            System.out.println("1. Dodaj wydatki.");
            System.out.println("2. Wyświetl wydatki.");
            System.out.println("3. Zakończ.");
            System.out.println("Wybierz numer: ");
            while (true){
                String input = sc.nextLine();
                try{
                    opcjaInt = Integer.parseInt(input);
                    break;
                } catch (NumberFormatException e){
                    System.out.println("To nie jest poprawna liczba! Spróbuj ponownie.");
                }
            }

            if(opcjaInt==1) {
                while(true){
                    System.out.println("Podaj opis (lub 'X' aby zakończyć): ");
                    String opis = sc.nextLine();
                    if(opis.equalsIgnoreCase("X")){
                        break;
                    }
                    System.out.println("Podaj kwotę: ");
                    double kwota;
                    while (true){
                        String kwotaTekst = sc.nextLine();
                        try{
                            kwota = Double.parseDouble(kwotaTekst.replace(',','.'));
                            break;
                        } catch (NumberFormatException e){
                            System.out.println("To nie jest poprawna liczba! Spróbuj ponownie.");
                        }
                    }
                    System.out.println("Podaj kategorię: ");
                    String kategoria = sc.nextLine();

                    expenseManager.addExpense(new Expense(opis, kwota, kategoria));
                    System.out.println("--- Dodano wydatek ---");
                }
            }
            else if(opcjaInt==2) {
                System.out.println("--- Lista wydatków ---");
                expenseManager.displayAllExpenses();
                System.out.println("\n--- Całkowita kwota ---");
                double suma = expenseManager.sumTotalExpenses();
                System.out.println(String.format(Locale.US,"Suma: %.2f PLN", suma));
            }
            else if(opcjaInt==3){
                System.out.println("Program kończy działanie.");
                break;
            }
            else{
                System.out.println("Wybierz poprawny numer.");
            }
        }
    }
}
