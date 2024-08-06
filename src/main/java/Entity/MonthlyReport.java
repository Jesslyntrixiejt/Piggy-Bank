package Entity;

import Values.Month;
import Values.TransactionType;

import java.util.ArrayList;

public class MonthlyReport {
    private final Month month;
    private final ArrayList<ExpenseRecord> listOfExpenseRecords;
    private long totalIncome;

    public long getBalance() {
        return balance;
    }

    public long getTotalOutcome() {
        return totalOutcome;
    }

    public long getTotalIncome() {
        return totalIncome;
    }

    public ArrayList<ExpenseRecord> getListOfExpenseRecords() {
        return listOfExpenseRecords;
    }

    public Month getMonth() {
        return month;
    }

    private long totalOutcome;
    private long balance;

    public MonthlyReport (Month month){
        this.month = month;
        listOfExpenseRecords = new ArrayList<>();
        totalIncome=0;
        totalOutcome=0;
        balance = 0;
    }

    public void addRecord(ExpenseRecord expenseRecord) {
        listOfExpenseRecords.add(expenseRecord);

        if (expenseRecord.transactionType().equals(TransactionType.INCOME)) {
            countTotalIncome();
            balance += expenseRecord.nominal();
        }else {
            countTotalOutcome();
            balance -= expenseRecord.nominal();

        }
    }

    public void countTotalIncome(){
        long income = 0;
        for(ExpenseRecord e : listOfExpenseRecords){
            if (e.transactionType().equals(TransactionType.INCOME)){
                income += e.nominal();
            }
        }
        totalIncome = income;
    }

    public void countTotalOutcome(){
        long outcome = 0;
        for(ExpenseRecord e : listOfExpenseRecords){
            if (e.transactionType().equals(TransactionType.OUTCOME)){
                outcome += e.nominal();
            }
        }
        totalOutcome = outcome;
    }


}
