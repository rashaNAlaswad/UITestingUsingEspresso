package com.example.uiautomationtestingusingespresso;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({MainActivityTest.class, LoginActivityTest.class})
public class AppTestSuite {
}
