public class Part_2_Test
{

    public static void main(String[] args)
    {
        Part_2 test = new Part_2();  //initializes with class defined

        double saver1, saver2, rate;
        saver1 = 2000.00;  //set saver1 to $2000
        saver2 = 3000.00;  //set saver2 to $3000

        rate = Part_2.modifyInterestRate(0.04);  //set annual interest rate to 4%

        System.out.println("Month    saver1      saver2");  //headers

        for(int i = 1; i < 13; i++)  //loops through 12 months
        {
            saver1 = saver1 + Part_2.calculateMonthlyInterest(saver1, rate);  //sets saver1 for each month equal to new value given by calculateMonthlyInterest
            saver2 = saver2 + Part_2.calculateMonthlyInterest(saver2, rate);  //sets saver2 for each month equal to new value given by calculateMonthlyInterest

            if(i < 10)
                System.out.printf("  %d     $%.2f    $%.2f\n", i, saver1, saver2);  //prints months 1-9 savings balances

            if(i >= 10)
                System.out.printf(" %d     $%.2f    $%.2f\n", i, saver1, saver2);  //prints months 10-12 savings balances
        }

        rate = Part_2.modifyInterestRate(0.05);  //set annual interest rate to 5%

        saver1 = saver1 + Part_2.calculateMonthlyInterest(saver1, rate);  //sets saver1 for month 13 to new balance
        saver2 = saver2 + Part_2.calculateMonthlyInterest(saver2, rate);  //sets saver2 for month 13 to new balance

        System.out.printf("\n 13     $%.2f    $%.2f\n", saver1, saver2);  //prints 13th month balances
    }
}
