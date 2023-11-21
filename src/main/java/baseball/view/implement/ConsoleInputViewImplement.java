package baseball.view.implement;

import baseball.validator.GuessValidator;
import baseball.view.interfaces.InputView;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class ConsoleInputViewImplement implements InputView {
    private final GuessValidator guessValidator = new GuessValidator();

    public List<Integer> getGuess() throws IllegalArgumentException {
        System.out.println("숫자를 입력해 주세요 : ");
        String s = Console.readLine();
        validateGuess(s);
        return parseGuessInput(s);
    }

    private void validateGuess(String s) throws IllegalArgumentException {
        checkNumeric(s);
        guessValidator.checkDuplication(s);
        guessValidator.checkLength(s);
        guessValidator.checkRange(s);
    }

    public String getRestart() throws IllegalArgumentException {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

    private void checkNumeric(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ERROR: Numeric Only");
        }
    }

    private List<Integer> parseGuessInput(String s) {
        return Arrays.stream(s.split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }
}
