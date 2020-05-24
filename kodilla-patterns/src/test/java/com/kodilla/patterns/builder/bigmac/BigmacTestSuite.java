package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {

    @Test
    public void test1() {

        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun(Bun.BUN_SESAME)
                .burgers(7)
                .sauce(Sauce.SAUCE_BARBECUE)
                .ingredient(Ingredient.INGR_BACON)
                .ingredient(Ingredient.INGR_CHAMPIGNONS)
                .ingredient(Ingredient.INGR_SHRIMPS)
                .build();
        System.out.println(bigmac);

        //When
        String bunName = bigmac.getBun().getName();
        int numberOfBurgers = bigmac.getBurgers();
        String sauceName = bigmac.getSauce().getName();
        int numberOfIngredients = bigmac.getIngredients().size();

        //Then
        Assert.assertEquals("Sesame bun", bunName);
        Assert.assertEquals(7, numberOfBurgers);
        Assert.assertEquals("Barbecue", sauceName);
        Assert.assertEquals(3, numberOfIngredients);
    }

}
