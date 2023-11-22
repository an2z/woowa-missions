package vendingmachine.domain;

public class Money {

    private int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public void reduceAmount(int itemPrice) {
        amount -= itemPrice;
    }

    public int getAmount() {
        return amount;
    }
}
