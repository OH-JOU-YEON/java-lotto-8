package lotto.model.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMakerTest {

    LottoMaker lottoMaker = new LottoMaker();

    @Test
    @DisplayName("로또금액과 돈을 넣으면 개수만큼 로또를 발행하는지 테스트")
    public void lottoQuantityTest() {
        List<Lotto> issuedLotto = lottoMaker.issueLotto(10000);

        Assertions.assertThat(issuedLotto.size()).isEqualTo(10);
    }


}