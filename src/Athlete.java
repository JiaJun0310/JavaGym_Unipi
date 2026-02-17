public class Athlete extends User {
    private boolean professional;
    private int experienceLevel; // 1 to 5

    public Athlete(int id, String firstName, String lastName, String gender, String birthDate, String contactDetails, boolean professional, int experienceLevel) {
        super(id, firstName, lastName, gender, birthDate, contactDetails);
        this.professional = professional;
        this.experienceLevel = experienceLevel;
    }

    public boolean getProfessional() {
        return professional;
    }

    public void setProfessional(boolean professional) {
        this.professional = professional;
    }

    public int getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(int experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    
}