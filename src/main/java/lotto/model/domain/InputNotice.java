package lotto.model.domain;

public enum InputNotice {

    PRICE_INPUT("구입 금액을 입력해주세요.");

    private final String noticeString;

    InputNotice(String noticeString) {
        this.noticeString = noticeString;
    }

    public String getNoticeString() {
        return this.noticeString;
    }
}
