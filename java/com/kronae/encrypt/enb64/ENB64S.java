package com.kronae.encrypt.enb64;

import com.kronae.encrypt.exception.DataTooLotException;
import com.kronae.encrypt.util.RandomString;
import com.kronae.encrypt.util.RegexSplit;
import com.kronae.encrypter.Encrypter;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

public class ENB64S { // Encrypt aNd Base64 encrypting system with Salts
    private final @Range(from = 1, to = 16) int salts;
    private final ENB64 encrypter;

    public ENB64S(@NotNull String key, @Range(from=1,to=16) int salts) {
        this.encrypter = new ENB64(key);
        this.salts = salts;
    }
    public @NotNull String encrypt(@NotNull String decrypted) {
        String r = RandomString.generate(salts);
        System.out.println(r);
        return encrypter.encrypt(decrypted + r);
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
        String decrypted = encrypter.decrypt(encrypted);
        return decrypted.substring(0, decrypted.length() - salts);
    }

    @Contract(pure = true)
    public static int count(@NotNull String encrypted) {
        return encrypted.split("\\$").length;
    }
}
