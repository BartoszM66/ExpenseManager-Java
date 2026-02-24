import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileExpenseRepository implements ExpenseRepository {
    private static final String FILE_NAME = "expenses_data.csv";

    @Override
    public void save(Expense expense){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))){
            String liniaDoZapisu = expense.getDescription()+";"+expense.getAmount()+";"+expense.getCategory();
            writer.write(liniaDoZapisu);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Expense> findAll() {
        List<Expense> expenses = new ArrayList<>();
        Path path = Paths.get(FILE_NAME);

        if(!Files.exists(path)){
            return expenses;
        }

        try {
            List<String> lines = Files.readAllLines(path);

            for(String line : lines){
                String[] parts = line.split(";");
                Double amount = Double.parseDouble(parts[1]);
                Expense expense = new Expense(parts[0],amount,parts[2]);
                expenses.add(expense);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return expenses;
    }
}
