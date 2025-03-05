package calculator.level2;

import java.util.ArrayList;

public class Calculator {

    private double num1;
    private double num2;
    private char operator;
    private static ArrayList<Double> addList = new ArrayList<>();
    // Lv2. 계산기 과제 해결중 트러블 슈팅
    // 처음에는 연산 결과들을 저장하는 addList를 static으로 선언하지 않고 코드를 실행했는데, 연산 결과들을 출력하는 printResults()를 호출할때
    // 앞서 연산했던 결과가 초기화되고 현재 진행중인 연산 결과만 출력되는 문제가 발생함
    // 그 이유는 App클래스의 메인 메서드에서 해당 while문은 매번 새로운 객체를 생성하기 때문이었다.
    // 해결 방법: 이전의 연산 결과를 기억하려면 addList를 static으로 선언하여 매순간 객체가 새로 생기더라도 이전의 연산 결과는 저장할 수 있도록 할 수 있었다.

    public double calculate(double num1, double num2, char operator) {
        double result = 0;

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
                if (num2 == 0) {
                    System.out.println("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.");
                    break;
                }
                result = num1 / num2;
                System.out.println("= " + result);
                break;
            }
            default:
                System.out.println("유효하지 않은 연산 기호입니다.");
                return 0;
        }
        addResult(result);

       return result;

    }

    public void removeResult() {
        try {
            addList.remove(0);  // 첫 번째 요소 제거
        } catch (IndexOutOfBoundsException e) {
            System.out.println("삭제할 요소가 없습니다.");
        }
        //유효하지 않은 인덱스 접근시 예외 처리
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public char getOperator() {
        return operator;
    }

    public void addResult(double result) {
        if (num2 != 0) {
            addList.add(result);
        }
    }

    public void printResults() {
        System.out.print("연산 결과들: ");
        for (double result: addList) {
            System.out.print(result + " ");
        }
        System.out.println("");
    }


}