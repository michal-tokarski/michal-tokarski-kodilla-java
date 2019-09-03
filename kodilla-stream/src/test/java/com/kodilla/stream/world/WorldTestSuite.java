package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity() {
        // Given
        // - Create world :
        World world = new World();
        // - Create and add continents to the world :
        Continent europe = new Continent("Europe");
        Continent africa = new Continent("Africa");
        Continent asia = new Continent("Asia");
        world.addContinent(europe);
        world.addContinent(africa);
        world.addContinent(asia);

        //When
        // - Create and add countries to the continents :
        europe.addCountry(new Country("Poland", new BigDecimal("100000001")));
        europe.addCountry(new Country("Great Britain", new BigDecimal("100000002")));
        europe.addCountry(new Country("Spain", new BigDecimal("100000003")));
        africa.addCountry(new Country("Egypt", new BigDecimal("100000001")));
        africa.addCountry(new Country("Morocco", new BigDecimal("100000002")));
        africa.addCountry(new Country("Cameroon", new BigDecimal("100000003")));
        asia.addCountry(new Country("Mongolia", new BigDecimal("100000001")));
        asia.addCountry(new Country("China", new BigDecimal("100000002")));
        asia.addCountry(new Country("Pakistan", new BigDecimal("100000003")));

        //Then
        BigDecimal expectedPopulation = new BigDecimal("900000018");
        Assert.assertEquals(expectedPopulation, world.getPeopleQuantity());
    }

}
