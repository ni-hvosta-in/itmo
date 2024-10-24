package attacks;
import ru.ifmo.se.pokemon.*;

public class Slash extends PhysicalMove {

    public Slash(){
        super(Type.NORMAL,140, 100);
    }

    @Override
    protected double calcCriticalHit(Pokemon pokemon, Pokemon pokemon1) {
        if (Math.random() <= 1d/8) {
            return 2;
        }
        else {
            return 1;
        }
    }

    @Override
    protected String describe() {
        return "Бьет атакой Slash";
    }
}