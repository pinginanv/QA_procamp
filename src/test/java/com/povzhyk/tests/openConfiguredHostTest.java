package com.povzhyk.tests;

import com.povzhyk.apiclient.HTTPRequests;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class openConfiguredHostTest extends BaseTestClass {
    @Test
    public void openConfiguredHost() {
        System.out.println("Test to open host configured by Configurator");
        goToUrl();

        Response response = new HTTPRequests().sendGetRequest(getConfiguration(),"");
        Assert.assertEquals(response.statusCode(),200);
    }
}
