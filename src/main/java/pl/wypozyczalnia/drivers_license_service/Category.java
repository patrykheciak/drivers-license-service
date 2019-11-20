package pl.wypozyczalnia.drivers_license_service;

import java.util.Date;

public class Category {
    public String name;
    public Date validSince;
    public Date expirationDate;

    public Category(String name, Date validSince, Date expirationDate) {
        this.name = name;
        this.validSince = validSince;
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getValidSince() {
        return validSince;
    }

    public void setValidSince(Date validSince) {
        this.validSince = validSince;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
