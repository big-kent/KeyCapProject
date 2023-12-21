//Best case: MMMMMMMMMMMM 1 guess
//Worst case: AAAAAAAAAAAA 60 guesses
//Average case: ~58 guesses

public class SecretKeyGuesser {
    //Initialize the letters that appear in the secret key including "M","O","C","H","A".
    private static final String LETTER = "MOCHA";
    //Initialize the secret key length since its a constant 12.
    private static final int SECRET_KEY_LENGTH = 12;
    //Initialize the index to track the recent character that has been changed
    private int last_modified_character_index = 0; 
    //Initialize the variable to save the position of the recent changed character
    private int last_modified_character_position = 0; 
    
    //Method complexity: O(N)
    public void start(){
        SecretKey key = new SecretKey();
        String currentKey = generateInitialKey();
        int currentScore = key.guess(currentKey);

        while (currentScore < SECRET_KEY_LENGTH){
            String newKey = modifyKeySequentially(currentKey);
            int newScore = key.guess(newKey);

            if (newScore > currentScore){
                currentKey = newKey;
                currentScore = newScore;
            }

            if (newScore == SECRET_KEY_LENGTH){
                break;
            }
        }
        System.out.println("The Secret key is: " + currentKey);
    }

    //Method complexity: O(1)
    //Change the letter in the secret key sequentially starting from the first character until matches with the key.
    //Worst case complexity: O(M+N) - Check M conditions for outer if and when find the true condition, check n conditions for the inner if.
    private String modifyKeySequentially(String key){
        //Change the secret key string into array to change one character at a time.
        char[] key_character = key.toCharArray();
        last_modified_character_index++;
        if (last_modified_character_index >= LETTER.length()) {
            last_modified_character_index = 0;
            last_modified_character_position++;
            if (last_modified_character_position >= SECRET_KEY_LENGTH) {
                last_modified_character_position = 0;
            }
        }
        key_character[last_modified_character_position] = LETTER.charAt(last_modified_character_index);
        return new String(key_character);
    }
    
    //Method complexity: O(N)
    private String generateInitialKey() {
        StringBuilder key_sb = new StringBuilder();
        //Initialize an initial key to change the letter
        for (int i = 0; i < SECRET_KEY_LENGTH; i++){
            //Starting from the first character
            key_sb.append(LETTER.charAt(0)); 
        }
        return key_sb.toString();
    }
}


