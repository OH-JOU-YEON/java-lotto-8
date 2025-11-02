package lotto.model.domain;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class LottoWinVerifierTest {

    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    Lotto lotto = new Lotto(numbers);
    List<Lotto> lottoList = List.of(lotto);

    @Test
    @DisplayName("로또 검증기 출력 테스트")
    public void lootVerifierOutTest() {

        LottoWinVerifier lottoWinVerifier = new LottoWinVerifier(numbers, lottoList, 7);

        Assertions.assertThat(lottoWinVerifier.printWinCount()).contains("개 일치", "개");

    }

}