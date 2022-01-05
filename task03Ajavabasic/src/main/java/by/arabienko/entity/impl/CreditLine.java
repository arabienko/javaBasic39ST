package by.arabienko.entity.impl;

import java.util.Objects;

public class CreditLine extends Credit {

    private String name;
    private String purposeLoan;
    private double rate;
    private int term;
    private String borrower;
    private int amount;
    private String specialConditions;
    private boolean repayment;
    private String getMoney;


    public CreditLine(String name, String purposeLoan, double rate,
                      int term, String borrower, int amount) {
        super(name, purposeLoan, rate, term, borrower, amount);
    }

    public CreditLine(boolean repayment, String specialConditions,
                      int amount, String name, String purposeLoan,
                      double rate, int term, String borrower, String getMoney) {
        super(name, purposeLoan, rate, term, borrower, amount);
        this.specialConditions = specialConditions;
        this.repayment = repayment;
        this.getMoney = getMoney;
    }

/*
    public String getSpecialConditions() {
        return specialConditions;
    }
*/
    /*public void setSpecialConditions(String specialConditions) {
        this.specialConditions = specialConditions;
    }*/
/*
    public String getGetMoney() {
        return getMoney;
    }
*/
    /*public void setGetMoney(String getMoney) {
        this.getMoney = getMoney;
    }*/

    @Override
    public double monthlyPayment() {
        return ((amount * rate / 100) + amount) / term / 12;
    }

    @Override
    public String toString() {
        return "CreditLine{" +
                "name='" + name + '\'' +
                ", purposeLoan='" + purposeLoan + '\'' +
                ", rate=" + rate +
                ", term=" + term +
                ", borrower='" + borrower + '\'' +
                ", amount=" + amount +
                ", specialConditions='" + specialConditions + '\'' +
                ", repayment=" + repayment +
                ", getMoney='" + getMoney + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this==o) return true;
        if (o==null || getClass()!=o.getClass()) return false;
        if (!super.equals(o)) return false;
        CreditLine that = (CreditLine) o;
        return Double.compare(that.rate, rate)==0 &&
                term==that.term && amount==that.amount &&
                repayment==that.repayment &&
                Objects.equals(name, that.name) &&
                Objects.equals(purposeLoan, that.purposeLoan) &&
                Objects.equals(borrower, that.borrower) &&
                Objects.equals(specialConditions, that.specialConditions) &&
                Objects.equals(getMoney, that.getMoney);
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),
                name, purposeLoan, rate, term,
                borrower, amount, specialConditions,
                repayment, getMoney);
    }
}
