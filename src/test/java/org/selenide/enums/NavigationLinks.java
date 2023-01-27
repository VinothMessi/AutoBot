package org.selenide.enums;

public enum NavigationLinks {
    DASHBOARD("Dashboard"),
    ORDERS("Orders"),
    DOWNLOADS("Downloads"),
    ADDRESSES("Addresses"),
    ACCOUNT_DETAILS("Account details"),
    LOGOUT("Logout");

    private final String value;

    public String getValue() {
        return value;
    }

    private NavigationLinks(String value) {
        this.value = value;
    }
}