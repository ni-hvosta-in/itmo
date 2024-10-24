package pokemons;
import attacks.*;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Espurr extends Pokemon {
    public Espurr(String name, int level) {
        super(name, level);
        addType(Type.PSYCHIC);
        setStats(62,48,54,63,60,68);
        setMove(new CalmMind(), new ChargeBeam(), new DarkPulse());
    }
}
