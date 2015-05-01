package Model;

import Model.security.*;
/**
 * This class has all the functions to determine the variant at variation points
 * Created by Tobias on 25.04.2015.
 */
public class Variance {

    public boolean hasMultiCast(){
        return true;
    }
    public IEncryption getEncryption(){
        //Default Verhalten für Encryption
        //TODO: abhÃ¤ngig von config zurück geben
        return new DefaultEncryption();
    }

    public boolean hasCamera(){
        return true;
    }

    //....etc
}
