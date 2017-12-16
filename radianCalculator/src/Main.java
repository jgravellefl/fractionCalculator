import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class Main {
/*
    public static int[] simplify(int[] a){
        if (a.length == 2){
            if (a[1] == 1){
                return a;
            }
            for (int i = 2; i < 10; i++){
                if (a[1] % i ==0 & a[0] % i ==0){
                    a[1] /= i;
                    a[0] /=i;
                }
            }
            return a;
        }
        else {
            if (a[2] == 1){
                return a;
            }
        }
        for (int i = 2; i < 10; i++){
            if (a[2] % i ==0 & a[0] % i ==0){
                a[2] /= i;
                a[0] /=i;
            }
        }
        return a;
    }
    public static int[] rationalize(int[] a){
        a[1] *= a[3];
        a[2] *= a[3];
        a[3] = 1;
        return a;
    }

    public static int[] addVals(int[] a, int[] b) {
        int[] c = new int[2];
        if (a[1] == b[1]) {
            c[0] = a[0] + a[0];
            c[1] = a[1];
        } else {
            c[1] = a[1] * b[1];
            c[0] = (a[0] * (c[1] / a[1])) + (b[0] * (c[1] / b[1]));
        }
            return simplify(c);
    }

        public static int[] multVals(int[] a, int[] b){
            int[] c = new int[4];
            c[0] = a[0] * b[0];
            c[1] = 1;
            c[2] = a[1] * b[1];
            c[3] = 1;
            return simplify(c);
        }

        public static int[] subVals(int[] a, int[] b){
            int[] c = new int[2];
            if (a[1] == b[1]){
                c[0] = a[0] - b[0];
                c[1] = a[1];
            }
            else{
                c[1] = a[1] * b[1];
                c[0] = (a[0] * (c[1] / a[1])) - (b[0] * (c[1] / b[1]));
            }
            return simplify(c);
        }

        public static int[] divideVals(int[] a, int[] b){
            int[] c = new int[2];
            c[0] = a[0] * b[1];
            c[1] = a[1] * b[0];
            return simplify(c);
        }

        public static int[] sqrVals(int[] a, int[] b){
            int z = a[0];
            int q = a[1];
            if (b[0] < 0){
                a[0] = q;
                a[1] = z;
                b[0] = -b[0];
            }
            int x = a[0];
            int y = a[1];
            System.out.println(a[0]);
            System.out.println(a[1]);
            for (int i = 1; i < b[0]; i++){
                a[0] *= x;
                a[1] *=y;
            }
            if (b[1] > 1){
                return sqrRoot(a, b);
            }
            else{
                return simplify(a);
            }
        }

        public static int[] sqrRoot(int[] a, int[] b) {
            int[] c = new int[4];
            System.out.println(a[0]);
            System.out.println(a[1]);
            int negCounter = 0;
            int counter = 0;
            while (counter < 2) {
                System.out.println("'SHould i kill myself?");
                counter++;
                int x = 0;
                if (a[0] < 0 && b[1] % 2 == 0){
                    break;
                }
                else if (a[0] < 0){
                    negCounter++;
                    a[0] = -a[0];
                }
                if (counter == 1) {
                    x = a[0];
                } else {
                    x = a[1];
                }
                for (int t = (int)(.5 * x) + 1; t > 0; t--) {
                    System.out.println("t" + t + "");
                    int n = t;
                    for (int v = 1; v < b[1]; v++) {
                        n *= t;
                    }
                    System.out.println("n" + n + "");
                    System.out.println(x);
                    if (n == x) {
                        x = t;
                        System.out.println("Does it come here");
                        break;
                    } else {
                        for (int i = 0; i < x + 1; i++) {
                            int v = i * n;
                            if (v == x) {
                                x = t;
                                System.out.println("Counter is " + counter + "");
                                if (counter == 1) {
                                    c[1] = i;
                                    i += 1000000000;
                                    n += 1000000000;
                                    t = -1;
                                } else {
                                    c[3] = i;
                                    System.out.println("Heyyyy" + i + "");
                                    i += 1000000000;
                                    n += 1000000000;
                                    t = -1;
                                }
                            }
                        }
                    }
                }
                if (counter == 1) {
                    if (negCounter == 1){
                        System.out.println("this is x "+ x + "");
                        c[0] = -x;
                    }
                    else {
                        System.out.println("hello");
                        c[0] = x;
                    }
                } else {
                    c[2] = x;
                }

            }
            System.out.println(c[0]);
            System.out.println(c[2]);
            if (c[1] == 0){
                c[1] = 1;
            }
            if (c[3] == 0){
                c[3] = 1;
            }
            if (c[3] != 1){
                c = rationalize(c);
            }
            return simplify(c);
        }
*/
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("input equation");
        String z = scnr.nextLine();
        String[] inputStr = z.split(" ");
        ArrayList<String> aList = new ArrayList<String>();
        Collections.addAll(aList, inputStr);

        orderOfOps y = new orderOfOps();
        System.out.println(y.OrderOfOps(aList));


        /*
        System.out.println("" + q[0] + "/" + q[1] + "");
        q = multVals(a, b);
        System.out.println("" + q[0] + "/" + q[1] + "");
        q = subVals(a, b);
        System.out.println("" + q[0] + "/" + q[1] + "");
        q = divideVals(a,b);
        System.out.println("" + q[0] + "/" + q[1] + "");

        q = sqrVals(a, b);

        int[] z = new int[4];
        z = q.clone();
        int yep = 0;
        if (a[0] < 0 && b[1] % 2 == 0) {
            System.out.println("Does not exist");
            yep++;
        }
        if (yep == 0) {
            if (q[1] == 1 && q[3] == 1) {
                System.out.println("" + q[0] + "/" + q[2] + "");
            } else if (q[1] == 1) {
                System.out.println("" + q[0] + "/" + q[2] + " " + b[1] + "root " + q[3] + "");
            } else if (q[3] == 1) {
                System.out.println("" + q[0] + " " + b[1] + "√" + q[1] + "/" + q[2] + "");
            } else {
                System.out.println("" + q[0] + " " + b[1] + "√" + q[1] + "/" + q[2] + " " + b[1] + "root " + q[3] + "");
            }
        }
    */
    }
}
