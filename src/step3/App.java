package step3;

import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();
        Scanner sc = new Scanner(System.in);
        String exit = " ";

        while (!exit.equals("exit")) {
            System.out.print("첫번째 숫자 입력: ");
            String input1 = sc.next();
            Number num1 = input1.contains(".") ? Double.parseDouble(input1) : Integer.parseInt(input1);
            System.out.print("두번째 숫자 입력: ");
            String input2 = sc.next();
            Number num2 = input2.contains(".") ? Double.parseDouble(input2) : Integer.parseInt(input2);
            System.out.print("부호 입력: ");
            char sign = sc.next().charAt(0);
            OperatorType operatorType = OperatorType.fromChar(sign);

            double result = arithmeticCalculator.calculate(num1, num2, operatorType);
            System.out.println("결과: " + result);

            System.out.println("계산 기록: " + arithmeticCalculator.getData());

            System.out.print("오래된 결과 삭제(yes 입력): ");
            String remove = sc.next();
            if(remove.equals("yes")){
                arithmeticCalculator.removeData();
                System.out.println("계산 기록: " + arithmeticCalculator.getData());
            }

            System.out.print("기준값보다 큰값 출력(yes입력): ");
            String yes = sc.next();
            if(yes.equals("yes")){
                System.out.print("기준이 될 값: ");
                double value = sc.nextDouble();
                System.out.println("결과: " + arithmeticCalculator.getBigData(value));
            }

            System.out.print("종료할까요(exit 입력): ");
            exit = sc.next();
        }
        sc.close();
    }
}
