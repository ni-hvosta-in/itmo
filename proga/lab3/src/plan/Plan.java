package plan;

import clothes.Clothes;
import exceptions.NoItemException;
import people.Intruders;
import people.Location;
import people.Patient;
import people.Personal;

import java.util.ArrayList;

public record Plan (ArrayList<Patient> owners, ArrayList<Clothes> Pantry, Intruders intruders1, Intruders intruders2, Personal personal, Exit exit) {
    public void getPlan() throws NoItemException {
        System.out.println("Таким образом выяснился план побега, задуманный " + intruders1.getName() + " и " + intruders2.getName());
        System.out.println();
        System.out.println("По плану:");
        intruders1.escapePart1(Location.HOSPITAL, exit);
        System.out.println(intruders1.getName() + " и " + intruders2.getName() + " рассчитывали ");
        personal.chase(intruders1);
        if (!Pantry.isEmpty()) {
            intruders2.escapePart2(owners, Pantry);
        } else {
            throw new NoItemException();
        }
    }
}
