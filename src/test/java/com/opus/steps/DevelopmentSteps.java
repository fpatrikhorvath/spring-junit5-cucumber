package com.opus.steps;

import io.cucumber.java.en.And;

public class DevelopmentSteps {
    @And("I want to see the thread id in the log")
    public void iWantToSeeTheThreadIdInTheLog() {
        System.out.println("------------" + Thread.currentThread().getId() + "-----------------");
    }
    @And("I want to wait {int} seconds")
    public void waitTime(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }
}
