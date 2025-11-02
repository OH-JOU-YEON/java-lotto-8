package lotto.model.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMaker {

    // 금액을 입력받아 금액만큼 로또를 발행한다.
    // 발행한 로또를 반환한다.
    private final long lottoPrice = 1000;

    public List<LottoAndBonusNumber> issueLotto(long inputPrice) {
        long lottoQuantity = getLottoQuantity(inputPrice);
        List<LottoAndBonusNumber> lottoList = new ArrayList<>();

        for (int i = 0; i < lottoQuantity; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 7);
            Lotto lotto = new Lotto(randomNumbers.subList(0, 6));
            Integer bonusNumber = randomNumbers.get(6);
            LottoAndBonusNumber lottoAndBonusNumber = new LottoAndBonusNumber(lotto, bonusNumber);
            lottoList.add(lottoAndBonusNumber);
        }

        return lottoList;
    }

    private long getLottoQuantity(long inputPrice) {
        return inputPrice / this.lottoPrice;
    }

}
