package com.T1.timurdavletgareev.service;

import com.T1.timurdavletgareev.dto.CountedSymbolsDto;
import com.T1.timurdavletgareev.dto.TextToDecodeDto;
import com.T1.timurdavletgareev.error.exception.IncorrectRequestException;
import com.T1.timurdavletgareev.service.util.SymbolFrequencyPair;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
@NoArgsConstructor
public class SymbolCounterServiceImpl implements SymbolCounterService {

    @Override
    public CountedSymbolsDto countSymbols(TextToDecodeDto inputTextDto) {

        log.info("-- Counting symbols for text: {}", inputTextDto.getText());

        if (inputTextDto.getText().isBlank() || inputTextDto.getText().isEmpty()) {
            throw new IncorrectRequestException(" - Text is blank or empty");
        }

        Map<Character, Integer> letterMap = new HashMap<>();
        Integer counter;

        char[] chars = inputTextDto.getText().toCharArray();

        for (char c : chars) {
            counter = letterMap.getOrDefault(c, 0);
            letterMap.put(c, ++counter);
        }

        List<SymbolFrequencyPair> sortedList = sortMapByValues(letterMap);

        CountedSymbolsDto countedSymbolsDto = new CountedSymbolsDto(listToString(sortedList));

        log.info("-- Symbols counted: {}", countedSymbolsDto.countedSymbols());

        return countedSymbolsDto;
    }

    private List<SymbolFrequencyPair> sortMapByValues(Map<Character, Integer> unsortedMap) {

        List<SymbolFrequencyPair> listToSort = new ArrayList<>();

        for (Character character : unsortedMap.keySet()) {
            listToSort.add(new SymbolFrequencyPair(character, unsortedMap.get(character)));
        }

        return listToSort.stream().sorted().collect(Collectors.toList());
    }

    private String listToString(List<SymbolFrequencyPair> list) {

        StringBuilder builder = new StringBuilder();
        String tempString;

        if (list.isEmpty()) {
            return "";
        }

        for (SymbolFrequencyPair symbolFrequencyPair : list) {

            tempString = "“" + symbolFrequencyPair.symbol() + "”: " + symbolFrequencyPair.frequency() + ", ";
            builder.append(tempString);
        }

        builder.delete(builder.length() - 2, builder.length());

        return builder.toString();
    }
}
