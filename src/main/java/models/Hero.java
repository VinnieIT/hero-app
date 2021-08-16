package models;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Hero {

        private String name;
        private int age;
        private String heroPower;
        private String weakness;
        private static ArrayList<Hero> h_instances = new ArrayList<>();
        private boolean published;
        private LocalDateTime createdAt;
        private int id;
        public Hero(String name, int age, String power, String weakness){
            this.name = name;
            this.age = age;
            this.heroPower = power;
            this.weakness = weakness;
            this.published = false;
            this.createdAt = LocalDateTime.now();
            h_instances.add(this);
            this.id = h_instances.size();
        }
        public String getName(){
            return name;
        }
        public int getAge(){
            return age;
        }
        public String getHeroPower(){
            return heroPower;
        }
        public String getWeakness(){
            return weakness;
        }
        public static ArrayList<Hero> getAll(){
            return h_instances;
        }
        public static void clearAllHeroes(){
            h_instances.clear();
        }
        public boolean getPublished(){
            return this.published;
        }
        public LocalDateTime getCreatedAt(){
            return createdAt;
        }
        public int getId(){
            return id;
        }
        public static Hero findById(int id){
            return h_instances.get(id-1);
        }
        public void update(String newName, int newAge, String newPower, String newWeakness){
            this.name = newName;
            this.age = newAge;
            this.heroPower = newPower;
            this.weakness = newWeakness;
        }
        public void deleteHero(){
            h_instances.remove(id-1);
        }

}
