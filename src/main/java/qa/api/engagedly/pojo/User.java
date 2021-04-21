package qa.api.engagedly.pojo;

public class User {
    private String first_name;
    private String last_name;
    private String email;
    private String id;
    private String name;
    private String middle_name;
    private String employee_id;
    private String status;
    private String display_picture;
    private JobTitle job_title;
    private BusinessUnit business_unit;
    private String employee_type;
    private String birthdate;
    private Location location;
    private String phone_number;


    // constructor
    public User(String first_name, String last_name, String email, String id, String name, String middleName,
                String employeeID, String status, String displayPicture, JobTitle jobTitle, BusinessUnit businessUnit,
                String employeeType, String birthDay, Location location, String phoneNumber) {

        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.id = id;
        this.name = name;
        this.middle_name = middleName;
        this.employee_id = employeeID;
        this.status = status;
        this.display_picture = displayPicture;
        this.job_title = jobTitle;
        this.business_unit = businessUnit;
        this.employee_type = employeeType;
        this.birthdate = birthDay;
        this.location =  location;
        this.phone_number = phoneNumber;



    }

    // getter and setter methods:

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }


    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getId() {
        return id;
    }

    public void setId(String email) {
        this.email = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middle_name;
    }

    public void setMiddleName(String middleName) {
        this.middle_name = middleName;
    }

    public String getEmployeeID() {
        return employee_id;
    }

    public void setEmployeeID(String employeeID) {
        this.employee_id = employeeID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDisplayPicture() {
        return display_picture;
    }

    public void setDisplayPicture(String displayPicture) {
        this.display_picture = displayPicture;
    }

    public JobTitle getJobTitle() {
        return job_title;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.job_title = jobTitle;
    }

    public BusinessUnit getBusinessUnit() {
        return business_unit;
    }

    public void setBusinessUnit(BusinessUnit businessUnit) {
        this.business_unit = businessUnit;
    }

    public String getEmployeeType() {
        return employee_type;
    }

    public void setEmployeeType(String employeeType) {
        this.employee_type = employeeType;
    }

    public String getBirthDay() {
        return birthdate;
    }

    public void setBirthDay(String birthDay) {
        this.birthdate = birthDay;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phone_number = phoneNumber;
    }
}
