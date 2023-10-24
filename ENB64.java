package com.kronae.encrypt.enb64;

import com.kronae.encrypt.enb64.exception.DataTooLotException;
import com.kronae.encrypt.enb64.util.RegexSplit;

// IntelliJ
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class ENB64 { // Encrypt aNd Base64 encrypting system
    private final char[] key;

    public ENB64(@NotNull String key) {
        this.key = key.toCharArray();
    }
    public @NotNull String encrypt(@NotNull String decrypted) {
        char[] chars = decrypted.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (char c : key) {
                chars[i] = (char) (chars[i] + c);
            }
        }

        String encrypted = new String(chars);

        return B64.encode(encrypted) + "$";
    }
    public String[] decryptAll(@NotNull String encrypted) {
        if(!encrypted.endsWith("$"))
            return null;

        String[] arr = RegexSplit.split(encrypted, B64.regex);
        for (int i = 0; i < arr.length; i++)
            arr[i] = decrypt(arr[i]);

        return arr;
    }
    public @NotNull String decrypt(@NotNull String encrypted) {
        if(count(encrypted) > 1)
            throw new DataTooLotException("Encrypted data is too lot! Please use ENB64S#decryptAll(String) or user ENB64S.count(String) to get count");

        String decoded = B64.decodeOne(encrypted);

        char[] chars = decoded.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (char c : key) {
                chars[i] = (char) (chars[i] - c);
            }
        }

        return new String(chars);
    }

    @Contract(pure = true)
    public static int count(@NotNull String encrypted) {
        return encrypted.split("\\$").length;
    }
}
