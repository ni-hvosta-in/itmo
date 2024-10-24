package attacks;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class CosmicPower extends StatusMove {
    public CosmicPower(){
        super(Type.PSYCHIC, 0, 100);
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        pokemon.setMod(Stat.DEFENSE, +1);
        pokemon.setMod(Stat.SPECIAL_DEFENSE, +1);
    }

    @Override
    protected String describe() {
        return "Использует Cosmic Power, чтобы повысить все виды защиты";
    }
}
