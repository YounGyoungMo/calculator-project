package calculator.level2;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Calculator calculator;
        while (true) {
            calculator = new Calculator();
            System.out.println("종료하시려면 exit, 계속하시려면 아무거나 입력해주세요");
            String isExit = scanner.next();

            if (isExit.equals("exit")) {
                break;
            }

            System.out.print("num1 입력 : ");
            double num1 = scanner.nextInt();
            calculator.setNum1(num1);

            System.out.print("기호 입력 : ");
            char operator = scanner.next().charAt(0);
            calculator.setOperator(operator);

            System.out.print("num2 입력 : ");
            double num2 = scanner.nextInt();
            calculator.setNum2(num2);

            System.out.println(calculator.getNum1() + " " + calculator.getOperator() + " " + calculator.getNum2());

            double result = calculator.calculate(num1, num2, operator);
            calculator.printResults();

//            calculator.addResult(result);
//            calculator.printResults();

        }

        System.out.println("첫 번째 요소를 삭제합니다.");
        calculator.removeResult();
        calculator.printResults();



    }
}
