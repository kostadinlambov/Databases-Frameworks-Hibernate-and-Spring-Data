package p04_Telephony;

public class Smartphone implements Callable, Browsable {


    @Override
    public void browse( String url) {
        System.out.printf("Browsing: %s!%n", url);

    }

    @Override
    public void call(String number) {
        System.out.printf("Calling... %s%n", number);
    }
}
