package baseball.view.interfaces;

import baseball.model.CompareDto;

public interface OutputView {
    void printWelcome();

    void printNothing();

    void printHint(CompareDto compareDto);
}
