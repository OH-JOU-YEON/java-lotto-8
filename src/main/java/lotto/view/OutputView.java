package lotto.view;

import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoWinVerifier;

public class OutputView {

    public void printLottoQuantity(long quantity) {
        System.out.println(quantity + "개 구매했습니다");
    }

    public void printLotto(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.printLotto());
        }
    }

    public void printWinDetail(LottoWinVerifier lottoWinVerifier) {
        System.out.println(lottoWinVerifier.printWinCount());
    }

    public void printWinProfitRate(LottoWinVerifier lottoWinVerifier, long inputPrice) {
        System.out.println(lottoWinVerifier.printProfitRate(inputPrice));
    }
}
