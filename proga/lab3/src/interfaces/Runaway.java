package interfaces;

import clothes.Clothes;
import exceptions.NoItemException;
import people.Location;
import people.Patient;
import plan.Exit;

import java.util.ArrayList;

public interface Runaway {
    void theft(ArrayList<Patient> owners, ArrayList<Clothes> Pantry) throws NoItemException;
    void escapePart1(Location from, Exit typeExit);
    void escapePart2(ArrayList<Patient> owners, ArrayList<Clothes> Pantry) throws NoItemException;
}
