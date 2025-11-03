package lotto.model.domain.constant;

public enum LottoWinConstant {
    LOTTO_NUMBERS_COUNT(6),
    FIRST_TO_SECOND(LOTTO_NUMBERS_COUNT.getWinConstant() + 1),
    THIRD_TO_LAST(LOTTO_NUMBERS_COUNT.getWinConstant() + 2),
    SECOND_CONDITION(LOTTO_NUMBERS_COUNT.getWinConstant() - 1),
    FIFTH_CONDITION(3),
    LOTTO_NUMBER_MAX_VALUE(45),
    LOTTO_NUMBER_MIN_VALUE(1);

    private final int winConstant;

    LottoWinConstant(int winConstant) {
        this.winConstant = winConstant;
    }

    public int getWinConstant() {
        return winConstant;
    }
}
