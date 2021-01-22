package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DemoWebShopTests {

    @Test
    void addGiftCardToWishlist() {
        given()
                .baseUri("http://demowebshop.tricentis.com")
                .multiPart("giftcard_1.RecipientName", "name")
                .multiPart("giftcard_1.RecipientEmail", "asfasf@test.test")
                .multiPart("giftcard_1.SenderName", "myName")
                .multiPart("giftcard_1.SenderEmail", "myEmail@test.test")
                .multiPart("addtocart_1.EnteredQuantity", "1")
                .post("/addproducttocart/details/1/2")
                .then()
                .statusCode(200)
                .body("message", equalTo("The product has been added to your <a href=\"/wishlist\">wishlist</a>"));
    }
}
