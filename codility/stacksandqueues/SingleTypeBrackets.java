package codility.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Deque;

import codility.utility.string.StringUtils;

/**
 * A string S consisting of N characters is called properly nested if:
 * 
 * S is empty; S has the form "(U)" where U is a properly nested string; S has
 * the form "VW" where V and W are properly nested strings. For example, string
 * "(()(())())" is properly nested but string "())" isn't.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(String S); }
 * 
 * that, given a string S consisting of N characters, returns 1 if string S is
 * properly nested and 0 otherwise.
 * 
 * For example, given S = "(()(())())", the function should return 1 and given S
 * = "())", the function should return 0, as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [0..1,000,000]; string S consists only of
 * the characters "(" and/or ")". Copyright 2009–2021 by Codility Limited. All
 * Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 * 
 * TIME COMPLEXITY - O(N)
 */
public class SingleTypeBrackets {
    private static final char OPENED_BRACKET = '(';
    private static final char CLOSED_BRACKET = ')';

    public static void main(String[] args) {

        String nestedString = "(()(())())";
        int isNested = solution(nestedString);
        System.out.printf("isNested? Actual %s, Expected 1 %n", isNested);

        nestedString = "())";
        isNested = solution(nestedString);
        System.out.printf("isNested? Actual %s, Expected 0 %n", isNested);

        nestedString = ")(";
        isNested = solution(nestedString);
        System.out.printf("isNested? Actual %s, Expected 0 %n", isNested);
    }

    public static int solution(String testNestedString) {

        if (StringUtils.isEmpty(testNestedString)) {
            return 1;
        }

        char[] charArray = testNestedString.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < charArray.length; i++) {
            char nest = charArray[i];
            if (nest == OPENED_BRACKET) {
                stack.push(nest);
            } else if (nest == CLOSED_BRACKET) {
                if (stack.isEmpty()) {
                    return 0;
                }

                stack.pop();
            }
        }

        // Is Stack is not Empty then return 0
        if (!stack.isEmpty()) {
            return 0;
        }

        return 1;
    }
}
