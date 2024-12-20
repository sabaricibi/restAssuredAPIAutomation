package qa.api.com.pojo;

public class Location {
    private String id;
    private String name;

    public Location(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getLocID(){
        return id;
    }

    public String getLocName(){
        return name;
    }

    public void setLocID(String id){
        this.id = id;
    }

    public void setLocName(String name){
        this.name = name;
    }
}
