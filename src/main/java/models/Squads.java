package models;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Squads {
    private String squadName;
    private int maxSize;
    private String cause;
    private static ArrayList<Squads> s_instances = new ArrayList<Squads>();
    private boolean published;
    private String createdAt;
    private int id;

    public Squads(String squadName, int maxSize, String cause){
        this.squadName = squadName;
        this.maxSize = maxSize;
        this.cause = cause;
        this.published = false;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm");
        LocalDateTime Date = LocalDateTime.now();
        this.createdAt = Date.format(format);
        s_instances.add(this);
        this.id = s_instances.size();
    }

}

