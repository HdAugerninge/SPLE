package model.security;

/**
 * Created by test on 26.04.2015.
 */
public class CaesarianEncryption implements IEncryption {

    public String encrypt(String s){
        String ret = "";
        for(int i=0;i<s.length();i++){
            ret += ""+((char)(s.charAt(i)+1));
        }
        return ret;
    }

    public String decrypt(String s){
        String ret = "";
        for(int i=0;i<s.length();i++){
            ret += ""+((char)(s.charAt(i)-1));
        }
        return ret;
    }
}
