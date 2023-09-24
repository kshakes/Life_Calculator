import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static MoneyManager mm = new MoneyManager();

    //Leaving all these variables here since it works. There may be a more efficient way to do things
    private static float monthly;
    private static float carBudget;
    private static float carPrice;
    private static float houseCost;
    private static float rate;
    private static float interestRate;
    private static float investmentAmount;

    public static void main(String[] args) {
        System.out.println("Exit Program -> 0\nCalculate Salary -> 1");
        switch(scanner.nextInt()){
            case 0 -> System.exit(0);
            case 1 -> enterSalary();
        }
    }

    public static void enterSalary(){
        System.out.println("What should you spend money on based on your salary?");
        System.out.print("Salary After Tax: ");

        float salaryInput = scanner.nextFloat();
        mm.setSalary(salaryInput);

        //Do all the calculations to be able to set variables
        monthly = mm.getSalary() / 12;
        houseCost = monthly * 0.45f;
        carBudget = monthly * 0.15f;
        rate = mm.getInterest();
        interestRate = mm.getMonthlyRate();
        investmentAmount = monthly * 0.20f;
        carPrice = mm.getCarPrice();

        mm.setMonthly(monthly);
        System.out.println(mm.showInfo());

        mm.setCarBudget(carBudget);
        mm.setHouseCost(houseCost);
        mm.setCarPrice(carPrice);
        mm.setInvestmentAmount(investmentAmount);
        mm.calcCosts();

        choiceToEdit();
    }


    public static void editValues(float carBudget, float houseCost) {
        //Shows the previous Car Budget and House Budget and then allows the user to edit it to their own value.
        System.out.print("Edit Car Budget from £" + mm.getCarBudget() + " -> £");
        float carBudgetEdit = scanner.nextFloat();
        mm.setCarBudget(carBudgetEdit);

        System.out.print("Edit House Budget from £" + mm.getHouseCost() + " -> £");
        float houseBudgetEdit = scanner.nextFloat();
        mm.setHouseCost(houseBudgetEdit);
        mm.setCarPrice(carPrice);
        mm.calcCosts();

        choiceToEdit();
    }

    public static void choiceToEdit(){
        System.out.println("\n0 -> Main Menu\n1 -> Edit Values\n2 -> Emergency Fund Calculator\n3 -> Retirement Fund Calculator");
        int choice = scanner.nextInt();
        switch(choice){
            case 0 -> main(null);
            case 1 -> editValues(carBudget, houseCost);
            case 2 -> {
                System.out.print("Spending Money Per Month: ");
                mm.setAmountToSpend(scanner.nextInt());
                mm.emergencyFund();
                choiceToEdit();
            }
            case 3 -> {
                System.out.print("What is your age? ");
                mm.retirementFund(scanner.nextInt());
                choiceToEdit();
            }
            default -> {
                System.out.println("Invalid Input");
                enterSalary();
            }
        }
    }
}