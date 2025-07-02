package com.api.automation.core;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import com.api.automation.config.ConfigReader;

public class BaseTest {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = ConfigReader.get("baseURI");
    }
}
