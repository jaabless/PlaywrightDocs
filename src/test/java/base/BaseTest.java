package base;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import utils.LoggerUtil;
import utils.ScreenshotUtil;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeAll
    void setup() {
        LoggerUtil.info("Launching browser");
        playwright = Playwright.create();
        browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @BeforeEach
    void createContext(TestInfo testInfo) {
        context = browser.newContext();
        page = context.newPage();
        LoggerUtil.info("Starting test: " + testInfo.getDisplayName());
    }

    @AfterEach
    void tearDown(TestInfo testInfo) {
        if (testInfo.getTags().contains("FAILED")) {
            ScreenshotUtil.capture(page, testInfo.getDisplayName());
        }
        context.close();
    }

    @AfterAll
    void closeBrowser() {
        browser.close();
        playwright.close();
    }
}
