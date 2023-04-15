//********************************//
//Name: Abdulaziz Mohammed Altamimi
//Email: ozyaltamimi261@gmail.com
//Section Number: ZA1 
//Assignment Title: Assignment 2
//ID : 1940715
//Date: 7/4/2020
//********************************//
package atmsimulation;

public class customer {

    private String accountNumber;
    private int pinNumber;
    private int arrivalTime;
    private int waitingTime;
    private int departureTime;
    private int amount;
    private String command;
    private customer next;

    public customer(String accountNumber, int pinNumber, int arrivalTime, int amount, String command) {
        this.accountNumber = accountNumber;
        this.pinNumber = pinNumber;
        this.arrivalTime = arrivalTime;
        this.amount = amount;
        this.command = command;
        this.next = null;
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

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public customer getNext() {
        return next;
    }

    public void setNext(customer next) {
        this.next = next;
    }

}
