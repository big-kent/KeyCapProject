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

//Symmetric-key Algorithm
//This case "AAAAAAAAAAAA" have 61 guessing more than Hill Climbing with the same correctKey
//Time Complexity:
//Space Complexity:
//Best case: MMMMMMMMMMMM
//Worst case: AAAAAAAAAAAA for now

// public class SecretKeyGuesser {

//     private static final String CHARACTERS = "MOCHA";
//     private static final int KEY_LENGTH = 12;

//     public void start() {
//         SecretKey key = new SecretKey();
//         StringBuilder currentKey = new StringBuilder("MMMMMMMMMMMM");
//         int currentScore = key.guess(currentKey.toString());

//         for (int i = 0; i < KEY_LENGTH; i++) {
//             for (int j = 0; j < CHARACTERS.length(); j++) {
//                 char originalChar = currentKey.charAt(i);
//                 char newChar = CHARACTERS.charAt(j);
//                 currentKey.setCharAt(i, newChar);
//                 int newScore = key.guess(currentKey.toString());
                
//                 if (newScore > currentScore) {
//                     currentScore = newScore; // Correct character found for this position
//                     break;
//                 } else {
//                     currentKey.setCharAt(i, originalChar); // Revert if not correct
//                 }
//             }
//         }

//         System.out.println("I found the secret key. It is " + currentKey);
//     }
// }

//================================================================================================================================================================================

// Hill Climbing without any FrameWork
// More guess time than Symmetric-key
//Time Complexity:
//Space Complexity:
//Best case:
//Worst case:

    //COHOMMOCAMHA 60/24153900 nanoseconds
    //CHMCOAMOHAMO 57/21690600 nanoseconds
    //AOMHCMHMOHAC 58/22394900 nanoseconds
    //OCMAHAMOHMCO 57/27833600 nanoseconds
    //OMCAMOHCHOMA 60/22900700 nanoseconds
    //MMMMMMMMMMMM 1/21185100 nanoseconds
    //AAAAAAAAAAAA 60/25850100 nanoseconds
    //OOOOOOOOOOOO 57/20588900 nanoseconds
    //CCCCCCCCCCCC 58/22579400 nanoseconds
    //HHHHHHHHHHHH 59/20634200 nanoseconds
    // MOCHA


// public class SecretKeyGuesser {
    
//     private static final String LETTER = "MOCHA";
//     private static final int SECRET_KEY_LENGTH = 12;
//     private int last_modified_character_index = 0; // Index to keep track of last modified character
//     private int last_modified_character_position = 0; // Position of the last modified character in the key

//     public void start() {
//         SecretKey key = new SecretKey();
//         String currentKey = generateInitialKey();
//         int currentScore = key.guess(currentKey);

//         while (currentScore < SECRET_KEY_LENGTH) {
//             String newKey = modifyKeySequentially(currentKey);
//             int newScore = key.guess(newKey);

//             if (newScore > currentScore) {
//                 currentKey = newKey;
//                 currentScore = newScore;
//             }

//             if (newScore == SECRET_KEY_LENGTH) {
//                 break;
//             }
//         }
//         System.out.println("The Secret key is: " + currentKey);
//     }

//     private String modifyKeySequentially(String key) {
//         char[] keyChars = key.toCharArray();
//         last_modified_character_index++;
//         if (last_modified_character_index >= LETTER.length()) {
//             last_modified_character_index = 0;
//             last_modified_character_position++;
//             if (last_modified_character_position >= SECRET_KEY_LENGTH) {
//                 last_modified_character_position = 0;
//             }
//         }
//         keyChars[last_modified_character_position] = LETTER.charAt(last_modified_character_index);
//         return new String(keyChars);
//     }

//     private String generateInitialKey() {
//         StringBuilder key = new StringBuilder();
//         for (int i = 0; i < SECRET_KEY_LENGTH; i++) {
//             key.append(LETTER.charAt(0)); // Start with the first character
//         }
//         return key.toString();
//     }
// }

//==================================================================================================================================================================

// Symmetric algorithm
    //COHOMMOCAMHA 34/21397300 nanoseconds
    //CHMCOAMOHAMO 34/22247000 nanoseconds
    //AOMHCMHMOHAC 36/21396000 nanoseconds
    //OCMAHAMOHMCO 34/21819500 nanoseconds
    //OMCAMOHCHOMA 34/20707700 nanoseconds
    //MMMMMMMMMMMM 1/20928900 nanoseconds
    //AAAAAAAAAAAA 49/22246800 nanoseconds
    //OOOOOOOOOOOO 13/20745600 nanoseconds
    //CCCCCCCCCCCC 25/20971900 nanoseconds
    //HHHHHHHHHHHH 37/21957800 nanoseconds

    // MOCHA

public class SecretKeyGuesser {

    private static final String CHARACTERS = "MOCHA";
    private static final int KEY_LENGTH = 12;

    public void start() {
        SecretKey key = new SecretKey();
        StringBuilder currentKey = new StringBuilder("MMMMMMMMMMMM");
        int currentScore = key.guess(currentKey.toString());

        for (int i = 0; i < KEY_LENGTH; i++) {
            char originalChar = currentKey.charAt(i);
            for (int j = 0; j < CHARACTERS.length(); j++) {
                char newChar = CHARACTERS.charAt(j);
                if (newChar != originalChar) {
                    currentKey.setCharAt(i, newChar);
                    int newScore = key.guess(currentKey.toString());

                    if (newScore > currentScore) {
                        currentScore = newScore; // Correct character found for this position
                        break;
                    } else {
                        currentKey.setCharAt(i, originalChar); // Revert if not correct
                    }
                }
            }
        }

        System.out.println("I found the secret key. It is " + currentKey);
    }

}

