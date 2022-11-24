package baseball;

import java.util.Scanner;

/* 유저로부터 입력받는 클래스 */
public class User {
    private final Scanner scanner;
    private static final Validator validator = new Validator();

    public User(Scanner scanner) {
        this.scanner = scanner;
    }

    public String takeInputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumber = scanner.nextLine();
        validate(validator, inputNumber);
        return inputNumber;
    }

    public boolean askIfEnd() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = scanner.nextLine();
        if (isEnd(input)) {
            throw new IllegalArgumentException();
        }
        return false;
    }

    private boolean isEnd(String input) {
        return input.equals("2");
    }

    private void validate(Validator validator, String inputNumber) {
        if (!validator.isNumber(inputNumber) || !validator.isLengthThree(inputNumber)
                || !validator.isRightRangeNumber(inputNumber) || !validator.isAllDifferentNumber(inputNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public void closeScanner() {
        scanner.close();
    }
}
