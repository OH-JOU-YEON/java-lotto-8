package lotto.model.domain.verifier;

import java.util.Arrays;
import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoAndBonusNumber;
import lotto.model.domain.LottoMaker;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class LottoWinVerifierTest {

    LottoMaker lottoMaker = LottoMaker.INSTANCE;
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    Lotto lotto = new Lotto(numbers);
    List<LottoAndBonusNumber> lottoList = lottoMaker.issueLotto(1000);

    @Test
    @DisplayName("로또 검증기 출력 테스트")
    public void lottoVerifierOutTest() {

        LottoWinVerifier lottoWinVerifier = new LottoWinVerifier(numbers, lottoList, 7);

        Assertions.assertThat(lottoWinVerifier.printWinCount()).contains("개 일치", "개");
    }

    @Test
    @DisplayName("검증기가 올바른 수익률을 반환하는지 테스트")
    public void lottoProfitRateTest() {
        LottoWinVerifier lottoWinVerifier = new LottoWinVerifier(numbers, lottoList, 7);

        Assertions.assertThat(lottoWinVerifier.printProfitRate(1000)).contains(".0%");
    }
}