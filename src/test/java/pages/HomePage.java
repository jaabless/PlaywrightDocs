package pages;

import base.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Step;

import static org.junit.jupiter.api.Assertions.*;

public class HomePage extends BasePage {

    private final Locator languageMenu;
    private final Locator javaOption;
    private final Locator getStartedBtn;

    public HomePage(Page page) {
        super(page);

        // Target the language dropdown button specifically
        languageMenu = page.locator("a[role='button']:has-text('Node.js')");


        // Select Java option inside dropdown
        javaOption = page.getByText("Java", new Page.GetByTextOptions().setExact(true));

        // Get started button
        getStartedBtn = page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Get started"));
    }

    @Step("Open Playwright homepage")
    public void open() {
        navigate("https://playwright.dev/");
        assertTrue(page.title().contains("Playwright"));
    }

    @Step("Hover language menu and select Java")
    public void selectJavaLanguage() {

        languageMenu.hover();

        assertTrue(javaOption.isVisible(),
                "Java option not visible in dropdown");

        javaOption.click();
    }

    @Step("Click Get Started")
    public void clickGetStarted() {

        assertTrue(getStartedBtn.isVisible(),
                "Get Started button not visible");

        getStartedBtn.click();
    }
}
