
/**
 *	A class that stores each letter of the hand. It will then determine which letter we can use and how often each one for finding the word (or combination of words) with the highest score.
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
public class Hand extends Word{
	/**
	 * Create a new Hand with the string value of all letters in the hand and the value of each letter
	 * 
	 * @param s String value of all letters contained in the hand
	 * @param lettersValue LettersValues object which stores the value of each letter for a game
	 */
	public Hand(String s, LettersValues lettersValue) {
		super(s, lettersValue);
	}

}
