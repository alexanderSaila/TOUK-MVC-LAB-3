public class EncryptionEngine {

    Controller controller;

    int encryptionKey;

    public EncryptionEngine(Controller controller){
        this.encryptionKey = 0;
        this.controller = controller;
    }

    public void setEncryptionKey(int encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

    public int getEncryptionKey() {
        return encryptionKey;
    }

    public String encrypt(String inputText){
        return null;
    }

    public String decrypt(String inputText){
        return null;
    }
}

