package step3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator calculator = new ArithmeticCalculator();
        String exit = " ";

        while(!exit.equals("exit")){
            System.out.print("첫번째 숫자를 입력하세요: ");
            String input1 = sc.next();
            Number num1 = input1.contains(".") ? Double.parseDouble(input1) : Integer.parseInt(input1);
            System.out.print("연산할 부호를 입력하세요: ");
            char operator = sc.next().charAt(0);
            OperatorType operatorType = OperatorType.fromChar(operator);
            System.out.print("두번째 숫자를 입력하세요: ");
            String input2 = sc.next();
            Number num2 = input2.contains(".") ? Double.parseDouble(input2) : Integer.parseInt(input2);

            double result = calculator.calculate(num1, num2, operatorType);
            System.out.println("결과: " + result);

            System.out.println("계산 기록: " + calculator.getResults());

            System.out.print("가장 먼저 계산된 기록을 삭제할까요?(yes입력): ");
            String yes = sc.next();
            if(yes.equals("yes")){
                calculator.removeResults();
                System.out.println("계산 기록: " + calculator.getResults());
            }

            System.out.print("큰 값 조회: ");
            String ans = sc.next();
            if(ans.equals("yes")){
                System.out.print("값을 입력: ");
                double value = sc.nextDouble();
                System.out.println("큰값들: " + calculator.getBigResult(value));
            }

            System.out.print("계산을 종료할까요?(exit 입력): ");
            exit = sc.next();
        }
        sc.close();
    }
}
