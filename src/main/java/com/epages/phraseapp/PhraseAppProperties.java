package com.epages.phraseapp;

import static com.epages.phraseapp.PhraseAppProperties.PHRASEAPP_PROJECT_PREFIX;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties(PHRASEAPP_PROJECT_PREFIX)
public class PhraseAppProperties {

    public static final String PHRASEAPP_PROJECT_PREFIX = "phraseapp";

    public static final String PHRASEAPP_INCONTEXT_EDITOR_ENABLED = PHRASEAPP_PROJECT_PREFIX + ".incontext-editor-enabled";

    private String incontextEditorPrefix = "{{__";

    private String incontextEditorSuffix = "__}}";

}
