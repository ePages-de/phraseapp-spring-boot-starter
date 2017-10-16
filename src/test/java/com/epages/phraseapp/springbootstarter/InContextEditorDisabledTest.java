package com.epages.phraseapp.springbootstarter;

import static com.epages.phraseapp.PhraseAppProperties.PHRASEAPP_INCONTEXT_EDITOR_ENABLED;
import static org.assertj.core.api.Java6BDDAssertions.then;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.epages.phraseapp.PhraseAppAutoConfiguration;
import com.epages.phraseapp.PhraseAppEmptyProjectIdProvider;
import com.epages.phraseapp.PhraseAppProjectIdProvider;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PhraseAppAutoConfiguration.class, properties = PHRASEAPP_INCONTEXT_EDITOR_ENABLED + "=false")
public class InContextEditorDisabledTest {

    @Autowired
    private PhraseAppProjectIdProvider projectIdProvider;

    @Test
    public void should_provide_project_id() {

        then(projectIdProvider).isInstanceOf(PhraseAppEmptyProjectIdProvider.class);
        then(projectIdProvider.getProjectId()).isEmpty();
    }

}