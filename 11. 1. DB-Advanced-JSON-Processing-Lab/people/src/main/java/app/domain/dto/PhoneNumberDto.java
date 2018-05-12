package app.domain.dto;

public class PhoneNumberDto {
    private  String number;

    public PhoneNumberDto(String number) {
        this.number = number;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
