package Entity;

import Values.Currencies;

import java.util.Map;

public class Wallet {

    private double balance;

    private long savedamount;

    private int valuesYuaninRupiah;

    public Wallet (){
    }

    public double getcoin() {
        return balance/10.000;
    }
    public double getBalanceinRupiah() {
        return balance;
    }

    public double getBalanceinYuan() {
        return balance/valuesYuaninRupiah;
    }

    public void setBalance(double balance, Currencies currencies) throws Exception {
        if (balance < 0) throw new Exception(" Coin can't be less than 0 !");
        else {
            if(currencies.equals(Currencies.RUPIAH)) this.balance = balance;
            else this.balance = balance * valuesYuaninRupiah;
        }
    }

    public long getSavedamount() {
        return savedamount;
    }

    public void setSavedamount(long savedamount) throws Exception {
        if (savedamount < 0) throw new Exception(" Coin can't be less than 0 !");
        else this.savedamount = savedamount;
    }

    public int getValuesYuaninRupiah() {
        return valuesYuaninRupiah;
    }

    public void setValuesYuaninRupiah(int valuesYuaninRupiah) throws Exception {

        if (valuesYuaninRupiah <= 0) throw new Exception(" Values Yuan in Rupiah must be greater than 0 !");
        else this.valuesYuaninRupiah = valuesYuaninRupiah;
    }

}
