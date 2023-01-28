package com.example.application.data;

public class Jahresbericht {
    private Integer jahr;
    private Integer einzahlung;
    private Double rendite;
    private Double kapital;
    private Double endKapital;

    public Jahresbericht(Integer jahr, Integer einzahlung, Double rendite, Double kapital, Double endKapital) {
        this.jahr = jahr;
        this.einzahlung = einzahlung;
        this.rendite = rendite;
        this.kapital = kapital;
        this.endKapital = endKapital;
    }

    public Integer getJahr() {
        return jahr;
    }

    public void setJahr(Integer jahr) {
        this.jahr = jahr;
    }

    public Integer getEinzahlung() {
        return einzahlung;
    }

    public void setEinzahlung(Integer einzahlung) {
        this.einzahlung = einzahlung;
    }

    public Double getRendite() {
        return rendite;
    }

    public void setRendite(Double rendite) {
        this.rendite = rendite;
    }

    public Double getKapital() {
        return kapital;
    }

    public void setKapital(Double kapital) {
        this.kapital = kapital;
    }

    public Double getEndKapital() {
        return endKapital;
    }

    public void setEndKapital(Double endKapital) {
        this.endKapital = endKapital;
    }
}
