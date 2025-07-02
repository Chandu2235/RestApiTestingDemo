package com.api.automation.tests;

import com.api.automation.core.BaseTest;
import com.api.automation.core.RestClient;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserApiTest extends BaseTest {

    @Test
    public void testGetUser() {
        Response response = RestClient.get("/users/1");
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("username"), "Bret");
    }
}
