

// This is a dummy Controller, so the View compiles
public class Controller {

    View view;
    EncryptionEngine encryptionEngine;

    public Controller(){
        encryptionEngine = new EncryptionEngine(this);
        view = new View(this);
    }

    public void encryptButtonClicked(){
        try{
            int encryptionKey = Integer.parseInt(view.getEncryptionKey().trim());
            encryptionEngine.setEncryptionKey(encryptionKey);
            System.out.println("Encryption key set to: " + encryptionKey);

            String encryptedString = encryptionEngine.encrypt(view.getInputText());
            view.setOutputText(encryptedString);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Key Entry.");
            view.setOutputText("Invalid Key.");
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            view.setOutputText(e.getMessage());
        }
    }

    public void decryptButtonClicked(){
        try{
            int encryptionKey = Integer.parseInt(view.getEncryptionKey().trim());
            encryptionEngine.setEncryptionKey(encryptionKey);
            System.out.println("Encryption key set to: " + encryptionKey);

            String decryptedString = encryptionEngine.decrypt(view.getInputText());
            view.setOutputText(decryptedString);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Key Entry.");
            view.setOutputText("Invalid Key.");
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
