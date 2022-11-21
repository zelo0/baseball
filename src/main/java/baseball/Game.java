package baseball;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Game {
    private String answer;
    private final Scanner scanner;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            answer = pickThreeNumbers();
            System.out.println("answer = " + answer);
            proceed();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = scanner.nextLine();
            if (input.equals("2")) {
                break;
            } else if (!input.equals("1")) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void proceed() {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String inputNumber = scanner.nextLine();
            String output = verifyAnswer(inputNumber);
            System.out.println(output);
            if (output.equals("3스트라이크")) {
                break;
            }
        }
    }

    private String verifyAnswer(String inputNumber) {
        int strike = 0;
        int ball = 0;

        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException();
        }

        // 자리수 일치 여부 확인
        for (int i = 0; i < 3; i++) {
            if (isStrike(inputNumber.charAt(i), answer.charAt(i))) {
                strike++;
            } else if (isBall(i, inputNumber, answer)) {
                ball++;
            }
        }

        return getJudgeString(strike, ball);
    }

    private String getJudgeString(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }
        StringBuilder sb = new StringBuilder();
        if (ball > 0) {
            sb.append(ball);
            sb.append("볼");
            if (strike > 0) {
                sb.append(" ");
            }
        }
        if (strike > 0) {
            sb.append(strike);
            sb.append("스트라이크");
        }
        return sb.toString();
    }

    private boolean isBall(int inputIndex, String inputNumber, String answer) {
        for (int i = 0; i < 3; i++) {
            if (i == inputIndex) {
                continue;
            }
            if (inputNumber.charAt(inputIndex) == answer.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    private boolean isStrike(char input, char answer) {
        return input == answer;
    }

    private String pickThreeNumbers() {
        ArrayList<Integer> answer = new ArrayList<>(3);
        while (answer.size() < 3) {
            int number = RandomUtils.nextInt(1, 9);
            if (!answer.contains(number)) {
                answer.add(number);
            }
        }
        return answer.stream().map(String::valueOf).collect(Collectors.joining(""));
    }
}
