package lotto.model.domain.verifier;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import lotto.model.domain.Enum.ErrorNotice;

public class InputVerifier {

    Pattern userNumberSeparator = Pattern.compile(",");
    Pattern userNumberTypeVerifier = Pattern.compile("\\D");

    public void verifyPrice(Long price) {

        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ErrorNotice.INPUT_PRICE_ERROR_NOTICE.getErrorNoticeString());
        }
    }

    public void verifyUserNumbersFormat(String userNumbersString) {

        List<String> userNumbers = Arrays.stream(userNumbersString.split(userNumberSeparator.pattern())).toList();

        for (String userNumber : userNumbers) {
            verifyNumericType(userNumber);
            verifyUserNumbersRange(userNumber);
        }
    }

    private void verifyNumericType(String userNumber) {
        if (userNumberTypeVerifier.matcher(userNumber).find()) {
            throw new IllegalArgumentException(
                    ErrorNotice.INPUT_USER_NUMBERS_FORMAT_ERROR_NOTICE.getErrorNoticeString());
        }
    }

    private void verifyUserNumbersRange(String userNumber) {
        if (Long.parseLong(userNumber) > 45 || Long.parseLong(userNumber) == 0) {
            throw new IllegalArgumentException(
                    ErrorNotice.INPUT_USER_NUMBERS_FORMAT_ERROR_NOTICE.getErrorNoticeString());
        }
    }

}
