package pokemons;

import attacks.CalmMind;
import attacks.ChargeBeam;
import attacks.Charm;
import attacks.DarkPulse;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class MeowsticMale extends Pokemon {
    public MeowsticMale(String name, int level){
        super(name, level);
        addType(Type.PSYCHIC);
        setStats(74,48,76,83,81,104);
        setMove(new CalmMind(), new ChargeBeam(), new DarkPulse(), new Charm());
    }
}
