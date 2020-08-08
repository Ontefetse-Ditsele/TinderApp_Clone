/**
 * Ontefetse Ditsele
 * 
 * Person Class : A super class to create all profiles.
 * 06 August 2020
 */

public class Person {
    private String name;
    private int  age;
    private String gender;
    private String location;

    public Person(final String name,final int age, final String gender,final String location){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.location = location;
    }
    public void setName(final String name){ this.name = name;}
    public void setAge(final int age){ this.age = age;}
    public void setGender(final String gender){ this.gender = gender;}
    public void setLocation(final String location){this.location = location;}

    public String getName(){ return this.name;}
    public int getAge(){ return this.age;}
    public String getGender(){return  this.gender;}
    public String getLocation(){ return this.location;}

    @Override
    public String toString(){ 
        return this.name +" Age: "+ this.age +"   "+this.gender;
    }
}
