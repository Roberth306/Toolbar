package com.germangascon.toolbar.paises;

public class Country {
    private String countryCode;
    private String countryName;
    private long population;
    private String capital;
    private String isoAlpha3;

    public Country(String countryCode, String countryName, long population, String capital, String isoAlpha3) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.population = population;
        this.capital = capital;
        this.isoAlpha3 = isoAlpha3;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getIsoAlpha3() {
        return isoAlpha3;
    }

    public void setIsoAlpha3(String isoAlpha3) {
        this.isoAlpha3 = isoAlpha3;
    }
}
