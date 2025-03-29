package people;

public class Patient extends Character {

    private TypeClothing cloth;

    public Patient(String name, Location location) {
        super(name, location);
        cloth = TypeClothing.NAKED;
        System.out.println(name + " cоздан в " + location.getLocation());
    }

    public Patient(String name, Location location, boolean comment) {
        super(name, location);
        cloth = TypeClothing.NAKED;
        if (comment) {
            System.out.println(name + " cоздан в " + location.getLocation());
        }
    }

    @Override
    public void moveTo(Location destination, Speed speed) {
        this.setLocation(destination);
        if (speed == Speed.FAST) {
            System.out.println(getName() + " бросился в " + destination.getLocation());
        } else {
            System.out.println(getName() + " пошел в " + destination.getLocation());
        }
    }


    public TypeClothing getCloth() {
        return cloth;
    }

    public void setCloth(TypeClothing cloth) {
        this.cloth = cloth;
    }


}
