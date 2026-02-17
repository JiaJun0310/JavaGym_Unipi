public class Sport {
    private String name;
    private boolean Professional;

    public Sport(String name, boolean Professional) {
        this.name = name;
        this.Professional = Professional;
    }
    public Sport(){

    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isProfessional() {
        return Professional;
    }
    public void setProfessional(boolean Professional) {
        this.Professional = Professional;
    }

}
