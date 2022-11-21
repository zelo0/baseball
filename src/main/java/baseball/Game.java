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
            proceed();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = scanner.nextLine();
            if (input.equals("1")) {
                continue;
            } else if (input.equals("2")) {
                break;
            } else {
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
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException();
        }

        int strike = 0;
        int ball = 0;

        // 자리수 일치 여부 확인
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (inputNumber.charAt(i) == answer.charAt(j)) {
                    if (i == j) {
                        strike++;
                    } else {
                        ball++;
                    }
                    break;
                }
            }
        }

        if (strike == 0 && ball == 0) {
            return "낫싱";
        }
        StringBuffer ret = new StringBuffer();
        if (ball > 0) {
            ret.append(ball);
            ret.append("볼");
            if (strike > 0) {
                ret.append(" ");
            }
        }
        if (strike > 0) {
            ret.append(strike);
            ret.append("스트라이크");
        }
        return ret.toString();
    }

    private String pickThreeNumbers() {
        ArrayList<Integer> answer = new ArrayList<Integer>(3);
        while (answer.size() < 3) {
            int number = RandomUtils.nextInt(1, 9);
            if (!answer.contains(number)) {
                answer.add(number);
            }
        }
        return answer.stream().map(String::valueOf).collect(Collectors.joining(""));
    }
}
