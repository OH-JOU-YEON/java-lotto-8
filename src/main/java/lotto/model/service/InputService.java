package lotto.model.service;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import lotto.model.domain.verifier.InputVerifier;
import lotto.view.InputView;

public class InputService {

    private final InputVerifier inputVerifier = new InputVerifier();
    private final InputView inputView = new InputView();
    Pattern userNumberSeparator = Pattern.compile(",");

    public long getInputLottoPrice() {
        try {
            String lottoPriceString = inputView.getInputPrice();
            inputVerifier.verifyPriceFormat(lottoPriceString);
            long lottoPrice = Long.parseLong(lottoPriceString);
            inputVerifier.verifyPrice(lottoPrice);
            return lottoPrice;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInputLottoPrice();
        }
    }

    public List<Integer> getLottoNumber() {
        try {
            String inputLottoNumber = inputView.getInputUserNumbers();
            inputVerifier.verifyUserNumbersFormat(inputLottoNumber);
            return Arrays.stream(inputLottoNumber.split(userNumberSeparator.pattern()))
                    .map(Integer::parseInt).toList();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLottoNumber();
        }
    }

    public Integer getBonusNumber() {
        try {
            Integer bonusNumber = inputView.getBonusNumber();
            inputVerifier.verifyBonusNumberRange(bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber();
        }
    }
}
