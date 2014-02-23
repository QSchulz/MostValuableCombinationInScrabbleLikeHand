import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 *A class that parses and stores each word contained in an external dictionary whose path is given to Parse function
 *The created object can give the word with the highest score made by letters owned in hand considering the value of letters given in the LettersValues attribute,
 * retrieve a word thanks to its index in the dictionary, give all possible simple words from the dictionary, give all possible combinations of words given a hand of letters and
 * create a word which is the result of an "addition" between two words.
 * 
 *  @author NOVAK Johann
 *  	johann.novak@utbm.fr
 *  @author OLFF Nathan
 *  	nathan.olff@utbm.fr
 *  @author RABILLER Donatien
 *  	donatien.rabiller@utbm.fr
 *  @author SCHULZ Quentin
 *  	quentin.schulz@utbm.fr
 *  
 *  @version v0.1
 * 
 **/

public class Main {
	public static void main(String[] args) {
		Dictionary dico = new Dictionary();
		System.out.print("Parsing dictionary.");
		dico.ParseLettersValuesFile("lettervalues.txt");
		dico.Parse("enable1.txt");
		System.out.println("\t\t done.");
		
		Hand hand = null;
		try {
			System.out.print("Parsing hand.");
			Scanner scan = new Scanner(new FileReader("hand"));
			hand = new Hand(scan.nextLine(), dico.getLettersValues());
			scan.close();
			System.out.println("\t\t done.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Searching for the word (or combination of words) with the maximal value.");
		Word result = dico.getWordWithMaxValue(hand);
		System.out.println("\t\t done.");
		System.out.println("Writing result.");
		PrintWriter w;
		try {
			w = new PrintWriter("result.txt", "UTF-8");
			for(String s : result.getWord().split(" ")) {
				w.println(s);
			}
			w.print(result.getValue());
			w.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
