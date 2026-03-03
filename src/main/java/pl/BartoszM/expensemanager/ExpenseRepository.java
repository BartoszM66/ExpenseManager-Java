package pl.BartoszM.expensemanager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
