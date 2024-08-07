package Entity;

import java.time.LocalDate;

public abstract class CashFlow {

    private String description;
    private double nominal;
    private LocalDate date;

    public CashFlow (String description, double nominal, LocalDate date) throws Exception {
        setDescription(description);
        setNominal(nominal);
        setDate(date);
    }
    public double getNominal() {
        return nominal;
    }

    private void setNominal(double nominal) throws Exception {
        if (nominal <= 0) throw new Exception("Your Nominal must be greater than 0!");
        else this.nominal = nominal;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) throws Exception{
       if (description.length()> 100) throw new Exception("The Description cannot exceed 100 characters!");
           else this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    private void setDate(LocalDate date) throws Exception {
        this.date = date;
    }
}
