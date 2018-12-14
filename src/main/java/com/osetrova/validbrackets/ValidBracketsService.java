package com.osetrova.validbrackets;

import java.util.Stack;

public class ValidBracketsService {

    private static final String OPENING_BRACKETS = "{([";
    private static final String CLOSING_BRACKETS = "})]";

    public boolean isBracketStringValid(String checkedString) {
        boolean result = true;
        Stack<Character> brackets = new Stack<>();

        if (!checkedString.trim().isEmpty()) {
            for (int i = 0, y = checkedString.length(); i < y; i++) {
                Character currentBracket = checkedString.charAt(i);
                if (OPENING_BRACKETS.indexOf(currentBracket) >= 0) {
                    brackets.push(currentBracket);
                } else {
                    if (!brackets.empty()) {
                        if (isOpeningBracketWrong(brackets.pop(), currentBracket)) {
                            result = false;
                            break;
                        }
                    } else {
                        result = false;
                        break;
                    }
                }
            }

            if (!brackets.isEmpty()) {
                result = false;
            }
        }

        return result;
    }

    private boolean isOpeningBracketWrong(Character openingBracket, Character closingBracket) {
        return OPENING_BRACKETS.indexOf(openingBracket) != CLOSING_BRACKETS.indexOf(closingBracket);
    }
}
