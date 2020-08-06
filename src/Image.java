

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
    public void setTags(final String[]  tags){
        this.tags = tags;
    }
    public String[] getTags(){
        return this.tags;

    }
    public void setDescription(final String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
    public void setTitle(final String title){
        this.title = title;
    }
    public String getTitle(){
            return this.title;
    }
    public void setURL(final String url){
        this.url = url;
    }
    public String getURL(){
        return this.url;
    }
}
