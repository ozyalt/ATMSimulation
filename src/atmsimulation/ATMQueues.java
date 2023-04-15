//********************************//
//Name: Abdulaziz Mohammed Altamimi
//Email: ozyaltamimi261@gmail.com
//Section Number: ZA1 
//Assignment Title: Assignment 2
//ID : 1940715
//Date: 7/4/2020
//********************************//
package atmsimulation;

public class ATMQueues {

    private customer front;
    private customer back;

    public ATMQueues() {
        this.front = null;
        this.back = null;
    }

    public boolean isEmpty() {
        return front == null;
    }
    // Inside Q //

    public void enqueue(String accountNumber, int pinNumber, int arrivalTime, int amount, String command) {
        if (isEmpty()) {
            front = enqueue(front, back, accountNumber, pinNumber, arrivalTime, amount, command);
            back = front;
        } else {
            back = enqueue(front, back, accountNumber, pinNumber, arrivalTime, amount, command);
        }

    }

    private customer enqueue(customer front, customer back, String accountNumber, int pinNumber, int arrivalTime, int amount, String command) {

        customer temper = new customer(accountNumber, pinNumber, arrivalTime, amount, command);

        if (isEmpty()) {
            return temper;
        } else {
            back.setNext(temper);
            back = back.getNext();
            return back;
        }
    }

    // Inside Q //
    public void enqueuetwo(customer zix) {
        if (isEmpty()) {
            front = zix;
            back = front;
        } else {
            back.setNext(zix);
            back = back.getNext();
        }

    }

    public customer dequeue() {
        customer temper = front;
        front = dequeue(front);
        if (front == null) {
            back = null;
        }
        return temper;
    }
    // Outside Q //

    private customer dequeue(customer front) {
        front = front.getNext();
        return front;
    }
    // Peek //

    public customer peek() {
        return front;

    }

}
