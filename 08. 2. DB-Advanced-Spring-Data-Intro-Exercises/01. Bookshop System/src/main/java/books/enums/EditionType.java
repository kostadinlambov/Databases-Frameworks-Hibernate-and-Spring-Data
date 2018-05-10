package books.enums;

public enum EditionType {
    NORMAL(0), PROMO(1), GOLD(2);

    private int value;

    EditionType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
