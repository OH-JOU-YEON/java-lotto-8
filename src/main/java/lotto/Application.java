package lotto;

import lotto.controller.LottoLauncherController;

public class Application {
    public static void main(String[] args) {
        LottoLauncherController lottoLauncherController = new LottoLauncherController();
        lottoLauncherController.runLottoLauncher();
    }
}
