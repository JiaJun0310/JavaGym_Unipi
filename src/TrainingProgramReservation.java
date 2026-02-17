
import java.time.LocalDate;

public class TrainingProgramReservation {
    private String id;
    private Athlete athlete;
    private TrainingProgram trainingProgram;
    private LocalDate trainingDate;

    public TrainingProgramReservation(String id, Athlete athlete, TrainingProgram trainingProgram, LocalDate trainingDate) {
    	this.id = id;
        this.athlete = athlete;
        this.trainingProgram = trainingProgram;
        this.trainingDate = trainingDate;
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

    public LocalDate getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(LocalDate trainingDate) {
        this.trainingDate = trainingDate;
    }

    
}
