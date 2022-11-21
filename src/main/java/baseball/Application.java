package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        //TODO: 숫자 야구 게임 구현
        Game game = new Game(scanner);
        game.start();
    }
}
