import java.util.Scanner;

/**
 * Calculator.java
 * A simple console-based calculator that performs
 * addition, subtraction, multiplication, and division.
 */
public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char continueChoice;

        System.out.println("=========================================");
        System.out.println("           SIMPLE JAVA CALCULATOR        ");
        System.out.println("=========================================");
        System.out.println("Supported operators: +  -  *  /");
        System.out.println("-----------------------------------------");

        do {
            double num1 = 0, num2 = 0;
            char operator;
            boolean validInput = true;

            // Read first number
            System.out.print("Enter first number  : ");
            try {
                num1 = Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: '" + "First value" + "' is not a valid number.");
                validInput = false;
            }

            // Read operator
            System.out.print("Enter operator (+,-,*,/): ");
            String opInput = scanner.nextLine().trim();
            operator = opInput.isEmpty() ? '\0' : opInput.charAt(0);

            // Read second number
            System.out.print("Enter second number : ");
            try {
                num2 = Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: Second value is not a valid number.");
                validInput = false;
            }

            System.out.println("-----------------------------------------");

            if (validInput) {
                switch (operator) {
                    case '+':
                        printResult(num1, num2, '+', num1 + num2);
                        break;
                    case '-':
                        printResult(num1, num2, '-', num1 - num2);
                        break;
                    case '*':
                        printResult(num1, num2, '*', num1 * num2);
                        break;
                    case '/':
                        if (num2 == 0) {
                            System.out.println("Error: Division by zero is not allowed.");
                        } else {
                            printResult(num1, num2, '/', num1 / num2);
                        }
                        break;
                    default:
                        System.out.println("Error: '" + operator + "' is not a supported operator.");
                }
            }

            System.out.println("-----------------------------------------");
            System.out.print("Do you want to perform another calculation? (y/n): ");
            String choiceInput = scanner.nextLine().trim().toLowerCase();
            continueChoice = choiceInput.isEmpty() ? 'n' : choiceInput.charAt(0);
            System.out.println("-----------------------------------------");

        } while (continueChoice == 'y');

        System.out.println("Thank you for using the calculator. Goodbye!");
        scanner.close();
    }

    /**
     * Prints the calculation result in a clean, readable format.
     */
    private static void printResult(double num1, double num2, char operator, double result) {
        System.out.printf("RESULT: %.2f %c %.2f = %.2f%n", num1, operator, num2, result);
    }
}
