public class Subscription implements Pricelist {
    private String id;
    private Athlete athlete;
    private TrainingProgram trainingProgram;
    private double Cost;

    public Subscription(String id, Athlete athlete, TrainingProgram trainingProgram, double Cost) {
    	this.id = id;
        this.athlete = athlete;
        this.trainingProgram = trainingProgram;
        this.Cost = Cost;
    }

    @Override
    public double calculateTotalPrice() {
        return this.Cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    public TrainingProgram getTrainingProgram() {
        return trainingProgram;
    }

    public void setTrainingProgram(TrainingProgram trainingProgram) {
        this.trainingProgram = trainingProgram;
    }

    public double getCost() {
        return Cost;
    }

    public void setCost(double Cost) {
        this.Cost = Cost;
    }


}