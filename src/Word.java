import java.util.HashMap;
import java.util.Set;

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
public class Word {
	HashMap<Character, Integer> map;
	String word;
	int value;
	/**
	 * Create a new Word object whose string value is the string passed by parameter and whose value (or score) is computed thanks to the LettersValues object passed by parameter
	 * 
	 * @param s The String value representing the word (actually, the word in its first sense)
	 * @param lettersValue The object storing the value for each letter in the alphabet
	 */
	public Word(String s, LettersValues lettersValue) {
		word = s;
		map = new HashMap<Character, Integer>();
		value = 0;
		Integer i;
		for(char c : word.toCharArray()) {
			if(c == ' ' || c == '\n' || c == '\t')
				continue;
			
			value += lettersValue.getLettersValue(c);
			
			if((i = map.get(c)) == null) {
				map.put(c, 1);
			} else {
				map.put(c, ++i);
			}
		}
	}
	
	/**
	 * Return the string value of the word
	 * 
	 * @return The string value of the word
	 */
	public String getWord() {
		return word;
	}
	/**
	 * Return the value of the word (the addition of each value of each letter which makes the word)
	 * 
	 * @return The value of the word
	 */
	public int getValue() {
		return value;
	}
	/**
	 * Return the number of time the character is repeated in the word
	 * 
	 * @param c The character to be found in the word
	 * 
	 * @return The number of time the character is found in the word
	 */
	public Integer getNumberOfCharacter(char c) {
		return map.get(c);
	}
	/**
	 * Return the map associated to the word containing as a key one character in the alphabet and as a value the number of time this character is repeated in the word
	 * 
	 * @return The map associated to the word containing as a key one character in the alphabet and as a value the number of time this character is repeated in the word
	 */
	HashMap<Character, Integer> getMap() {
		return map;
	}
	/**
	 * Check whether the word is possible with the hand passed by parameter
	 * 
	 * @param h The hand which allows us to determine if the word is possible or not
	 * 
	 * @return
	 * <ul>
	 * <li> true, if the word is possible
	 * <li> false, if not
	 * </ul>
	 */
	public boolean isMapCompatible(Hand h) {
		HashMap<Character, Integer> wmap = h.getMap();
		Integer i;
		Set<Character> set = map.keySet();
		for(char c : set) {
			
			if((i = wmap.get(c)) == null) {
				/*The letter doesn't exist in the hand*/
				return false;
			} else {
				if(i < map.get(c))
					/*The letter is repeated more in the word than in the hand*/
					return false;
			}
		}
		
		return true;
	}
	/**
	 * Return the string value of the word
	 * 
	 * @return The String value of the word
	 */
	public String toString(){
		return word;
	}
}
