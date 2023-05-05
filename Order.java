import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order> {

    private int orderNumber;
    private int orderTime;
    private DAY orderDay;
    private Customer customer;
    private List<Beverage> beverages;

    public Order(int orderTime, DAY orderDay, Customer customer) {
        this.orderNumber = generateOrderNumber();
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = new Customer(customer.getName(), customer.getAge());
        this.beverages = new ArrayList<>();
    }

    public int generateOrderNumber() {
        Random rand = new Random();
        return rand.nextInt(80000) + 10000;
    }

    @Override
    public boolean isWeekend() {
        return orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY;
    }

    @Override
    public Beverage getBeverage(int itemNo) {
        if (itemNo >= 0 && itemNo < beverages.size()) {
            return (Beverage) beverages.get(itemNo);
        }
        return null;
    }

    @Override
    public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
        Beverage bev = new Coffee(bevName, size, extraShot, extraSyrup);
        beverages.add(bev);
    }

    @Override
    public void addNewBeverage(String bevName, SIZE size) {
        Beverage bev = new Alcohol(bevName, size, isWeekend());
        beverages.add(bev);
    }

    @Override
    public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addProtein) {
        Beverage bev = new Smoothie(bevName, size, numOfFruits, addProtein);
        beverages.add(bev);
    }

    @Override
    public double calcOrderTotal() {
        double total = 0.0;
        for (Beverage bev : beverages) {
            total += bev.calcPrice();
        }
        return total;
    }

    @Override
    public int findNumOfBeveType(TYPE type) {
        int count = 0;
        for (Beverage bev : beverages) {
            if (bev.getType() == type) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Number: ").append(orderNumber).append("\n");
        sb.append("Order Time: ").append(orderTime).append("\n");
        sb.append("Order Day: ").append(orderDay).append("\n");
        sb.append("Customer: ").append(customer).append("\n");
        sb.append("Beverages:\n");
        for (Beverage bev : beverages) {
            sb.append(bev).append("\n");
        }
        sb.append("Order Total: $").append(String.format("%.2f", calcOrderTotal())).append("\n");
        return sb.toString();
    }

    @Override
    public int compareTo(Order otherOrder) {
        return Integer.compare(orderNumber, otherOrder.orderNumber);
    }

    public int getOrderNo() {
        return orderNumber;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public DAY getOrderDay() {
        return orderDay;
    }

    public Customer getCustomer() {
        return new Customer(customer.getName(), customer.getAge());
    }
    public void setCustomer(Customer customer) {
    	   this.customer = new Customer(customer.getName(), customer.getAge());
    	}

    public int getTotalItems() {
        int totalItems = 0;
        for (Beverage beverage : beverages) {
            totalItems++;
        }
        return totalItems;
    }
}