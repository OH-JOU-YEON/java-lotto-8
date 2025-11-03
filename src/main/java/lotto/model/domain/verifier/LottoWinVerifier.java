package lotto.model.domain.verifier;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.model.domain.LottoAndBonusNumber;
import lotto.model.domain.constant.Place;

public class LottoWinVerifier {

    // 사용자가 고른 로또 당첨 번호를 저장한다.
    // 로또 묶음을 받아 당첨 내역을 검사한다.
    // 당첨 개수를 저장한다.
    // 수익률을 검사한다.

    private final List<Integer> userNumbers;
    private final List<LottoAndBonusNumber> lottoList;


    private final Map<Place, Integer> placeCount = new EnumMap<>(Place.class);


    public LottoWinVerifier(List<Integer> inputNumbers, List<LottoAndBonusNumber> lottoList, Integer bonusNumber) {
        this.lottoList = lottoList;
        this.userNumbers = inputNumbers;
        initializePlaceCount();
        verifyLottoPlace(bonusNumber);
    }

    private void initializePlaceCount() {
        List<Place> places = Arrays.stream(Place.values()).sorted(Collections.reverseOrder()).toList();
        for (Place place : places) {
            this.placeCount.put(place, 0);
        }
    }

    private void verifyLottoPlace(int bonusNumber) {
        // 로또 검증하기
        // 로또 등수를 맵에 저장한다.

        Place[] places = Place.values();

        for (LottoAndBonusNumber lottoAndBonus : this.lottoList) {
            int lottoWinNumber = lottoAndBonus.lotto()
                    .validateWin(this.userNumbers, lottoAndBonus.bonusNumber(), bonusNumber);
            int placeNumber = changeLottoWinOrdinalToPlaceOrdinal(lottoWinNumber);
            if (placeNumber < 0) {
                continue;
            }
            Integer beforeValue = nullCheck(placeCount.get(places[placeNumber]));
            placeCount.put(places[placeNumber], beforeValue + 1);
        }
    }

    private Integer nullCheck(Integer integer) {
        if (integer == null) {
            return 0;
        }
        return integer;
    }


    private int changeLottoWinOrdinalToPlaceOrdinal(int lottoWinOrdinal) {
        return lottoWinOrdinal - 1;
    }

    private double calculateProfitRate(long inputPrice) {
        return (getProfit()) / inputPrice * 100;
    }

    private double getProfit() {
        double profit = 0;

        for (Place key : this.placeCount.keySet()) {
            profit += key.getValue() * this.placeCount.get(key);
        }

        return profit;
    }

    public String printWinCount() {

        DecimalFormat df = new DecimalFormat("###,###");

        StringBuilder sb = new StringBuilder();

        for (Place key : this.placeCount.keySet()) {
            sb.append(key.getWinNotice())
                    .append(" (").append(df.format(key.getValue()))
                    .append("원) - ")
                    .append(this.placeCount.get(key).toString())
                    .append("개\n");

        }
        return sb.toString();
    }

    public String printProfitRate(long inputPrice) {

        return "총 수익률은 "
                + String.format("%.1f", calculateProfitRate(inputPrice))
                + "%입니다.";
    }
}
