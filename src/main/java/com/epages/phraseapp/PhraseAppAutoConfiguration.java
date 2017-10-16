package com.epages.phraseapp;

import static com.epages.phraseapp.PhraseAppProperties.PHRASEAPP_INCONTEXT_EDITOR_ENABLED;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties(PhraseAppProperties.class)
public class PhraseAppAutoConfiguration {

    @Bean
    @ConditionalOnProperty(value = PHRASEAPP_INCONTEXT_EDITOR_ENABLED, matchIfMissing = true)
    public MessageSource messageSource(PhraseAppProperties properties) {
        return new PhraseAppMessageSource(properties);
    }

    @Bean
    @ConditionalOnProperty(value = PHRASEAPP_INCONTEXT_EDITOR_ENABLED, matchIfMissing = true)
    public PhraseAppProjectIdProvider phraseAppDefaultProjectIdProvider() {
        return new PhraseAppConfigurationPropertyProjectIdProvider();
    }

    @Bean
    @ConditionalOnMissingBean(PhraseAppProjectIdProvider.class)
    public PhraseAppProjectIdProvider emptyPhraseAppProjectIdProvider() {
        return new PhraseAppEmptyProjectIdProvider();
    }

    @Bean
    public PhraseAppJavascriptHeader phraseAppJavascriptHeader(PhraseAppProjectIdProvider idProvider) {
        return new PhraseAppJavascriptHeader(idProvider);
    }
}
