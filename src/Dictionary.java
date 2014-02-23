import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
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

public class Dictionary {
	private Word[] words;
	private final int nbWords = 172820;
	private LettersValues lettersValue;
	
	public Dictionary() {
		words = new Word[nbWords];
		lettersValue = new LettersValues();
	}
	/**
	 *Retrieve and store the value of each letter contained in the file whose path is in parameter
	 *
	 * @param file The path of the file containing the value of the letters
	 **/
	public void ParseLettersValuesFile(String file) {
		
		lettersValue = new LettersValues();
		lettersValue.parseFile(file);
	}
	/**
	 *Retrieve and store the whole set of allowed words contained in the file whose path is in paramater
	 *
	 * @param file The path of the file containing the whole set of allowed words
	 **/
	public void Parse(String file) {
		try {
			Scanner scan = new Scanner(new FileReader(file));
			String s = null;
			int i=0;
			
			while(scan.hasNextLine() && i<nbWords) {
				s=scan.nextLine();
				words[i++] = new Word(s, lettersValue);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Return the word (or a combination of words) possible with the given hand
	 * 
	 * @param h The hand (set of letters) from which we want to create a word or a combination of words
	 * 
	 * @return A word which has the maximal score during two minutes of running program
	 */
	public Word getWordWithMaxValue(Hand h) {
		return findMaxScore(getPossibleCombination(h));
	}
	/**
	 * Return the word at the (n+1)th index in the dictionary
	 * 
	 * @param n The (n+1)th index of the word in the dictionary
	 * 
	 * @return A word which is at the (n+1)th index in the dictionary
	 */
	public Word getWord(int n) {
		return words[n];
	}
	/**
	 * From a given hand, return all possible words made with letters in the hand which are only in dictionary
	 * 
	 * @param h The hand (set of letters) from which we want to test if a word is possible
	 * 
	 * @return The list of possible words made by the given hand
	 */
	public LinkedList<Word> getPossibleWordList(Hand h) {
		LinkedList<Word> wordList = new LinkedList<Word>();
		for(Word w : words) {
			if(w.isMapCompatible(h)) {
				wordList.add(w);
			}
		}
		return wordList;
	}
	/**
	 * Search for the word with the highest score in a list of words
	 * 
	 * @param list A list of words in which we have to find the word which scores the highest
	 * 
	 * @return The word with the highest score
	 */
	public Word findMaxScore(LinkedList<Word> list)
	{
		int temp = list.get(0).getValue(), temp2;
		int index = 0;
		for(int i = 0; i < list.size()-1; ++i)
		{
			temp2 = list.get(i+1).getValue();
			if(temp < temp2)
			{
				temp = temp2;
				index = i;
			}
		}
		return list.get(index);
	}
	/**
	 * In a two minutes delay, find the maximum of possible combinations of words with the given hand and return it as a list
	 * 
	 * @param h The hand (set of letters) from which we want to find all possible combinations of words
	 * 
	 * @return The list of all possible combinations of words
	 */
	public LinkedList<Word> getPossibleCombination(Hand h) {
		LinkedList<Word> result = new LinkedList<Word>();
		LinkedList<Word> L = new LinkedList<Word>();
		
		long start = System.currentTimeMillis();
		long end=start;
		LinkedList<Word> l = getPossibleWordList(h);
		
		for(Word w : l) {
			L.add(w);
			Word Temp = w;
			do {
				end = System.currentTimeMillis();
				if(end-start >= 115000)
					return L;
				/*We start with a word in the list of all possible words in the dictionary and then we try to combine it with all already made (and successful) combinations
				 * while ensuring that we are still under 2min of execution*/
				int size = L.size();
				for(int i=0 ; i<size ; ++i) {
					Word temp;
					end = System.currentTimeMillis();
					if(end-start >= 115000)
						return L;
					
					if((temp = CreateWord(Temp, L.get(i), h))!= null) {
						L.add(temp);
					}
				}
				result.addAll(L);
			} while((Temp = CreateWord(Temp, w, h)) != null && (end-start < 115000));
		}
		
		
		
		return result;
	}
	/**
	 * Create a new word which is (if possible with the given hand) the combination of the first and the second words
	 * 
	 * @param word1 The word from which we want to attach the word2 Word
	 * @param word2 The word we want to attach to the word1 Word
	 * @param h The Hand which allows to verify that the combination is still possible
	 * 
	 * @return
	 * <ul>
	 * <li>null if the combination of words is not possible with the given hand
	 * <li>the combination of words otherwise
	 * </ul>
	 */
	public Word CreateWord(Word word1, Word word2, Hand h) {
		Word newWord = new Word(word1 + " "+ word2, lettersValue);
		if(newWord.isMapCompatible(h))
			return newWord;
		else			
			return null;
	}
	/**
	 * Return the LettersValues object of the dictionary
	 * 
	 * @return The LettersValues object of the dictionary
	 */
	public LettersValues getLettersValues() {
		return lettersValue;
	}
	/**
	 * Return the string value of the word at the (n+1)th index in the dictionary
	 * 
	 * @param n The (n+1)th index of the word in the dictionary
	 * 
	 * @return The string value of the word which is at the (n+1)th index in the dictionary
	 */
	public String getString(int n) {
		return words[n].getWord();
	}
}
