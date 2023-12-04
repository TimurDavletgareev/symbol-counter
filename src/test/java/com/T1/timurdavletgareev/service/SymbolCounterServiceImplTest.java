package com.T1.timurdavletgareev.service;

import com.T1.timurdavletgareev.dto.TextToDecodeDto;
import com.T1.timurdavletgareev.error.exception.IncorrectRequestException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class SymbolCounterServiceImplTest {

    SymbolCounterService symbolCounterService = new SymbolCounterServiceImpl();

    @Test
    void shouldCountSymbols() {

        TextToDecodeDto text = new TextToDecodeDto();
        text.setText("aaaaabcccc");
        assertEquals("“a”: 5, “c”: 4, “b”: 1", symbolCounterService.countSymbols(text).countedSymbols());

        text.setText("aaabbbbccccccc");
        assertEquals("“c”: 7, “b”: 4, “a”: 3", symbolCounterService.countSymbols(text).countedSymbols());

        text.setText("cccaab");
        assertEquals("“c”: 3, “a”: 2, “b”: 1", symbolCounterService.countSymbols(text).countedSymbols());

        text.setText("bbbbbaac");
        assertEquals("“b”: 5, “a”: 2, “c”: 1", symbolCounterService.countSymbols(text).countedSymbols());

        text.setText("cab");
        assertEquals("“a”: 1, “b”: 1, “c”: 1", symbolCounterService.countSymbols(text).countedSymbols());

        text.setText(" ");
        assertThrows(IncorrectRequestException.class,
                () -> symbolCounterService.countSymbols(text));
    }
}