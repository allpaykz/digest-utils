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
     * Generate SHA512 hash from string.
     * <p>
     * It returns result in hex encoded format (Hexadecimal)
     *
     * @param stringToHash
     *
     * @return encoded string in hexadecimal format
     */
    public static String sha512(final String stringToHash) {
        return getDigestByAlgorithm(stringToHash, SHA_512);
    }

    /**
     * Generate SHA_1 hash from string.
     * <p>
     * It returns result in hex encoded format (Hexadecimal)
     *
     * @param stringToHash
     *
     * @return encoded string in hexadecimal format
     */
    public static String sha1(final String stringToHash) {
        return getDigestByAlgorithm(stringToHash, SHA_1);
    }

    /**
     * Generate MD5 hash from string.
     * <p>
     * It returns result in hex encoded format (Hexadecimal)
     *
     * @param stringToHash
     *
     * @return encoded string in hexadecimal format
     */
    public static String md5(final String stringToHash) {
        return getDigestByAlgorithm(stringToHash, MD5);
    }

    /**
     * Generate digest hash from string and specified algorithm
     * <p>
     * Throws RuntimeException if algorithm is not provided
     *
     * @param stringToHash
     * @param digestAlgorithm
     * @return encoded string in hexadecimal format
     */
    private static String getDigestByAlgorithm(final String stringToHash, final String digestAlgorithm) {
        final MessageDigest md;
        try {
            md = MessageDigest.getInstance(digestAlgorithm);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException(
                "For some reasons algorithm not found. Normally this should never happend");
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
