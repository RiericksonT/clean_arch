package br.com.alura.codechella.domain;

public class Address {
    private String street;
    private String number;
    private String zipCode;
    private String complement;

    public Address(String street, String number, String zipCode, String complement) {
        this.street = street;
        this.number = number;
        this.zipCode = zipCode;
        this.complement = complement;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }
}
