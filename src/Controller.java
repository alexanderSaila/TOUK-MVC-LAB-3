

// This is a dummy Controller, so the View compiles
public class Controller {

    View view;
    EncryptionEngine encryptionEngine;
    InputValidator inputValidator;

    public Controller(){
        encryptionEngine = new EncryptionEngine(this);
        inputValidator = new InputValidator(this);
        view = new View(this);
    }

    public void encryptButtonClicked(){
        String keyString = view.getEncryptionKey().trim();
        String inputString = view.getInputText();

        if(inputValidator.checkValidKey(keyString)){
            encryptionEngine.setEncryptionKey(Integer.parseInt(keyString));
        }
        else {
            view.setOutputText("Invalid Key.");
            return;
        }

        if(inputValidator.checkValidStringInput(inputString)){
            view.setOutputText(encryptionEngine.encrypt(inputString));
        }
        else {
            view.setOutputText("Invalid Key.");
        }
    }

    public void decryptButtonClicked(){
        String keyString = view.getEncryptionKey().trim();
        String inputString = view.getInputText();

        if(inputValidator.checkValidKey(keyString)){
            encryptionEngine.setEncryptionKey(Integer.parseInt(keyString));
        }
        else {
            view.setOutputText("Invalid Key.");
            return;
        }

        if(inputValidator.checkValidStringInput(inputString)){
            view.setOutputText(encryptionEngine.decrypt(inputString));
        }
        else {
            view.setOutputText("Invalid Key.");
        }
    }
}
