package attacks;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class AcidArmor extends StatusMove {
    public AcidArmor(){
        super(Type.POISON,0,100);
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        pokemon.setMod(Stat.DEFENSE,+2);
    }

    protected String describe() {
        return "использует Acid Armor повышает защиту на +2";
    }
}
