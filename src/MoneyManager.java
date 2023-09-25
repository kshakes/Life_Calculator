import java.text.DecimalFormat;

public class MoneyManager {

    //Life Stats
    private float salary;
    private float monthly;
    private float houseCost;
    private float foodCost = 150; //Constant value. May change
    private float investmentAmount;
    private float amountToSpend;

    //Car Variables
    private float carPrice;
    private float carBudget;
    private float interest = 5f;
    private final float monthlyRate = (interest/100f) / 12f;

    DecimalFormat df = new DecimalFormat("#.##");


    public MoneyManager(){

    }

    public float getAmountToSpend() {
        return amountToSpend;
    }

    public void setAmountToSpend(float amountToSpend) {
        this.amountToSpend = amountToSpend;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getHouseCost() {
        return houseCost;
    }

    public void setHouseCost(float houseCost) {
        this.houseCost = Float.parseFloat(df.format(houseCost));
    }

    public float getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(float carPrice) {
        this.carPrice = (float) (carBudget * ((1 - Math.pow(1 + monthlyRate, -36))) / monthlyRate);
    }

    public float getCarBudget() {
        return carBudget;
    }

    public void setCarBudget(float carBudget) {
        this.carBudget = Float.parseFloat(df.format(carBudget));
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public void setMonthly(float monthly) {
        this.monthly = salary / 12;
    }

    public float getMonthly() {
        return monthly;
    }

    public float getFoodCost() {
        return foodCost;
    }

    public float getMonthlyRate() {
        return monthlyRate;
    }

    public float getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(float investmentAmount) {
        this.investmentAmount = monthly * 0.20f;
    }

    public String showInfo(){
        return "\n\nHere's how much you make!\nSalary: £" + salary +
                "\nMonthly Take Home: £" + df.format(monthly);
    }

    public void calcCosts(){
        float amountLeft = (monthly - (carBudget+houseCost+investmentAmount+foodCost));

        System.out.println("\nBelow is the MAX you should spend on each section\n----------------------------------------------" +
                "\nCar Budget: £" + df.format(carBudget) + " (Overall Price of £" + df.format(carPrice) + ")" +
                "\nHouse Cost: £" + df.format(houseCost) +
                "\nFood Cost Per Person: £" + df.format(foodCost) +
                "\n----------------------------------------------" +
                "\nOther Costs:\nInvestments: £" + df.format(investmentAmount) +
                "\n\nAmount Left: £" + df.format(amountLeft) + " (Starting Balance £" + df.format(monthly) + ")");
    }

    public void emergencyFund(){
        float needs = carBudget + houseCost + foodCost;
        float left = monthly - needs;
        float currentSaved = 0;
        int months = 0;
        float fund = needs * 6;

        System.out.println("\n\nDuring the building of the emergency fund, NO INVESTING WILL OCCUR");
        System.out.println("Expenses used:\n" +
                "   Car: £" + carBudget +
                "   House: £" + houseCost +
                "   Food: £" + foodCost +
                "\n                 Total: £" + needs);
        System.out.println("--------STRICT SAVING--------");
        while (currentSaved <= fund){
            currentSaved += left;
            months += 1;
            System.out.println("Month: " + months + "\nCurrent saved: £" + currentSaved + "\nTarget: £" + fund);
        }
        System.out.println("It took " + months + " months to save up a 6 month emergency fund STRICTLY!");
        System.out.println("-----------------");


        months = 0;
        currentSaved = 0;
        System.out.println("\nExpenses used:\n" +
                "   Car: £" + carBudget +
                "   House: £" + houseCost +
                "   Food: £" + foodCost +
                "   Spending Money: £" + amountToSpend +
                "\n                         Total :£" + (needs + amountToSpend));
        System.out.println("\n--------LOOSE SAVING--------");
        while (currentSaved <= fund){
            currentSaved += left - amountToSpend;
            months += 1;
            System.out.println("Month: " + months + "\nCurrent saved: £" + currentSaved + "\nTarget: £" + fund + "\n");
        }
        System.out.println("It took " + months + " months to save up a 6 month emergency fund LOOSELY!");
        System.out.println("-----------------");
    }

    public void retirementFund(int currentAge){
        double monthlyReturnRate = 0.08 / 12;
        int months = (66-currentAge) * 12;
        double initialBalance = 0.0f;
        for (int i = 1; i < months; i++) {
            initialBalance = (initialBalance + investmentAmount) * (1 + monthlyReturnRate);
        }
        System.out.println("\nTime until retirement: " + (66 - currentAge) +
                "\nInterest Rate: 8%" +
                "\nMonthly Investment: £" + investmentAmount +
                "\nRetirement Amount: £" + df.format(initialBalance) +
                "\n3% Withdrawal Every Year: £" + df.format(initialBalance * 0.03));
    }
}
