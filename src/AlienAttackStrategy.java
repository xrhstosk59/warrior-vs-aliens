import java.util.List;

public interface AlienAttackStrategy {
    List<Alien> attack(Warrior warrior, AlienArmy alienArmy);
}