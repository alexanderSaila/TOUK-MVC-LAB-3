import org.junit.Test;
import static org.junit.Assert.*;

public class EncryptionEngineTest {

    // Testing using only 1 as key for encryption and decryption
    @Test
    public void testSmallKey(){
        EncryptionEngine engine = new EncryptionEngine(null);
        engine.setEncryptionKey(1);

        String encrypt = engine.encrypt("a");
        String decrypt = engine.decrypt("a");

        assertEquals("b", encrypt);
        assertEquals("z", decrypt);
    }

    // Testing using keys larger than 26
    @Test
    public void testLargeKey(){
        EncryptionEngine engine = new EncryptionEngine(null);
        engine.setEncryptionKey(54);

        String encrypt = engine.encrypt("a");
        String decrypt = engine.decrypt("a");

        assertEquals("c", encrypt);
        assertEquals("y", decrypt);
    }

    // Testing using negative keys
    @Test
    public void testNegativeKey(){
        EncryptionEngine engine = new EncryptionEngine(null);
        engine.setEncryptionKey(-36);

        String encrypt = engine.encrypt("a");
        String decrypt = engine.decrypt("a");

        assertEquals("q", encrypt);
        assertEquals("k", decrypt);
    }

    // Testing using spaces in input
    @Test
    public void testInputsWithSpace(){
        EncryptionEngine engine = new EncryptionEngine(null);
        engine.setEncryptionKey(10);

        String encrypt = engine.encrypt("ABC DEF");
        String decrypt = engine.decrypt("A B C");

        assertEquals("KLM NOP", encrypt);
        assertEquals("Q R S", decrypt);
    }

    // Test with illegal entries
    @Test
    public void testIllegalEntries(){
        InputValidator validator = new InputValidator(null);

        assertFalse(validator.checkValidStringInput("ABC!!"));
        assertFalse(validator.checkValidKey("K"));

        assertTrue(validator.checkValidStringInput("ABC DEF"));
        assertTrue(validator.checkValidKey("5"));
    }
}
