//********************************//
//Name: Abdulaziz Mohammed Altamimi
//Email: ozyaltamimi261@gmail.com
//Section Number: ZA1 
//Assignment Title: Assignment 2
//ID : 1940715
//Date: 7/4/2020
//********************************//
package atmsimulation;

public class account {

    private String accountNumber;
    private int pinNumber;
    private int balance;
    private account next;

    public account(String accountNumber, int pinNumber, int balance, account next) {
        this.accountNumber = accountNumber;
        this.pinNumber = pinNumber;
        this.balance = balance;
        this.next = next;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public account getNext() {
        return next;
    }

    public void setNext(account next) {
        this.next = next;
    }

}
