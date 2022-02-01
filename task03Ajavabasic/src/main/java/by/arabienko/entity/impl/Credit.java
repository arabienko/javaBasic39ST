package by.arabienko.entity.impl;

import by.arabienko.entity.ICredit;

import java.util.Objects;

/**
 *
 */
public class Credit implements ICredit {

    private String name;
    private String purposeLoan;
    private double rate;
    private int term;
    private String borrower;
    private int amount;

    public Credit(String name, String purposeLoan,
                  double rate, int term,
                  String borrower, int amount) {
        this.name = name;
        this.purposeLoan = purposeLoan;
        this.rate = rate;
        this.term = term;
        this.borrower = borrower;
        this.amount = amount;
    }
    @Override
    public double monthlyPayment() {
        return ((amount * rate / 100) + amount) / term / 12;
    }
    public String getName() {
        return name;
    }
    public String getPurposeLoan() {
        return purposeLoan;
    }
    public String getBorrower() {
        return borrower;
    }
    public double getAmount() {
       return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getRate() {
        return rate;
    }

    public int getTerm() {
        return term;
    }
    @Override
    public String toString() {
        return "Credit{ " +
                "name= " + name + '\'' +
                ", purpose ='" + purposeLoan
                + '\'' +
                ", rate= " + rate +
                ", borrower= " + borrower +
                ", term= " + term +
                ", amount= " + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this==o) return true;
        if (o==null || getClass()!=o.getClass()) return false;
        Credit credit = (Credit) o;
        return Double.compare(credit.rate, rate)==0
                && term==credit.term
                && amount==credit.amount
                && Objects.equals(name, credit.name)
                && Objects.equals(purposeLoan, credit.purposeLoan)
                && Objects.equals(borrower, credit.borrower);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, purposeLoan,
                rate, term, borrower, amount);
    }
}
