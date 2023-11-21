package baseball.validator;

import java.util.Arrays;

public class GuessValidator {

    private static final int GUESS_LENGTH = 3;

    public void checkRange(String s) {
        if (s.contains("0")) {
            throw new IllegalArgumentException("Zero is not Allowed.");
        }
    }

    public void checkDuplication(String s) {
        int uniqueNumbersCount = (int) Arrays.stream(s.split("")).distinct().count();
        if (uniqueNumbersCount != s.length()) {
            throw new IllegalArgumentException("Numbers Duplicated!!");
        }
    }

    public void checkLength(String s) {
        if (Arrays.stream(s.split("")).count() != GUESS_LENGTH) {
            throw new IllegalArgumentException("Inappropriate Guess Length!!");
        }
    }


}
