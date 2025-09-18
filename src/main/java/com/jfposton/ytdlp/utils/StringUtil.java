package com.jfposton.ytdlp.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author markuss
 */
public class StringUtil {
    public static List<String> splitCommandLine(String commandLine) {
        List<String> tokens = new ArrayList<>();
        boolean inQuotes = false;
        StringBuilder currentToken = new StringBuilder();

        for (int i = 0; i < commandLine.length(); i++) {
            char c = commandLine.charAt(i);

            if (c == '"') {
                inQuotes = !inQuotes; // Toggle quote status
            } else if (Character.isWhitespace(c) && !inQuotes) {
                if (currentToken.length() > 0) {
                    tokens.add(currentToken.toString());
                    currentToken.setLength(0);
                }
            } else {
                currentToken.append(c);
            }
        }

        // Add last token
        if (currentToken.length() > 0) {
            tokens.add(currentToken.toString());
        }

        return tokens;
    }
}