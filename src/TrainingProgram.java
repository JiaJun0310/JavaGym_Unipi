public class TrainingProgram {
    private int id;
    private Sport sport;
    private Facility facility;
    private Coach coach;
    private int minexperience;
    private boolean requiresReservation;
    private String gender;
    private int duration;
    private String day;

    public TrainingProgram(int id ,Sport sport, Facility facility, Coach coach, int minexperience, boolean requiresReservation, String gender, int duration, String day) {
        this.id = id;
        this.sport = sport;
        this.facility = facility;
        this.coach = coach;
        this.minexperience = minexperience;
        this.requiresReservation = requiresReservation;
        this.gender = gender;
        this.duration = duration;
        this.day = day;
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

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public int getMinexperience() {
        return minexperience;
    }

    public void setMinexperience(int minexperience) {
        this.minexperience = minexperience;
    }

    public boolean isRequiresReservation() {
        return requiresReservation;
    }

    public void setRequiresReservation(boolean requiresReservation) {
        this.requiresReservation = requiresReservation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    
}