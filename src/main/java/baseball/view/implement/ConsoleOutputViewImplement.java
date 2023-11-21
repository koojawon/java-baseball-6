package baseball.view.implement;

import baseball.model.CompareDto;
import baseball.view.interfaces.OutputView;

public class ConsoleOutputViewImplement implements OutputView {
    public void printWelcome() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }


    public void printNothing() {
        System.out.println("낫싱");
    }

    public void printHint(CompareDto compareDto) {
        StringBuilder stringBuilder = new StringBuilder();
        if (compareDto.getBall() != 0) {
            stringBuilder.append(compareDto.getBall()).append("볼 ");
        }
        if (compareDto.getStrike() != 0) {
            stringBuilder.append(compareDto.getStrike()).append("스트라이크");
        }
        System.out.println(stringBuilder);
    }

}
