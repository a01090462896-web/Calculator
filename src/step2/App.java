package step2;

import java.util.Scanner;

// 문자가 입력되거나 음수 입력시 예외 처리 수행
public class App {
    public static double inputNumber(Scanner scanner, String message) {
        while (true) {
            System.out.println(message);
            String input = scanner.next();
            try {
                double number = Double.parseDouble(input);
                if (number < 0) {
                    System.out.println("양의 정수만 입력 가능합니다.");
                    continue;
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();

        while (true) {
            // 첫번째 정수 입력
            double num1 = inputNumber(scanner, "첫번쨰 양의 정수를 입력하세요.");
            // 두번째 정수 입력
            double num2 = inputNumber(scanner, "두번쨰 양의 정수를 입력하세요.");


            System.out.println("사칙연산을 입력하세요");
            char operator = scanner.next().charAt(0);

            ArithmeticCalculator.OperatorType operatorType = null;
            switch (operator) {
                case '+':
                    operatorType = ArithmeticCalculator.OperatorType.PLUS;
                    break;
                case '-':
                    operatorType = ArithmeticCalculator.OperatorType.MINUS;
                    break;
                case '*':
                    operatorType = ArithmeticCalculator.OperatorType.MULTIPLY;
                    break;
                case '/':
                    operatorType = ArithmeticCalculator.OperatorType.DIVIDE;
                    break;
                default:
                    System.out.println("잘못된 연산자입니다.");
                    continue;
            }

            // 0으로 나누기 예외 처리
            if (operator == '/' && num2 == 0) {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에는 0이 입력될 수없습니다.");
                continue;
            }

            // 계산 실행
            try {
                double result = calculator.calculate((double) num1, (double) num2, operatorType);
                System.out.println("결과: " + result);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
                continue;
            }

            // 저장된 결과 목록 확인
            System.out.println("저장된 결과 목록: " + calculator.getResultList());

            // 기록 삭제 테스트
            System.out.println("가장 오래된 기록을 지우려면 remove를 입력 (넘어가려면 아무거나 입렵): ");
            String commad = scanner.next();
            if (commad.equals("remove")) {
                calculator.removeResult();
                System.out.println("삭제 후 목록: " + calculator.getResultList());
            }

            System.out.println("입력한 값보다 큰 결과값들을 조회하겠습니까? (yes 입력 시 조회)");
            String choice = scanner.next();
            if (choice.equals("yes")) {
                System.out.println("기준이 될 숫자 입력하세요: ");
                double threshold = scanner.nextDouble();
                System.out.println(threshold + "보다 큰 결과 목록: " + calculator.getResultsGreaterThan(threshold));
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