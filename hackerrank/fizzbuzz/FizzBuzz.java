import java.util.Optional;

/**
 * Given a number n for each integer i in the range from 1 to n inclusive, print one value per line as follows
 * 
 * If i % 3 & 5 then print FizzBuzz
 * if I % 3 then pring Fizz
 * if I % 5 then print Buzz
 * if i is not a multiple then return the value of i
 */
class FizzBuzz {
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    /*
     * Complete the 'fizzBuzz' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void main(String[] args) {
        fizzBuzz(15);
    }

    public static void fizzBuzz(int n) {
        // Write your code here

        for (int i = 1; i <= n; i++) {
            StringBuilder fizzbuzzBuilder = new StringBuilder();

            if (i % 3 == 0) {
                fizzbuzzBuilder.append(FIZZ);
            }

            if (i % 5 == 0) {
                fizzbuzzBuilder.append(BUZZ);
            }

            Optional<String> result = Optional.of(fizzbuzzBuilder.toString());

            if (!result.get().equals("")) {
                System.out.println(result.get());
            } else {
                System.out.printf("%d%n", i);
            }
        }
    }

}