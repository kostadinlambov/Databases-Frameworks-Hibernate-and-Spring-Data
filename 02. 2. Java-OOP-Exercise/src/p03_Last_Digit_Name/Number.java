package p03_Last_Digit_Name;

public class Number {
    private int number;

    public Number(int number){
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public String getNameOfLastDigit(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.number).reverse();
        String lastDigit = sb.charAt(0)+"";

        switch (lastDigit){
            case "0":
                return "zero";
            case "1":
                return "One";
            case "2":
                return "two";
            case "3":
                return "three";
            case "4":
                return "four";
            case "5":
                return "five";
            case "6":
                return "six";
            case "7":
                return "seven";
            case "8":
                return "eight";
            case "9":
                return "nine";
        }
        return null;
    }
}
