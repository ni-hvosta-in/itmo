package people;

import clothes.Clothes;
import interfaces.Runaway;
import plan.Exit;

import java.util.ArrayList;

public class Intruders extends Patient implements Runaway {
    public Intruders(String name, Location location) {
        super(name, location);
    }

    public Intruders(Intruders [] intruders){
        String name = "";
        boolean flag = false;
        for (Intruders i : intruders) {
            if (!flag){
                name = i.getName();
                flag = true;
            }else {
                name = name + " и " + i.getName() + " ";
            }
        }
        super(name, intruders[0].getLocation(), false);
    }

    public void moveTo(Location destination, Speed speed){
        this.setLocation(destination);
        if (speed == Speed.FAST) {
            System.out.println(getName() + " бросился в " + destination.getLocation());
        } else if (speed == Speed.NORMAL) {
            System.out.println(getName() + " пошел в " + destination.getLocation());
        } else {
            System.out.println(getName() + " проникает в " + destination.getLocation());
        }
    }


    @Override
    public void theft(ArrayList<Patient> owners, ArrayList<Clothes> Pantry){
            for (Clothes clothes : Pantry) {
                for (Patient own : owners) {
                    if (clothes.getOwner() == own) {
                        clothes.setLocation(Location.OTHER);
                        if (this.getName() == own.getName()) {
                            System.out.println(this.getName() + " похищает свою одежду");
                            this.setCloth(TypeClothing.DRESSED);

                        } else {
                            System.out.println(this.getName() + " похищает одежду " + own.getName());
                            own.setCloth(TypeClothing.DRESSED);
                        }
                    }
                }
            }

    }

    @Override
    public void escapePart1(Location from, Exit exit) {
        System.out.println(this.getName()+ " бежит с " + from.getLocation() + " через " + exit.getExit() +
                " в " + this.getCloth().getTypeCl());
        moveTo(Location.OTHER, Speed.FAST);


    }
    @Override
    public void escapePart2(ArrayList<Patient> owners, ArrayList<Clothes> Pantry){

        moveTo(Location.PANTRY, Speed.SLOW);
        theft(owners, Pantry);


    }
}
