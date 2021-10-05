package com.example.spring.resolver.implementation;

import com.example.spring.resolver.abstraction.IFieldErrorResolver;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

@Component
public class FieldErrorResolver implements IFieldErrorResolver {

    @Override
    public List<String> extractErrorMessages(BindingResult bindingResult) {
        List<String> messages = new ArrayList<>();
        for (ObjectError error: bindingResult.getFieldErrors()) {
            messages.add(error.getDefaultMessage());
        }
        return messages;
    }
}
