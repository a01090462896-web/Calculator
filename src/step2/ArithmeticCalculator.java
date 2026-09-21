package step2;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator {
    private List<Integer> resultList = new ArrayList<>();

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

    public int calculate(int num1, int num2, OperatorType operator) {
        int result = 0;

        switch (operator) {
            case PLUS:
                result = num1 + num2;
                break;
            case MINUS:
                result = num1 - num2;
                break;
            case MULTIPLY:
                result = num1 * num2;
                break;
            case DIVIDE:
                result = num1 / num2;
                break;
        }

        resultList.add(result);
        return result;
    }

    public List<Integer> getResultList() {
        return resultList;
    }

    public void setResultList(List<Integer> resultList) {
        this.resultList = resultList;
    }

    // 저장된 기록 삭제하는 메서드
    public void removeResult() {
        if (!resultList.isEmpty()) {
            resultList.remove(0);
        }
    }
}