import java.time.LocalDate;

public class Payment  {
    private int id;
    private LocalDate paymentDate;
    private String paymentMethod;
    private Pricelist pricelistItem;
    private double totalCost;

    public Payment(int id, LocalDate paymentDate, String paymentMethod, Enrollment pricelistItem, double totalCost) {
    	this.id = id;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.pricelistItem = pricelistItem;
        this.totalCost = totalCost;
    }
    
    public Payment(int id, LocalDate paymentDate, String paymentMethod, Subscription pricelistItem, double totalCost) {
    	this.id = id;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.pricelistItem = pricelistItem;
        this.totalCost = totalCost;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Pricelist getPricelistItem() {
        return pricelistItem;
    }

    public void setPricelistItem(Pricelist pricelistItem) {
        this.pricelistItem = pricelistItem;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    
}