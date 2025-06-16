import java.util.Scanner;
import java.util.ArrayList;

public class Menu {

    public static void greetings(User currentUser) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nHello " + currentUser.getName() + ",");
        int a;
        if("Account Holder".equals(currentUser.getType()))
            a = 1;
        else if("Bank Officer".equals(currentUser.getType()))
            a = 2;
        else if("Finance Officer".equals(currentUser.getType()))
            a = 3;
        else      //loan officer
            a = 4;

        switch(a){
            case 1:
                AccountHolder ah = (AccountHolder) currentUser;
                int b;
                do{
                    System.out.println("1. Deposit Money");
                    System.out.println("2. Withdraw Money");
                    System.out.println("3. See Balance");
                    System.out.println("4. Add Tabung Account");
                    System.out.println("5. Transfer to Tabung");
                    System.out.println("6. Transfer from Tabung");
                    System.out.println("7. Loan Application");
                    System.out.println("8. View Transaction History");
                    System.out.println("9. Exit");
                    System.out.println("Choose: ");
                    b = scan.nextInt();

                    switch(b){
                        case 1:
                            System.out.println("Enter amount: ");
                            double amt1 = scan.nextDouble();
                            ah.depositToMain(amt1);
                            break;
                        case 2:
                            System.out.println("Enter amount: ");
                            double amt2 = scan.nextDouble();
                            ah.withdrawFromMain(amt2);
                            break;
                        case 3:
                            System.out.println("Account Balance: "+ah.getMainBalance());
                            break;
                        case 4:
                            //ah.addTabungAccount(tabung);
                            break;
                        case 5:
                            System.out.println("Enter amount: ");
                            double amt3 = scan.nextDouble();
                            //ah.transferToTabung(tabungID, amt3);
                            break;
                        case 6:
                            System.out.println("Enter amount: ");
                            double amt4 = scan.nextDouble();
                            //ah.transferFromTabung(tabungID, amt4);
                            break;
                        case 7:
                            //loan
                            break;
                        case 8:
                            ah.viewTransactionHistory();
                            break;
                        case 9:
                            System.out.println("Exiting...");
                            break;
                        default:
                            System.out.println("Error");
                    }
                } while (b!=9);

                break;

            case 2:
                int c;
                do{ 
                    System.out.println("1. Register Account");
                    System.out.println("2. Exit");
                    System.out.println("Choose: ");
                    c = scan.nextInt();

                    switch(c){
                        case 1:
                            break;
                        case 2:
                            System.out.println("Exiting...");
                            break;
                        default:
                            System.out.println("Error");
                    }
                } while (c!=2);

                break;

            case 3:
                FinanceOfficer fo = (FinanceOfficer) currentUser;
                int d;
                do{
                    System.out.println("1. Set Dividend");
                    System.out.println("2. Generate Report");
                    System.out.println("3. Exit");
                    System.out.println("Choose: ");
                    d = scan.nextInt();

                    switch(d){
                        case 1:
                            fo.setDivRate();
                            break;
                        case 2:
                            //fo.processDiv(); //bankAccount list dlm kurungan?
                            break;
                        case 3:
                            System.out.println("Exiting...");
                            break;
                        default:
                            System.out.println("Error");
                    }

                }while(d!=3);

                break;

            case 4:
                //LoanOfficer lo = (LoanOfficer) currentUser;  //extend User kat loanofficer
                int e;
                do {
                    System.out.println("1. Approve Loan");
                    System.out.println("2. Reject Loan");
                    System.out.println("3. Process Loan");
                    System.out.println("4. Exit");
                    System.out.println("Choose: ");
                    e = scan.nextInt();

                    switch(e){
                        case 1:

                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            System.out.println("Exiting...");
                            break;
                        default:
                            System.out.println("Error");
                    }

                } while (e!=4);

                break;

            default:
                System.out.println("Error");
        }
        

        scan.close();
    }

    public void greetings(SystemAdmin currentUser) {
        System.out.println("Hello " + currentUser.getName() + ",\n");
    }

    public void resume() {
        System.out.print("Press any key to continue...");
        this.scan.nextLine();
    }

    public void invalid() {
        System.out.println("[Warning] Error");
        this.resume();
        System.out.println("===========================================");
    }
}
