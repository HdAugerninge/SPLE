package model.security;

/**
 * Created by test on 26.04.2015.
 */
public class DefaultEncryption implements IEncryption {

    public String encrypt (String s){return s;}
    public String decrypt (String s){return s;}
}
