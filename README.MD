# phraseapp-spring-boot-starter

### What is inside?

This project contains Spring Boot starter which is created to simplify integration of [PhraseApp In-Context Editor](https://phraseapp.com/docs/guides/in-context-editor/) into your [Spring Boot](https://projects.spring.io/spring-boot/) application. 

The starter currently supports [PhraseApp API v.2](https://phraseapp.com/docs/api/v2/).

Inspired by [*phraseapp-spring-example*](https://github.com/phrase/phraseapp-spring-example).

### How to use this project?

It is assumed that you have already finished preparing you translation keys and a PhraseApp project is already created, if not please look at [How to get started with PhraseApp](https://phraseapp.com/docs/guides/setup/getting-started/)

#### Step 1 / 3. Add the build script dependency

##### Add the Gradle script

```groovy
runtime 'com.epages:phraseapp-spring-boot-starter:0.0.1'
```

##### Add the Maven script

```xml
<dependency>
  <groupId>com.epages</groupId>
  <artifactId>phraseapp-spring-boot-starter</artifactId>
  <version>0.0.1</version>
  <type>provided</type>
</dependency>
```

#### Step 2 / 3. Provide configuration in the application.yml 

##### Provide project id

PhraseApp project id should be provided via the configuration property.

```yaml
phraseapp:
  project-id: 123456789012345678901234567890ab  
```           

##### Disable PhraseApp In-Context Editor

[PhraseApp In-Context Editor](https://phraseapp.com/docs/guides/in-context-editor/) is enabled for you by default, but, most probably, you might not want it being enabled for you in the production environment. 
So please take care that corresponding property is disabled [wherever it is necessary](https://docs.spring.io/spring-boot/docs/current/reference/html/howto-properties-and-configuration.html).

```yaml
phraseapp:  
  incontext-editor-enabled: false
```

#### Step 3 / 3. Add script to your templates

```javascript
<head>
    <script th:utext="${@phraseAppJavascriptHeader.getHeader()}"></script>
</head>
```
