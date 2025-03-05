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
//            Lv1 계산기 과제 해결중 트러블 슈팅2
//            계산기 루프중 처음에는 System.out.println("종료하시려면 exit, 계속하시려면 아무거나 입력해주세요");
//            해당 문구가 출력됐을 때 exit을 누르면 종료, 아무거나 입력하면 계속하는 것이 제대로 작동했지만
//            두 번째 계산부터 String isExit = scanner.nextLine(); 해당 부분에서 isExit에 입력받지 않고 그 다음 코드로 넘어가는 문제가 발생함.
//                    위 문제와 마찬가지로 앞서 입력된 exit이후 버퍼에 개행문자가 남아 있어서 사용자가 입력하기도 전에 이미 isExit에 공백 문자가 저장되어 발생한 문제이다.
//                    해결 방법: 단어만 읽는 next()를 사용하여 해결함
//            앞의 문제와 동일한 문제임에도 불구하고 같은 실수를 반복하게 된 원인:
//            반복문으로 인해 isExit에 계속해서 입력된 문자가 저장되는 것을 생각하지 못했고,
//            앞의 문제에서는 오류가 직관적으로 발생하여 웹서핑을 통해 해결할 수 있었지만 이번에는 명시적인 오류가 발생하지 않아 미리 알 수 없었다.

            // 입력된 값이 "exit"인지 확인하고 일치하면 반복문 빠져나옴
            if (isExit.equals("exit")) {
                break;
            }

            // num1, operator, num2 변수에 각각 입력된 값 저장
            System.out.print("num1 입력 : ");
            int num1 = scanner.nextInt();
            System.out.print("기호 입력 : ");
            char operator = scanner.next().charAt(0);
//        Lv1 계산기 과제 해결중 트러블 슈팅1
//        StringIndexOutOfBoundsException: Index 0 out of bounds for length 0 오류 발생
//        -> charAt(0)을 호출했는데 입력된 문자열이 빈 문자열이라 발생한 오류
//        즉, char operator = scanner.nextLine().charAt(0);
//        위 코드, 문자열을 받아오는 부분에서 문제가 생긴 것임
//        우선 해당 문제를 해결하기 위해 입력 버퍼의 원리를 알 필요가 있는데, Scanner 클래스의 입력 버퍼는 입력을 여러 토큰으로 분리할 때
//        기본적으로 공백 문자를 기준으로 구분하며, \n이 추가된다.
//        nextLine()의 경우 버퍼에 입력된 문자열을 개행 문자까지 다 가져오는데, 문제는 해당 코드 앞 부분에,
//        int num1 = scanner.nextInt(); 라는 코드로 인해 버퍼에 개행문자가 남아 있어서 nextLine()은 문자열이 입력 받기도 전에 개행 문자를 읽어버려
//        결과적으로 operator에는 공백 문자가 저장된 것이다.
//        해결 방법: 버퍼에 입력된 문자열을 개행 문자까지 다 가져오는 nextLine() 대신 단어만 읽는 next()를 사용하여 해결함.
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
