package com.example.spring.resolver.abstraction;

import org.springframework.validation.BindingResult;

import java.util.List;

public interface IFieldErrorResolver {

    List<String> extractErrorMessages(BindingResult bindingResult);
}
