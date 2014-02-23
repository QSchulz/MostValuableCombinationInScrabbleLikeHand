import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


/**
 *	A class that parses and stores values for each letter in the game.
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
public class LettersValues {
	short[] tab;
	/**
	 * Create a new LettersValues object which stores a maximum of 26 values (as many as letters exists in the alphabet)
	 */
	public LettersValues()
	{
		this.tab = new short[26];
	}
	/**
	 * Return the value of the character passed by parameter
	 * 
	 * @param c The character whose value is asked
	 * 
	 * @return the value of the character (short)
	 */
	public short getLettersValue(char c) {		
		if(c<'a')
			return 0;
		else
			return tab[c-'a'];
	}
	/**
	 * Parse the file whose path is passed by parameter for finding value of each letter of the alphabet
	 * 
	 * @param path The path of the file from which we want to extract value of each letter
	 */
	public void parseFile(String path)
	{
			try {
				Scanner input = new Scanner(new FileReader(path));
				String s = null, s2;
				int i=0;
				while(input.hasNextLine() && i<26)
				{
					s = input.nextLine();
					s2 = s.substring(1,s.length());
					this.tab[i] = Short.parseShort(s2);
					++i;
				}
				
				input.close();
				} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	}
}

