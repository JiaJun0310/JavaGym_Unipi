public class Coach extends User {
    private Sport sport;
    private String degrees;// arraylist isos prepi na ginei
    private int id;
    
    public Coach(int id, String firstName, String lastName, String gender, String birthDate, String contactDetails, Sport sport, String degrees) {
        super(id, firstName, lastName, gender, birthDate, contactDetails);
        this.sport = sport;
        this.degrees = degrees;
    }



    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public String getDegrees() {
        return degrees;
    }

    public void setDegrees(String degrees) {
        this.degrees = degrees;
    }

    
}