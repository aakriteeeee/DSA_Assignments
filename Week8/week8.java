package Week8;

class PathFinder {

    String[] input;
    int rows;
    int columns;

    PathFinder(String[] input) {
        this.input = input;
        this.rows = input.length;
        this.columns = input[0].length();
    }

    int processor() {

        int keys = keysNumberFinder();

        int totalTravelled = 0;
        int keysFound = 0;
        boolean run = true;
        int x = 0;
        int travelledRow = 0;
        int adder = 1;
        char[] foundK = new char[2];

        while (run) {
            if (input[travelledRow].charAt(x + adder) != '#') {

                if (input[travelledRow].charAt(x + adder) == '*') {
                    x += adder;
                    totalTravelled++;
                    continue;
                } else {
                    if (input[travelledRow].charAt(x + adder) != input[travelledRow].toUpperCase().charAt(x + adder)) {
                        totalTravelled++;
                        foundK[keysFound] = input[travelledRow].charAt(x + adder);
                        x += adder;
                        keysFound++;

                        if (keysFound == keys) {
                            run = false;
                            break;
                        } else {
                            continue;
                        }

                    } else {

                        boolean yes = false;

                        for (int l = 0; l < foundK.length; l++) {
                            if (foundK[l] == input[travelledRow].toLowerCase().charAt(x + adder)) {

                                yes = true;
                            }
                        }

                        if (yes) {
                            // keysFound++;
                            totalTravelled++;
                            x += adder;
                            continue;
                        } else {
                            adder *= -1;
                            continue;
                        }

                    }
                }

            }

            if (input[travelledRow + 1].charAt(x) != '#') {

                if (input[travelledRow + 1].charAt(x) == '*') {

                    travelledRow += 1;
                    totalTravelled++;
                    continue;
                } else {
                    if (input[travelledRow + 1].charAt(x) != input[travelledRow + 1].toUpperCase().charAt(x)) {
                        totalTravelled++;
                        foundK[keysFound] = input[travelledRow + 1].charAt(x);
                        travelledRow += 1;
                        keysFound++;

                        if (keysFound == keys) {
                            run = false;
                            break;
                        } else {
                            continue;
                        }

                    } else {

                        boolean yes = false;

                        for (int l = 0; l < foundK.length; l++) {
                            if (foundK[l] == input[travelledRow + 1].toLowerCase().charAt(x)) {

                                yes = true;
                            }
                        }

                        if (yes) {
                            // keysFound++;
                            totalTravelled++;
                            travelledRow++;
                            continue;
                        }

                    }
                }

            }
        }

        return totalTravelled;
    }

    int keysNumberFinder() {

        int alphabets = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (input[i].charAt(j) == '@' || input[i].charAt(j) == '#'
                        || input[i].charAt(j) == '*') {
                    continue;
                } else {
                    alphabets++;
                }
            }
        }

        int keys = alphabets / 2;

        return keys;
    }

    public static void main(String[] args) {

        String[] value = { "@*a*#", "###*#", "b*A*B" };

        PathFinder pth = new PathFinder(value);
        System.out.println(pth.processor());
    }

}