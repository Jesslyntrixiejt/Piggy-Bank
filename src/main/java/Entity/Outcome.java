package Entity;

import Values.Category;

import java.time.LocalDate;

public class Outcome extends CashFlow {

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    private Category category;



    public Outcome (Category category, String description, double nominal, LocalDate date) throws Exception{

        super( description,nominal, date);



    }

}
