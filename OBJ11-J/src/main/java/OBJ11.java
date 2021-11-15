public class OBJ11 {
    public final class BankOperations {
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
        private static ncOBJ11.BankOperations bop;

        public static void store(ncOBJ11.BankOperations bo) {
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
            ncOBJ11.BankOperations bo;
            try {
                bo = new ncOBJ11.BankOperations();
            } catch (SecurityException ex) {
                bo = null;
            }

            ncOBJ11.Storage.store(bo);
            System.out.println("Proceed with normal logic");
        }
    }

    public static class Interceptor extends ncOBJ11.BankOperations {
        private static Interceptor stealInstance = null;

        public static Interceptor get() {
            try {
                new ncOBJ11.Interceptor();
            } catch (Exception ex) {/* Ignore exception */}
            try {
                synchronized (ncOBJ11.Interceptor.class) {
                    while (stealInstance == null) {
                        System.gc();
                        ncOBJ11.Interceptor.class.wait(10);
                    }
                }
            } catch (InterruptedException ex) {
                return null;
            }
            return stealInstance;
        }

        protected void finalize() {
            synchronized (ncOBJ11.Interceptor.class) {
                stealInstance = this;
                ncOBJ11.Interceptor.class.notify();
            }
            System.out.println("Stole the instance in finalize of " + this);
        }
    }

    public class AttackerApp { // Invoke class and gain access
        // to the restrictive features
        public static void main(String[] args) {
            ncOBJ11.Interceptor i = ncOBJ11.Interceptor.get(); // Stolen instance

            // Can store the stolen object even though this should have printed
            // "Invalid Object!"
            ncOBJ11.Storage.store(i);

            // Now invoke any instance method of BankOperations class
            i.greet();

            ncOBJ11.UserApp.main(args); // Invoke the original UserApp
        }
    }
}
