# ENB64S, The best encrypting system.
ENB64S automatically adds salt to strengthen security,
This method allows encryption using a key.

# Encryption method of ENB64(S)
1. Combine random string to the right of String input. Currently, the number of characters in the random string is determined by the user. 
2. Convert String input and String key to char[] respectively.
3. Adds the sum of the values of the char[] key to the values in the char[] input.
4. Converts char[] input to String.
5. Encode the converted characters in Base64.
6. Add $ at the end.

It also automatically adds a $ symbol at the end to make it easier to use.
This makes it easy to distinguish data during socket communication.
