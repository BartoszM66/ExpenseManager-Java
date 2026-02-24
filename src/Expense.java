public class Expense {
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
