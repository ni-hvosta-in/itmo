package people;

public abstract class Character {
    private String name;
    private Location location;

    public Character(Location location){
        this.location = location;
    }

    public Character(String name, Location location){
        if (name == ""){
            throw new IllegalArgumentException("The name must not be empty");
        }
        this.name = name;
        this.location = location;
    }

    public String getName(){
        return this.name;
    }

    public Location getLocation(){
        return this.location;
    }
    public void setLocation(Location location){
        this.location = location;
    }

    public abstract void moveTo(Location destination, Speed speed);
}
