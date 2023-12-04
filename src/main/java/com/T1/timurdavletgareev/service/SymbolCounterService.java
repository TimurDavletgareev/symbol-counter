package com.T1.timurdavletgareev.service;

import com.T1.timurdavletgareev.dto.CountedSymbolsDto;
import com.T1.timurdavletgareev.dto.TextToDecodeDto;

public interface SymbolCounterService {

    CountedSymbolsDto countSymbols(TextToDecodeDto inputText);
}
