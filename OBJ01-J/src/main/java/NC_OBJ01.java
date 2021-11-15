import java.util.Scanner;

public class NC_OBJ01 {

    public int total; // Number of elements

    static void add() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter number you want to add from '1': ");
        int total = myObj.nextInt();  // Read user input

        if (total < Integer.MAX_VALUE) {
            total++;
            System.out.println("Your new total is " + total);
        } else {
            throw new ArithmeticException("Overflow");
        }
    }

    static void remove() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter number you want to remove from '1': ");
        int total = myObj.nextInt();  // Read user input

        if (total > 0) {
            total--;
            System.out.println("Your new total is -" + total);
        } else {
            throw new ArithmeticException("Overflow");
        }
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Would you like to add or subtract (A/S): ");
        String x = myObj.nextLine().toUpperCase();  // Read user input

        if (x.equals("A")) {
            add();
        } else if (x.equals("S")) {
            remove();
        } else {
            System.out.println("Unknown value");
        }
    }
}