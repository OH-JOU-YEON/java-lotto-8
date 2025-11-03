package lotto.model.service;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import lotto.model.domain.verifier.InputVerifier;
import lotto.view.InputView;

public class InputService {

    private final InputView inputView = new InputView();
    private final InputVerifier inputVerifier = new InputVerifier();
    Pattern userNumberSeparator = Pattern.compile(",");

    public long getInputLottoPrice() {
        long lottoPrice = inputView.getInputPrice();
        inputVerifier.verifyPrice(lottoPrice);
        return lottoPrice;
    }

    public List<Integer> getLottoNumber() {
        String inputLottoNumber = inputView.getInputUserNumbers();
        inputVerifier.verifyUserNumbersFormat(inputLottoNumber);
        return Arrays.stream(inputLottoNumber.split(userNumberSeparator.pattern()))
                .map(Integer::parseInt).toList();
    }

    public Integer getBonusNumber() {
        Integer bonusNumber = inputView.getBonusNumber();
        inputVerifier.verifyBonusNumberRange(bonusNumber);
        return bonusNumber;
    }
}
