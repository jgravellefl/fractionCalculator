import java.util.ArrayList;

public class orderOfOps {

    public int[] toFraction(String a) {
        int[] q = new int[2];
        int numa = 0;
        int v = 10;
        int numb = 0;
        int c = 0;
        if (a.contains("/")) {
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != '/') {
                    if (numa == 0) {
                        numa = Character.getNumericValue(a.charAt(i));
                    } else {
                        numa = (numa * v) + Character.getNumericValue(a.charAt(i));
                        v *= 10;
                    }
                } else {
                    i++;
                    while (i < a.length()) {
                        if (numb == 0) {
                            numb = Character.getNumericValue(a.charAt(i));
                        } else {
                            numb = numb * c + Character.getNumericValue(a.charAt(i));
                            i++;
                            c *= 10;
                        }
                    }
                }
            }
        }
        else{
            numa = Integer.parseInt(a);
            numb = 1;

        }
        q[0] = numa;
        q[1] = numb;
        return q;
    }

    public String OrderOfOps(ArrayList<String> x) {
        int addition_count = 0;
        int subtraction_count = 0;
        int mult_count = 0;
        int div_count = 0;
        int sqr_count = 0;
        int root_count = 0;
        int paren_count = 0;
        for (int i = 0; i < x.size(); i++) {
            if (x.get(i).equals("+")) {
                addition_count++;
            } else if (x.get(i).equals("-")) {
                subtraction_count++;
            } else if (x.get(i).equals("*")) {
                mult_count++;
            } else if (x.get(i).equals("/")) {
                div_count++;
            } else if (x.get(i).equals("^")) {
                sqr_count++;
            } else if (x.get(i).equals("(")) {
                paren_count++;
            }
        }
        while (paren_count > 0) {
            int counter = paren_count;
            int xcounter = paren_count;
            ArrayList<String> parenthesis = new ArrayList<String>();
            int w = 0;
            int n = 0;
            //for (int n = 0; n < x.size(); n++ ) {
            while (xcounter > 0) {
                if (x.get(n).equals("(")) {
                    xcounter--;
                    n++;
                } else {
                    n++;
                }
            }
            w = n-1;
            while (!x.get(n).equals((")"))) {
                parenthesis.add(x.get(n));
                if (x.get(n).equals("+")) {
                    addition_count--;
                }
                else if (x.get(n).equals("-")){
                    subtraction_count--;
                }
                else if ( x.get(n).equals("*")){
                    mult_count--;
                }
                else if (x.get(n).equals("/")){
                    div_count--;
                }
                else if (x.get(n).equals("rt")){
                    root_count--;
                }
                else if (x.get(n).equals("sqr")){
                    sqr_count--;
                }
                x.remove(n);
            }
            if (x.get(n).equals(")")) {
                x.remove(n);
            }
            x.set(w, OrderOfOps(parenthesis));
            paren_count--;
        }


        while (sqr_count > 0) {
            int[] fullBox = new int[4];
            String t = "";
            for (int n = 0; n < x.size(); n++){
                if (x.get(n).equals("^")){
                    String a = x.get(n-1);
                    int[] aBox = toFraction(a);
                    fullBox[0] = aBox[0];
                    fullBox[1] = aBox[1];
                    String b = x.get(n+1);
                    int[] bBox = toFraction(b);
                    fullBox[2] = bBox[0];
                    fullBox[3] = bBox[1];
                    for (int i = 0; i < fullBox.length; i++){
                        System.out.println(fullBox[i]);
                    }
                    int[] ultBox = operations.sqrVals(fullBox);
                    t+= ultBox[0];
                    t+= "/";
                    t+= ultBox[1];
                    x.set(n-1, t);
                    x.remove(n);
                    x.remove(n);
                    sqr_count--;
                }
            }

        }
        while (root_count > 0){
            for (int n = 0; n < x.size(); n++){
                if (x.get(n).equals("rt"));

            }
        }
        while (div_count != 0) {
                int[] fullBox = new int[4];
                String t = "";
                for (int n = 0; n < x.size() - 1; n++) {
                    if (x.get(n).equals("/")) {
                        String a = x.get(n - 1);
                        int[] aBox = toFraction(a);
                        fullBox[0] = aBox[0];
                        fullBox[1] = aBox[1];
                        String b = x.get(n + 1);
                        int[] bBox = toFraction(b);
                        fullBox[2] = bBox[0];
                        fullBox[3] = bBox[1];
                        int[] ultBox = operations.divideVals(fullBox);
                        t+= ultBox[0];
                        t+= "/";
                        t+= ultBox[1];
                        x.set(n - 1, t);
                        x.remove(n);
                        x.remove(n);
                        div_count--;
                    }
                }
            }
            while (mult_count != 0) {
                int[] fullBox = new int[4];
                String t = "";
                for (int n = 0; n < x.size() - 1; n++) {
                    if (x.get(n).equals("*")) {
                        String a = x.get(n - 1);
                        int[] aBox = toFraction(a);
                        fullBox[0] = aBox[0];
                        fullBox[1] = aBox[1];
                        String b = x.get(n + 1);
                        int[] bBox = toFraction(b);
                        fullBox[2] = bBox[0];
                        fullBox[3] = bBox[1];
                        int[] ultBox = operations.multVals(fullBox);
                        t+= ultBox[0];
                        t+= "/";
                        t+= ultBox[1];
                        x.set(n - 1, t);
                        x.remove(n);
                        x.remove(n);
                        mult_count--;
                    }
                }

            }
            while (addition_count > 0) {
                int[] fullBox = new int[4];
                String t = "";
                for (int n = 0; n < x.size(); n++) {
                    if (x.get(n).equals("+")) {
                        String a = x.get(n - 1);
                        int[] aBox = toFraction(a);
                        fullBox[0] = aBox[0];
                        fullBox[1] = aBox[1];
                        String b = x.get(n + 1);
                        int[] bBox = toFraction(b);
                        fullBox[2] = bBox[0];
                        fullBox[3] = bBox[1];
                        int[] ultBox = operations.addVals(fullBox);
                        t += ultBox[0];
                        t += "/";
                        t += ultBox[1];
                        x.set(n - 1, t);
                        x.remove(n);
                        x.remove(n);
                        addition_count--;
                    }
                }
            }
            while (subtraction_count > 0){
                int[] fullBox = new int[4];
                String t = "";
                for (int n = 0; n < x.size(); n++){
                    if (x.get(n).equals("-")){
                        String a = x.get(n-1);
                        int[] aBox = toFraction(a);
                        fullBox[0] = aBox[0];
                        fullBox[1] = aBox[1];
                        String b = x.get(n+1);
                        int[] bBox = toFraction(b);
                        fullBox[2] = bBox[0];
                        fullBox[3] = bBox[1];
                        int[] ultBox = operations.subVals(fullBox);
                        t += ultBox[0];
                        t += "/";
                        t += ultBox[1];
                        x.set(n-1, t);
                        x.remove(n);
                        x.remove(n);
                        subtraction_count--;
                    }
                }
            }
        return x.get(0);
    }
}

