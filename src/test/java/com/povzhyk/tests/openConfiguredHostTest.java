package com.povzhyk.tests;

import org.testng.annotations.Test;

public class openConfiguredHostTest extends BaseTestClass {
    @Test
    public void openConfiguredHost() {
        System.out.println("Test to open host configured by Configurator");
        goToUrl();

    }
}
