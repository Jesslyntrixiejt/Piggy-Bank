package Entity;

import Values.Month;
import Values.TransactionType;

import java.util.ArrayList;

public class MonthlyReport {
    private final Month month;
    private final ArrayList<CashFlow> listOfExpenseRecords;
    private double totalIncome;

    public double getBalance() {
        return balance;
    }

    public double getTotalOutcome() {
        return totalOutcome;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public ArrayList<CashFlow> getListOfExpenseRecords() {
        return listOfExpenseRecords;
    }

    public Month getMonth() {
        return month;
    }

    private double totalOutcome;
    private double balance;

    public MonthlyReport (Month month){
        this.month = month;
        listOfExpenseRecords = new ArrayList<>();
        totalIncome=0;
        totalOutcome=0;
        balance = 0;
    }

    public void addRecord(CashFlow cashFlow) {
        listOfExpenseRecords.add(cashFlow);

        if (cashFlow instanceof Income) {
            countTotalIncome();
            balance += cashFlow.getNominal();
        }else {
            countTotalOutcome();
            balance -= cashFlow.getNominal();

        }
    }

    public void countTotalIncome(){
        double income = 0;
        for(CashFlow e : listOfExpenseRecords){
            if (e instanceof Income){
                income += e.getNominal();
            }
        }
        totalIncome = income;
    }

    public void countTotalOutcome(){
        double outcome = 0;
        for(CashFlow e : listOfExpenseRecords){
            if (e instanceof Outcome){
                outcome += e.getNominal();
            }
        }
        totalOutcome = outcome;
    }


}
