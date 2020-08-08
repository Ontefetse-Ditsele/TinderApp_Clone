/*Ontefetse Ditsele
 *
 * Image Object to assit Profile with adding images.
 * 06 August 2020.
 * */

public class Image {
    private String url;
    private String description;
    private String title;
    private String[] tags;
    
    public Image(final String url,final String descrption,final String title,final String[] tags){
        this.url = url;
        this.description = descrption;
        this.title = title;
        this.tags = tags;
    }
    
    public void setURL(final String url){ this.url = url; }
    public void setTags(final String[]  tags){ this.tags = tags; }
    public void setTitle(final String title){ this.title = title; }
    public void setDescription(final String description){ this.description = description; }
    
    public String getURL(){ return this.url; }
    public String getTitle(){ return this.title; }
    public String[] getTags(){ return this.tags; }
    public String getDescription(){ return this.description; } 

    @Override
    public String toString(){
        return this.url + " \n"+ this.description +" \n"+ "#"+this.tags[0] +"#"+this.tags[1]+"#"+this.tags[2];
    }
}
