package by.arabienko.entity.impl;

import by.arabienko.entity.IBank;

import java.util.List;

public class Bank implements IBank, Cloneable {

    private String bankName;
    private List<Credit> credits;
    private static long counter = 0;
    private static long ID = counter++;

    public Bank(String bankName, List<Credit> credits) {
        this.bankName = bankName;
        this.credits = credits;
    }

    @Override
    public long getId() {
        return ID;
    }

    public String getBankName() {
        return bankName;
    }

    public List<Credit> getCredits() {
       List<Credit> creditCopy = List.copyOf(credits);
        return creditCopy;
    }

    public int getLengthListCredit(){
        return credits.size();
    }

    public void setCredits(List<Credit> credits) {
        this.credits = credits;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass()!=obj.getClass()) return false;
        Bank bank = (Bank) obj;
        if(((Bank) obj).getCredits() == null) return false;
        if(this.getLengthListCredit() != bank.getLengthListCredit()) return false;
        for (int i = 0; i< ((Bank) obj).getCredits().size(); i++){
            if(!this.getCredits().get(i).equals(bank.getCredits().get(i))){
                return false;
            }
        }
        return ((Bank) obj).getBankName().equals(bank.bankName);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bankName==null) ? 0:hashCode());
        result = prime * result + ((credits==null) ? 0:hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new
                StringBuilder("\nBank: " + bankName + " : \n");
        if (!credits.isEmpty()) {
            for (int i = 0; i < credits.size(); i++) {
                sb.append("Credit: " + credits.get(i));
                sb.append("\n");
            }
        } else sb.append("credit null");
        return sb.toString();
    }


}
