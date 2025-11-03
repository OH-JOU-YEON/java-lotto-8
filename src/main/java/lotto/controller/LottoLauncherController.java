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
        outputView.printLottoQuantity(lottoMaker.getLottoQuantity(inputPrice));

        List<LottoAndBonusNumber> lottoList = lottoMaker.issueLotto(inputPrice);
        outputView.printLotto(lottoList);

        List<Integer> userNumbers = inputService.getLottoNumber();
        Integer userBonusNumber = inputService.getBonusNumber();

        LottoWinVerifier lottoWinVerifier = new LottoWinVerifier(userNumbers, lottoList, userBonusNumber);
        outputView.printWinDetail(lottoWinVerifier);
        outputView.printWinProfitRate(lottoWinVerifier, inputPrice);

    }
}
