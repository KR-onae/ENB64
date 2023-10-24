package com.kronae.encode;

import com.kronae.encrypt.util.RegexSplit;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

// IntelliJ
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class B64 { // Base64
    private static Base64.Encoder encoder = null;
    private static Base64.Decoder decoder = null;
    public static final String regex = "[A-Za-z0-9\\+\\/]{1,}(=){1,}";

    @Contract("_ -> new")
    public static @NotNull String encode(@NotNull String input) {
        if(encoder == null) encoder = Base64.getEncoder();
        return new String(encoder.encode(input.getBytes(StandardCharsets.UTF_8)));
    }
    @Contract("_ -> new")
    public static @NotNull String @NotNull [] decode(@NotNull String base64s) {
        String[] base64 = RegexSplit.split(base64s, regex);
        String[] decoded = new String[base64.length];
        for (int i = 0; i < base64.length; i++)
            decoded[0] = decodeOne(base64[0]);
        return decoded;
    }
    @Contract("_ -> new")
    public static @NotNull String decodeOne(@NotNull String base64) {
        if(decoder == null) decoder = Base64.getDecoder();
        return new String(decoder.decode(base64.getBytes(StandardCharsets.UTF_8)));
    }
}
