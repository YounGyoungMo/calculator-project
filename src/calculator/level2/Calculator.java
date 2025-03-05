package calculator.level2;

import java.util.ArrayList;

public class Calculator {

    private double num1;
    private double num2;
    private char operator;
    private static ArrayList<Double> addList = new ArrayList<>();

    // 매개변수가 num1, num2, operator인 calculate 메서드 정의
    public double calculate(double num1, double num2, char operator) {
        double result = 0;

        // 연산자에 따라 다른 연산을 하여 결과값을 출력하는 switch - case문
        switch (operator) {
            case '+': {
                result = num1 + num2;
                System.out.println("= " + result);
                break;
            }
            case '-': {
                result = num1 - num2;
                System.out.println("= " + result);
                break;
            }
            case '*': {
                result = num1 * num2;
                System.out.println("= " + result);
                break;
            }
            case '/': {
                // 분모가 0일 경우 예외 처리
                if (num2 == 0) {
                    System.out.println("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.");
                    break;
                }
                result = num1 / num2;
                System.out.println("= " + result);
                break;
            }
            // 사칙연산 기호 외에 다른 입력값이 들어올 경우 예외 처리
            default:
                System.out.println("유효하지 않은 연산 기호입니다.");
                return 0;
        }
        addResult(result);

       return result;

    }

    // 클래스 변수 addList에 가장 먼저 저장된 결과값 삭제
    public void removeResult() {
        try {
            addList.remove(0);  // 첫 번째 요소 제거
        } catch (IndexOutOfBoundsException e) {
            System.out.println("삭제할 요소가 없습니다.");
        }
        //유효하지 않은 인덱스 접근시 예외 처리
    }

    // 멤버 변수들에 값들을 설정하는 세터 메서드들
    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    // 멤버 변수들의 값들을 반환하는 게터 메서드들
    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public char getOperator() {
        return operator;
    }

    // 클래스 변수 addList에 결과값을 넣는 addResult 메서드 정의
    public void addResult(double result) {
        // 연산자가 나눗셈 연산자이면서 분모가 0일 경우에만 addList에 결과값을 넣지 않음
        if (!(operator == '/' && num2 == 0)) {
            addList.add(result);
        }
    }

    // 연산 결과값들을 출력하는 printResults 메서드 정의
    public void printResults() {
        System.out.print("연산 결과들: ");
        // 향상된 for문 활용하여 addList의 요소들을 가져와 차례대로 출력
        for (double result: addList) {
            System.out.print(result + " ");
        }
        System.out.println("");
    }


}