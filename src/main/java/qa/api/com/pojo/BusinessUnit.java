package qa.api.com.pojo;

public class BusinessUnit {
    private String id;
    private String name;

    public BusinessUnit(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getBUId(){
        return id;
    }

    public String getBUName(){
        return name;
    }

    public void setBUId(String id){
        this.id = id;
    }

    public void setBUName(String name){
        this.name = name;
    }
}
