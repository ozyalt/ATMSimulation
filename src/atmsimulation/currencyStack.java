//********************************//
//Name: Abdulaziz Mohammed Altamimi
//Email: ozyaltamimi261@gmail.com
//Section Number: ZA1 
//Assignment Title: Assignment 2
//ID : 1940715
//Date: 7/4/2020
//********************************//
package atmsimulation;

public class currencyStack {

    private currency[] stack;
    private int top;
    private int maxSize;

    public currencyStack(int maxSize) {
        this.stack = new currency[maxSize];
        this.top = -1;
        this.maxSize = maxSize;
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public boolean isEmpty() {
        return (top == -1);
    }
    // Stack Helpers //

    public currency pop() {
        return stack[top--];
    }
    // Stack Helpers //

    public currency peek() {
        return stack[top];
    }
    // Stack Helpers //

    public void push(currency deto) {
        stack[++top] = deto;

    }
    // backdrop for Cash  //

    public int backdrop() {
        return top + 1;
    }

    // Push Value //
    public int ref(int val) {
        int x = 0;
        while (!this.isFull()) {
            this.push(new currency(val));
            x += val;
        }
        return x;
    }

    public void refer(int val, int count) {
         int i=0;
        while (i < count) {
            this.push(new currency(val));
            i++;
        }
    }

    // Pop count //
    public void takeOut(int count) {
        int i=0;

        while (i < count) {
            this.pop();
            i++;
        }

    }
}
