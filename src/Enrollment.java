import java.time.LocalDate;

public class Enrollment implements Pricelist
{
    private int id;
    private Athlete athlete;
    private LocalDate today;
    private double cost;
    private int discount;
    
    

    public Enrollment(int id, Athlete athlete, LocalDate today, double cost, int discount) {
        this.id = id;
        this.athlete = athlete;
        this.today = today;
        this.cost = cost;
        this.discount = discount;
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public Athlete getAthlete() {
        return athlete;
    }



    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }



    public LocalDate getToday() {
        return today;
    }



    public void setToday(LocalDate today) {
        this.today = today;
    }



    public double getCost() {
        return cost;
    }



    public void setCost(double cost) {
        this.cost = cost;
    }



    public int getDiscount() {
        return discount;
    }



    public void setDiscount(int discount) {
        this.discount = discount;
    }



	@Override
	public double calculateTotalPrice() {
		// TODO Auto-generated method stub
		return 0;
	}
    
}
