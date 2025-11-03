package lotto.model.domain;

import java.util.List;
import java.util.Objects;
import lotto.model.domain.constant.ErrorNotice;
import lotto.model.domain.constant.LottoWinConstant;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoWinConstant.LOTTO_NUMBERS_COUNT.getWinConstant()) {
            throw new IllegalArgumentException(ErrorNotice.INPUT_USER_NUMBERS_COUNT_ERROR_NOTICE.getErrorNotice());
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
        if ((count == LottoWinConstant.SECOND_CONDITION.getWinConstant() && bonus)
                || (count >= LottoWinConstant.LOTTO_NUMBERS_COUNT.getWinConstant())) {
            return LottoWinConstant.FIRST_TO_SECOND.getWinConstant() - count;
        }

        if (count >= LottoWinConstant.FIFTH_CONDITION.getWinConstant()) {
            return LottoWinConstant.THIRD_TO_LAST.getWinConstant() - count;
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
