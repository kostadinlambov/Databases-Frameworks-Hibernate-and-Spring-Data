package p04_Number_in_Reversed_Order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BigDecimal inputNum = new BigDecimal(reader.readLine());
        DecimalNumber dn = new DecimalNumber(inputNum);

        System.out.println(dn.reverseNum());
    }
}

