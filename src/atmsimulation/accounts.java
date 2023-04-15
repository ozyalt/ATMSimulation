//********************************//
//Name: Abdulaziz Mohammed Altamimi
//Email: ozyaltamimi261@gmail.com
//Section Number: ZA1 
//Assignment Title: Assignment 2
//ID : 1940715
//Date: 7/4/2020
//********************************//
package atmsimulation;

public class accounts {

    private account head;

    public accounts() {
        this.head = null;
    }

    public void insert(String data, int dota, int doby) {
        head = insert(head, data, dota, doby);

    }

    // ********* Allows us the insert words in the LinkList ********* //
    private account insert(account head, String data, int dota, int doby) {

        if (head == null) {
            head = new account(data, dota, doby, head);
            return head;
        } else {
            account helpPtr = head;
            while (helpPtr.getNext() != null) {

                helpPtr = helpPtr.getNext();
            }
            account newNode = new account(data, dota, doby, helpPtr.getNext());
            helpPtr.setNext(newNode);
        }
        return head;

    }

    public void delete(String word) {
        head = delete(head, word);
    }
    // ********* Allows us the Delete words in the LinkList ********* //

    private account delete(account head, String data) {
        if (head == null) {
            return head;
        } else {
            account helPtr = head;
            while (helPtr.getNext() != null) {
                if (helPtr.getNext().getAccountNumber().equals(data)) {
                    helPtr.setNext(helPtr.getNext().getNext());
                }
                helPtr = helPtr.getNext();
            }
            return head;
        }
    }
    // ********* Search   ********* //

    public boolean search(String word) {
        account helPtr = head;
        while (helPtr != null) {
            if (helPtr.getAccountNumber().equals(word)) {
                return true;
            }
            helPtr = helPtr.getNext();
        }
        return false;
    }

    public account SearchWord(String word) {
        account helPtr = head;
        while (helPtr != null) {
            if (helPtr.getAccountNumber().equals(word)) {
                return helPtr;
            }
            helPtr = helPtr.getNext();
        }
        return null;

    }
}
