import java.security.NoSuchAlgorithmException;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

/**
 * @author Sanzhar Aubakirov (c0rp.aubakirov@gmail.com)
 */
public class SecurityUtilsTest {
    private static final String word1 = "123qwe";
    private static final String word2 = "asdzxc";
    private static final String word3 = "yoda";

    private static final String SHA512_1 = "4aeb2000b9de5858f5e5e0b7eda52f253caf19582c67cbbb453be6987ecc1baf27d75670e39f78058fb1ebee3d16b83d1cbdc8d3628636377b2458ea5bf12ff2";
    private static final String SHA512_2 = "4dd2fd3d44e3b80ddb7e59152bb5219f8ab8a8c6f949b6a6a11650e89d7ad7853a48062cc45bf7d895813cd3aa6f34bc63d188652d0a87c9d05fea825dd68d7b";
    private static final String SHA512_3 = "0b48920fa990311b6ec6127146a293ea4b45a89aca9574361499b6fc3355625d8d81ef220b45f52658d1d6fc7db3c3f04c2b221b2765e0ee78d0d4b705542528";

    private static final String SHA1_1 = "05fe7461c607c33229772d402505601016a7d0ea";
    private static final String SHA1_2 = "d30afd521506d7d66c4a0954cc3948f16791eb05";
    private static final String SHA1_3 = "faa4dba18c9534bb11dffd21a0cf32a8ec5573ac";

    private static final String MD5_1 = "46f94c8de14fb36680850768ff1b7f2a";
    private static final String MD5_2 = "cffbad68bb97a6c3f943538f119c992c";
    private static final String MD5_3 = "8280de3ef89855b206c1d74510deb424";

    public static final String ERROR = "\n\nProvided hash for words are incorrect. Method produces wrong hashes.\n\t !!! Please pay attention !!! this could lead to serious security problems\n";

    @Test
    public void testGetSHA512CodeFromString() throws NoSuchAlgorithmException {
        assertEquals(SecurityUtils.sha512(SecurityUtilsTest.word1), SecurityUtilsTest.SHA512_1, ERROR);
        assertEquals(SecurityUtils.sha512(SecurityUtilsTest.word2), SecurityUtilsTest.SHA512_2, ERROR);
        assertEquals(SecurityUtils.sha512(SecurityUtilsTest.word3), SecurityUtilsTest.SHA512_3, ERROR);
    }

    @Test
    public void testGetSHA1CodeFromString() throws Exception {
        assertEquals(SecurityUtils.sha1(SecurityUtilsTest.word1), SecurityUtilsTest.SHA1_1, ERROR);
        assertEquals(SecurityUtils.sha1(SecurityUtilsTest.word2), SecurityUtilsTest.SHA1_2, ERROR);
        assertEquals(SecurityUtils.sha1(SecurityUtilsTest.word3), SecurityUtilsTest.SHA1_3, ERROR);
    }

    @Test
    public void testGetMD5CodeFromString() throws Exception {
        assertEquals(SecurityUtils.md5(SecurityUtilsTest.word1), SecurityUtilsTest.MD5_1, ERROR);
        assertEquals(SecurityUtils.md5(SecurityUtilsTest.word2), SecurityUtilsTest.MD5_2, ERROR);
        assertEquals(SecurityUtils.md5(SecurityUtilsTest.word3), SecurityUtilsTest.MD5_3, ERROR);
    }

}
