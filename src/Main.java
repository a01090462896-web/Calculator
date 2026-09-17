import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 첫 번째 정수 입력 및 음수 검사
        while (true) {
            System.out.println("첫번쨰 양의 정수를 입력하세요: ");
            int intBox = scanner.nextInt();
            System.out.println("intBox = " + intBox);

            if (intBox < 0) {
                System.out.println("양의 정수만 입력 가능합니다");
                continue;
            }

            // 두 번째 정수 입력 및 음수 검사
            while (true) {
                System.out.println("두번째 양의 정수를 입력하세요: ");
                int intBox2 = scanner.nextInt();
                System.out.println("intBox2 = " + intBox2);

                if (intBox2 < 0) {
                    System.out.println("양의 정수만 입력 가능합니다");
                    continue;
                }
                break;
                System.out.println("사칙연산 기호를 입력하세요: ");
                String operator = scanner.next();
                System.out.println("intBox3 = " + operator);

                // 나누기 에러 검사
                if (operator.equals("/") && intBox2 == 0) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에는 0이 입력될 수없습니다.");
                    continue;
                }

                int result = 0;

                switch (operator) {
                    case "+":
                        result = intBox + intBox2;
                        break;
                    case "-":
                        result = intBox - intBox2;
                        break;
                    case "*":
                        result = intBox * intBox2;
                        break;
                    case "/":
                        result = intBox / intBox2;
                        break;
                }

                // 결과 출력
                System.out.println("결과: " + result);

                // 종료 여부 확인
                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                String exitCheck = scanner.next();

                if (exitCheck.equals("exit")) {
                    System.out.println("계산기를 종료합니다.");
                    break;
                }
            }
        }
    }
}