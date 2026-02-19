package CodSoftTask3;

import java.awt.*;
import java.lang.reflect.AccessFlag;
import java.util.Scanner;

public class BanckAccount {
    private double Balance ;


    //method for cheacking banck balance deteilas
    public BanckAccount(double Balance){
        this.Balance = Balance;
    }


    //method for deposite ammount
    public double GetBalanceDeteil(){
        return Balance;
    }
    public void Deposite(double amount){
        Balance += amount;
    }

    //method for widrow ammount
    public boolean Widrow(double amount){
        if(amount <= Balance && amount >0){
            Balance -= amount;
            return true;
        }
        return false;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BanckAccount account = new BanckAccount(100);
        ATM atm = new ATM(account);

        while (true){

            System.out.print("Enter the Choice : ");
            int Choice = sc.nextInt();

            switch (Choice){
                case 1:
                    atm.GetBalanceDeteils();
                    System.out.println();
                    break;

                case 2:
                    System.out.print("Enter the Amount : ");
                    double DepAmount = sc.nextDouble();
                    atm.DepositeAmount(DepAmount);
                    System.out.println();
                    break;

                case 3:
                    System.out.print("Enter the Amount : ");
                    double WidAmount = sc.nextDouble();
                    atm.WidrowalAmmount(WidAmount);
                    System.out.println();
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Enter the Correct Input !");
            }
        }


    }
}


//ATM Machin Class
class ATM{
    private BanckAccount Account;

    public ATM(BanckAccount Account){
        this.Account = Account;
    }

    // method for get Banck deteils
    public void GetBalanceDeteils(){
        System.out.println("ACOUNT BALANCE : "+Account.GetBalanceDeteil());
    }

    //method for deposite ammount
    public void DepositeAmount(double amount){
        if(amount >0){
            Account.Deposite(amount);
            System.out.println("Succesfully Deposited Rs."+amount);
        }else {
            System.out.println("Invalid Ammount !");
        }
    }

    public void WidrowalAmmount(double amount) {
        if (amount <= 0) {
            System.out.println("Ivalid Amount !, Please Enter valid Amount");
        } else if (Account.Widrow(amount)) {
            System.out.println("Amount Successfully Widrowed : " + amount);
        } else {
            System.out.println("Insufficient Balance, Widroal Feiled !");
        }
    }

}

