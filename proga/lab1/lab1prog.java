import java.util.Random;

import static java.lang.Math.*;

public class Lab1 {

    public static double calculation(long w, double x) {

        double ans;

        switch ((int) w) {
            case 13:
                ans = pow(((sin(atan((x - 2) / 12))) / (pow((pow(Math.E, x) - 1) / (pow(x, (3d / 4) * x)), 2) - (1d / 2))), 3);
                break;

            case 5, 6, 10, 14, 15, 16:
                ans = pow(sin(pow(Math.E, x)), ((Math.PI - pow(x, (1d / 3) * (3 * (x + (1d / 3)) + 1))) / 0.25));
                break;

            default:
                ans = pow(atan(cos(cos(asin((x - 2) / 12)))), 0.5 * (1 - sin(pow(pow(x, (2d / 3) / (1d / 4 + x)), 3))));
                break;
        }
        return ans;

    }

    public static double rand(int a, int b) {

        Random r = new Random();
        double ans = r.nextInt(b - a + 1) + a;
        if (ans != 4) {
            ans += random();
        }
        return ans;

    }

    public static void show(double[][] w) {
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.printf("%15.4f", w[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        long h [] = new long[13];
        long[] w = {0,1,2};
        w = new long[13];

        double[] x;
        x = new double[20];

        double[][] c;
        c = new double[13][20];

        for (int i = 0; i < 13; i++) {
            w[i] = i + 4;
        }

        System.out.println("W:");

        for (int i = 0; i < 13; i++) {
            System.out.print(w[i] + " ");
        }

        System.out.println();
        System.out.println();


        for (int i = 0; i < 20; i++) {
            x[i] = rand(-8, 4);
        }

        System.out.println("X:");

        for (int i = 0; i < 20; i++) {
            System.out.print(x[i] + " ");
        }

        System.out.println();
        System.out.println();

        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 20; j++) {
                c[i][j] = calculation(w[i], x[j]);
            }
        }

        System.out.println("С:");
        show(c);

    }

}
