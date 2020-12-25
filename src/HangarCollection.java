import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HangarCollection {

    private final Map<String, Hangar<Plane, IRocketsForm>> hangarStages;
    private final int frameWidth;
    private final int frameHeight;

    public HangarCollection(int frameWidth, int frameHeight) {
        hangarStages = new HashMap<>();
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
    }

    public void addHangar(String name) {
        if (!hangarStages.containsKey(name)) {
            hangarStages.put(name, new Hangar<>(frameWidth, frameHeight));
        }
    }

    public void delHangar(String name) {
        hangarStages.remove(name);
    }

    public Hangar<Plane, IRocketsForm> get(String name) {
        if (hangarStages.containsKey(name)) {
            return hangarStages.get(name);
        }
        return null;
    }

    public Vehicle getPlane(String hangarName, int planeIndex) {
        if (hangarStages.containsKey(hangarName)) {
            return hangarStages.get(hangarName).getVehicle(planeIndex);
        }
        return null;
    }

    public Set<String> keySet() {
        return hangarStages.keySet();
    }
}
