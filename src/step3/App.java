package step3;

import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator calculator = new ArithmeticCalculator();

        String exit = " ";

        while(!exit.equals("exit")) {
            System.out.print("첫번째 숫자를 입력하시오.: ");
            String input1 = sc.next();
            Number num1 = input1.contains(".") ? Double.parseDouble(input1) : Integer.parseInt(input1);
            System.out.print("계산한 부호를 입력하시오.: ");
            char operator = sc.next().charAt(0);
            OperatorType operatorType = OperatorType.fromChar(operator);
            System.out.print("두번째 숫자를 입력하시오.: ");
            String input2 = sc.next();
            Number num2 = input2.contains(".") ? Double.parseDouble(input2) : Integer.parseInt(input2);

            double result = calculator.calculate(num1,num2,operatorType);
            System.out.println("결과: " + result);
            System.out.println("결과 목록: " + calculator.getData());

            System.out.print("오래된 결과를 지울까요?(yes입력): ");
            String remove = sc.next();
            if(remove.equals("yes")){
                calculator.removeData();
                System.out.println("결과 목록: " + calculator.getData());
            }

            System.out.print("보다 큰값들을 조회할까요?(yes 입력)");
            String search = sc.next();
            if (search.equals("yes")){
                System.out.print("비교할 값을 입력하세요");
                double value = sc.nextDouble();
                System.out.println("결과: " + calculator.searchData(value));
            }

            System.out.print("계산을 끝낼까요?(exit 입력)");
            exit = sc.next();
        }
        sc.close();
    }
}
