package utils;

import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;

public class ScreenshotUtil {

    public static void capture(Page page, String testName) {
        byte[] screenshot = page.screenshot();
        Allure.addAttachment(
                "Screenshot - " + testName,
                new ByteArrayInputStream(screenshot)
        );
    }
}
