package step2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Calculator calculator = new Calculator();

        while (true) {
            // 첫번째 정수 입력 및 음수 검사
            System.out.println("첫번쨰 양의 정수를 입력하세요. ");
            int num1 = scanner.nextInt();
            if (num1 <0 ) {
                System.out.println("양의 정수만 입력 가능합니다.");
                continue;
            }

            // 두 번째 정수 입렵 및 음수 검사
            int num2 = scanner.nextInt();
            while (true) {
                System.out.println("두번째 양의 정수를 입력하세요.");
                num2 = scanner.nextInt();
                if (num2 < 0) {
                    System.out.println("양의 정수만 입력 가능합니다.");
                    continue;
                }
                break;
            }
            System.out.println("사칙연산을 입력하세요");
            char operator = scanner.next().charAt(0);

            // 계산 실행
            int result = calculator.calculate(num1, num2, operator);

            System.out.println("결과: " + result);
            break;
        }
    }
}
