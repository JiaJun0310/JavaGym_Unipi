public class Facility {
    private String name;
    private int capacity;

    public Facility(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
    public Facility(){

    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getMaxCapacity() {
        return capacity;
    }
    public void setMaxCapacity(int capacity) {
        this.capacity = capacity;
    }
    
}