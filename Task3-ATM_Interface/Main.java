import java.util.*;
 class ATM {
    static Scanner sc = new Scanner(System.in);
    static double balance = 50000.0; // Initial balance
    static int pin; // Account PIN

    public static void main(String[] args) {
        System.out.println("            ******ATM MACHINE******");
        System.out.println("[============================================]");
        System.out.println("|           Welcome to Your Account          |");
        System.out.println("[============================================]");

        // Set 4-digit PIN
        setPIN();


        // Authenticating user
        authenticateUser();

        // Main Opertions were to be performed from here
        while (true) {
            System.out.println("_________________________________________");
            System.out.println("Choose the Operation you want to Perform:");
            System.out.println(" 1. Withdraw Amount");
            System.out.println(" 2. Deposit Amount");
            System.out.println(" 3. Check Balance");
            System.out.println(" 4. Change PIN");
            System.out.println(" 5. Exit");
            System.out.println("_________________________________________");
            System.out.print("Enter Your Choice : ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    withdrawAmount();
                    break;
                case 2:
                    depositAmount();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    changePIN();
                    break;
                    
                case 5:
                    System.out.println("_________________________________________");
                    System.out.println("\n           **THANK YOU**");
                    System.out.println("_________________________________________");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to set 4-digit PIN
    public static void setPIN() {
        while (true) 
        {
            try{
                System.out.print("Set your 4-digit PIN: ");
                pin = sc.nextInt();
                if (pin >= 1000 && pin <= 9999) 
                {
                    break;
                 } else 
                {
                 System.out.println("Invalid PIN. Please enter a 4-digit PIN.");
                }
             }
        catch(NumberFormatException e) 
            {
                System.out.println("Invalid input. Please enter a valid 4-digit PIN.");
            }
    }
}

    // Method to authenticate user with 4-digit PIN
    public static void authenticateUser() {
        System.out.print("Enter your 4-digit PIN to Proceed: ");
        int userPIN = sc.nextInt();
        if (userPIN != pin) {
            System.out.println("Invalid PIN....");
            System.exit(0);
        }
    }

    // Method to withdraw amount
    public static void withdrawAmount()  
    {
        System.out.println("_________________________________________");
        System.out.print("Enter Your Amount: Rs.");
        double withdrawAmount = sc.nextDouble();

        if (withdrawAmount > 15000) 
        {
            System.out.println("Sorry, You can only withdraw upto Rs. 15000 in one transaction.");
        } else if (withdrawAmount > balance) {
            System.out.println("Sorry, Your account does not have sufficient balance.");
        }
         else 
         {
            System.out.println("\nPlease Wait! Your Transaction is Processing.");
            balance -= withdrawAmount;
            System.out.println("\t**Withdrawal Successful**");
            System.out.println(" _________________________________________");
            System.out.println("|                                         |");
            System.out.println( "|   Withdrawal Amount : Rs." + withdrawAmount + "        |");
            System.out.println( "|   Remaining Balance : Rs." + balance + "        |");
            System.out.println("|_________________________________________|");
        }
    }


    // Method to deposit amount
    public static void depositAmount() 
    {
        System.out.println("_________________________________________");
        System.out.print("Enter Your Amount: Rs.");
        double depositAmount = sc.nextDouble();
        if (depositAmount > 20000) {
            System.out.println("Sorry, You can only deposit up to Rs. 20000 in one transaction.");
        }
        else{
             balance += depositAmount;
             System.out.println("\nYour amount is deposited successfully!");
                System.out.println(" _________________________________________");
                 System.out.println("|                                         |");
                 System.out.println("|   Deposited Amount : Rs." + depositAmount + "         |");
                System.out.println("|   Total Balance : Rs." + balance + "            |");
                System.out.println("|_________________________________________|");
        }
    }

    // Method to check balance
    public static void checkBalance() 
    {
        System.out.println("  ________________________________________");
        System.out.println(" |      Your Balance : Rs. " + balance+    "        |");
        System.out.println(" |________________________________________|");
    }

    // Method to change 4-digit PIN
    public static void changePIN() {
        while (true) {
            try {
                    System.out.print("Enter your new 4-digit PIN: ");
                    int newPIN = sc.nextInt();

                    if (newPIN >= 1000 && newPIN <= 9999)
                     {
                        pin = newPIN;
                        System.out.println("PIN changed successfully!");
                        break;
                     } 
                     else 
                     {
                        System.out.println("Invalid PIN. Please enter a 4-digit PIN.");
                        System.out.println("_________________________________________");
                     }
                }
                catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid 4-digit PIN.");
                    sc.next(); 
                }
        
    }
}
 }

