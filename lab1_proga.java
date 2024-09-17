import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Lab1 {

    public static boolean in_set(long x, int [] X) {
        int k = 0;
        for (int i : X) {
            if (x == i) {
                k = 1;
                break;
            }
        }
        if (k == 1) return true;
        else return false;
    }

    public static double calculation(double x, long z) {
        int [] X = {5, 6, 10, 14, 15, 16};
        if (z == 13) return (Math.sin(Math.atan((x-2)/12)))/(((Math.pow(Math.E,x)-1)/(Math.pow(x,0.75*x))));
        else if (in_set(z,X)) return Math.pow(Math.sin(Math.pow(Math.E,x)), 4*(Math.PI-Math.pow(x,(3*x + 2)/3)));
        else return Math.pow(Math.atan(Math.cos(Math.cos(Math.asin((x-2)/12)))),0.5*(1-Math.sin(Math.pow(Math.pow(x,(2/(3*(0.25+x)))),3))));
    }

    public static void show(double [][] w){
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 20; j++) System.out.printf("%12.4f ", w[i][j]);
            System.out.println();
        }
    }
    public static void main(String[] args) {

            Random r = new Random();

            long [] z;
            z = new long[13];

            double [] x;
            x = new double[20];

            double [][] w;
            w = new double[13][20];


            for (int i = 0; i < 13; i++) z[i] = i+4;
            System.out.println("Z:");
            for (int i = 0; i < 13; i++) System.out.print(z[i] + " ");

            System.out.println();
            System.out.println();

            for (int i = 0; i < 20; i++) x[i] = r.nextInt(13)-8;
            System.out.println("X:");
            for (int i = 0; i < 20; i++) System.out.print(x[i]+ " ");

            System.out.println();
            System.out.println();

            System.out.println("W:");
            for (int i = 0; i < 13; i++) for (int j = 0; j < 20; j++) w[i][j] = calculation(x[j],z[i]);

            show(w);
    }
}
