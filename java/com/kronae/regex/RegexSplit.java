package com.kronae.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// IntelliJ
import org.jetbrains.annotations.NotNull;

public class RegexSplit {
    public static String @NotNull [] split(String input, String regex) {
        List<String> matches = new ArrayList<>();
        Matcher m = Pattern.compile(regex)
                .matcher(input);

        while (m.find())
            matches.add(m.group());

        return matches.toArray(new String[0]);
    }
}
