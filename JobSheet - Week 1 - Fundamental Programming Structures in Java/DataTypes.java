package w1;

/**
 *
 * @author ZAHRA
 */

import java.util.Scanner;
import java.math.BigInteger;

public class DataTypes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        for (int i = 0; i < t; i++) {
            if (input.hasNextBigInteger()) {
                BigInteger n = input.nextBigInteger();
                
                if (n.compareTo(BigInteger.valueOf(Long.MIN_VALUE)) >= 0 && 
                    n.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) <= 0) {
                    
                    long val = n.longValue();
                    
                    System.out.println(n + " can be fitted in:");
                    if (val >= Byte.MIN_VALUE && val <= Byte.MAX_VALUE) System.out.println("* byte");
                    if (val >= Short.MIN_VALUE && val <= Short.MAX_VALUE) System.out.println("* short");
                    if (val >= Integer.MIN_VALUE && val <= Integer.MAX_VALUE) System.out.println("* int");
                    System.out.println("* long");
                } else {
                    System.out.println(n + " can't be fitted anywhere.");
                }
            } else {
                System.out.println(input.next() + " can't be fitted anywhere.");
            }
        }
    }
}