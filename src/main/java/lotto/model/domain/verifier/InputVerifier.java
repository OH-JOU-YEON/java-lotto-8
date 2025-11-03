package lotto.model.domain.verifier;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import lotto.model.domain.constant.ErrorNotice;
import lotto.model.domain.constant.LottoWinConstant;

public class InputVerifier {

    Pattern userNumberSeparator = Pattern.compile(",");
    Pattern userNumberTypeVerifier = Pattern.compile("\\D");

    public void verifyPrice(Long price) {
        if (price % LottoWinConstant.LOTTO_NUMBERS_COUNT.getWinConstant() != 0) {
            throw new IllegalArgumentException(ErrorNotice.INPUT_PRICE_ERROR_NOTICE.getErrorNotice());
        }
    }

    public void verifyPriceFormat(String inputPrice) {
        if (userNumberTypeVerifier.matcher(inputPrice).find()) {
            throw new IllegalArgumentException(ErrorNotice.INPUT_PRICE_FORMAT_ERROR_NOTICE.getErrorNotice());
        }
    }

    public void verifyUserNumbersFormat(String inputUserNumbers) {

        List<String> userNumbers = Arrays.stream(inputUserNumbers.split(userNumberSeparator.pattern())).toList();
        Set<String> duplicatedChecker = new HashSet<>();
        for (String userNumber : userNumbers) {
            verifyNumericType(userNumber);
            verifyUserNumbersRange(userNumber);
            duplicatedChecker.add(userNumber);
        }
        checkDuplicated(duplicatedChecker);
    }

    public void checkDuplicated(Set<String> duplicatedChecker) {
        if (duplicatedChecker.size() != LottoWinConstant.LOTTO_NUMBERS_COUNT.getWinConstant()) {
            throw new IllegalArgumentException(
                    ErrorNotice.INPUT_USER_NUMBERS_DUPLICATED_ERROR_NOTICE.getErrorNotice());
        }
    }

    private void verifyNumericType(String userNumber) {
        if (userNumberTypeVerifier.matcher(userNumber).find()) {
            throw new IllegalArgumentException(
                    ErrorNotice.INPUT_USER_NUMBERS_FORMAT_ERROR_NOTICE.getErrorNotice());
        }
    }

    private void verifyUserNumbersRange(String userNumber) {
        if (Long.parseLong(userNumber) > LottoWinConstant.LOTTO_NUMBER_MAX_VALUE.getWinConstant() ||
                Long.parseLong(userNumber) < LottoWinConstant.LOTTO_NUMBER_MIN_VALUE.getWinConstant()) {
            throw new IllegalArgumentException(
                    ErrorNotice.INPUT_USER_NUMBERS_FORMAT_ERROR_NOTICE.getErrorNotice());
        }
    }

    public void verifyBonusNumberRange(Integer bonusNumber) {
        if (bonusNumber > LottoWinConstant.LOTTO_NUMBER_MAX_VALUE.getWinConstant() ||
                bonusNumber < LottoWinConstant.LOTTO_NUMBER_MIN_VALUE.getWinConstant()) {
            throw new IllegalArgumentException(
                    ErrorNotice.INPUT_BONUS_NUMBER_RANGE_ERROR_NOTICE.getErrorNotice());
        }
    }
}
