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


// Hill climbing
// public class SecretKeyGuesser {

//     // Constants defining the characters used in the key and the key's length
//     private static final String CHARACTERS = "MOCHA";
//     private static final int KEY_LENGTH = 12;

//     // The start method begins the process of guessing the secret key
//     public void start() {
//         // Create an instance of the SecretKey class
//         SecretKey key = new SecretKey();
//         // Generate a random initial key
//         String currentKey = generateRandomKey();
//         // Get the initial score (number of correct characters in the key)
//         int currentScore = key.guess(currentKey);

//         // Loop until the correct key is found
//         while (currentScore < KEY_LENGTH) {
//             // Create a new key by modifying the current key
//             String newKey = modifyKey(currentKey);
//             // Get the score for the new key
//             int newScore = key.guess(newKey);

//             // If the new key is better (or equal), update the current key and score
//             if (newScore > currentScore) {
//                 currentKey = newKey;
//                 currentScore = newScore;
//             }

//             // If the correct key is found, exit the loop
//             if (newScore == KEY_LENGTH) {
//                 break;
//             }
//         }

//         // Print the found key
//         System.out.println("I found the secret key. It is " + currentKey);
//     }

//     // Modifies the current key by changing one random character
//     private String modifyKey(String key) {
//         // Convert the string to a character array for modification
//         char[] keyChars = key.toCharArray();
//         // Randomly choose an index to modify
//         int indexToModify = (int) (Math.random() * KEY_LENGTH);
//         // Randomly choose a new character from the allowed characters
//         char newChar = CHARACTERS.charAt((int) (Math.random() * CHARACTERS.length()));
//         // Replace the character at the chosen index with the new character
//         keyChars[indexToModify] = newChar;
//         // Return the modified key as a new string
//         return new String(keyChars);
//     }

//     // Generates a random key from the allowed characters
//     private String generateRandomKey() {
//         StringBuilder key = new StringBuilder();
//         for (int i = 0; i < KEY_LENGTH; i++) {
//             // Append a random character from CHARACTERS to the key
//             key.append(CHARACTERS.charAt((int) (Math.random() * CHARACTERS.length())));
//         }
//         // Return the generated key as a string
//         return key.toString();
//     }
// }


// Hill Climbing thách đấu NHIỀU LẦN ĐOÁN HƠN NHƯNG ÍT COMPLEXITY HƠN
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



//a symmetric-key algorithm AAAAAAAAAAAA: 61 LẦN, CÁC SECRET KEY CÒN LẠI TỐT HƠN HILL CLIMBING, complexity nhiều hơn, thời gian ra kết quả chậm hơn không đáng kể so với hill climbing
public class SecretKeyGuesser {

    private static final String CHARACTERS = "MOCHA";
    private static final int KEY_LENGTH = 12;

    public void start() {
        SecretKey key = new SecretKey();
        StringBuilder currentKey = new StringBuilder("MMMMMMMMMMMM");
        int currentScore = key.guess(currentKey.toString());

        for (int i = 0; i < KEY_LENGTH; i++) {
            for (int j = 0; j < CHARACTERS.length(); j++) {
                char originalChar = currentKey.charAt(i);
                char newChar = CHARACTERS.charAt(j);
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

        System.out.println("I found the secret key. It is " + currentKey);
    }
}








