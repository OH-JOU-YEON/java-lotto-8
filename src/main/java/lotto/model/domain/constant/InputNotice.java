package lotto.model.domain.constant;

public enum InputNotice {

    PRICE_INPUT("구입 금액을 입력해주세요."),
    USER_NUMBERS_INPUT("당첨 번호를 입력해주세요."),
    BONUS_NUMBER_INPUT("보너스 번호를 입력해주세요.");

    private final String notice;

    InputNotice(String notice) {
        this.notice = notice;
    }

    public String getNotice() {
        return this.notice;
    }
}
