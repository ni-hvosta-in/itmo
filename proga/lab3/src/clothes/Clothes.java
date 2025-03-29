package clothes;

import people.Location;
import people.Patient;

public class Clothes {
    private Patient owner;
    private Location location;
    public Clothes(Patient owner, Location location){
        this.location = location;
        this.owner = owner;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Patient getOwner() {
        return owner;
    }

    public void setOwner(Patient owner) {
        this.owner = owner;
    }
}
