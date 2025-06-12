import java.util.Scanner;


public class Menu {

    public static void greetings(User currentUser) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nHello " + currentUser.getName() + ",");

        System.out.println("1. Account Holder");
        System.out.println("2. Bank Officer");
        System.out.println("3. Finance Officer");
        System.out.println("4. Loan Officer");
        System.out.println("Choose: ");
        int a = scan.nextInt();

        do{
            switch(a){
                case 1: 
                    System.out.println("1. Deposit Money");
                    System.out.println("2. Withdraw Money");
                    System.out.println("3. See Balance");
                    System.out.println("4. Tabung");
                    System.out.println("5. Loan Application");
                    System.out.println("6. View Transaction History");
                    System.out.println("Choose: ");
                    int b = scan.nextInt();

                    do { 
                        switch(b){
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                //System.out.println(currentUser.BankAccount.balance);
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 6:
                                //currentUser.Transaction.viewTransactionHistory();
                                break;
                            default:
                                System.out.println("Error");
                        }
                    } while (b<1||b>6);

                    break;

                case 2:
                    System.out.println("Approve Account");
                    break;

                case 3:
                    System.out.println("1. Set Dividend");
                    System.out.println("2. Generate Report");
                    break;

                case 4:
                    System.out.println("Approve Loan");
                    break;

                default:
                    System.out.println("Error");
            }
        }while(a<1||a>4);

        scan.close();
    }

    public static void greetings(SystemAdmin currentUser) {
        System.out.println("\nHello " + currentUser.getName() + ",");
    }

}
