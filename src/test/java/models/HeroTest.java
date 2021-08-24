package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getName() {
        Hero hero = new Hero("Vincent", 22, "SuperSpreader", "Vaccine");
        String name = hero.getName();
        Assertions.assertTrue(true,name );
    }

    @Test
    void getAge() {
        Hero hero = new Hero("Vincent", 22, "SuperSpreader", "Vaccine");
        String age = hero.getWeakness();
        Assertions.assertTrue(true,age );
    }

    @Test
    void getHeroPower() {
        Hero hero = new Hero("Vincent", 22, "SuperSpreader", "Vaccine");
        String power = hero.getHeroPower();
        Assertions.assertTrue(true,power );
    }

    @Test
    void getWeakness() {
        Hero hero = new Hero("Vincent", 22, "SuperSpreader", "Vaccine");
        String weakness = hero.getWeakness();
        Assertions.assertTrue(true,weakness );
    }

    @Test
    void getAll() {
        Hero hero = new Hero("Vincent", 22, "SuperSpreader", "Vaccine");
        Hero hero2 = new Hero("James", 18, "SuperDrinker", "Sobriety");
        assertTrue(Hero.getAll().contains(hero));
        assertTrue(Hero.getAll().contains(hero2));
    }

    @Test
    void clearAllHeroes() {
        Hero hero = new Hero("Vincent", 22, "SuperSpreader", "Vaccine");
        Hero hero2 = new Hero("James", 18, "SuperDrinker", "Sobriety");
        Hero.clearAllHeroes();
        Assertions.assertEquals(0,Hero.getAll().size());

    }

    @Test
    void getPublished() {
    }

    @Test
    void getCreatedAt() {
    }

    @Test
    void getId() {
    }

    @Test
    void findById() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteHero() {
    }
}