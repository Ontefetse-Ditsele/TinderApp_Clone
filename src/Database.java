import java.util.ArrayList;
import java.io.*;
/** Ontefetse Ditsele & Tahir-Mahmood Rhonda
 *
 *  Database to be used by TinderSwipe, to assist with wrtting to and from a CSV
 * 07 August 2020
 */


public class Database {
    protected ArrayList<Profile> userPreferences ;
    protected ArrayList<Profile> allAppUsers = new ArrayList<Profile>();

    private final String path = "C:/Users/connex/OneDrive/Desktop/zaio_deliverables/TinderApp_Clone/bin/profiles.csv";
    private final String npath = "C:/Users/connex/OneDrive/Desktop/zaio_deliverables/TinderApp_Clone/bin/swipes.csv";

    private PrintWriter Write;
    private BufferedReader Read;
    private File swipes;

    public Database() {
        userPreferences = new ArrayList<Profile>();
        allAppUsers = new ArrayList<Profile>();
    }

    public void readCSV() {
        String row = null;
        Profile p;
        //Image[] 
        try {
            this.Read = new BufferedReader(new FileReader(path));
            this.Read.readLine();
            while ((row = Read.readLine()) != null) {
                String[] r = row.split(",");
                Image[] img = new Image[3];
                /*
                 * name = 0 pic1: url=1, decript=2, title=3, tags=4 (split=|) pic2: url=5,
                 * decript=6, title=7, tags=8 (split=|) pic3: url=9, decript=10, title=11,
                 * tags=12(split=|) bio=13 location=14 age=15 gender=16
                 */
                p = new Profile(r[0].trim(), Integer.parseInt(r[15].trim()), r[16].trim(), r[14].trim(), r[13].trim());
                for (int i = 0; i < 3; i++) {
                    int j = 4 * i;
                    img[i] = new Image(r[j + 1].trim(), r[j + 2].trim(), r[j + 3].trim(), r[j + 4].trim().split("\\|"));
                }
                p.setImages(img);
                this.allAppUsers.add(p);
            }
            this.Read.close();
        } catch (final Exception e) {
            System.out.println("Error reading from profiles.csv" + e.getMessage());
        }
    }

    public void writeCSV(final Profile p) {
        this.swipes = new File(npath);
        Image[] img = p.getImages();
        try {
            this.Write = new PrintWriter(new BufferedWriter(new FileWriter(this.swipes, true)));
            Write.print(p.getName() + ",");
            for (int i = 0; i < 3; i++) {
                Image m = img[i];
                Write.print(m.getURL() + ",");
                Write.print(m.getDescription() + ",");
                Write.print(m.getTitle() + ",");
                String[] tags = m.getTags();
                String t = "";
                for (int j = 0; j < 3; j++) {
                    t += tags[j] + "|";
                }
                Write.print(t + ",");
            }
            Write.print(p.getBIO() + "," + p.getLocation() + "," + p.getAge() + "," + p.getGender());
            Write.println("");
            Write.close();
        } catch (final Exception e) {
            System.out.print("Error writting to swipes.csv" + e.getMessage());
        }
    }

    public Profile[] getPreference() {
        return this.userPreferences.toArray(new Profile[0]);
    }

    public void setPreference(final String gender) {
        for (int i = 0; i < this.allAppUsers.size(); i++) {
            if (gender.equals("B")) {
                this.userPreferences = this.allAppUsers;
            } else {
                Profile p = this.allAppUsers.get(i);
                if (p.getGender().equals(gender)) {
                    this.userPreferences.add(p);
                }
            }
        }
    }
}
