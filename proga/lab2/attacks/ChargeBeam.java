package attacks;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

import static java.lang.Math.random;

public class ChargeBeam extends SpecialMove {
    public ChargeBeam(){
        super(Type.ELECTRIC, 50, 90);
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        if (random() <= 0.7) {
            pokemon.setMod(Stat.SPECIAL_ATTACK, +1);
        }
    }

    @Override
    protected String describe() {
        return "Бьет атакой Charge Beam";
    }
}
