import java.util.*;
import java.io.*;

/** Ontefetse Ditsele & 
 *
 *  
 */

import java.io.FileWriter;
import java.io.BufferedReader;

public class Database {
    protected ArrayList<Profile> userPreferences = new ArrayList<Profile>();
    private ArrayList<Profile> allPreferences = new ArrayList<Profile>();

    private String path;
    private String npath;

    private FileWriter Write;
    private BufferedReader Read;
    private File swipes;

    public Database(){ }

    public void readCSV(){
        FileReader fr;
        BufferedReader br;
        String row = null;
        Profile p;
        Image[] img = new Image[3];
        try {
            //fr = new FileReader("profiles.csv");
            br = new BufferedReader(new FileReader("profiles.csv"));//fr);
            br.readLine();
            while ((row = br.readLine()) != null) {
                String[] r = row.split(",");
                //name = 0
                //pic1: url=1, decript=2, title=3, tags=4(split=|)
                //pic2: url=5, decript=6, title=7, tags=8(split=|)
                //pic3: url=9, decript=10, title=11, tags=12(split=|)
                //bio=13
                //location=14
                //age=15
                //gender=16
                p = new Profile(r[0].trim(), Integer.parseInt(r[15].trim()),
                                r[16].trim(), r[14].trim(), r[13].trim());
                for (int i = 0; i < 3; i++) {
                    int j = 4*i;
                    img[i] = new Image(r[j+1].trim(), r[j+2].trim(),
                                       r[j+3].trim(), r[j+4].trim().split("\\|"));
                }
                p.setImages(img);
                this.allPreferences.add(p);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(" Error" + e);
        }
    }

    public void writeCSV(Profile p){
        this.swipes = new File("./swipes.csv");
        Image[] img = p.getImages();
        try {

            FileWriter fr = new FileWriter(this.swipes, true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter pr = new PrintWriter(br);
            pr.print(p.getName()+",");
            for (int i = 0; i < 3; i++) {
                Image m = img[i];
                pr.print(m.getURL() + ",");
                pr.print(m.getDescription() + ",");
                pr.print(m.getTitle() + ",");
                String[] tags = m.getTags();
                String t = "";
                for (int j = 0; j < 3; j++) {
                    t += tags[j] + "|";
                }
                pr.print(t + ",");
            }
            pr.print(p.getBIO() + ",");
            pr.print(p.getLocation() + ",");
            pr.print(p.getAge() + ",");
            pr.println(p.getGender());
            pr.close();
            br.close();
            fr.close();
        } catch (Exception e) {
            Sytetem.out.print("Error writeCSV" + e);
        }
    }

    public Profile[] getPreference(){
        return this.userPreferences.toArray(new Profile[0]);
    }

    public void setPreference(final String gender){
        //this.userPreferences = this.allPreferences;
        //this.userPreferences.removeIf(n -> (n.getGender().equals(gender)));
        for (int i = 0; i < this.allPreferences.size(); i++) {
            Profile p = this.allPreferences.get(i);
            if (p.getGender().equals(gender)) {
                this.userPreferences.add(p);
            }
        }
    }

    /*public static void main(String[] args) {
        Database db = new Database();
        db.readCSV();
        db.setPreference("male");
        db.writeCSV(db.allPreferences.get(0));
        System.out.println(db.allPreferences.size());
        System.out.println(db.userPreferences.size());
    }*/
}
