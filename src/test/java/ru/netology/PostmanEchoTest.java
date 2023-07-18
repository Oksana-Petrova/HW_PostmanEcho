package ru.netology;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class PostmanEchoTest {
    @Test
    void shouldReturnDataValueLatin() {
        // Given - When - Then
        // Предусловия
        given()
           .baseUri("https://postman-echo.com")
           .body("Wellnes") // отправляемые данные (заголовки и query можно выставлять аналогично)
           // Выполняемые действия
           .when()
           .post("/post")
           // Проверки
           .then().log().all()
           .statusCode(200)
           .body("data", equalTo("Wellness"))
        ;
    }

    @Test
    void shouldReturnDataValue() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("Запрос") // отправляемые данные (заголовки и query можно выставлять аналогично)
                // Выполняемые действия
                .when()
                .post("/post")
                // Проверки
                .then().log().all()
                .statusCode(200)
                .body("data", equalTo("Результат"))
        ;
    }
}