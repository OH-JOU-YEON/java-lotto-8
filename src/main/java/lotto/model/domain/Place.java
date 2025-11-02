package lotto.model.domain;

public enum Place {
    // 등수
    // 등수 번호와 등수 개수를 가짐

    FIRST_PLACE(2000000000L, "6개 일치"),
    SECOND_PLACE(30000000L, "5개 일치, 보너스 볼 일치"),
    THIRD_PLACE(1500000L, "5개 일치"),
    FOURTH_PLACE(50000, "4개 일치"),
    FIFTH_PLACE(5000, "3개 일치");

    private final long value;

    private final String winNotice;

    Place(long value, String winNotice) {
        this.value = value;
        this.winNotice = winNotice;
    }

    public long getValue() {
        return this.value;
    }

    public String getWinNotice() {
        return this.winNotice;
    }
}
