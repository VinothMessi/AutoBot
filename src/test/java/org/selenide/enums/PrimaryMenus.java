package org.selenide.enums;

public enum PrimaryMenus {
    HOME("Home"),
    ABOUT("About"),
    SHOP("Shop"),
    BLOG("Blog"),
    CONTACT("Contact"),
    MYACCOUNT("My account");

    private final String value;

    public String getValue() {
        return value;
    }

    private PrimaryMenus(String value) {
        this.value = value;
    }
}