package com.example.yurt2.entity;

import jakarta.persistence.*;

@Entity
@Table(name="address")
public class Address {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="street")
    private String street;
    @Column(name="city")
    private String city;
    @Column(name="country")
    private String country;
    @Column(name="address_type")
    private String addressType;
    @Column(name = "address_description")
    private String addressDescription;

    public Address(Long id, String street, String city, String country, String addressType, String addressDescription) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.country = country;
        this.addressType = addressType;
        this.addressDescription = addressDescription;
    }

    public Address(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getAddressDescription() {
        return addressDescription;
    }

    public void setAddressDescription(String addressDescription) {
        this.addressDescription = addressDescription;
    }
}
