package qa.api.engagedly.pojo;

public class JobTitle {
    private String id;
    private String name;

    public JobTitle(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getJobID(){
        return id;
    }

    public String getJobName(){
        return name;
    }

    public void setJobID(String id){
        this.id = id;
    }

    public void setJobName(String name){
        this.name = name;
    }

    }
