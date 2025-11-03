package lotto.model.domain.verifier;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import lotto.model.domain.constant.ErrorNotice;

public class InputVerifier {

    Pattern userNumberSeparator = Pattern.compile(",");
    Pattern userNumberTypeVerifier = Pattern.compile("\\D");

    public void verifyPrice(Long price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ErrorNotice.INPUT_PRICE_ERROR_NOTICE.getErrorNoticeString());
        }
    }

    public void verifyPriceFormat(String inputPriceString) {
        if (userNumberTypeVerifier.matcher(inputPriceString).find()) {
            throw new IllegalArgumentException(ErrorNotice.INPUT_PRICE_FORMAT_ERROR_NOTICE.getErrorNoticeString());
        }
    }

    public void verifyUserNumbersFormat(String userNumbersString) {

        List<String> userNumbers = Arrays.stream(userNumbersString.split(userNumberSeparator.pattern())).toList();
        Set<String> duplicatedChecker = new HashSet<>();
        for (String userNumber : userNumbers) {
            verifyNumericType(userNumber);
            verifyUserNumbersRange(userNumber);
            duplicatedChecker.add(userNumber);
        }
        checkDuplicated(duplicatedChecker);
    }

    public void checkDuplicated(Set<String> duplicatedChecker) {
        if (duplicatedChecker.size() != 6) {
            throw new IllegalArgumentException(
                    ErrorNotice.INPUT_USER_NUMBERS_DUPLICATED_ERROR_NOTICE.getErrorNoticeString());
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

    public void verifyBonusNumberRange(Integer bonusNumber) {
        if (bonusNumber > 45 || bonusNumber == 0) {
            throw new IllegalArgumentException(
                    ErrorNotice.INPUT_BONUS_NUMBER_RANGE_ERROR_NOTICE.getErrorNoticeString());
        }
    }
}
