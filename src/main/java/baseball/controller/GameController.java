package baseball.controller;

import baseball.model.Answer;
import baseball.model.CompareDto;
import baseball.view.interfaces.InputView;
import baseball.view.interfaces.OutputView;
import java.util.List;

public class GameController {

    private static final String RETRY = "1";
    private static final String QUIT = "2";
    private static final int END_STRIKE_COUNT = 3;
    private final OutputView outputView;
    private final InputView inputView;
    private final Answer answer;

    public GameController(InputView inputView, OutputView outputView) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.answer = new Answer();
    }

    public boolean getRetry() {
        String s = inputView.getRestart();
        System.out.println(s);
        if (s.equals(RETRY)) {
            return true;
        }
        if (s.equals(QUIT)) {
            return false;
        }
        throw new IllegalArgumentException("Wrong Input!!");
    }

    public void printWelcome() {
        outputView.printWelcome();
    }

    public void generateAnswer() {
        answer.generateAnswer();
    }

    public void tryGuess() {
        List<Integer> s;
        CompareDto compareResult;
        do {
            s = inputView.getGuess();
            compareResult = answer.compareAnswer(s);
            printHint(compareResult);
        } while (checkGameEnd(compareResult));
    }

    private boolean checkGameEnd(CompareDto compareDto) {
        return compareDto.getStrike() != END_STRIKE_COUNT;
    }

    private void printHint(CompareDto compareDto) {
        if ((compareDto.getStrike() | compareDto.getBall()) == 0) {
            outputView.printNothing();
            return;
        }
        outputView.printHint(compareDto);
    }
}
