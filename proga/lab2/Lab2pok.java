import pokemons.*;
import ru.ifmo.se.pokemon.*;

public class Lab2pok {
    public static void main(String[] args) {
        Battle b = new Battle();
        Cryogonal cryogonal = new Cryogonal("Alex",1);
        Espurr espurr = new Espurr("Danya",4);
        MeowsticMale meowsticMale = new MeowsticMale("Yarik", 4);
        Cleffa cleffa = new Cleffa("Misha", 6);
        Clefairy clefairy = new Clefairy("opa", 6);
        Clefable clefable = new Clefable("Жора", 6);
        b.addAlly(cryogonal);
        b.addAlly(cleffa);
        b.addAlly(clefable);
        b.addFoe(espurr);
        b.addFoe(meowsticMale);
        b.addFoe(clefairy);
        b.go();
    }
}
