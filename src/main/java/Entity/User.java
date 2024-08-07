package Entity;

import javafx.scene.image.Image;

public class User {

    private String firstname;

    private String lastname;

    private String password;

    private Wallet wallet;

    private Image profilepicture;

    private double target;

    private String quotes;

    public User (String firstname, String lastname, String password, Image profilepicture, double target) throws Exception {
        setFirstname(firstname);
        setLastname(lastname);
        setPassword(password);
        setProfilepicture(profilepicture);
        setTarget(target);
        setWallet(new Wallet());
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) throws Exception {

            if (firstname.length() > 12) throw new Exception ("First name can't be exceed 12 characters !");
            else if (firstname.contains(" ")) throw new Exception ("First name can't contain white space !");
            else this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) throws Exception {

        if(firstname.length() > 12) throw new Exception ("Last name can't be exceed 12 characters !");
        else if (firstname.contains(" ")) throw new Exception ("Last name can't contain white space !");
        else this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) throws Exception {

       if(wallet == null) throw new Exception(" Wallet can't be null !");
       else  this.wallet = wallet;
    }

    public Image getProfilepicture() {
        return profilepicture;
    }

    public void setProfilepicture(Image profilepicture) {

        if(profilepicture == null) this.profilepicture = new Image("/Assets/Image/Image_defaultProfile.png");
        else this.profilepicture = profilepicture;
    }

    public double getTarget() {
        return target;
    }

    public void setTarget(double target) throws Exception {

        if(target <= 0) throw new Exception(" Target must be greater than 0 !");
        else this.target = target;
    }

    public String getQuotes() {
        return quotes;
    }

    public void setQuotes(String quotes) {
        this.quotes = quotes;
    }

}
