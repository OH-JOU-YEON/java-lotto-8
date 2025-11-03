package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.domain.constant.InputNotice;

public class InputView {

    // 입력을 받는다

    public String getInputPrice() {
        System.out.println(InputNotice.PRICE_INPUT.getNoticeString());
        return Console.readLine();
    }

    public String getInputUserNumbers() {
        System.out.println(InputNotice.USER_NUMBERS_INPUT.getNoticeString());
        return Console.readLine();
    }

    public Integer getBonusNumber() {
        System.out.println(InputNotice.BONUS_NUMBER_INPUT.getNoticeString());
        return Integer.parseInt(Console.readLine());
    }
}
