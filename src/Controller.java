

// This is a dummy Controller, so the View compiles
public class Controller {

    View view;
    EncryptionEngine encryptionEngine;

    public Controller(){
        encryptionEngine = new EncryptionEngine(this);
        view = new View(this);
    }

    public void encryptButtonClicked(){

    }

    public void decryptButtonClicked(){

    }
}
