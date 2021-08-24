package models;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Hero {

        private String name;
        private int age;
        private String heroPower;
        private String weakness;
        private static ArrayList<Hero> h_instances = new ArrayList<Hero>();
        private boolean published;
        private String createdAt;
        private int id;
        public Hero(String name, int age, String heroPower, String weakness){
            this.name = name;
            this.age = age;
            this.heroPower = heroPower;
            this.weakness = weakness;
            this.published = false;
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm");
            LocalDateTime Date = LocalDateTime.now();
            this.createdAt = Date.format(format);
            h_instances.add(this);
            this.id = h_instances.size();
        }


}
