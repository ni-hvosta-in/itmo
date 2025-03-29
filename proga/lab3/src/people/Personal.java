package people;

import clothes.Clothes;
import exceptions.NoItemException;
import plan.Exit;
import plan.Plan;

import java.util.ArrayList;
import java.util.Objects;

public class Personal extends Character {
    private Post post;

    public Personal(Location location) {
        super("Персонал больницы", location);
        System.out.println("Персонал создан в " + location.getLocation());
    }

    public Personal(String name, Post post, Location location) {
        super(name, location);
        this.post = post;
        System.out.println(name + " " + post.getPost() + " создан в " + location.getLocation());
    }

    public Personal(Personal... personal) {    // изменяемое число, должность
        String groupName = "";
        boolean count = false;
        for (Personal p : personal) {
            if (!count) {
                groupName = p.getName();
                count = true;
            } else {
                groupName = groupName + " и " + p.getName() + " ";
            }
        }
        super(groupName, personal[0].getLocation());
    }

    public void moveTo(Location destination, Speed speed) {
        this.setLocation(destination);
        if (speed == Speed.FAST) {
            System.out.println(getName() + " бросился в " + destination.getLocation());
        } else {
            System.out.println(getName() + " пошел в " + destination.getLocation());
        }
    }

    public Boolean findPatient(Patient p) {
        if (p.getLocation() == this.getLocation()) {
            return true;
        } else {

            if (Math.random() < 0.8) {
                System.out.println("Сразу обнаружил пропажу " + p.getName());
                return false;
            } else {
                System.out.println("Не заметили пропажу");
                return true;
            }
        }
    }

    public ArrayList<Patient> findClothes(ArrayList<Clothes> Pantry) {

        ArrayList<Patient> owner = new ArrayList<>();

        for (Clothes clothes : Pantry) {
            if (clothes.getLocation() == Location.OTHER) {
                owner.add(clothes.getOwner());
            }
        }
        return owner;
    }

    public void chase(Intruders intruders) {
        System.out.println(this.getName() + " бросится в погоню за " + intruders.getName());
        this.setLocation(intruders.getLocation());
    }

    private Exit getExit() {
        Exit typeofExit;
        double chance = Math.random();
        if (chance < 1d / 3) {
            typeofExit = Exit.DOOR;
        } else if (chance < 2d / 3) {
            typeofExit = Exit.HOLE;
        } else {
            typeofExit = Exit.WINDOW;
        }
        return typeofExit;
    }

    public void ThinkPlan(ArrayList<Patient> owners, ArrayList<Clothes> Pantry, Intruders... intruders) throws NoItemException { // переменное количество

        Intruders[] intruders1 = new Intruders[intruders.length / 2];
        Intruders[] intruders2 = new Intruders[intruders.length - intruders1.length];

        for (int i = 0; i < intruders.length; i++) {
            if (i <= intruders1.length - 1) {
                intruders1[i] = intruders[i];
            } else {
                intruders2[i - intruders1.length] = intruders[i];
            }

        }

        Intruders intrudersGroup1 = new Intruders(intruders1);
        Intruders intrudersGroup2 = new Intruders(intruders2);
        if (intruders.length < owners.size()) {
            System.out.println("Таким образом план побега вообще не понятен");
        } else {
            if (Math.random() < 0.8) {
                Plan plan = new Plan(owners, Pantry, intrudersGroup1, intrudersGroup2, this, getExit());
                plan.getPlan();
                if (Math.random() < 0.8) {
                    System.out.println("План оправдался");
                    intrudersGroup2.moveTo(Location.OTHER, Speed.FAST);
                } else {
                    this.moveTo(Location.HOSPITAL, Speed.NORMAL);
                    intrudersGroup2.setLocation(Location.HOSPITAL);
                    if (intrudersGroup2.getLocation() == this.getLocation()) {
                        System.out.println("План провалился");
                    }
                }
            } else {
                System.out.println("Таким образом план побега вообще не понятен");
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Personal pers = (Personal) obj;
        return (Objects.equals(this.getName(), pers.getName()) && (Objects.equals(this.getLocation(), pers.getLocation())));
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.getLocation());
    }

    @Override
    public String toString() {
        return " " + this.getName() + " ";
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
