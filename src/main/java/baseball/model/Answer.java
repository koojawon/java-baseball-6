package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Answer {
    private List<Integer> answer;

    public void generateAnswer() {
        Set<Integer> answer = new HashSet<>();
        while (answer.size() < 3) {
            answer.add(Randoms.pickNumberInRange(1, 10));
        }
        this.answer = answer.stream().toList();
    }

    public CompareDto compareAnswer(List<Integer> guess) {
        List<Integer> ball = getBalls(guess);
        List<Integer> strike = getStrike(ball, guess);
        System.out.println(answer);
        return new CompareDto(strike.size(), ball.size() - strike.size());
    }

    private List<Integer> getBalls(List<Integer> guess) {
        return guess.stream()
                .filter(answer::contains)
                .toList();

    }

    private List<Integer> getStrike(List<Integer> balls, List<Integer> guess) {
        return balls.stream()
                .filter(e -> answer.get(guess.indexOf(e)).equals(e))
                .toList();
    }
}
