package step2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private List<Integer> resultList = new ArrayList<>();

    public int calculate(int num1, int num2, char operator) {
        int result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
        }
        resultList.add(result);

        return result;
    }
}
