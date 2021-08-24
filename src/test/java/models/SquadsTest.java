package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class SquadsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getSquadName() {
        Squads squad = new Squads("Glazers", 3, "GGMU");
        String name = squad.getSquadName();
        Assertions. assertEquals("Glazers", name);
    }

    @Test
    void getMaxSize() {
        Squads squad = new Squads("Glazers", 3, "GGMU");
        Integer maxsize = squad.getMaxSize();
        Assertions. assertEquals(3, maxsize);
    }

    @Test
    void getCause() {
        Squads squad = new Squads("Glazers", 3, "GGMU");
        String cause = squad.getCause();
        Assertions. assertEquals("GGMU", cause);
    }

    @Test
    void getAll() {
        Squads squad = new Squads("Glazers", 3, "GGMU");
        Squads squad2 = new Squads("Glazers", 3, "GGMU");
        assertTrue(Squads.getAll().contains(squad));
        assertTrue(Squads.getAll().contains(squad2));
    }

    @Test
    void clearAllHeroes() {
        Squads squad = new Squads("Glazers", 3, "GGMU");
        Squads squad2 = new Squads("Glazers", 3, "GGMU");
        Squads.clearAllHeroes();
        Assertions.assertEquals(0,Squads.getAll().size());
    }

    @Test
    void getPublished() {
        Squads squad = new Squads("Glazers", 3, "GGMU");
        Assertions.assertEquals(false, squad.getPublished() );
    }

    @Test
    void getCreatedAt() {
        Squads squad = new Squads("Glazers", 3, "GGMU");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm");
        LocalDateTime Date = LocalDateTime.now();
        String createdAt = Date.format(format);
        Assertions.assertEquals(createdAt,squad.getCreatedAt()  );
    }

    @Test
    void getId() {
        Squads squad = new Squads("Glazers", 3, "GGMU");
        Assertions.assertEquals(1, squad.getId() );
    }

    @Test
    void findById() {
        Squads squad = new Squads("Glazers", 3, "GGMU");
        Squads squad2 = new Squads("Kroenke", 3, "COYG");
        assertEquals(2,Squads.findById(squad2.getId()).getId());
    }

//    @Test
//    void update() {
//    }
//
//    @Test
//    void deleteSquad() {
//    }
}