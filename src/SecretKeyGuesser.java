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

//Second method:
import java.util.Random;

    public class SecretKeyGuesser {
        public void start() {
            SecretKey key = new SecretKey();
            String str = "MMMMMMMMMMMM";
            while (key.guess(str) != 12) {
                str = next(str);
                System.out.println("Guessing... " + str);
            }
            System.out.println("I found the secret key. It is " + str);
        }


        private StringBuilder generateRandomKey() {
            StringBuilder randomKey = new StringBuilder();
            for (int i = 0; i < 12; i++) {
                randomKey.append(POSSIBLE_CHARACTERS[random.nextInt(POSSIBLE_CHARACTERS.length)]);
            }
            return randomKey;
        }

        private StringBuilder improveGuess(StringBuilder currentGuess, int matchedPositions) {
            StringBuilder newGuess = new StringBuilder(currentGuess);

            for (int i = 0; i < 12; i++) {
                if (newGuess.charAt(i) != secretKey.charAt(i)) {
                    double prob = random.nextDouble();
                    double matchProb = (double) matchedPositions / 12;

                    if (prob < matchProb) {
                        newGuess.setCharAt(i, secretKey.charAt(i));
                    } else {
                        newGuess.setCharAt(i, POSSIBLE_CHARACTERS[random.nextInt(POSSIBLE_CHARACTERS.length)]);
                    }
                }
            }

            return newGuess;
        }
    }

