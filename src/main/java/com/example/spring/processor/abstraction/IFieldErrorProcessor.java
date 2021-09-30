package com.example.spring.processor.abstraction;

import org.springframework.validation.BindingResult;

import java.util.List;

public interface IFieldErrorProcessor {

    List<String> extractErrorMessages(BindingResult bindingResult);
}
