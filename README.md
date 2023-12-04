# Symbol counter
Приложение Symbol counter это REST API по <a href="https://docs.google.com/document/d/1G_bNiKfEWXorOOry79s7UzPTNvYy4tRaYqnUnhPxuiU/edit">тестовому заданию</a>

### Инструкция по сборке
Для сборки приложения необходимы Java Development Kit и Maven

Варианты запуска:
1) Используя IDE (на примере IntellijIdea) Выбрать в меню Run-> run SymbolCounterApplication
2) Создать .jar используя Maven Plugin: $ mvn package и выполнить $ java -jar target/symbol-counter-v1.jar
3) Используя Maven Plugin: $ mvn spring-boot:run

### Swagger
Зайти на https://editor-next.swagger.io, выбрать File -> Import URL и вставить <a href="https://raw.githubusercontent.com/TimurDavletgareev/symbol-counter/main/symbol-counter-spec.json">этот URL</a>
