package CodSoftTask1;

import java.time.Year;
import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Random random = new Random();

        int Rounds = 0;
        int TotalScore = 0;

        while (true){
            Rounds++;

            int TargetNumber = random.nextInt(100)+1;

            int Attempts = 5;
            int UserGeuss;

            Boolean IsCorrect = false;

            System.out.println("Roud NO-"+Rounds+" Started !");
            System.out.println("Geuss The Numbur Between 1 to 100");
            System.out.println("You Have Attempt : "+Attempts+" Attempts");

            while (Attempts > 0){

                System.out.print("Enter The User Geuss No : ");
               UserGeuss = sc.nextInt();

               if(UserGeuss == TargetNumber){
                   System.out.println("Geuss Number is Correct !");
                   IsCorrect = true;

                   int Score = Attempts * 10;
                   TotalScore += Score;

                   System.out.println("You Scored : "+Score);
                   break;
               }else if (UserGeuss > TargetNumber){
                   System.out.println("Too High ! try again.");
               }else {
                   System.out.println("Too Low ! try again.");
               }

                Attempts--;
                System.out.println("Attempts Lefts : "+Attempts);
            }
            System.out.println("ROUND NO : "+Rounds+" IS COMPLITED !");
            System.out.println();

            if(!IsCorrect){
                System.out.println("Do you Fail Correct Number Was : "+TargetNumber);
            }

            System.out.println("Do you Want to Play Again (yes/no) : ");
            sc.nextLine();
            String Input = sc.nextLine();

            if(Input.equalsIgnoreCase("No")){
                break;
            }
            System.out.println();
        }


    }
}
