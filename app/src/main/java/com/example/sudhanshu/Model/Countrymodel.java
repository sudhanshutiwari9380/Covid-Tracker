package com.example.sudhanshu.Model;

public class Countrymodel {
    private String CountryName;
    private String CountryCase;
    private String CountryDeath;
    private String CountryRecovred;

    public String getCountryCase() {
        return CountryCase;
    }

    public void setCountryCase(String CountryCase) {
        this.CountryCase = CountryCase;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String CountryName) {
        this.CountryName = CountryName;
    }



    public Countrymodel(String CountryName, String CountryCase, String countryDeath, String countryRecovred) {
        this.CountryName = CountryName;
        this.CountryCase = CountryCase;
        this.CountryDeath = countryDeath;
        this.CountryRecovred = countryRecovred;
    }

    public String getCountryDeath() {
        return CountryDeath;
    }

    public void setCountryDeath(String countryDeath) {
        CountryDeath = countryDeath;
    }

    public String getCountryRecovred() {
        return CountryRecovred;
    }

    public void setCountryRecovred(String countryRecovred) {
        CountryRecovred = countryRecovred;
    }
}
