//********************************//
//Name: Abdulaziz Mohammed Altamimi
//Email: ozyaltamimi261@gmail.com
//Section Number: ZA1 
//Assignment Title: Assignment 2
//ID : 1940715
//Date: 7/4/2020
//********************************//

package atmsimulation;

import java.util.Random;

public class currency {
   int max=999999999;
   int min=1;
    private int serialNumber;
    private int value;
     
          



    public currency( int value) {
        this.serialNumber = (int)(Math.random() * 999999);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
     
        this.serialNumber = serialNumber;
         
    }
    
}

