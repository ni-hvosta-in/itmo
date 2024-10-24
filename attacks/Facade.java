package attacks;

import ru.ifmo.se.pokemon.*;

public class Facade extends PhysicalMove {
    public Facade(){
        super(Type.NORMAL, 70, 100);
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        if (pokemon.getCondition() == Status.BURN){
            pokemon.addEffect(new Effect().stat(Stat.ATTACK, (int)pokemon.getStat(Stat.ATTACK) * 2));
        }
        if (pokemon.getCondition() == Status.POISON) {
            pokemon.addEffect(new Effect().stat(Stat.ATTACK, (int)pokemon.getStat(Stat.ATTACK) * 2));
        }
        if (pokemon.getCondition() == Status.PARALYZE) {
            pokemon.addEffect(new Effect().stat(Stat.ATTACK, (int)pokemon.getStat(Stat.ATTACK) * 2));
        }
    }
}
