package lotto.model.domain.constant;

public enum LottoPrice {
    EACH_PRICE(1000);

    private final long price;

    LottoPrice(long price) {

        this.price = price;
    }

    public long getPrice() {
        return price;
    }
}
