package calculator.level2;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        // Calculator 클래스의 calculator 객체 선언
        Calculator calculator;
        while (true) {
            // calculator 객체 생성
            calculator = new Calculator();
            System.out.println("종료하시려면 exit, 계속하시려면 아무거나 입력해주세요");
            String isExit = scanner.next();

            // isExit에 입력된 값이 "exit"와 일치할 경우 반복문 빠져나옴
            if (isExit.equals("exit")) {
                break;
            }

            // num1, 연산자, num2 입력 받고 calculator 객체의 세터 메서드를 통해 각 멤버 변수에 저장
            System.out.print("num1 입력 : ");
            double num1 = scanner.nextInt();
            calculator.setNum1(num1);

            System.out.print("기호 입력 : ");
            char operator = scanner.next().charAt(0);
            calculator.setOperator(operator);

            System.out.print("num2 입력 : ");
            double num2 = scanner.nextInt();
            calculator.setNum2(num2);

            // calculator 객체의 게터 메서드를 통해 연산되는 숫자와 기호 출력
            System.out.println(calculator.getNum1() + " " + calculator.getOperator() + " " + calculator.getNum2());

            // calculator 객체의 calculate 메서드 호출후 그 결과값을 result에 저장
            double result = calculator.calculate(num1, num2, operator);

            // calculator 객체의 printResuls() 메서드 호출하여 이때까지의 연산 결과값들을 출력
            calculator.printResults();

        }

        //exit를 입력해서 반복문에서 빠져 나옴.

        System.out.println("첫 번째 요소를 삭제합니다.");
        // calculator 객체의 removeResult() 메서드를 호출하여 가장 먼저 저장된 결과값을 삭제한다.
        calculator.removeResult();
        // calculator 객체의 printResults() 메서드를 호출하여 결과값이 삭제된 상태의 연산 결과값들을 출력한다.
        calculator.printResults();


    }
}
