package base;

import com.microsoft.playwright.Page;

public class BasePage {

    protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    public void navigate(String url) {
        page.navigate(url);
    }

    public boolean isTextVisible(String text) {
        return page.locator("text=" + text).isVisible();
    }
}
