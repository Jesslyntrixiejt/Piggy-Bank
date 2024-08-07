package Entity;

import java.time.LocalDate;

public class Income extends CashFlow {

    public Income (String description, double nominal, LocalDate date) throws Exception {
        super(description, nominal, date);
    }

}
