package com.example.challenge.exceptions;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public  class Field {
    private String property;
    private String message;
}
