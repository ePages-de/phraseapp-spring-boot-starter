package com.epages.phraseapp;

import static com.epages.phraseapp.PhraseAppProperties.PHRASEAPP_PROJECT_PREFIX;

import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;

public class PhraseAppConfigurationPropertyProjectIdProvider implements PhraseAppProjectIdProvider {

    public static final String PHRASEAPP_PROJECT_ID = PHRASEAPP_PROJECT_PREFIX + ".project-id";

    @Getter(onMethod = @__(@Override))
    @Value("${" + PHRASEAPP_PROJECT_ID + "}")
    private String projectId;

}
