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
    

}
