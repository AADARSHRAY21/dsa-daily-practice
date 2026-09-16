/*
 * Problem: Maximum Product
 * Link: 
 * Difficulty: Medium
 * Pattern: Greedy + Mathematical Optimization
 * Topics: greedy, Math, dp
 *
 * Approach (in my own words):
 * -
 *
 * Time Complexity: O(n) with greedy + mathemmatical , O(log n) with proper mathematical formula.
 * Space Complexity: O(1).
 *
 * Needed hint? Yes
 * Notes : "Split N so that product is maximum.",Maximum Product = Break into 3s,Mathematical Formula.
 * Revisit on: (7 days from 2026-09-16)
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n == 2) {
            System.out.println(1);
        }
        else if (n == 3) {
            System.out.println(2);
        }
        else {

            long product = 1;

            while (n > 4) {

                product *= 3;
                n -= 3;
            }

            product *= n;

            System.out.println(product);
        }

        sc.close();
    }
}
and Mathematical formula
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n == 2) {
            System.out.println(1);
        }
        else if (n == 3) {
            System.out.println(2);
        }
        else {

            int quotient = n / 3;
            int remainder = n % 3;

            long answer;

            if (remainder == 0) {
                answer = power(3, quotient);
            }
            else if (remainder == 1) {
                answer = power(3, quotient - 1) * 4;
            }
            else {
                answer = power(3, quotient) * 2;
            }

            System.out.println(answer);
        }

        sc.close();
    }

    static long power(long base, int exponent) {

        long result = 1;

        while (exponent > 0) {

            result *= base;
            exponent--;
        }

        return result;
    }
}
To make the mathematical implementation truly O(log N), use binary exponentiation for the power calculation.
static long power(long base, int exponent) {

    long result = 1;

    while (exponent > 0) {

        if (exponent % 2 == 1) {
            result *= base;
        }

        base *= base;
        exponent /= 2;
    }

    return result;
}

