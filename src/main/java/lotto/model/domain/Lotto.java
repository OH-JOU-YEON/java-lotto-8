package lotto.model.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public int validateWin(List<Integer> userNumbers, int bonusNumber, int userBonusNumber) {

        // 유저 넘버와 비교해서 얼마나 일치했는지 반환한다.

        int count = 0;

        for (Integer num : this.numbers) {
            for (Integer userNum : userNumbers) {
                count += compareEachNumber(num, userNum);
            }
        }

        boolean bonus = compareBonusNumber(bonusNumber, userBonusNumber);

        return determinePlace(count, bonus);
    }

    public int determinePlace(int count, boolean bonus) {
        if ((count == 5 && bonus) || (count >= 6)) {
            return 7 - count;
        }

        if (count >= 3) {
            return 8 - count;
        }

        return 0;
    }

    public int compareEachNumber(Integer num, Integer userNum) {
        int count = 0;

        if (Objects.equals(userNum, num)) {
            count += 1;
        }

        return count;
    }

    public boolean compareBonusNumber(int bonusNumber, int userBonusNumber) {

        return bonusNumber == userBonusNumber;
    }

    public String printLotto() {
        return this.numbers.toString();
    }
}
