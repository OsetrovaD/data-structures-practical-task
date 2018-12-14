package com.osetrova.validbrackets;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidBracketsServiceTest {

    private ValidBracketsService service = new ValidBracketsService();

    @Test
    public void checkIsBracketStringValidWithEmptyString() {
        String brackets = "   ";

        boolean result = service.isBracketStringValid(brackets);
        assertTrue(result);
    }

    @Test
    public void checkIsBracketStringValidWithInvalidString() {
        String brackets = "({}[)";

        boolean result = service.isBracketStringValid(brackets);
        assertFalse(result);
    }

    @Test
    public void checkIsBracketStringValidWithOpeningBracketsOnly() {
        String brackets = "({[";

        boolean result = service.isBracketStringValid(brackets);
        assertFalse(result);
    }

    @Test
    public void checkIsBracketStringValidWithValidString() {
        String brackets = "({[]}){()}";

        boolean result = service.isBracketStringValid(brackets);
        assertTrue(result);
    }
}
