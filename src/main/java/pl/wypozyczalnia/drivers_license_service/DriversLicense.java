package pl.wypozyczalnia.drivers_license_service;


public class DriversLicense {
    public String pesel;
    public Category[] categories;

    public DriversLicense(String pesel, Category[] categories) {
        this.pesel = pesel;
        this.categories = categories;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Category[] getCategories() {
        return categories;
    }

    public void setCategories(Category[] categories) {
        this.categories = categories;
    }
}


