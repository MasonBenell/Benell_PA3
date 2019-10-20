import java.security.SecureRandom;
import java.util.Scanner;

public class Part_1
{
    public static double questions(int ari, int dif)  //method to generate questions
    {
        SecureRandom rand = new SecureRandom();  //initialize random

        int num1, num2;
        double correct;

        if (dif == 1)  //sets 2 random single digit numbers
        {
            num1 = rand.nextInt(9) + 1;
            num2 = rand.nextInt(9) + 1;
        }
        else if (dif == 2)  //sets 2 random two digit numbers
        {
            num1 = rand.nextInt(99) + 1;
            num2 = rand.nextInt(99) + 1;
        }
        else if (dif == 3)  //sets 2 random three digit numbers
        {
            num1 = rand.nextInt(999) + 1;
            num2 = rand.nextInt(999) + 1;
        }
        else  //sets 2 random four digit numbers
        {
            num1 = rand.nextInt(9999) + 1;
            num2 = rand.nextInt(9999) + 1;
        }



        if(ari == 1)  //sets arithmetic to addition
        {
            System.out.print("What is " + num1 + " + " + num2 +"? ");
            correct = num1 + num2;
        }
        else if(ari == 2)  //sets arithmetic to multiplication
        {
            System.out.print("What is " + num1 + " * " + num2 +"? ");
            correct = num1 * num2;
        }
        else if(ari == 3)  //sets arithmetic to subtraction
        {
            System.out.print("What is " + num1 + " - " + num2 +"? ");
            correct = num1 - num2;
        }
        else if(ari == 4)  //sets arithmetic to division
        {
            System.out.print("What is " + num1 + " / " + num2 +"? ");
            correct = (double)num1 / (double)num2;
        }
        else  //sets arithmetic to be random
        {
            int sign;
            sign = rand.nextInt(4) + 1;  //randomizes the sign

            if (sign == 1)
            {
               System.out.print("What is " + num1 + " + " + num2 + "? ");
                correct = num1 + num2;
            }
            else if (sign == 2)
            {
                System.out.print("What is " + num1 + " * " + num2 + "? ");
                correct = num1 * num2;
            }
            else if (sign == 3)
            {
                System.out.print("What is " + num1 + " - " + num2 + "? ");
                correct = num1 - num2;
            }
            else
            {
                System.out.print("What is " + num1 + " / " + num2 + "? ");
                correct = num1 / num2;
            }
        }

        return correct;
    }

    public static void responses(int count)  //method to generate responses
    {
        if (count >= 8)  //used if >75% were correct
        {
            System.out.println("Congratulations, you are ready to go to the next level!");
        }
        else  //used if <75% were correct
        {
            System.out.println("Please ask your teacher for extra help");
        }
    }

    public static int difficulty()  //method to determine difficulty
    {
        Scanner in = new Scanner(System.in);

        int dif;

        System.out.print("Enter difficulty level(1-4, 0 if you want to quit): ");
        dif = in.nextInt();

        return dif;
    }

    public static int type()  //method to determine problem type
    {
        Scanner in = new Scanner(System.in);

        int ari;

        System.out.print("Enter arithmetic(1 for +, 2 for *, 3 for -, 4 for /, 5 for mixed): ");
        ari = in.nextInt();

        return ari;
    }

    public static void main(String[] args)
    {
        SecureRandom rand = new SecureRandom();  //initialize random
        Scanner in = new Scanner(System.in);  //initialize scanner

        int quit, dif, ari, count;
        double ans, correct, close;

        quit = 1;

        while(quit != 0)  //program loops through 10 questions at a time and quits when user chooses
        {
            count = 0;

            dif = difficulty();  //calls difficulty method

            ari = type();  //calls arithmetic type method

            for (int i = 0; i < 10; i++)
            {
                correct = questions(ari, dif);  //calls question and stores answer to question

                ans = in.nextDouble();  //user input answer

                close = Math.abs(correct - ans);  //stores difference

                if (close <= 0.01)  //if users answer is within 0.01 of correct answer
                {
                    count++;
                }
            }

            responses(count);

            System.out.print("Enter 0 if you wish to quit, otherwise, enter 1: ");  //prompt if you would like to continue
            quit = in.nextInt();

            System.out.println("");
        }
    }
}
