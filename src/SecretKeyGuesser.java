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

//Second method by Kiet: *********************
// import java.util.Random;

//     public class SecretKeyGuesser {
//         public void start() {
//             SecretKey key = new SecretKey();
//             String str = "MMMMMMMMMMMM";
//             while (key.guess(str) != 12) {
//                 str = next(str);
//                 System.out.println("Guessing... " + str);
//             }
//             System.out.println("I found the secret key. It is " + str);
//         }


//         private StringBuilder generateRandomKey() {
//             StringBuilder randomKey = new StringBuilder();
//             for (int i = 0; i < 12; i++) {
//                 randomKey.append(POSSIBLE_CHARACTERS[random.nextInt(POSSIBLE_CHARACTERS.length)]);
//             }
//             return randomKey;
//         }

//         private StringBuilder improveGuess(StringBuilder currentGuess, int matchedPositions) {
//             StringBuilder newGuess = new StringBuilder(currentGuess);

//             for (int i = 0; i < 12; i++) {
//                 if (newGuess.charAt(i) != secretKey.charAt(i)) {
//                     double prob = random.nextDouble();
//                     double matchProb = (double) matchedPositions / 12;

//                     if (prob < matchProb) {
//                         newGuess.setCharAt(i, secretKey.charAt(i));
//                     } else {
//                         newGuess.setCharAt(i, POSSIBLE_CHARACTERS[random.nextInt(POSSIBLE_CHARACTERS.length)]);
//                     }
//                 }
//             }

//             return newGuess;
//         }
//     }

//Third method by Kent:**************************
// Base on Brute-force approach algorithm
// Optimize with Hill Climbling Algorithm


// SecretKeyGuesser.java

import java.util.Random;

public class SecretKeyGuesser {
    private static final char[] OPTIONS = {'M', 'O', 'C', 'H', 'A'};
    private static final int KEY_LENGTH = 12;

    public void start() {
        SecretKey secretKey = new SecretKey(generateRandomKey());
        int counter = 0;

        while (true) {
            counter++;
            String currentGuess = generateRandomKey();
            int currentMatchCount = secretKey.guess(currentGuess);

            if (currentMatchCount == KEY_LENGTH) {
                System.out.println("Correct Secret Key: " + currentGuess);
                System.out.println("Number of Guesses: " + counter);
                break;
            }

            // Hill Climbing
            String neighborGuess = generateNeighbor(currentGuess);
            int neighborMatchCount = secretKey.guess(neighborGuess);

            if (neighborMatchCount > currentMatchCount) {
                // Move to the better neighbor
                currentGuess = neighborGuess;
            }
        }
    }

    private String generateRandomKey() {
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < KEY_LENGTH; i++) {
            key.append(randomChar());
        }
        return key.toString();
    }

    private char randomChar() {
        return OPTIONS[new Random().nextInt(OPTIONS.length)];
    }

    private String generateNeighbor(String currentGuess) {
        // Generate a neighbor by randomly changing one character in the current guess
        int indexToChange = new Random().nextInt(KEY_LENGTH);
        char[] neighborKey = currentGuess.toCharArray();
        neighborKey[indexToChange] = randomChar();
        return new String(neighborKey);
    }

    public static void main(String[] args) {
        SecretKeyGuesser guesser = new SecretKeyGuesser();
        guesser.start();
    }
}




