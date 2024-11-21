package pokemons;

import attacks.Confide;
import attacks.CosmicPower;
import attacks.DoubleTeam;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Clefairy extends Cleffa {
    public Clefairy(String name, int level) {
        super(name, level);
        addType(Type.FAIRY);
        setStats(70,45,48,60,65,35);
        addMove(new CosmicPower());
    }
}
