package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class DepositTransaction2 extends ConcreteBaseTransaction {
    /**
     * Lecture1_adt.TransactionInterface Constructor
     *
     * @param amount in an integer
     * @param date   : Not null, and must be a Calendar object
     * @return void
     * Instialises the field, attributes of a transaction
     * Creates a object of this
     */
    public DepositTransaction2(int amount, @NotNull Calendar date) {
        super(amount, date);
    }


    private boolean checkDepositAmount(int amt){
        if (amt < 0){
            return false;
        }
        else{
            return  true;
        }
    }

    // Method to print a transaction receipt or details
    public void printTransactionDetails(){
        System.out.println("Deposit Trasaction: "+this.toString());
    }

    @Override
    public void apply(BankAccount ba){
        double curr_balance = ba.getBalance();
        double new_balance = curr_balance + getAmount();
        ba.setBalance(new_balance);
    }
}
