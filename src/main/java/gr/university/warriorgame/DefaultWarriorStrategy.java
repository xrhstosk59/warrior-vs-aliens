package gr.university.warriorgame;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Default attack strategy for the warrior.
 * <p>
 * This strategy combines information from both observers (Satellite and Telescope)
 * to identify and destroy detected aliens. Aliens detected by either observer
 * are targeted and destroyed.
 * </p>
 */
public class DefaultWarriorStrategy implements WarriorAttackStrategy {

    @Override
    public void attack(AlienArmy alienArmy, Satellite satellite, Telescope telescope) {
        List<Alien> satelliteDetections = satellite.getObservedAliens();
        List<Alien> telescopeDetections = telescope.getObservedAliens();

        // Combine detections from both observers using a Set to avoid duplicates
        Set<Alien> targets = new HashSet<>();
        targets.addAll(satelliteDetections);
        targets.addAll(telescopeDetections);

        // Destroy all detected aliens
        int killCount = 0;
        for (Alien alien : targets) {
            if (alien.isAlive()) {
                alien.destroy();
                killCount++;
            }
        }

        System.out.println("Ο πολεμιστής κατέστρεψε " + killCount + " εχθρούς!");
    }
}
