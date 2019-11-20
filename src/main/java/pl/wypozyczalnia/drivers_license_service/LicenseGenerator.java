package pl.wypozyczalnia.drivers_license_service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import static java.time.temporal.ChronoUnit.DAYS;

public class LicenseGenerator {

    private static final double PROBABILITY_OF_HAVING_DRIVERS_LICENSE = 0.81;
    private static final String[] CATEGORY_NAMES_WITHOUT_B = new String[]{
            "AM", "A1", "A2", "A", "B1", "C1", "C", "D1", "D", "BE", "C1E", "CE", "D1E", "DE", "T"
    };
    private static final int MAX_CATEGORIES_COUNT = 5;

    public DriversLicense generate(String pesel) {
        Random random = new Random(Long.parseLong(pesel));
        return new DriversLicense(pesel, generateCategories(random));
    }

    private Category[] generateCategories(Random random) {
        List<Category> categories = new ArrayList<>();

        if (random.nextDouble() < PROBABILITY_OF_HAVING_DRIVERS_LICENSE) {
            categories.add(generateCategory("B", random)); // Each driver with a license has at least B category
            // random category names
            ArrayList<String> names = new ArrayList<>(Arrays.asList(CATEGORY_NAMES_WITHOUT_B));
            Collections.shuffle(names, random);
            // generate categories, and populate the list
            int categoriesToGenerate = random.nextInt(MAX_CATEGORIES_COUNT - 1);
            for (int i = 0; i < categoriesToGenerate; i++) {
                categories.add(generateCategory(names.get(i), random));
            }
            // sort the output by category name
            categories.sort(new Comparator<Category>() {
                @Override
                public int compare(Category s, Category t1) {
                    return s.name.compareTo(t1.name);
                }
            });
        }
        return categories.toArray(new Category[0]);
    }

    private Category generateCategory(String name, Random random) {
        LocalDate validSince = generateRandomValidSince(random);
        LocalDate expirationDate = validSince.plusYears(15);

        return new Category(
                name,
                Date.from(validSince.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()),
                Date.from(expirationDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())
        );
    }

    private LocalDate generateRandomValidSince(Random random) {
        LocalDate validSinceFrom = LocalDate.now().minusYears(14).minusMonths(3);
        LocalDate validSinceTo = LocalDate.now();
        long daysBetween = DAYS.between(validSinceFrom, validSinceTo);
        int randomDayNumer = random.nextInt((int) daysBetween);
        return validSinceFrom.plusDays(randomDayNumer);
    }
}
