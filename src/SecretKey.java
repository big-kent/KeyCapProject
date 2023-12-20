// Secret Key by Kiet for second method
// public class SecretKey {
//     private String correctKey;
//     private int counter;

//     public SecretKey() {
//         // for the real test, your program will not know this
//         correctKey = "CHAMOMOCHAHA";
//         counter = 0;
//     }

//     public int guess(String guessedKey) {
//         counter++;
//         // validation
//         if (guessedKey.length() != correctKey.length()) {
//             return -1;
//         }
//         int matched = 0;
//         for (int i = 0; i < guessedKey.length(); i++) {
//             char c = guessedKey.charAt(i);
//             if (c != 'M' && c != 'O' && c != 'C' && c != 'H' && c != 'A') {
//                 return -1;
//             }
//             if (c == correctKey.charAt(i)) {
//                 matched++;
//             }
//         }
//         if (matched == correctKey.length()) {
//             System.out.println("Number of guesses: " + counter);
//         }
//         return matched;
//     }

//     public static void main(String[] args) {
//         new SecretKeyGuesser().start();
//     }
// }

//Secret key by Kent for the third method.
// SecretKey.java

import java.util.Arrays;

public class SecretKey {
    private final char[] key;

    public SecretKey(char[] key) {
        if (key.length != 12 || !isValidKey(key)) {
            throw new IllegalArgumentException("Invalid secret key");
        }
        this.key = Arrays.copyOf(key, key.length);
    }

    public int guess(String guessedKey) {
        if (guessedKey.length() != 12 || !isValidKey(guessedKey.toCharArray())) {
            return -1;
        }

        int count = 0;
        for (int i = 0; i < key.length; i++) {
            if (key[i] == guessedKey.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isValidKey(char[] key) {
        for (char c : key) {
            if (c != 'M' && c != 'O' && c != 'C' && c != 'H' && c != 'A') {
                return false;
            }
        }
        return true;
    }
}

