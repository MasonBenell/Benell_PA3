public class Part_2
{
    private static double annualInterestRate;  //private class variable
    private double savingsBalance;  //private instance variable

    public static double calculateMonthlyInterest(double bal, double rate)  //public instance method
    {
        return bal * rate / 12.0;  //new balance calculation
    }

    public static double modifyInterestRate(double num)  //public class method
    {
        annualInterestRate = num;

        return annualInterestRate;
    }
}
