// you are provided with an array A [] containing set of different words in the form of string 
// and you are provided with targeted word, 
// return length of subset s from set A required to from targeted word by using 
// combination of different letters of subset s.


package Week5;
public class week5 {
    // funtion to 
    public static void checkSubset(String target, String[] set) {
        String visited = "";

        int ans = 0;

        for (int i = 0; i < target.length(); i++) {
            for (int j = 0; j < set.length; j++) {
                for (int k = 0; k < set[j].length(); k++) {
                    if (target.toUpperCase().charAt(i) == set[j].toUpperCase().charAt(k)
                            && !visited.contains(target.charAt(i) + "")) {
                        visited += target.charAt(i);

                        if (ans <= j + 1) {
                            ans++;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        String target = "frog";
        String[] set = { "programming", "For", "developers" };
        checkSubset(target, set);
    }
}