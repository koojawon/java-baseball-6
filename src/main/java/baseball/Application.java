package baseball;

import baseball.controller.GameController;
import baseball.view.implement.ConsoleInputViewImplement;
import baseball.view.implement.ConsoleOutputViewImplement;
import baseball.view.interfaces.InputView;
import baseball.view.interfaces.OutputView;

public class Application {

    private static final OutputView outputView = new ConsoleOutputViewImplement();
    private static final InputView inputView = new ConsoleInputViewImplement();

    public static void main(String[] args) {
        GameController gameController = new GameController(inputView, outputView);
        gameController.printWelcome();
        do {
            gameController.generateAnswer();
            gameController.tryGuess();
        } while (gameController.getRetry());
    }
}
