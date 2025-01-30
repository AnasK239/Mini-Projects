import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        String filepath = "words.txt";
        ArrayList<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))){
            String line;
            while ( (line = reader.readLine()) != null) {
                words.add(line.trim());
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Couldn't find the file");
        }
        catch (IOException e) {
            System.out.println("Something went wrong");
        }

        Random rand = new Random();
        String word = words.get(rand.nextInt(words.size()));

        System.out.println(word);

        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> wordState = new ArrayList<>();
        int wrongGuess = 0;

        for (int i = 0; i < word.length(); i++) {

           wordState.add('_');
        }

        while (wrongGuess<6) {

            System.out.println(getWrongGuess(wrongGuess));
            System.out.println();
            System.out.print("Word: ");

            for (Character character : wordState) {
                System.out.print(character+" ");
            }
            System.out.println();
            System.out.print("Guess a letter: ");

            char guess = scanner.next().toLowerCase().charAt(0);

            if(word.indexOf(guess) >=0){
                System.out.println("Nice guess\n");

                for (int i = 0; i < word.length(); i++) {
                    if(word.charAt(i) == guess){
                    wordState.set(i, guess);
                    }
                }
                if(!wordState.contains('_'))
                {
                    System.out.println("You win !");
                    System.out.println("The word was "+word);
                    System.out.println("You had "+getWrongGuess(wrongGuess));

                    break;
                }
            }
            else
            {
                wrongGuess ++;
                System.out.println("Try again!");
                System.out.println();
            }
        }

        if(wrongGuess >= 6)
        {
            System.out.println(getWrongGuess(wrongGuess));
            System.out.println("Game over!");
            System.out.println("The word was "+word);

        }
        scanner.close();
    }

    static String getWrongGuess (int wrongGuess)
    {
        return switch(wrongGuess){

          case 0 -> "0 Wrong Guesses";
          case 1 -> "1 Wrong Guesses";
          case 2 -> "2 Wrong Guesses";
          case 3 -> "3 Wrong Guesses";
          case 4 -> "4 Wrong Guesses";
          case 5 -> "5 Wrong Guesses";
          case 6 -> "6 Wrong Guesses";
          default -> "";
        };

    }
}