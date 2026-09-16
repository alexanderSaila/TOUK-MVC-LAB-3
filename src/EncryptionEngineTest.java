import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EncryptionEngineTest {

    // Testing using only 1 as key for encryption and decryption
    @Test
    void testSmallKey(){
        EncryptionEngine engine = new EncryptionEngine(null);
        engine.setEncryptionKey(1);

        String encrypt = engine.encrypt("a");
        String decrypt = engine.decrypt("a");

        assertEquals("b", encrypt);
        assertEquals("z", decrypt);
    }

    // Testing using keys larger than 26
    @Test
    void testLargeKey(){
        EncryptionEngine engine = new EncryptionEngine(null);
        engine.setEncryptionKey(54);

        String encrypt = engine.encrypt("a");
        String decrypt = engine.decrypt("a");

        assertEquals("c", encrypt);
        assertEquals("y", decrypt);
    }

    // Testing using negative keys
    @Test
    void testNegativeKey(){
        EncryptionEngine engine = new EncryptionEngine(null);
        engine.setEncryptionKey(-10);

        String encrypt = engine.encrypt("a");
        String decrypt = engine.decrypt("a");

        assertEquals("q", encrypt);
        assertEquals("k", decrypt);
    }

    // Testing using spaces in input
    @Test
    void testInputsWithSpace(){
        EncryptionEngine engine = new EncryptionEngine(null);
        engine.setEncryptionKey(10);

        String encrypt = engine.encrypt("ABC DEF");
        String decrypt = engine.decrypt("A B C");

        assertEquals("KLM NOP", encrypt);
        assertEquals("Q R S", decrypt);
    }

    // Test with illegal entries
    @Test
    void testIllegalEntries(){
        EncryptionEngine engine = new EncryptionEngine(null);
        engine.setEncryptionKey(1);

        assertThrows(IllegalArgumentException.class, () -> {
            engine.encrypt("ABC!!");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            engine.decrypt("@ABC,.");
        });
    }
}
