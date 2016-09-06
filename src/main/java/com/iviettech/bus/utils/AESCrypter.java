
package com.iviettech.bus.utils;

import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

@Component
public class AESCrypter {
    
    public String decrypt(String text, String key, String iv)
            throws GeneralSecurityException {
        String originalString = null;
        if ((text == null) || (key == null) || (iv == null) || (key.length() != 16) || (iv.length() != 16)) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());

        cipher.init(2, skeySpec, ivSpec);

        byte[] textAsByteArray = stringToHex(text);
        if (textAsByteArray != null) {
            byte[] original = cipher.doFinal(textAsByteArray);
            try {
                originalString = new String(original, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new GeneralSecurityException("Unsupported encoding exception");
            }
        }
        return originalString;
    }

    public String encrypt(String text, String key, String iv)
            throws GeneralSecurityException {
        if ((text == null) || (key == null) || (iv == null) || (key.length() != 16) || (iv.length() != 16)) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());

        cipher.init(1, skeySpec, ivSpec);

        byte[] encrypted = cipher.doFinal(text.getBytes());

        return hexToString(encrypted);
    }

    public static byte[] stringToHex(String s) {
        if ((s == null) || (s.length() == 0)) {
            return null;
        }
        int l = s.length();
        if (l % 2 == 1) {
            return null;
        }
        byte[] b = new byte[l / 2];
        for (int i = 0; i < l / 2; i++) {
            b[i] = ((byte)Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
        }
        return b;
    }

    public static String hexToString(byte[] buf) {
        if ((buf == null) || (buf.length == 0)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(buf.length * 2);
        for (int i = 0; i < buf.length; i++)
        {
            if ((buf[i] & 0xFF) < 16) {
                stringBuilder.append("0");
            }
            stringBuilder.append(Long.toString(buf[i] & 0xFF, 16));
        }
        return stringBuilder.toString();
    }
}