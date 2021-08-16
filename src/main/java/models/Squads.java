package models;


import java.time.LocalDateTime;
import java.util.ArrayList;


public class Squads {
    private String squadName;
    private int maxSize;
    private String cause;
    private static ArrayList<Squads> s_instances = new ArrayList<Squads>();
    private boolean published;
    private LocalDateTime createdAt;
    private int id;

    public Squads(String squadName, int maxSize, String cause){
        this.squadName = squadName;
        this.maxSize = maxSize;
        this.cause = cause;
        this.published = false;
        this.createdAt = LocalDateTime.now();
        s_instances.add(this);
        this.id = s_instances.size();
    }
    public String getSquadName(){
        return squadName;
    }
    public int getMaxSize(){
        return maxSize;
    }
    public String getCause(){
        return cause;
    }
    public static ArrayList<Squads> getAll(){
        return s_instances;
    }
    public static void clearAllHeroes(){
        s_instances.clear();
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
    public static Squads findById(int id){
        return s_instances.get(id-1);
    }
    public void update(String newSquadName, int newMaxSize, String newCause){
        this.squadName = newSquadName;
        this.maxSize = newMaxSize;
        this.cause = newCause;
    }
    public void deleteSquad(){
        s_instances.remove(id-1);
    }
}

