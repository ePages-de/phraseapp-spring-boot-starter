package com.epages.phraseapp;

import org.springframework.util.StringUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PhraseAppJavascriptHeader {

    private static final String JS_SCRIPT_TEMPLATE =
            "window.PHRASEAPP_CONFIG = {\n" +
                    "  projectId: '%s'\n" +
                    "};\n" +
                    "(function() {\n" +
                    "    var phraseapp = document.createElement('script');\n" +
                    "    phraseapp.type = 'text/javascript';\n" +
                    "    phraseapp.async = true;\n" +
                    "    phraseapp.src = ['https://', 'phraseapp.com/assets/in-context-editor/2.0/app.js?', new Date().getTime()].join('');\n" +
                    "    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(phraseapp, s);\n" +
                    "})();\n";

    private final PhraseAppProjectIdProvider projectIdProvider;

    public String getHeader() {

        return StringUtils.isEmpty(projectIdProvider.getProjectId())
                ? ""
                : String.format(JS_SCRIPT_TEMPLATE, projectIdProvider.getProjectId());
    }
}