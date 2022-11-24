package baseball;


import java.util.Scanner;

public class Game {
    private Computer computer;
    private User user;

    public Game(Scanner scanner) {
        computer = new Computer();
        user = new User(scanner);
    }

    public void start() {
        computer = new Computer();
        do {
            computer.pickThreeNumbers();
            guess();
        } while (!user.askIfEnd());
        user.closeScanner();
    }

    private void guess() {
        while (true) {
            String inputNumber = user.takeInputNumber();
            String output = computer.verifyAnswer(inputNumber);
            System.out.println(output);
            if (output.equals("3스트라이크")) {
                break;
            }
        }
    }
}
