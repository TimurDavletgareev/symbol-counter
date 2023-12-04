package com.T1.timurdavletgareev.service.util;

import java.util.Objects;

public record SymbolFrequencyPair(Character symbol, Integer frequency) implements Comparable<SymbolFrequencyPair> {

    @Override
    public int compareTo(SymbolFrequencyPair o) {

        if (!Objects.equals(o.frequency, this.frequency)) {
            return o.frequency().compareTo(this.frequency());
        } else {
            return this.symbol().compareTo(o.symbol());
        }
    }
}
