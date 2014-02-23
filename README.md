#Most Valuable Combination In Scrabble-like Hand

Given a "hand" of letters, a dictionary and the value of each letter, the problem is to find the
combination of words making the highest score. (@see Subject.pdf or Subject part at the end of the README.md)

####Authors:
Johann NOVAK (johann.novak@utbm.fr) <br>
Nathan OLFF (nathan.olff@utbm.fr) <br>
Donatien RABILLER (donatien.rabiller@utbm.fr) <br>
Quentin SCHULZ (quentin.schulz@utbm.fr)

####Usage:
* Continue the project

Clone the repository and directly import it in your favorite IDE (it was developed thanks to Eclipse, so it will work also with NetBeans).

* Take a look at the project

Download the .jar and all images at the root of this project and run it on your computer (the safest way to run the project is to import it in your IDE and export it to a .jar file instead of downloading it).

**Files needed**<br>
- *enable1.txt* which is the file containing the whole dictionary (currently roughly 173.000 words)<br>
- *hand* which is the file containing the letters in your "hand"<br>
- *lettersvalues.txt* which is the file containing the value for each letter in the alphabet

Next, set the .jar file executable: chmod +x MostValuableCombinationInScrabbleLikeHand.jar<br>
Then run it with: java -jar MostValuableCombinationInScrabbleLikeHand.jar<br>
It will run during 2min and return the result in a file named *result.txt*<br>
The result is formatted as following:<br>
- Each word of the combination takes one line.<br>
- Score of the word.

#####Changelog

**v0.1 - 2014-02-23**
Initial release.<br>

###Subject
(@see Subject.pdf)<br>

Given a “hand” of letters, a dictionary and the value of each letter. The problem is to find the
combination of words making the highest score.<br>
A hand is composed of more than 10 lowercase ascii letters ( an average number would
be 100 but we would increase this number in case of a draw between two teams )<br>
The dictionary will be a file containing one word per line.  ( roughly 90 000 words )<br>
The different values (one for each letter) will be given in the file « lettersvalue », each line
will contain a pair of the following form form :<br>
z34<br>
example:<br>
a1<br>
b2<br>
c4

Using all the letter you can in your hand and only words present in the dictionary, You will
therefore have to form the combination of words making the highest score you can<br>
As an example :<br>
Given the dictionnary : « I am a poney hey» the hand : « zeyhdgtriopn» and the
letter values <I4 p3 o2 n1 e1 y5 h1><br>
The highest combination is : “I poney” with a score of 16<br>
The combination “I hey” is also possible but would only score 11 points

Authorized programming languages are: C/C++, Java, Python<br>
The program should run on linux (no .net funtions).<br>
For C/C++ developpers, provide you sources along with a makefile.<br>
The runnable should be called solution.bin

**Inputs :<br>**
­-            « lettervalue.txt » : contains the value of each letter .It will be composed of 26
lines, with the form a2 (lettervalue)<br>
­-            « enable1.txt » : contains the whole dictionary with one word per line.<br>
­-            « hand » contains one line the letters

**Ouputs :**
The output should be written to the file solution which will contain every word of the best
combination you found with one word per line<br>
exemple:<br>
I<br>
poney<br>
