import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by c0rp on 11/21/16.
 */

public class SecurityUtils {

    private static final String SHA_512 = "SHA-512";
    private static final String SHA_1 = "SHA-1";
    private static final String MD5 = "MD5";

    /**
     * Generate SHA-512 digest from string.
     * <p>
     * It returns result in hex encoded format (Hexadecimal)
     *
     * @param stringToDigest Data to digest
     *
     * @return SHA-512 digest as encoded string in hexadecimal format
     */
    public static String sha512(final String stringToDigest) {
        return getDigestByAlgorithm(stringToDigest, SHA_512);
    }

    /**
     * Generate SHA-1 digest from string.
     * <p>
     * It returns result in hex encoded format (Hexadecimal)
     *
     * @param stringToDigest Data to digest
     *
     * @return SHA-1 digest as  encoded string in hexadecimal format
     */
    public static String sha1(final String stringToDigest) {
        return getDigestByAlgorithm(stringToDigest, SHA_1);
    }

    /**
     * Generate MD5 hash from string.
     * <p>
     * It returns result in hex encoded format (Hexadecimal)
     *
     * @param stringToDigest Data to digest
     *
     * @return MD5 digest as encoded string in hexadecimal format
     */
    public static String md5(final String stringToDigest) {
        return getDigestByAlgorithm(stringToDigest, MD5);
    }

    /**
     * Generate digest from string and specified algorithm
     * <p>
     * Throws RuntimeException if algorithm is not provided in runtime
     *
     * @param stringToHash Data to digest
     * @param digestAlgorithm Algorithm name
     * @return calculated digest as encoded string in hexadecimal format
     */
    private static String getDigestByAlgorithm(final String stringToHash, final String digestAlgorithm) {
        final MessageDigest md;
        try {
            md = MessageDigest.getInstance(digestAlgorithm);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException(
                "For some reasons algorithm " +digestAlgorithm + " not found. Normally this should never happen");
        }
        md.update(stringToHash.getBytes());
        final byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        final StringBuffer hashCodeBuffer = new StringBuffer();
        for (byte aByteData : byteData) {
            hashCodeBuffer.append(Integer.toString((aByteData & 0xff) + 0x100, 16).substring(1));
        }
        return hashCodeBuffer.toString();
    }
}
