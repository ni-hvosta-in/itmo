package pokemons;
import attacks.*;
import ru.ifmo.se.pokemon.*;

public class Cryogonal extends Pokemon {
    public Cryogonal (String name, int level){
        super(name, level);
        addType(Type.ICE);
        setStats(80,50,50,95,135,105);
        setMove(new Slash(), new AcidArmor(), new Sharpen(), new Blizzard());
    }
}
