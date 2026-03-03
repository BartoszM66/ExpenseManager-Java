package pl.BartoszM.expensemanager;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Locale;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Opis wydatku nie może być pusty!")
    private String description;

    @Positive(message = "Kwota wydatku musi być większa od zera!")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "0.00")
    private double amount;

    @NotBlank(message = "Kategoria wydatku nie może być pusta!")
    private String category;

    public Expense(String description, double amount, String category) {
        this.description = description;
        this.amount = amount;
        this.category = category;
    }

    @Override
    public String toString(){
        String sformatowanaKwota = String.format(Locale.US, "%.2f", amount);
        return "Opis: " + description + " | Kwota: " + sformatowanaKwota + " | Kategoria: " + category;
    }
}
