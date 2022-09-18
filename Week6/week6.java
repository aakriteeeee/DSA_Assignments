// you are provided with an array of different words and target words. each character of 
// word represents different digit from 0 to 9 and each 
// different characters must represent different digits. return if sum of number represented 
// on array equals to the number 
// represented by targeted word, otherwise return false.


package Week6;

import java.util.HashMap;

class RandomUniqueEqualizer {

    String[] leftSide;
    String rightSide;
    HashMap<String, String> mapper = new HashMap<String, String>();

    RandomUniqueEqualizer(String[] leftSide, String rightSide) {

        this.leftSide = leftSide;
        this.rightSide = rightSide;
    }

    boolean processor() {

        String checkval1 = String.join("", leftSide);
        String checkvalFinal = checkval1 + rightSide;
        // System.out.println(checkval);

        String uniqueCheck = uniqueFinder(checkvalFinal, checkval1.charAt(checkval1.length() - 1));

        int leftSum = leftItterSum();

        String rightSum = "";

        for (int i = 0; i < rightSide.length(); i++) {
            rightSum += mapper.get("" + rightSide.charAt(i));
        }

        // System.out.println(rightSum);
        // System.out.println(leftSum);

        if (leftSum == Integer.parseInt(rightSum)) {
            return true;
        }

        return false;

    }

    int leftItterSum() {

        // int lastCheckIter = 0;
        int unitsItter = 0;
        String[] units = new String[leftSide.length];
        int leftTotal = 0;

        // if(leftSide[lastCheckIter].charAt(i) ==
        // leftSide[lastCheckIter].charAt(leftSide[lastCheckIter].length())){
        // unitsItter++;
        // }

        for (int i = 0; i < leftSide.length; i++) {

            units[unitsItter] = "";

            for (int j = 0; j < leftSide[i].length(); j++) {

                // System.out.println(mapper.get("H"));
                units[unitsItter] += mapper.get("" + leftSide[i].charAt(j));

            }
            leftTotal += Integer.parseInt(units[unitsItter]);
            unitsItter++;

        }

        // System.out.println(units[0]);
        // System.out.println(units[1]);
        // System.out.println(units[2]);

        // System.out.println(leftTotal);

        return leftTotal;
    }

    String uniqueFinder(String a, char leftend) {

        int len = 0;
        char[] passer = new char[a.length()];

        for (int i = 0; i < a.length(); i++) {
            boolean push = false;
            for (int j = 0; j < a.length(); j++) {
                if (i >= j) {
                    if (i == a.length() - 1) {
                        push = true;
                        break;
                    }
                    continue;
                }

                if (a.charAt(i) == a.charAt(j)) {
                    push = false;
                    break;
                } else if (a.charAt(i) != a.charAt(j)) {
                    push = true;
                }
            }
            if (push) {
                passer[len] = a.charAt(i);
                push = false;
                len++;
            }
        }

        String combined = "";
        int itter = 0;

        String[] leftRightSum = new String[2];

        for (int i = 0; i < len; i++) {
            combined += passer[i];
            mapper.put("" + passer[i], "" + i);
            // if (passer[i] == leftend) {
            // itter++;
            // }
            // leftRightSum[itter] += mapper.get("" + passer[i]);

        }

        // System.out.println(combined);

        return combined;
        // return leftRightSum;

    }

    public static void main(String[] args) {

        String[] leftInput = { "THER", "MOL", "NIS" };

        System.out.println(new RandomUniqueEqualizer(leftInput, "HRLI").processor());
    }

}