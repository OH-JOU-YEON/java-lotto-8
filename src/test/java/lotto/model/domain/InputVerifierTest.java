package lotto.model.domain;


import lotto.model.domain.verifier.InputVerifier;
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

    @Test
    @DisplayName("사용자 입력 번호 예외 테스트")
    public void verifyUserNumbersTest() {

        InputVerifier inputVerifier = new InputVerifier();

        Assertions.assertThatThrownBy(() -> inputVerifier.verifyUserNumbersFormat("467,13,21"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자 입력 번호에 숫자 외의 것이 들어갔는지 테스트")
    public void verifyUserNumbersFormatTest() {

        InputVerifier inputVerifier = new InputVerifier();

        Assertions.assertThatThrownBy(() -> inputVerifier.verifyUserNumbersFormat("4문7,13,21"))
                .isInstanceOf(IllegalArgumentException.class);

    }
}