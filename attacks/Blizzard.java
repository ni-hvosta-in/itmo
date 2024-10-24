package attacks;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

import static java.lang.Math.random;

public class Blizzard extends SpecialMove {
    public Blizzard(){
        super(Type.ICE,110,70);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        if (random() <= 0.1) {
            Effect.freeze(pokemon);
        }
    }

    @Override
    protected String describe() {
        return "Бьет атакой Blizzard может заморозить противника";
    }
}
