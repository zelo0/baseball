package baseball;


import java.util.Scanner;

public class Game {
    private final Scanner scanner;
    private Computer computer;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        computer = new Computer();
        while (true) {
            computer.pickThreeNumbers();
            proceed();
            askIfEnd();
        }
    }

    private void askIfEnd() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = scanner.nextLine();
        if (input.equals("2")) {
            throw new IllegalArgumentException();
        }
    }

    private void proceed() {
        Validator validator = new Validator();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String inputNumber = scanner.nextLine();
            validate(validator, inputNumber);
            String output = computer.verifyAnswer(inputNumber);
            System.out.println(output);
            if (output.equals("3스트라이크")) {
                break;
            }
        }
    }

    private void validate(Validator validator, String inputNumber) {
        if (!validator.isNumber(inputNumber) || !validator.isLengthThree(inputNumber)
            || !validator.isRightRangeNumber(inputNumber) || !validator.isAllDifferentNumber(inputNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
