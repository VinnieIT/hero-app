package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {


    @Test
    void getName() {
        Hero hero = new Hero("Vincent", 22, "SuperSpreader", "Vaccine");
        String name = hero.getName();
        Assertions.assertEquals("Vincent", name );
    }

    @Test
    void getAge() {
        Hero hero = new Hero("Vincent", 22, "SuperSpreader", "Vaccine");
        String age = hero.getWeakness();
        Assertions.assertEquals(22, age );
    }

    @Test
    void getHeroPower() {
        Hero hero = new Hero("Vincent", 22, "SuperSpreader", "Vaccine");
        String power = hero.getHeroPower();
        Assertions.assertEquals("SuperSpreader", power );
    }

    @Test
    void getWeakness() {
        Hero hero = new Hero("Vincent", 22, "SuperSpreader", "Vaccine");
        String weakness = hero.getWeakness();
        Assertions.assertEquals("Vaccine", weakness );
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
        Hero hero = new Hero("Vincent", 22, "SuperSpreader", "Vaccine");
        Assertions.assertEquals(false, hero.getPublished() );

    }

    @Test
    void getCreatedAt() {
        Hero hero = new Hero("Vincent", 22, "SuperSpreader", "Vaccine");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm");
        LocalDateTime Date = LocalDateTime.now();
        String createdAt = Date.format(format);
        Assertions.assertEquals(createdAt,hero.getCreatedAt()  );
    }

    @Test
    void getId() {
        Hero hero = new Hero("Vincent", 22, "SuperSpreader", "Vaccine");
        Assertions.assertEquals(1, hero.getId() );
    }

    @Test
    void findById() {
        Hero hero = new Hero("Vincent", 22, "SuperSpreader", "Vaccine");
        Hero hero2 = new Hero("James", 18, "SuperDrinker", "Sobriety");
        assertEquals(2,Hero.findById(hero2.getId()).getId());
    }

//    @Test
//    void update() {
//
//
//    }
}