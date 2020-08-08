
/**
 * Ontefetse Ditsele
 * 
 * TinderSwipe Class : A Controller Class that will be user by TinderApp and interact with Database with Profiles
 * 06 August 2020
 */

import java.util.ArrayList;
import java.util.List;

public class TinderSwipe {
    List<Profile> rightSwipes;
    Profile[] preference;
    
    Profile current;
    Database userData;

    private int cTracker = -1;  //Keep track of the current Profile in Prefence list.

	public TinderSwipe(final String preference) {
        rightSwipes = new ArrayList<Profile>();
        
        userData = new Database();
        userData.readCSV();
        userData.setPreference(preference);
    
        this.preference = userData.getPreference();
    }
    
	public Profile getNext() {
        cTracker ++;
        if (cTracker < this.preference.length){
            current = preference[cTracker];
        }else{
            current = null;}
        return current;
	}
	public void right() {
        rightSwipes.add(current);
        userData.writeCSV(current);
    }

    public Profile[] getRightSwipes(){
        return this.rightSwipes.toArray(new Profile[0]);
    }
}