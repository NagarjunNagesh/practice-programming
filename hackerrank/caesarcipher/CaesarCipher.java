package hackerrank.caesarcipher;

import java.util.HashMap;
import java.util.Map;

/**
 * Julius Caesar protected his confidential information by encrypting it using a
 * cipher. Caesar's cipher shifts each letter by a number of letters. If the
 * shift takes you past the end of the alphabet, just rotate back to the front
 * of the alphabet. In the case of a rotation by 3, w, x, y and z would map to
 * z, a, b and c. Original alphabet: abcdefghijklmnopqrstuvwxyz Alphabet rotated
 * +3: defghijklmnopqrstuvwxyzabc Example
 * 
 * 
 * The alphabet is rotated by , matching the mapping above. The encrypted string
 * is . Note: The cipher only encrypts letters; symbols, such as -, remain
 * unencrypted. Function Description Complete the caesarCipher function in the
 * editor below. caesarCipher has the following parameter(s): string s:
 * cleartext int k: the alphabet rotation factor Returns string: the encrypted
 * string Input Format The first line contains the integer, , the length of the
 * unencrypted string. The second line contains the unencrypted string, . The
 * third line contains , the number of letters to rotate the alphabet by.
 * Constraints
 * 
 * 
 * is a valid ASCII string without any spaces.
 * 
 * TimeComplexity - O(N)
 */
public class CaesarCipher {

    public static void main(String[] args) {
        String cipherText = caesarCipher("middle-Outz", 2);
        System.out.printf("%s%n", cipherText.equals("okffng-Qwvb"));
    }

    public static String caesarCipher(String s, int k) {
        char[] alphabetArray = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
                'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        char[] capitalAlphabetArray = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
                'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
        Map<Character, Integer> charToInteger = initializeMapToCharacter();
        Map<Character, Integer> charToCapitalInteger = initializeCapitalMapToCharacter();
        char[] characters = s.toCharArray();
        StringBuilder characterBuilder = new StringBuilder();

        for (char character : characters) {
            Integer alphabetPosition = charToInteger.get(character);

            if (alphabetPosition == null) {
                alphabetPosition = checkIfLetterIsCapital(charToCapitalInteger, character, alphabetPosition);
                calculateCipheredText(k, capitalAlphabetArray, characterBuilder, character, alphabetPosition);
            } else {
                calculateCipheredText(k, alphabetArray, characterBuilder, character, alphabetPosition);
            }
        }

        return characterBuilder.toString();
    }

    private static void calculateCipheredText(int k, char[] alphabetArray, StringBuilder characterBuilder,
            char character, Integer alphabetPosition) {
        if (alphabetPosition == null) {
            characterBuilder.append(character);
        } else {
            char cipher = calculateCipheredText(k, alphabetArray, alphabetPosition);
            characterBuilder.append(cipher);
        }
    }

    private static char calculateCipheredText(int k, char[] alphabetArray, Integer alphabetPosition) {
        int moveposition = alphabetPosition + k;
        moveposition = startFromA(moveposition);

        char cipher = alphabetArray[moveposition];
        return cipher;
    }

    private static Integer checkIfLetterIsCapital(Map<Character, Integer> charToCapitalInteger, char character,
            Integer alphabetPosition) {

        alphabetPosition = charToCapitalInteger.get(character);
        return alphabetPosition;
    }

    private static int startFromA(int moveposition) {
        if (moveposition > 25) {
            moveposition = moveposition - 26;
        }
        return moveposition;
    }

    private static Map<Character, Integer> initializeCapitalMapToCharacter() {
        Map<Character, Integer> charToInteger = new HashMap<>();
        charToInteger.put('A', 0);
        charToInteger.put('B', 1);
        charToInteger.put('C', 2);
        charToInteger.put('D', 3);
        charToInteger.put('E', 4);
        charToInteger.put('F', 5);
        charToInteger.put('G', 6);
        charToInteger.put('H', 7);
        charToInteger.put('I', 8);
        charToInteger.put('J', 9);
        charToInteger.put('K', 10);
        charToInteger.put('L', 11);
        charToInteger.put('M', 12);
        charToInteger.put('N', 13);
        charToInteger.put('O', 14);
        charToInteger.put('P', 15);
        charToInteger.put('Q', 16);
        charToInteger.put('R', 17);
        charToInteger.put('S', 18);
        charToInteger.put('T', 19);
        charToInteger.put('U', 20);
        charToInteger.put('V', 21);
        charToInteger.put('W', 22);
        charToInteger.put('X', 23);
        charToInteger.put('Y', 24);
        charToInteger.put('Z', 25);
        return charToInteger;
    }

    private static Map<Character, Integer> initializeMapToCharacter() {
        Map<Character, Integer> charToInteger = new HashMap<>();
        charToInteger.put('a', 0);
        charToInteger.put('b', 1);
        charToInteger.put('c', 2);
        charToInteger.put('d', 3);
        charToInteger.put('e', 4);
        charToInteger.put('f', 5);
        charToInteger.put('g', 6);
        charToInteger.put('h', 7);
        charToInteger.put('i', 8);
        charToInteger.put('j', 9);
        charToInteger.put('k', 10);
        charToInteger.put('l', 11);
        charToInteger.put('m', 12);
        charToInteger.put('n', 13);
        charToInteger.put('o', 14);
        charToInteger.put('p', 15);
        charToInteger.put('q', 16);
        charToInteger.put('r', 17);
        charToInteger.put('s', 18);
        charToInteger.put('t', 19);
        charToInteger.put('u', 20);
        charToInteger.put('v', 21);
        charToInteger.put('w', 22);
        charToInteger.put('x', 23);
        charToInteger.put('y', 24);
        charToInteger.put('z', 25);
        return charToInteger;
    }

}
