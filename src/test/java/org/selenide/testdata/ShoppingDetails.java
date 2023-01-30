package org.selenide.testdata;

import lombok.Data;

@Data
public class ShoppingDetails {
    private String username;
    private String password;
    private String product;
    private String price;
}