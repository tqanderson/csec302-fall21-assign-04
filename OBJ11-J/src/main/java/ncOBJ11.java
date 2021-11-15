import java.util.Scanner;

public class ncOBJ11 {

    public static class BankOperations {
        public BankOperations() {
            if (!performSSNVerification()) {
                throw new SecurityException("Access Denied!");
            }
        }

        private boolean performSSNVerification() {
            return false; // Returns true if data entered is valid, else false
            // Assume that the attacker always enters an invalid SSN
        }

        public void greet() {
            System.out.println("Welcome user! You may now use all the features.");
        }
    }

    public class Storage {
        private static BankOperations bop;

        public static void store(BankOperations bo) {
            // Store only if it is initializeds
            if (bop == null) {
                if (bo == null) {
                    System.out.println("Invalid object!");
                    System.exit(1);
                }
                bop = bo;
            }
        }
    }

    public class UserApp {
        public static void main(String[] args) {
            BankOperations bo;
            try {
                bo = new BankOperations();
            } catch (SecurityException ex) { bo = null; }

            Storage.store(bo);
            System.out.println("Proceed with normal logic");
        }
    }

    public static class Interceptor extends BankOperations {
        private static Interceptor stealInstance = null;

        public static Interceptor get() {
            try {
                new Interceptor();
            } catch (Exception ex) {/* Ignore exception */}
            try {
                synchronized (Interceptor.class) {
                    while (stealInstance == null) {
                        System.gc();
                        Interceptor.class.wait(10);
                    }
                }
            } catch (InterruptedException ex) { return null; }
            return stealInstance;
        }

        protected void finalize() {
            synchronized (Interceptor.class) {
                stealInstance = this;
                Interceptor.class.notify();
            }
            System.out.println("Stole the instance in finalize of " + this);
        }
    }

    public class AttackerApp { // Invoke class and gain access
        // to the restrictive features
        public static void main(String[] args) {
            Interceptor i = Interceptor.get(); // Stolen instance

            // Can store the stolen object even though this should have printed
            // "Invalid Object!"
            Storage.store(i);

            // Now invoke any instance method of BankOperations class
            i.greet();

            UserApp.main(args); // Invoke the original UserApp
        }
    }
}
