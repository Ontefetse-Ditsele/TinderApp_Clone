

public class Profile extends Person {
    
    //Instance Variable
    private String bio;
    private Image[] pictures;


    public Profile(final String name,final int age, final String gender,final String location, final String bio){
        super(name,age,gender,location);
        this.bio = bio;
        this.pictures = new Image[3];

    }
    public void setImages(final Image[] pics){
        this.pictures = pics;

    }
    public Image[] getImages() {
        return this.pictures;
    }
    public void setBIO(final String bio) {
            this.bio = bio;
    }
    public String getBIO(){
        return this.bio;
    }

    @Override
    public String toString(){
        return super.getName() +"  "+ this.bio;
    }
}
