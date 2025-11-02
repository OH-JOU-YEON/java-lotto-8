package lotto.model.domain;

public class InputVerifier {

    public void verifyPrice(Long price) {

        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ErrorNotice.INPUT_PRICE_ERROR_NOTICE.getErrorNoticeString());
        }
    }
    
}
