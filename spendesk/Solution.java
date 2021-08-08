package spendesk;

import java.util.Arrays;

/** Check if an array contains all the values of another array */
public class Solution {

    public static void main(String[] args) {
        String[] newsPaper = {"those", "are", "newspaper", "words"};
        String[] ransomNote = {"those", "are", "ransom", "node", "words"};
        boolean containsAll = canDoRansom(newsPaper, ransomNote);
        System.out.printf("Contains All ransome notes %b%n", containsAll);

        String[] newsPaper2 = {"those", "are", "newspaper", "words"};
        String[] ransomNote2 = {"those", "are", "newspaper", "words"};
        containsAll = canDoRansom(newsPaper2, ransomNote2);
        System.out.printf("Contains All ransome notes %b%n", containsAll);

        String[] newsPaper3 = {"those", "are", "newspaper", "words", "more"};
        String[] ransomNote3 = {"those", "are", "newspaper", "words"};
        containsAll = canDoRansom(newsPaper3, ransomNote3);
        System.out.printf("Contains All ransome notes %b%n", containsAll);

        String[] newsPaper4 = {};
        containsAll = canDoRansom(newsPaper4, ransomNote3);
        System.out.printf("Contains All ransome notes %b%n", containsAll);


        String[] ransomNote4 = {};
        containsAll = canDoRansom(newsPaper3, ransomNote4);
        System.out.printf("Contains All ransome notes %b%n", containsAll);

    }

    public static boolean canDoRansom(String[] newspaper, String[] ransomNote) {

        if (newspaper == null || newspaper.length == 0 || ransomNote == null || ransomNote.length == 0) {
            return false;
        }

        boolean containsAll = false;
        for (String oneWord : ransomNote) {
            containsAll = Arrays.stream(newspaper).anyMatch(x -> x == oneWord);

            if (!containsAll) {
                break;
            }
        }

        return containsAll;
    }
}
