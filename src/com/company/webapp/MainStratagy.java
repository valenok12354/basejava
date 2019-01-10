package com.company.webapp;

import com.company.webapp.storage.Strategy;

public class MainStratagy {
    Strategy strategy;

    public void setStrategy (Strategy strategy) {
        this.strategy = strategy;
    }
    public void executeStrategy() {
        strategy.doExecute();
    }

}
