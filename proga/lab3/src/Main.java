import clothes.Clothes;
import exceptions.NoItemException;
import people.*;


import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        String name = "Булька";
        Patient patient;

        try {
            patient = new Patient(name, Location.HOSPITAL);
        }catch (IllegalArgumentException e){
            patient = new Patient("Пациен", Location.HOSPITAL);
        }

        Intruders intruders1 = new Intruders("Пилюлькин", Location.OTHER);
        Intruders intruders2 = new Intruders("Ворчун", Location.OTHER);
        Intruders intruders3 = new Intruders("Данька", Location.OTHER);

        Clothes c1 = new Clothes(patient, Location.PANTRY);
        Clothes c2 = new Clothes(intruders1, Location.OTHER);
        Clothes c3 = new Clothes(intruders2, Location.OTHER);

        ArrayList<Clothes> Pantry = new ArrayList<>();
        Pantry.add(c1);
        Pantry.add(c2);
        Pantry.add(c3);

        Personal personal = new Personal(Location.OTHER);
        Personal med = new Personal("Медуница",Post.CHIEFPHISICION, Location.OTHER);
        Personal group = new Personal(med, personal);
        System.out.println();
        group.moveTo(Location.HOSPITAL, Speed.NORMAL);

        if (!group.findPatient(intruders1)) {

            group.moveTo(Location.PANTRY, Speed.FAST);
            System.out.println();
            ArrayList<Patient> owner;
            owner = group.findClothes(Pantry);

            if (!owner.isEmpty()) {
                System.out.println("Пропало " + owner.size() + " комплекта одежды");
            }
            for (Clothes clothes : Pantry) {
                if (!owner.contains(clothes.getOwner())) {
                    System.out.println("Осталась только одежда " + clothes.getOwner().getName());
                }
            }

            c2.setLocation(Location.PANTRY);
            c3.setLocation(Location.PANTRY);

            try {
                group.ThinkPlan(owner, Pantry, intruders1, intruders2);
            } catch (NoItemException e) {
                System.out.println(e.getMessage());
            }


        }
    }
}