package books.enums;

public enum AgeRestriction {
    MINOR(0), TEEN(1), ADULT(2);

    private int value;

    AgeRestriction(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
