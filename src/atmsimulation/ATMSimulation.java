//********************************//
//Name: Abdulaziz Mohammed Altamimi
//Email: ozyaltamimi261@gmail.com
//Section Number: ZA1 
//Assignment Title: Assignment 2
//ID : 1940715
//Date: 7/4/2020
//********************************//
package atmsimulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

public class ATMSimulation {

    public static void main(String[] args) throws FileNotFoundException {

        // Main // 
        File file = new File("ATMSimulation.txt");
        if (!file.exists()) {
            System.out.println("File Not availble");
            System.exit(0);
        }
        File fileo = new File("ATMSimulations.txt");
        PrintWriter printer = new PrintWriter(fileo);

        Scanner SC = new Scanner(file);
        // Stack of Caash And Link List Nodes //
        accounts llnode = new accounts();
        ATMQueues atm = new ATMQueues();
        ATMQueues atmos = new ATMQueues();
        currencyStack fifty = new currencyStack(200);
        currencyStack onehandredy = new currencyStack(200);
        currencyStack fivehundredy = new currencyStack(200);
        String inpute;

        do {
            inpute = SC.next();
            if (inpute.equals("ADDACCOUNT")) {
                String accountNumber = SC.next();
                int pinNumber = SC.nextInt();
                int balance = SC.nextInt();
                llnode.insert(accountNumber, pinNumber, balance);
                printer.println("Account created with account number " + accountNumber + " with " + balance + " SAR initial balance.");

            } else {

                int arrivalTime = SC.nextInt();
                String accountNumber = SC.next();
                int pinNumber = SC.nextInt();
                int amount = SC.nextInt();
                atmos.enqueue(accountNumber, pinNumber, arrivalTime, amount, inpute);
            }
            System.out.println("this is insert method ");
            for (int i = 10 ; i < arrivalTime; i++) {
                if(arrivalTime ==< notaamt s );
                
                
            }
        } while (SC.hasNext());

        int finalDepartureTime = 0;
        int TimeforService;
        while (!atmos.isEmpty()) {

            atm.enqueuetwo(atmos.dequeue());
            customer botler = atm.peek();
            // Switch for All ATM Function //         
            switch (botler.getCommand()) {
                case "DEPOSIT":
                    TimeforService = 5;
                    TimePrinter(botler, TimeforService, finalDepartureTime, printer);
                    depositCash(botler, llnode, fivehundredy, onehandredy, fifty, printer);
                    break;
                case "WITHDRAW":
                    TimeforService = 2;
                    TimePrinter(botler, TimeforService, finalDepartureTime, printer);
                    withdrawCash(botler, llnode, fivehundredy, onehandredy, fifty, printer);
                    break;
                case "BALANCE":
                    TimeforService = 1;
                    TimePrinter(botler, TimeforService, finalDepartureTime, printer);
                    balance(botler, llnode, printer);
                    break;
                case "REFILL":
                    TimeforService = 20;
                    TimePrinter(botler, TimeforService, finalDepartureTime, printer);
                    refillPrint(fivehundredy, onehandredy, fifty, printer, botler);
                    break;

            }
            finalDepartureTime = botler.getDepartureTime();

            atm.dequeue();
        }
        printer.close();

    }
    // Print Overall Time Method //

    public static void TimePrinter(customer zix, int TimeforService, int finalDepartureTime, PrintWriter printer) {
        zix.setWaitingTime(finalDepartureTime - zix.getArrivalTime());
        if (zix.getWaitingTime() < 0) {
            zix.setWaitingTime(0);
        }
        zix.setDepartureTime(zix.getArrivalTime() + zix.getWaitingTime() + TimeforService);
        printer.println("-------------------------------------------------");
        printer.printf("The customer arrived at %02d:%02d\n", (zix.getArrivalTime() / 60), (zix.getArrivalTime() % 60));
        printer.println("The customer waited for " + zix.getWaitingTime() + " minutes");
        printer.printf("The customer departed at %02d:%02d\n", (zix.getDepartureTime() / 60), (zix.getDepartureTime() % 60));
    }
    // Method to see Balance //

    public static void balance(customer zix, accounts list, PrintWriter printer) {
        account alpha = list.SearchWord(zix.getAccountNumber());
        if (alpha == null || (zix.getPinNumber() != alpha.getPinNumber())) {
            printer.println("Invalid Pin");
        } else {
            printer.println("Balance of the account number " + alpha.getAccountNumber() + " is " + alpha.getBalance());

        }
    }
    // Print Refill Amount for ATM Method //

    public static void refillPrint(currencyStack fivehundred, currencyStack onehandredy, currencyStack fifty, PrintWriter printer, customer zix) {
        int amountPlaced;
        printer.println("The status of three currency stacks is as follows: ");
        printer.println(fivehundred.backdrop() + " x 500");
        printer.println(onehandredy.backdrop() + " x 100");
        printer.println(fifty.backdrop() + " x 50");
        amountPlaced = fivehundred.ref(500);
        amountPlaced += onehandredy.ref(100);
        amountPlaced += fifty.ref(50);
        printer.println("The total amount refilled is " + amountPlaced);

    }
    // Deposit Cash to ATM Method //

    public static void depositCash(customer zix, accounts list, currencyStack fivehundred, currencyStack onehandredy, currencyStack fifty, PrintWriter printer) {
        account beta = list.SearchWord(zix.getAccountNumber());
        if (beta == null) {
            printer.println("Invalid Pin");
            return;
        }
        if (zix.getPinNumber() == beta.getPinNumber() && zix.getAmount() % 50 == 0) {
            int fiveHun = zix.getAmount() / 500;
            int oneHun = (zix.getAmount() - fiveHun * 500) / 100;
            int fift = (zix.getAmount() - (fiveHun * 500) - oneHun * 100) / 50;
            if (fivehundred.backdrop() + fiveHun <= 200 && onehandredy.backdrop() + oneHun <= 200 && fifty.backdrop() + fift <= 200) {
                fivehundred.refer(500, fiveHun);
                onehandredy.refer(100, oneHun);
                fifty.refer(50, fift);
                beta.setBalance(zix.getAmount() + beta.getBalance());
                printer.println(zix.getAmount() + " SAR successfully deposited  into the account number " + beta.getAccountNumber());
                printer.println("The amount includes " + fiveHun + " x 500 + " + oneHun + " x 100 + " + fift + " x 50");
                printer.println("The new balance is " + beta.getBalance());
                return;
            }
            printer.println("Amount cannot be deposited at current time");
        }
    }
    // Withdraw Cash From ATM Method //

    public static void withdrawCash(customer zix, accounts list, currencyStack fivehundred, currencyStack onehandredy, currencyStack fifty, PrintWriter printer) {
        account beta = list.SearchWord(zix.getAccountNumber());
        if (zix.getPinNumber() == beta.getPinNumber() && zix.getAmount() % 50 == 0 && zix.getAmount() <= beta.getBalance() && zix.getAmount() <= 5000) {
            int fiveHun = zix.getAmount() / 500;
            int oneHun = (zix.getAmount() - fiveHun * 500) / 100;
            int fift = (zix.getAmount() - (fiveHun * 500) - oneHun * 100) / 50;
            
            if (fivehundred.backdrop() - fiveHun >= 0 && onehandredy.backdrop() - oneHun >= 0 && fifty.backdrop() - fift >= 0) {
                fivehundred.takeOut(fiveHun);
                onehandredy.takeOut(oneHun);
                fifty.takeOut(fift);
                beta.setBalance(beta.getBalance() - zix.getAmount());
                printer.println(zix.getAmount() + " SAR withdrawn from the account number " + beta.getAccountNumber());
                printer.println("The amount includes " + fiveHun + " x 500 + " + oneHun + " x 100 + " + fift + " x 50");
                printer.println("The new balance is " + beta.getBalance());
            }
        }
        

    }
}
