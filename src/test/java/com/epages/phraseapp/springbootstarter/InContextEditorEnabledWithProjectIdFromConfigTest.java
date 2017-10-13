package com.epages.phraseapp.springbootstarter;

import static com.epages.phraseapp.PhraseAppConfigurationPropertyProjectIdProvider.PHRASEAPP_PROJECT_ID;
import static com.epages.phraseapp.PhraseAppProperties.PHRASEAPP_INCONTEXT_EDITOR_ENABLED;
import static org.assertj.core.api.Java6BDDAssertions.then;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.epages.phraseapp.PhraseAppAutoConfiguration;
import com.epages.phraseapp.PhraseAppConfigurationPropertyProjectIdProvider;
import com.epages.phraseapp.PhraseAppProjectIdProvider;
import com.epages.phraseapp.PhraseAppProperties;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PhraseAppAutoConfiguration.class,
        properties = {
                PHRASEAPP_INCONTEXT_EDITOR_ENABLED + "=true",
                PHRASEAPP_PROJECT_ID + "=my-test-project-id",
        })
public class InContextEditorEnabledWithProjectIdFromConfigTest {

    @Autowired
    private PhraseAppProjectIdProvider projectIdProvider;

    @Autowired
    private PhraseAppProperties phraseAppProperties;

    @Test
    public void should_provide_project_id() {

        then(projectIdProvider).isInstanceOf(PhraseAppConfigurationPropertyProjectIdProvider.class);
        then(projectIdProvider.getProjectId()).isEqualTo("my-test-project-id");
    }

}