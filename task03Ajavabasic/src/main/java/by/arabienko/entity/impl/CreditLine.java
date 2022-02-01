package by.arabienko.entity.impl;

import java.util.Objects;

public class CreditLine extends Credit {

    private String specialConditions;
    private boolean repayment;
    private String getMoney;

    public CreditLine(String name, String purposeLoan,
                      double rate, int term, String borrower,
                      int amount) {
        super(name, purposeLoan,
                rate, term,
                borrower, amount);
    }

    public CreditLine(boolean repayment, String specialConditions,
                      int amount, String name, String purposeLoan,
                      double rate, int term, String borrower,
                      String getMoney) {
        super(name, purposeLoan, rate, term, borrower, amount);
        this.specialConditions = specialConditions;
        this.repayment = repayment;
        this.getMoney = getMoney;
    }

    @Override
    public double monthlyPayment() {
        return ((super.getAmount()
                * super.getRate() / 100)
                + super.getAmount())
                / super.getTerm() / 12;
    }

    @Override
    public String toString() {
        return "CreditLine{" +
                super.toString() +
                ", specialConditions='"
                + specialConditions + '\'' +
                ", repayment=" + repayment +
                ", getMoney='" + getMoney + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this==o) return true;
        if (o==null
                || getClass()!=o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        CreditLine that =
                (CreditLine) o;
        return super.equals(this)
                && Objects.equals(specialConditions,
                        that.specialConditions)
                && Objects.equals(getMoney,
                        that.getMoney);
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),
                specialConditions,
                repayment, getMoney);
    }
}
