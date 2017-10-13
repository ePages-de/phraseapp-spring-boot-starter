package com.epages.phraseapp.springbootstarter;

import static com.epages.phraseapp.PhraseAppProperties.PHRASEAPP_PROJECT_PREFIX;
import static org.assertj.core.api.Java6BDDAssertions.then;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.epages.phraseapp.PhraseAppAutoConfiguration;
import com.epages.phraseapp.PhraseAppProperties;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PhraseAppAutoConfiguration.class,
        properties = {
                PHRASEAPP_PROJECT_PREFIX + ".incontext-editor-prefix=+++",
                PHRASEAPP_PROJECT_PREFIX + ".incontext-editor-suffix=---"
        })
public class InContextEditorPropertiesTest {

    @Autowired
    private PhraseAppProperties phraseAppProperties;

    @Test
    public void should_override_prefix() {
        then(phraseAppProperties.getIncontextEditorPrefix()).isEqualTo("+++");
    }

    @Test
    public void should_override_suffix() {
        then(phraseAppProperties.getIncontextEditorSuffix()).isEqualTo("---");
    }

}