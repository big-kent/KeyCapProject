public class SecretKey {
  private String correctKey;
  private int counter;

  public SecretKey() {
    // for the real test, your program will not know this
    correctKey = "HHHHHHHHHHHH"; 
    counter = 0;
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