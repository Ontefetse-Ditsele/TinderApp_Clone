/**
 * Ontefetse Ditsele
 * 
 * 06 August 2020
 */

public class TinderSwipe {
    Profile[] rightSwipes;
    Profile[] preference;

    Database userData;
    Profile current;
    private int tracker = -1;
    private int right = 0;

	public TinderSwipe(String preference) {
        //this.preference = preference;
        rightSwipes = new Profile[5];

        userData = new Database();
        userData.readCSV();
        userData.setPreference(preference);
    
        this.preference = userData.getPreference();
    }


	public Profile getNext() {
        tracker ++;
        current = preference[tracker];
        return current;
	}
	public void right() {
        rightSwipes[right] = current;
        userData.writeCSV(current);
    }

    public Profile[] getRightSwipes(){
        return rightSwipes;
    }
}