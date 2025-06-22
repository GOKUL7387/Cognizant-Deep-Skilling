class FinancialForecaster 
{
    public static double calculateFutureValue(double principal, double growthRate, int periods) 
    {
        if (periods == 0) 
        {
            return principal;
        }
        return calculateFutureValue(principal * (1 + growthRate), growthRate, periods - 1);
    }
}

public class FinancialForecasting 
{
    public static void main(String[] args) 
    {
        double principal = 1000.0;
        double growthRate = 0.05; 
        int[] periods = {1, 5, 10}; 

        System.out.println("Financial Forecasting Results:");
        for (int period : periods) 
        {
            double futureValue = FinancialForecaster.calculateFutureValue(principal, growthRate, period);
            System.out.printf("After %d years, $%.2f at %.2f%% growth rate becomes $%.2f%n", period, principal, growthRate * 100, futureValue);
        }
    }
}