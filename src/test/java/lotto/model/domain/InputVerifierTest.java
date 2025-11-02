package lotto.model.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputVerifierTest {

    @Test
    @DisplayName("가격 검증 테스트")
    public void verifyInputPriceTest() {

        InputVerifier inputVerifier = new InputVerifier();

        Assertions.assertThatThrownBy(() -> inputVerifier.verifyPrice((long) 54))
                .isInstanceOf(IllegalArgumentException.class);
    }

}