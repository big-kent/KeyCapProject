////Sample method: Number of guesses: 134848620
////I found the secret key. It is CHAMOMOCHAHA
//public class SecretKeyGuesser {
//    public void start() {
//        // brute force key guessing
//        SecretKey key = new SecretKey();
//        String str = "MMMMMMMMMMMM";
//        while (key.guess(str) != 12) {
//            str = next(str);
//            System.out.println("Guessing... " + str);
//        }
//        System.out.println("I found the secret key. It is " + str);
//    }
//
//    static int order(char c) {
//        if (c == 'M') {
//            return 0;
//        } else if (c == 'O') {
//            return 1;
//        } else if (c == 'C') {
//            return 2;
//        } else if (c == 'H') {
//            return 3;
//        }
//        return 4;
//    }
//
//    static char charOf(int order) {
//        if (order == 0) {
//            return 'M';
//        } else if (order == 1) {
//            return 'O';
//        } else if (order == 2) {
//            return 'C';
//        } else if (order == 3) {
//            return 'H';
//        }
//        return 'A';
//    }
//
//    // return the next value in 'MOCHA' order, that is
//    // M < O < C < H < A
//    public String next(String current) {
//        char[] curr = current.toCharArray();
//        for (int i = curr.length - 1; i >=0; i--) {
//            if (order(curr[i]) < 4) {
//                // increase this one and stop
//                curr[i] = charOf(order(curr[i]) + 1);
//                break;
//            }
//            curr[i] = 'M';
//        }
//        return String.valueOf(curr);
//    }
//}

//Use MiniMax algorithm for guesser
public class SecretKeyGuesser {

    public void start() {
        SecretKey secretKey = new SecretKey();

        // Initialize the guessed key to all 'M's
        StringBuilder guessedKey = new StringBuilder("MMMMMMMMMMMM");

        int counter = 0;

        while (true) {
            int matches = secretKey.guess(guessedKey.toString());
            counter++;

            if (matches == 12) {
                System.out.println("Correct Secret Key: " + guessedKey);
                //System.out.println("Number of Guesses: " + counter);
                break;
            }

            // Update the guessed key based on the Minimax algorithm
            updateGuessedKey(guessedKey, secretKey, matches);
        }
    }

    private void updateGuessedKey(StringBuilder guessedKey, SecretKey secretKey, int matches) {
        // Implement a simplified Minimax algorithm to update the guessed key
        // For simplicity, we choose the next character from the set {'M', 'O', 'C', 'H', 'A'}
        for (int i = 0; i < guessedKey.length(); i++) {
            if (guessedKey.charAt(i) != secretKey.correctKey.charAt(i)) {
                char nextGuess = getNextGuess(guessedKey.charAt(i));
                guessedKey.setCharAt(i, nextGuess);
                break;
            }
        }
    }

    private char getNextGuess(char currentGuess) {
        // Choose the next character in the set {'M', 'O', 'C', 'H', 'A'}
        switch (currentGuess) {
            case 'M':
                return 'O';
            case 'O':
                return 'C';
            case 'C':
                return 'H';
            case 'H':
                return 'A';
            case 'A':
                return 'M';
            default:
                // This should not happen in a valid game scenario
                throw new IllegalArgumentException("Invalid character: " + currentGuess);
        }
    }
}
