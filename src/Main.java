import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Exit Program -> 0\nCalculate Salary -> 1\nOption: ");
        switch(scanner.nextInt()){
            case 0 -> System.exit(0);
            case 1 ->  enterSalary();
        }
    }

    public static void enterSalary(){
        System.out.println("What should you spend money on based on your salary?");
        System.out.print("Salary After Tax: ");

        float salaryInput = scanner.nextFloat();

        //Pass salary into a second class that calculates cost and uses
        //variables for other features

        //Set the variables through a setter in second class

        choiceToEdit();
    }


    public static void editValues() {
        //Allow the user to edit the variables for house costs and car costs
    }

    public static void choiceToEdit(){
        System.out.println("\n0 -> Main Menu\n1 -> Edit Values\n2 -> Emergency Fund Calculator\n3 -> Retirement Fund Calculator");
        int choice = scanner.nextInt();
        switch(choice){
            case 0 -> main(null); //Go back to main where you can
            //input salary and go through the code again
            case 1 -> editValues(); // pass the car and house price
            case 2 -> {
                System.out.print("Spending Money Per Month: ");
                //Get and set the spending money to make an accurate calculation
                choiceToEdit();
            }
            case 3 -> {
                System.out.print("What is your age? ");
                //Let user input their age to calculate how many years until retirement
                choiceToEdit();
            }
            default -> {
                System.out.println("Invalid Input");
                enterSalary();
            }
        }
    }
}