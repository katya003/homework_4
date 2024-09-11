import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class WikiPageTests {

    @BeforeAll

    static void setUp()  {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }
    @AfterAll
    static void closeWindow() {
        WebDriverRunner.closeWindow();
    }

    @Test
    void watchWikiPageTests() {

        open("https://github.com/selenide/selenide");
        $("[data-content ='Wiki']").click();
        $("[href*='SoftAssertions']").click();
        $("#wiki-body").shouldHave(text(""" 
                        @ExtendWith({SoftAssertsExtension.class})
                        class Tests {
                          @Test
                          void test() {
                            Configuration.assertionMode = SOFT;
                            open("page.html");
                                       
                            $("#first").should(visible).click();
                            $("#second").should(visible).click();
                          }
                        }
                        """));
            }
        }





