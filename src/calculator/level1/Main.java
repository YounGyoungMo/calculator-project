package calculator.level1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);
        // exit을 입력하면 빠져나오는 무한 루프 생성
        while(true) {
            System.out.println("종료하시려면 exit, 계속하시려면 아무거나 입력해주세요");
            // Scanner 객체를 활용하여 isExit에 입력된 값 저장
            String isExit = scanner.next();
            if (isExit.equals("exit")) {
                break;
            }

            // num1, operator, num2 변수에 각각 입력된 값 저장
            System.out.print("num1 입력 : ");
            int num1 = scanner.nextInt();
            System.out.print("기호 입력 : ");
            char operator = scanner.next().charAt(0);
            System.out.print("num2 입력 : ");
            int num2 = scanner.nextInt();

            // 입력된 연산자에 따라 연산이 달라지는 switch-case문 작성
            switch (operator) {
                case '+': {
                    int result = num1 + num2;
                    System.out.println("result = " + result);
                    break;
                }
                case '-': {
                    int result = num1 - num2;
                    System.out.println("result = " + result);
                    break;
                }
                case '*': {
                    int result = num1 * num2;
                    System.out.println("result = " + result);
                    break;
                }
                case '/': {
                    if (num2 == 0) {
                        System.out.println("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.");
                        break;
                    }
                    int result = num1 / num2;
                    System.out.println("result = " + result);
                    break;
                }
                // 이 외의 연산 기호가 입력되었을 경우 예외 처리
                default :
                    System.out.println("유효하지 않은 연산 기호입니다.");
            }
        }


    }
}
