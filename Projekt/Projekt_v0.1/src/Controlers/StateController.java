package Controlers;

import Types.HoursPreference;
import Types.Preference;

public class StateController {
    public static StateController getStateControler(){
        return stateController;
    }

    private static StateController stateController=new StateController();

    private   String group;
    private  String prof;


    public  Preference preference=new Preference();

    private StateController(){}

    //TO DELETE!!
    public  String []classes={"101","201","301","401","501","601","701","102","103","101","201","301","401","501","601","701","102","103"};
    public  String []groups={"Gr.1","Gr.2","Gr.3","Gr4"};
    public  String [] profs ={"Kazimierz Michalik","Mirosław Głowacki","Grzegorz Górecki","Henry of Metal"};
    //END TO DELETE

    public  void setGroup(int i){
        if(i<0){group=null;}
        else group=groups[i];
    }
    public  void addHours(HoursPreference hoursPreference){
        if(group==null)preference.profPreferences.put(prof,hoursPreference);
        else preference.groupPreferences.put(group,hoursPreference);

        //JUst in case
        group=null;
        prof=null;
    }

    public  String getProf() {return prof;}
    public  String getGroup() {return group;}

    public  HoursPreference get(){
        if(group==null)return preference.profPreferences.get(prof);
        else return preference.groupPreferences.get(group);
    }
    public  void setProf(int i) {
        if(i<0)prof=null;
        else
        prof = profs[i];
    }




}
