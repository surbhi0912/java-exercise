import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        char operator;
        double operand1, operand2, result;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first number : ");
        operand1 = sc.nextDouble();

        System.out.println("Enter second number : ");
        operand2 = sc.nextDouble();

        System.out.println("Enter operation to perform among +, -, *, /");
        operator = sc.next().charAt(0);

        switch(operator){
            case '+':
                result = operand1 + operand2;
                System.out.println(operand1 + "" + operator + operand2 + "=" + result);
                break;
            case '-':
                result = operand1 - operand2;
                System.out.println(operand1 + "" + operator + operand2 + "=" + result);
                break;
            case '*':
                result = operand1 * operand2;
                System.out.println(operand1 + "" + operator + operand2 + "=" + result);
                break;
            case '/':
                result = operand1 / operand2;
                System.out.println(operand1 + "" + operator + operand2 + "=" + result);
                break;
            default:
                System.out.println("Invalid operator");
                break;
        }
        sc.close();
    }
}
