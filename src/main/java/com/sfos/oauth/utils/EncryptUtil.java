package com.sfos.oauth.utils;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 加密工具类
 */
public class EncryptUtil implements PasswordEncoder {

    /**
     * 对密码进行加密并返回
     * @param srcPassword
     * @return
     */
    @Override
    public String encode(CharSequence srcPassword) {
        //todo
        String encPassword = srcPassword.toString();
        return encPassword;
    }

    /**
     * 验证密码是否正确
     * @param charSequence
     * @param s
     * @return
     */
    @Override
    public boolean matches(CharSequence charSequence, String s) {
        //todo
        return true;
    }

}
