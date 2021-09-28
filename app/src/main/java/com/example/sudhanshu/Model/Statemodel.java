package com.example.sudhanshu.Model;

public class Statemodel {
    private String stateName;
    private String stateCase;
    private String stateDeath;
    private String stateRecovered;

    public String getStateCase() {
        return stateCase;
    }

    public void setStateCase(String stateCase) {
        this.stateCase = stateCase;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }



    public Statemodel(String stateName, String stateCase, String stateDeath, String stateRecovered) {
        this.stateName = stateName;
        this.stateCase = stateCase;
        this.stateDeath = stateDeath;
        this.stateRecovered = stateRecovered;
    }

    public String getStateDeath() {
        return stateDeath;
    }

    public void setStateDeath(String stateDeath) {
        this.stateDeath = stateDeath;
    }

    public String getStateRecovered() {
        return stateRecovered;
    }

    public void setStateRecovered(String stateRecovered) {
        this.stateRecovered = stateRecovered;
    }
}
