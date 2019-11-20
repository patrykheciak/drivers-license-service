package pl.wypozyczalnia.drivers_license_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriversLicenseController {

    private LicenseGenerator licenseGenerator = new LicenseGenerator();

    @GetMapping("/licenses/{pesel}")
    public DriversLicense getLicense(@PathVariable String pesel){
        return licenseGenerator.generate(pesel);
    }
}
