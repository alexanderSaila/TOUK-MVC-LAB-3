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

    public String encrypt(String inputText) {
        StringBuilder encryptedString = new StringBuilder();
        for (char x : inputText.toCharArray()) {
            char encryptedChar = ' ';
            if (x >= 'A' && x <= 'Z') {
                encryptedChar = (char) ('A' + ((x - 'A') + (encryptionKey % 26) + 26) % 26);
            } else if (x >= 'a' && x <= 'z') {
                encryptedChar = (char) ('a' + ((x - 'a') + (encryptionKey % 26) + 26) % 26);
            }
            encryptedString.append(encryptedChar);
        }
        return encryptedString.toString();
    }

    public String decrypt(String inputText){
        StringBuilder encryptedString = new StringBuilder();
        for (char x : inputText.toCharArray()) {
            char encryptedChar = ' ';
            if (x >= 'A' && x <= 'Z') {
                encryptedChar = (char) ('A' + ((x - 'A') + (-encryptionKey % 26) + 26) % 26);
            } else if (x >= 'a' && x <= 'z') {
                encryptedChar = (char) ('a' + ((x - 'a') + (-encryptionKey % 26) + 26) % 26);
            }
            encryptedString.append(encryptedChar);
        }
        return encryptedString.toString();
    }
}

