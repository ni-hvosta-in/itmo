package attacks;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class Sharpen extends StatusMove {
    public Sharpen(){
        super(Type.NORMAL,0,100);
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        pokemon.setMod(Stat.ATTACK,+1);
    }

    @Override
    protected String describe() {
        return "Юзает Sharpen для увеличения атаки";
    }
}
