import java.util.ArrayList;
import java.util.List;

public class InMemoryExpenseRepository implements ExpenseRepository {
    private List<Expense> expenses = new ArrayList<>();

    @Override
    public void save(Expense expense) {
        expenses.add(expense);
    }

    @Override
    public List<Expense> findAll() {
        return expenses;
    }
}
