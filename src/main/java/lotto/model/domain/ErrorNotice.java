package lotto.model.domain;

public enum ErrorNotice {

    INPUT_PRICE_ERROR_NOTICE("[ERROR] 금액은 1000원으로 나누어 떨어져야 합니다");

    private final String errorNoticeString;

    ErrorNotice(String errorNoticeString) {
        this.errorNoticeString = errorNoticeString;
    }

    public String getErrorNoticeString() {
        return this.errorNoticeString;
    }
}
