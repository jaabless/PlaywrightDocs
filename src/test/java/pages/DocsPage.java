package pages;

import base.BasePage;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static org.junit.jupiter.api.Assertions.*;

public class DocsPage extends BasePage {

    public DocsPage(Page page) {
        super(page);
    }

    @Step("Verify Installation section is displayed")
    public void verifyInstallationText() {
        assertTrue(isTextVisible("Installation"),
                "Installation text is NOT displayed");
    }
}
