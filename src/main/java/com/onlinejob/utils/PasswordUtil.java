package com.onlinejob.utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {

    private static  PasswordUtil passwordUtil = null;

    public PasswordUtil(){

    }

    public static PasswordUtil getPasswordUtil() {
        if(passwordUtil != null) {
            return passwordUtil;
        }
        passwordUtil = new PasswordUtil();

        return passwordUtil;
    }

    public String hashPassword(String password) {
        String hashedPass = BCrypt.hashpw(password, BCrypt.gensalt());
        return hashedPass;
    }
    public boolean comparePassword(String candidatePassword , String userEnteredPassword) {
        boolean isSame = BCrypt.checkpw(candidatePassword, userEnteredPassword);
        return isSame;
    }
}
