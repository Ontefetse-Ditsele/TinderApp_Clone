/**
 * Ontefetse Ditsele
 * Profile Class : assert Bio & Images to Person.
 * 
 * 06 August 2020
 */

public class Profile extends Person {
    
    //Instance Variable
    private String bio;
    private Image[] pictures;


    public Profile(final String name,final int age, final String gender,final String location, final String bio){
        super(name,age,gender,location);
        this.bio = bio;
        this.pictures = new Image[3];
    }
    public void setBIO(final String bio) { this.bio = bio; }
    public void setImages(final Image[] pics){ this.pictures = pics;  }

    public String getBIO(){ return this.bio; }
    public Image[] getImages() { return this.pictures;   }
    
    @Override
    public String toString(){
        return super.toString() +"\n"+ this.bio +"\n"+this.pictures[0];
    }
}
