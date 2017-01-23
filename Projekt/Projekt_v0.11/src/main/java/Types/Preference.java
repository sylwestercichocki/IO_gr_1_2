package Types;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Preference {
    public HashMap<String, HoursPreference> groupPreferences = new HashMap<>();
    public HashMap<String, HoursPreference> profPreferences = new HashMap<>();
    public HashMap<String, Integer[]> profClassPreference = new HashMap<>();

    @Override
    public String toString() {
        String a = "Grupy:\n";
        for (Map.Entry<String, HoursPreference> entry : groupPreferences.entrySet()) {
            String key = entry.getKey();
            HoursPreference value = entry.getValue();
            a += key + ":\n" + value.toString() + "\n";
        }

        a += "\nProwadzący:\n";
        for (Map.Entry<String, HoursPreference> entry : profPreferences.entrySet()) {
            String key = entry.getKey();
            HoursPreference value = entry.getValue();
            a += key + ":\n" + value.toString() + "\n";
        }

        a += "\nSale prowadzacyh:\n";
        for (Map.Entry<String,Integer []> entry : profClassPreference.entrySet()) {
            String key = entry.getKey();
            Integer[] value = entry.getValue();
            a += key + ":\n" + Arrays.toString(value) + "\n";
        }


        return a;
    }
}
