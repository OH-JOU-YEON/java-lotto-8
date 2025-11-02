package lotto.model.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMaker {

     // 금액을 입력받아 금액만큼 로또를 발행한다.
     // 발행한 로또를 반환한다.
    private long lottoPrice = 1000;

    public List<Lotto> issueLotto(long inputPrice) {
        long lottoQuantity = getLottoQuantity(inputPrice);
        List<Lotto> lottoList = new ArrayList<>();

        for(int i = 0; i<lottoQuantity; i++) {
            lottoList.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        return lottoList;
    }

    private long getLottoQuantity(long inputPrice) {
        return inputPrice / this.lottoPrice;
    }

}
