package com.kronae.encrypt;

import org.jetbrains.annotations.NotNull;

public abstract class Encrypter {
    @NotNull
    public abstract String encrypt(@NotNull String decrypted);
    @NotNull
    public abstract String decrypt(@NotNull String encrypted);
}
