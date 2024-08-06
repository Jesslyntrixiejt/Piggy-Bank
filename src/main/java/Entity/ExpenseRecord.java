package Entity;

import Values.Category;
import Values.TransactionType;

import java.time.LocalDate;

public record ExpenseRecord(Category category,TransactionType transactionType,long nominal,String description,LocalDate date) {
    public ExpenseRecord {
        if (nominal <= 0) try {
            throw new Exception("Your Nominal must be greater than 0!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (description.length()> 100) try {
            throw new Exception("The Description cannot exceed 100 characters!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

//public class ExpenseRecord {
//    private Category category;
//    private TransactionType transactionType;
//    private long nominal;
//    private String description;
//    private LocalDate date;
//
//    public ExpenseRecord (Category category,TransactionType transactionType,long nominal,String description,LocalDate date) throws Exception {
//        setCategory(category);
//        setTransactionType(transactionType);
//        setNominal(nominal);
//        setDescription(description);
//        setDate(date);
//    }
//
//    public Category getCategory() {
//        return category;
//    }
//
//    private void setCategory(Category category) {
//        this.category = category;
//    }
//
//    public TransactionType getTransactionType() {
//        return transactionType;
//    }
//
//    private void setTransactionType(TransactionType transactionType) {
//        this.transactionType = transactionType;
//    }
//
//    public long getNominal() {
//        return nominal;
//    }
//
//    private void setNominal(long nominal) throws Exception {
//        if (nominal <= 0) throw new Exception("Your Nominal must be greater than 0!");
//        else this.nominal = nominal;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    private void setDescription(String description) throws Exception{
//       if (description.length()> 100) throw new Exception("The Description cannot exceed 100 characters!");
//           else this.description = description;
//    }
//
//    public LocalDate getDate() {
//        return date;
//    }
//
//    private void setDate(LocalDate date) throws Exception {
//        this.date = date;
//    }
//
//
//}
