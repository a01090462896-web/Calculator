import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("첫번쨰 양의 정수를 입력하세요: ");
        int intBox = scanner.nextInt();
        System.out.println("intBox = " + intBox);

        System.out.println("두번째 양의 정수를 입력하세요: ");
        int intBox2 = scanner.nextInt();
        System.out.println("intBox2 = " + intBox2);

        System.out.println("사칙연산 기호를 입력하세요: ");
        String intBox3 = scanner.next();
        System.out.println("intBox3 = " + intBox3);
    }
}