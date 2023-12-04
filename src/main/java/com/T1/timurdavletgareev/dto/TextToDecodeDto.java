package com.T1.timurdavletgareev.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TextToDecodeDto {

    @NotNull
    private String text;
}
