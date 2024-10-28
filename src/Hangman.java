import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> words = List.of
                ("sweden", "norway", "oman", "greece", "italy", "Germany", "turkey", "kenya", "thailand", "brazil");

        Random random = new Random();

        String word = words.get(random.nextInt(words.size()));
        System.out.println(word);
        List<Character> playerGuesses = new ArrayList<>();
        printWordState(word, playerGuesses);

        while (true) {
            getPlayerGuess(scanner, playerGuesses, word);
            if (printWordState(word, playerGuesses)) {
                System.out.println("You Win !");
                break;
            }
        }
    }
    private static void getPlayerGuess(Scanner scanner, List<Character> playerGuesses, String word) {
        System.out.println("Please Entre a letter");
        String letterGuess = scanner.nextLine();
        playerGuesses.add(letterGuess.charAt(0));
    }

    private static boolean printWordState(String word, List<Character> playerGuesses) {
        int correctCount = 0;
        for (int i = 0; i < word.length(); i ++){
            if (playerGuesses.contains(word.charAt(i))){
                System.out.print(word.charAt(i));
                correctCount ++;
            }else{
                System.out.print("_");
            }
        }
        System.out.println();
        return(word.length()== correctCount);
    }

}
