package Entity;

import Values.Month;

import java.util.ArrayList;

public class YearlyReport {
    private final short year;
    private final ArrayList<MonthlyReport>listofMonthlyReport;

    public YearlyReport(short year){
        this.year= year;
        listofMonthlyReport = new ArrayList<>();
    }

    public long getTotalIncome(){
        long totalIncome = 0;
        for (MonthlyReport m : listofMonthlyReport) totalIncome += m.getTotalIncome();
        return totalIncome;
    }

    public long getTotalOutcome(){
        long totalOutcome = 0;
        for (MonthlyReport m : listofMonthlyReport) totalOutcome += m.getTotalOutcome();
        return totalOutcome;
    }

    public long remainingBalance (){
        return getTotalIncome()-getTotalOutcome();
    }

    public void addMonthlyReport(Month month){
        boolean alreadyExist = false;

        for(MonthlyReport m : listofMonthlyReport){
            if(m.getMonth().equals(month)){
                alreadyExist = true;
                break;
            }
        }

        if (!alreadyExist){
            listofMonthlyReport.add(new MonthlyReport(month));
        }
    }

    public ArrayList<MonthlyReport> getListofMonthlyRecord() {
        return listofMonthlyReport;
    }

    public short getYear() {
        return year;
    }


}
