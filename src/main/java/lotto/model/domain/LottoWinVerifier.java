package lotto.model.domain;

import java.util.List;
import lotto.Lotto;

public class LottoWinVerifier {

    // 사용자가 고른 로또 당첨 번호를 저장한다.
    // 로또 묶음을 받아 당첨 내역을 검사한다.
    // 당첨 개수를 저장한다.

    private final List<Integer> userNumbers;
    private final List<Lotto> lottoWinList;

    private int fifthPlaceCount;
    private int fourthPlaceCount;
    private int thirdPlaceCount;
    private int secondPlaceCount;
    private int firstPlaceCount;


    public LottoWinVerifier(List<Integer> inputNumbers, List<Lotto> lottoList) {
        this.lottoWinList = lottoList;
        this.userNumbers = inputNumbers;
    }

    @Override
    public String toString() {

        return "3개 일치 (5,000원) - " + fifthPlaceCount + "개\n"
                + "4개 일치 (50,000원) - " + fourthPlaceCount + "개\n"
                + "5개 일치 (1,500,000원) - " + thirdPlaceCount + "개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) -" + secondPlaceCount + "개\n"
                + "6개 일치 (2,000,000,000원) -" + fifthPlaceCount + "개\n";
    }

}
