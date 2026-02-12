package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import pages.DocsPage;
import pages.HomePage;

@Epic("Playwright Website")
@Feature("Language Selection and Docs Validation")
public class PlaywrightDocsTest extends BaseTest {

    @Test
    @Story("User switches language to Java and verifies Installation docs")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Hover language menu, switch to Java, click Get Started, verify Installation")
    void verifyInstallationForJava() {

        HomePage homePage = new HomePage(page);
        DocsPage docsPage = new DocsPage(page);

        homePage.open();
        homePage.selectJavaLanguage();
        homePage.clickGetStarted();

        docsPage.verifyInstallationText();
    }
}
