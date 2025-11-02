package lotto.view;


import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    @DisplayName("입력이 잘 들어오는지 테스트")
    public void inputTest() {
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream("10000".getBytes()));
        Assertions.assertThat(inputView.getInputPrice()).isEqualTo(10000);
    }

}