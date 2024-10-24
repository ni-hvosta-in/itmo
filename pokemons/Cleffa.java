package pokemons;

import attacks.Confide;
import attacks.DoubleTeam;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Cleffa extends Pokemon {
    public Cleffa(String name, int level){
        super(name, level);
        addType(Type.FAIRY);
        setStats(50,25,28,45,55,15);
        setMove(new DoubleTeam(), new Confide());
    }
}
