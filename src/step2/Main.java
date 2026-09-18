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
            if (num1 < 0) {
                System.out.println("양의 정수만 입력 가능합니다.");
                continue;
            }

            // 두 번째 정수 입렵 및 음수 검사
            int num2;
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

            // 저장된 결과 목록 확인
            System.out.println("저장된 결과 목록: " + calculator.getResultList());

            // 기록 삭제 테스트
            System.out.println("가장 오래된 기록을 지우려면 remove를 입력 (넘어가려면 아무거나 입렵): ");
            String commad = scanner.next();
            if (commad.equals("remove")) {
                calculator.removeResult();
                System.out.println("삭제 후 목록: " + calculator.getResultList());
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료");
            String exitCheck = scanner.next();

            if (exitCheck.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }
    }
}
