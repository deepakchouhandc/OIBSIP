package ATM;

import java.util.Scanner;
import java.util.SortedMap;

public class atm {
    private int id;
    private int password;

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public int getPassword() {
        return password;
    }

    public static void main(String[] args) {
        int  bal=1000;
        atm account = new atm();
        Scanner sc = new Scanner(System.in);
        //Taking I'd and password form user...
        account.setLogin();
        int checklogin=account.checkLogin();
        if(checklogin!=1)
        {
            account.setLogin();
        }
        // Show option to the user of ATM and take choice...
        account.showOption();
        int option;
        do {
            System.out.println("Enter your option");
             option = sc.nextInt();
             switch (option){
                 case 1:{

                     break;

                 }case 2:{
                     System.out.println("Enter the Amount For Deposit");
                     int depositAmount = sc.nextInt();
                     bal = bal+depositAmount;
                     break;

                 }case 3:{
                     System.out.println("You MINI Statement");
                     break;


                 }case 4:{
                     System.out.println("Your Account Balance");
                     System.out.println("Rs."+bal);
                     break;

                 }case 5:{
                     System.out.println("Enter the Account Number to Transfer");
                     int accountTransfer = sc.nextInt();
                     System.out.println("Enter the Amount to Transfer");
                     int amountTransfer = sc.nextInt();
                     bal = bal-amountTransfer;
                     System.out.println(amountTransfer+" Successfully Transfer to "+accountTransfer);
                     break;

                 }case 6:{
                     System.out.println("Thank You for Your Time\nHave a GOOD Day");
                     return;



                 }
             }
            account.showOption();

        }
        while (option!=6);


    }
    // Option for Atm
    public void showOption(){

        System.out.println("\n__________ * Welcome to DC ATM * __________ ");
            System.out.println("\n Select Number for ");
            System.out.println("1 :- Cash Withdraw");
            System.out.println("2 :- Deposit");
            System.out.println("3 :- Mini Statement");
            System.out.println("4 :- Check Balance");
            System.out.println("5 :- Transfer Money");
            System.out.println("6 :- EXIT");






    }

    public void withdraw()
    {

    }

    public void setLogin(){
        atm log = new atm();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Account ID ");
        int id = sc.nextInt();
        System.out.println("Enter your Account Password ");
        int password = sc.nextInt();
        log.setId(id);
        log.setPassword(password);
    }
    public int checkLogin()
    {
        if (getId()==1234 && getPassword()==452010)
        {
            return 1;

        }
        else
        {
            System.out.println("Wrong ID or Password");

        }
        return 0;

    }



}
