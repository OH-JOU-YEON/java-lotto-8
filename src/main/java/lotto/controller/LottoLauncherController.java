package lotto.controller;

import java.util.List;
import lotto.model.domain.LottoAndBonusNumber;
import lotto.model.domain.LottoMaker;
import lotto.model.domain.verifier.LottoWinVerifier;
import lotto.model.service.InputService;
import lotto.view.OutputView;

public class LottoLauncherController {

    private final LottoMaker lottoMaker = LottoMaker.INSTANCE;
    private final InputService inputService = new InputService();
    private final OutputView outputView = new OutputView();

    public void runLottoLauncher() {

        long inputPrice = inputService.getInputLottoPrice();

        List<Integer> userNumbers = inputService.getLottoNumber();
        Integer userBonusNumber = inputService.getBonusNumber();

        List<LottoAndBonusNumber> lottoList = lottoMaker.issueLotto(inputPrice);
        LottoWinVerifier lottoWinVerifier = new LottoWinVerifier(userNumbers, lottoList, userBonusNumber);

        outputView.printLottoQuantity(lottoMaker.getLottoQuantity(inputPrice));
        outputView.printLotto(lottoList);
        outputView.printWinDetail(lottoWinVerifier);
        outputView.printWinProfitRate(lottoWinVerifier, inputPrice);
    }
}
