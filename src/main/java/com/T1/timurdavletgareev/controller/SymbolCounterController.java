package com.T1.timurdavletgareev.controller;

import com.T1.timurdavletgareev.dto.CountedSymbolsDto;
import com.T1.timurdavletgareev.dto.TextToDecodeDto;
import com.T1.timurdavletgareev.service.SymbolCounterService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/count-symbols")
public class SymbolCounterController {

    private final SymbolCounterService symbolCounterService;

    @PostMapping
    public CountedSymbolsDto countSymbols(@RequestBody @NotNull @Valid TextToDecodeDto inputText) {

        return symbolCounterService.countSymbols(inputText);
    }
}
