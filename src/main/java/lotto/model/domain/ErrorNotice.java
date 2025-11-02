package lotto.model.domain;

public enum ErrorNotice {

    INPUT_PRICE_ERROR_NOTICE("[ERROR] 금액은 1000원으로 나누어 떨어져야 합니다"),
    INPUT_USER_NUMBERS_FORMAT_ERROR_NOTICE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String errorNoticeString;

    ErrorNotice(String errorNoticeString) {
        this.errorNoticeString = errorNoticeString;
    }

    public String getErrorNoticeString() {
        return this.errorNoticeString;
    }
}
