package com.deepakvadgama.testing.assertj;


import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AssertJTest {

    @Test
    public void testString() throws Exception {
        Assertions.assertThat("this very long string")
                .startsWith("this")
                .endsWith("string")
                .contains("long")
                .isNotBlank();
    }

    @Test
    public void testCollections() throws Exception {
        List<String> mainCities = new ArrayList<>();
        mainCities.add("Mumbai");
        mainCities.add("Delhi");
        mainCities.add("Bangalore");
        mainCities.add("Pune");

        List<String> allCities = new ArrayList<>(mainCities);
        allCities.add("Calcutta");
        allCities.add("Chennai");

        Assertions.assertThat(mainCities)
                .contains("Mumbai")
                .containsOnly("Delhi", "Mumbai", "Pune", "Bangalore")
                .doesNotContain("Chennai")
                .containsSequence("Mumbai", "Delhi", "Bangalore", "Pune");
    }

    class City {
        private String name;

        public City(String name) {
            this.name = name;
        }
    }

    @Test
    public void testPropertyExtraction() throws Exception {
        List<City> mainCities = new ArrayList<>();
        mainCities.add(new City("Mumbai"));
        mainCities.add(new City("Delhi"));
        mainCities.add(new City("Bangalore"));
        mainCities.add(new City("Pune"));

        List<City> allCities = new ArrayList<>(mainCities);
        allCities.add(new City("Calcutta"));
        allCities.add(new City("Chennai"));

        Assertions.assertThat(mainCities).extracting("name")
                .contains("Mumbai")
                .containsOnly("Delhi", "Mumbai", "Pune", "Bangalore")
                .doesNotContain("Chennai")
                .containsSequence("Mumbai", "Delhi", "Bangalore", "Pune");
    }
}
