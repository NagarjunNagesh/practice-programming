package codility.utility.string;

public class StringUtils {
    /**
     * 3585 *
     * <p>
     * Checks if a CharSequence is empty ("") or null.
     * </p>
     * 3586 * 3587 *
     * 
     * <pre>
    3588     * StringUtils.isEmpty(null)      = true
    3589     * StringUtils.isEmpty("")        = true
    3590     * StringUtils.isEmpty(" ")       = false
    3591     * StringUtils.isEmpty("bob")     = false
    3592     * StringUtils.isEmpty("  bob  ") = false
    3593     *
     * </pre>
     * 
     * 3594 * 3595 *
     * <p>
     * NOTE: This method changed in Lang version 2.0. 3596 * It no longer trims the
     * CharSequence. 3597 * That functionality is available in isBlank().
     * </p>
     * 3598 * 3599 * @param cs the CharSequence to check, may be null 3600 * @return
     * {@code true} if the CharSequence is empty or null 3601 * @since 3.0 Changed
     * signature from isEmpty(String) to isEmpty(CharSequence) 3602
     */
    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }
}
