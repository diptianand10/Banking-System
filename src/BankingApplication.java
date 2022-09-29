import java.util.Scanner;  
class BankDetails {  
    String account_no;  
    String account_name;  
    String account_type;  
    long account_balance;  
    long previousTransaction;
    Scanner sc = new Scanner(System.in);  

    public void createAccount() {  
        System.out.print("Enter Account number: "); 
        account_no = sc.next();  
        System.out.print("Enter Account type: ");  
        account_type = sc.next();  
        System.out.print("Enter Account name: ");  
        account_name = sc.next();  
        System.out.print("Enter Account balance: ");  
        account_balance = sc.nextLong();  
    }  
      
    public void showAccount() {  
        System.out.println("Account no.: " + account_no); 
        System.out.println("Account type: " + account_type);
        System.out.println("Name of account holder: " + account_name);     
        System.out.println("Balance: " + account_balance);  
    }  

    public boolean searchAccount(String acc_no) {  
        if (account_no.equals(acc_no)) {  
            showAccount();  
            return true;  
        }  
        return false;
    }  
      
    public void depositAmount() {  
        long amount;  
        System.out.println("Enter the amount you want to deposit: ");  
        amount = sc.nextLong();  
        account_balance = account_balance + amount;  
        previousTransaction = amount;
    }  
   
    public void withdrawAmount() {  
        long amount;  
        System.out.println("Enter the amount you want to withdraw: ");  
        amount = sc.nextLong();  
        if (account_balance >= amount) {  
            account_balance = account_balance - amount;  
            previousTransaction = -amount;
            System.out.println("Balance after withdrawal: " + account_balance);  
        } else {  
            System.out.println("Transaction failed...!!Your balance amount is less than " + amount);  
        }  
    }  

    public void getPreviousTransaction() {
		if(previousTransaction > 0) {
			System.out.println("Deposited Amount: " + previousTransaction);
		}
		else if(previousTransaction < 0) {
			System.out.println("Withdrawal Amount: " +Math.abs(previousTransaction));
		}
		else {
			System.out.println("No Transaction");
		}
	}
    
}  
public class BankingApplication
{  
    public static void main(String arg[]) 
    {  
        Scanner sc = new Scanner(System.in);  
        try{
            System.out.print("Enter number of customers: ");  
            int n = sc.nextInt();  
            BankDetails a[] = new BankDetails[n];  
            for (int i = 0; i < a.length; i++) 
            {  
                a[i] = new BankDetails();  
                a[i].createAccount();  
            }  
            int ch;  
            do {  
                System.out.println("\n ********Banking System Application********");  
                System.out.println("1. Display all account details\n 2. Search by Account number\n 3. Deposit the amount\n 4. Withdraw the amount\n 5.Previous transaction\n 6. Exit");  
                System.out.println("Enter your choice: ");  
                ch = sc.nextInt();  
                    switch (ch) {  
                        case 1:  
                            for (int i = 0; i < a.length; i++) {  
                                a[i].showAccount();  
                            }  
                            break;  
                        case 2:  
                            System.out.print("Enter account no. you want to search: ");  
                            String ac_no = sc.next();  
                            boolean found = true;  
                            for (int i = 0; i < a.length; i++) {  
                                found = a[i].searchAccount(ac_no);  
                                if (found) {  
                                    break;  
                                }  
                            }  
                            if (!found) {  
                                System.out.println("Account doesn't exist..");  
                            }  
                            break;  
                        case 3:  
                            System.out.print("Enter account no. you want to search: ");  
                            ac_no = sc.next();  
                            found = true;  
                            for (int i = 0; i < a.length; i++) {  
                                found = a[i].searchAccount(ac_no);  
                                if (found) {  
                                    a[i].depositAmount();  
                                    break;  
                                }  
                            }  
                            if (!found) {  
                                System.out.println("Account doesn't exist..");  
                            }  
                            break;  
                        case 4:  
                            System.out.print("Enter account no. you want to search: ");  
                            ac_no = sc.next();  
                            found = true;  
                            for (int i = 0; i < a.length; i++) {  
                                found = a[i].searchAccount(ac_no);  
                                if (found) {  
                                    a[i].withdrawAmount();  
                                    break;  
                                }  
                            }  
                            if (!found) {  
                                System.out.println("Account doesn't exist..");  
                            }  
                            break;  
                        case 5:
                            System.out.print("Enter account no. you want to search: ");
                            ac_no = sc.next();
                            found = true;
                            for (int i = 0; i < a.length; i++) {  
                                found = a[i].searchAccount(ac_no);  
                                if (found) {  
                                    a[i].getPreviousTransaction();  
                                    break;  
                                }  
                            }  
                            if (!found) {  
                                System.out.println("Account doesn't exist..");  
                            }  
                            break; 
                        case 6:  
                            System.out.println("Thank you for using our services...");  
                            break;  
                        default:
                            System.out.println("Invalid option...");
                    }  
                }  
                while (ch != 6); 
        }
        finally
        {
            sc.close();
        }
    }  
}  