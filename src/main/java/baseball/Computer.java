package baseball;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Computer {
    private String answerNumber;

    public void pickThreeNumbers() {
        ArrayList<Integer> answer = new ArrayList<>(3);
        while (answer.size() < 3) {
            int number = RandomUtils.nextInt(1, 9);
            if (!answer.contains(number)) {
                answer.add(number);
            }
        }
        answerNumber = answer.stream().map(String::valueOf).collect(Collectors.joining(""));
        System.out.println("answer = " + answerNumber);
    }

    public String verifyAnswer(String inputNumber) {
        int strike = 0;
        int ball = 0;

        // 자리수 일치 여부 확인
        for (int i = 0; i < 3; i++) {
            if (isStrike(inputNumber.charAt(i), answerNumber.charAt(i))) {
                strike++;
            } else if (isBall(i, inputNumber, answerNumber)) {
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
}
