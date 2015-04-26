package model.security;

/**
 * Created by test on 25.04.2015.
 */
public interface IEncryption {

    String encrypt(String s);
    String decrypt(String s);
}
