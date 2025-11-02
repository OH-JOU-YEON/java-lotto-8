package lotto.model.domain.Enum;

public enum InputNotice {

    PRICE_INPUT("구입 금액을 입력해주세요."),
    USER_NUMBERS_INPUT("당첨 번호를 입력해주세요."),
    BONUS_NUMBER_INPUT("보너스 번호를 입력해주세요.");

    private final String noticeString;

    InputNotice(String noticeString) {
        this.noticeString = noticeString;
    }

    public String getNoticeString() {
        return this.noticeString;
    }
}
