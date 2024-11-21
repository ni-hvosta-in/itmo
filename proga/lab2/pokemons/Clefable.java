package pokemons;

import attacks.Confide;
import attacks.CosmicPower;
import attacks.DoubleTeam;
import attacks.Facade;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Clefable extends Clefairy {
    public Clefable (String name, int level){
        super(name, level);
        addType(Type.FAIRY);
        setStats(95,70,73,95,90,60);
        addMove(new Facade());
    }
}
