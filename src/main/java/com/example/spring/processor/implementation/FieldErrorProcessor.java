package com.example.spring.processor.implementation;

import com.example.spring.processor.abstraction.IFieldErrorProcessor;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

@Component
public class FieldErrorProcessor implements IFieldErrorProcessor {

    @Override
    public List<String> extractErrorMessages(BindingResult bindingResult) {
        List<String> messages = new ArrayList<>();
        for (ObjectError error: bindingResult.getFieldErrors()) {
            messages.add(error.getDefaultMessage());
        }
        return messages;
    }
}
