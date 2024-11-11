package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class WithdrawalTransaction2 extends ConcreteBaseTransaction {

    public WithdrawalTransaction2(int amount, @NotNull Calendar date) {

        super(amount, date);
    }

    private boolean checkDepositAmount(int amt) {
        if (amt < 0) {
            return false;
        } else {
            return true;
        }
    }

    // Method to reverse the transaction
    public void reverse(BankAccount ba) {
        double curr_balance = ba.getBalance();
        double new_balance = curr_balance + getAmount();
        ba.setBalance(new_balance);

    } // return true if reversal was successful

    // Method to print a transaction receipt or details
    public void printTransactionDetails() {
        System.out.println("Deposit Transaction: " + this.toString());
    }

    /*
    Opportunity for assignment: implementing different form of withdrawal
     */

    public void apply(BankAccount ba) throws InsufficientFundsException {
        double curr_balance = ba.getBalance();

        if (curr_balance < getAmount()) {
            throw new InsufficientFundsException("Attempted to withdraw " + getAmount() + ", but only " + curr_balance + " is available.");
        }

        // Only execute if there are sufficient funds
        double new_balance = curr_balance - getAmount();
        ba.setBalance(new_balance);
    }

    public void apply(BankAccount ba, Boolean negative_balance) throws InsufficientFundsException{
        double curr_balance = ba.getBalance();
        double new_balance = 0;
        double amountNotWithdrawn = 0;

        try {
            if ( curr_balance <= 0 && negative_balance){
                throw new InsufficientFundsException("Attempted to withdraw" + getAmount() + ", but you balance is 0 or below 0");
            } else if (curr_balance  < getAmount()) {
                ba.setBalance(new_balance );
                amountNotWithdrawn = getAmount() - curr_balance;
            } else {
                new_balance = curr_balance - getAmount();
                ba.setBalance(new_balance);
            }
        } catch (InsufficientFundsException e){
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Transaction completed. Current balance: " + ba.getBalance());
            if (amountNotWithdrawn > 0) {
                System.out.println("Amount not withdrawn: " + amountNotWithdrawn);
            }
        }

    }

    /*
    Assignment 1 Q3: Write the Reverse method - a method unique to the WithdrawalTransaction Class
     */
}

