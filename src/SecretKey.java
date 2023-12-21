public class SecretKey {
  private String correctKey;
  private int counter;

  public SecretKey() {
    // for the real test, your program will not know this
    correctKey = "HHHHHHHHHHHH"; 
    counter = 0;
    //COHOMMOCAMHA 46/10484500 
    //CHMCOAMOHAMO 46/10940500 
    //AOMHCMHMOHAC 48/10657900
    //OCMAHAMOHMCO 46/10823100 
    //OMCAMOHCHOMA 46/10913200
    //MMMMMMMMMMMM error
    //AAAAAAAAAAAA 61/10413300
    //OOOOOOOOOOOO 25/11330500
    //CCCCCCCCCCCC 37/12462400
    //HHHHHHHHHHHH 49/10748500
  }

  public int guess(String guessedKey) {
    counter++;
    // validation
    if (guessedKey.length() != correctKey.length()) {
      return -1;
    }
    int matched = 0;
    for (int i = 0; i < guessedKey.length(); i++) {
      char c = guessedKey.charAt(i);
      if (c != 'M' && c != 'O' && c != 'C' && c != 'H' && c != 'A') {  
       return -1;
      }
      if (c == correctKey.charAt(i)) {
        matched++;
      }
    }
    if (matched == correctKey.length()) {
      System.out.println("Number of guesses: " + counter);
    }
    return matched;
  }

  public static void main(String[] args) {

    long start = System.nanoTime();

    // call the method
    new SecretKeyGuesser().start();

    // get the end time
    long end = System.nanoTime();

    // execution time in seconds
    long execution = (end - start);
    System.out.println("Execution time of Recursive Method is");
    System.out.println(execution + " nanoseconds");

    // new SecretKeyGuesser().start();
  }
}