import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static BigInteger[][] cal_fm = { { new BigInteger("1"), new BigInteger("1") },
            { new BigInteger("1"), new BigInteger("0") } };
    static BigInteger[][] cal_sum = { { new BigInteger("2"), new BigInteger("0"), new BigInteger("-1") },
            { new BigInteger("1"), new BigInteger("0"), new BigInteger("0") },
            { new BigInteger("0"), new BigInteger("1"), new BigInteger("0") } };
    static BigInteger[][] MOD = { { new BigInteger("1") }, { new BigInteger("1") } };
    static BigInteger[][] SUM = { { new BigInteger("4") }, { new BigInteger("2") }, { new BigInteger("1") } };

    private static BigInteger[][] mult(BigInteger[][] cal_fm2, BigInteger[][] mOD2, BigInteger p, boolean flag) {
        int i_max = cal_fm2.length;
        int j_max = mOD2[0].length;
        int k_max = cal_fm2[0].length;
        if (k_max != mOD2.length) {
            return null;
        }
        BigInteger[][] ans = new BigInteger[i_max][j_max];
        for (int i = 0; i < i_max; i++) {
            for (int j = 0; j < j_max; j++) {
                BigInteger sum = new BigInteger("0");
                for (int k = 0; k < k_max; k++) {
                    if (flag) {
                        sum = (sum.mod(p)).
                                add(cal_fm2[i][k].multiply(mOD2[k][j]).
                                        mod(p)).
                                mod(p);
                    } else {
                        sum = (sum.add(cal_fm2[i][k].multiply(mOD2[k][j])));
                    }
                }
                if (flag) {
                    ans[i][j] = sum.mod(p);
                } else {
                    ans[i][j] = sum;
                }
            }
        }
        return ans;
    }

    public static String fib(long n, long m, long p) {
        BigInteger mod = new BigInteger("0");
        BigInteger sum = new BigInteger("0");
        if (m > n + 2) {
            if (n == 1) {
                sum = new BigInteger("1");
            } else {
                n = n - 1;
                while (n != 0) {
//					System.out.println(n);
                    if ((n & 1) == 1) {
                        SUM = mult(cal_sum, SUM, new BigInteger(String.valueOf(p)), true);
                    }
                    n = n >> 1;
                    cal_sum = mult(cal_sum, cal_sum, new BigInteger(String.valueOf(p)), true);
                }
                sum = SUM[2][0];
            }
//			System.out.println(sum);
            return sum.mod(new BigInteger(String.valueOf(p))).toString();
        } else {
            if (m == 1 || m == 2) {
                mod = new BigInteger("1");
            } else {
                m = m - 1;
                while (m != 0) {
                    if ((m & 1) == 1) {
                        MOD = mult(cal_fm, MOD, new BigInteger(String.valueOf(p)), false);
                    }
                    m = m >> 1;
                    cal_fm = mult(cal_fm, cal_fm, new BigInteger(String.valueOf(p)), false);
                }
                mod = MOD[1][0];
            }
            if (n == 1) {
                sum = new BigInteger("1");
            } else {
                n = n - 1;
                while (n != 0) {
                    if ((n & 1) == 1) {
                        SUM = mult(cal_sum, SUM, mod, true);
                    }
                    n = n >> 1;
                    cal_sum = mult(cal_sum, cal_sum, mod, true);
                }
                sum = SUM[2][0];
            }
            return sum.mod(new BigInteger(String.valueOf(p))).toString();
        }
    }

    public static void main(String[] args) {
        long n, m, p;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextLong();
        m = scanner.nextLong();
        p = scanner.nextLong();
        System.out.println(fib(n, m, p));
    }
}
