package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.domain.InputNotice;

public class InputView {

    // 입력을 받는다

    public long getInputPrice() {
        System.out.println(InputNotice.PRICE_INPUT.getNoticeString());
        return Long.parseLong(Console.readLine());
    }

}
