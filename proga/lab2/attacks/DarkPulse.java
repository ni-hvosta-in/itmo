package attacks;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

import static java.lang.Math.random;

public class DarkPulse extends SpecialMove {
    public DarkPulse(){
        super(Type.DARK, 80,100);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        if (random() <= 0.2) {
            Effect.flinch(pokemon);
        }
    }

    @Override
    protected String describe() {
        return "Испльзует атаку Dark Pulse";
    }
}
