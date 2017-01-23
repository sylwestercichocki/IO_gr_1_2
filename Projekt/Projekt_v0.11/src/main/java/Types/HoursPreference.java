package Types;

import java.util.Arrays;
import java.util.HashMap;

public class HoursPreference {



    public boolean isDay(Days day){
        if(week.containsKey(day))return true;
        else return false;
    }
    public Boolean[] getDay(Days day){
        return week.get(day);
    }
    public void addDay(Days day, Boolean [] value){
        week.put(day,value);
    }

    private HashMap<Days,Boolean []> week=new HashMap<>();

    public void setWeek(HashMap<Days, Boolean[]> week) {
        this.week = week;
    }


    @Override
    public String toString() {
        String a="";
        for (HashMap.Entry<Days,Boolean []> entry : week.entrySet()) {
            Days key = entry.getKey();
            Boolean[] value = entry.getValue();
            a+=key+ Arrays.toString(value)+"\n";
        }
        return a;
    }
}
