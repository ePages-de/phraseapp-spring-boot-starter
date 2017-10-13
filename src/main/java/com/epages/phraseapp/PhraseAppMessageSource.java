package com.epages.phraseapp;

import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PhraseAppMessageSource implements MessageSource {

    private final PhraseAppProperties phraseAppProperties;

    @Override
    public String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
        return getPhraseAppDecorated(code);
    }

    @Override
    public String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException {
        return getPhraseAppDecorated(code);
    }

    @Override
    public String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException {

        return Optional.ofNullable(resolvable.getCodes())
                .map(Arrays::stream)
                .get()
                .findFirst()
                .map(this::getPhraseAppDecorated)
                .orElse("");
    }

    private String getPhraseAppDecorated(String code) {
        return phraseAppProperties.getIncontextEditorPrefix() + "phrase_" + code + phraseAppProperties.getIncontextEditorSuffix();
    }
}