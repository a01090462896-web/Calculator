package step2;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T extends Number> {
    private List<Double> resultList = new ArrayList<>();

    public enum OperatorType {
        PLUS('+'),
        MINUS('-'),
        MULTIPLY('*'),
        DIVIDE('/');

        private final char symbol;

        OperatorType(char symbol) {
            this.symbol = symbol;
        }
        public char getSymbol() {
            return symbol;
        }
    }

    public double calculate(T num1, T num2, OperatorType operator) {
        double n1 = num1.doubleValue();
        double n2 = num2.doubleValue();
        double result = 0;

        switch (operator) {
            case PLUS:
                result = n1 + n2;
                break;
            case MINUS:
                result = n1 - n2;
                break;
            case MULTIPLY:
                result = n1 * n2;
                break;
            case DIVIDE:
                if (n2 == 0) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                result = n1 / n2;
                break;
        }
        // 연산 결과를 저장
        resultList.add(result);
        return result;
    }

    // 게터
    public List<Double> getResultList() {
        return resultList;
    }

    // 세터
    public void setResultList(List<Double> resultList) {
        this.resultList = resultList;
    }

    // 저장된 기록 삭제하는 메서드
    public void removeResult() {
        if (!resultList.isEmpty()) {
            resultList.remove(0);
        }
    }

    // 스트림 활용
    public void printResultsGreaterThan(double threshold) {
        resultList.stream()
                .filter(result -> result > threshold)
                .forEach(System.out::println);
    }

    // 특정 값보다 큰 결과값 반환
    public List<Double> getResultsGreaterThan(double threshold) {
        return resultList.stream()
                .filter(result -> result > threshold)
                .toList();
    }
}