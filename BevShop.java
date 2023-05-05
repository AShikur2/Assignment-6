import java.util.ArrayList;

public class BevShop implements BevShopInterface {
	private ArrayList<Order> orders = new ArrayList<Order>();
	private int alcoholNum;
	
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) 
	{
		orders.add(new Order(time, day, new Customer(customerName, customerAge)));
	}
	
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) 
	{
		getCurrentOrder().addNewBeverage(bevName, size, extraShot, extraSyrup);
	}
	
	public void processAlcoholOrder(String bevName, SIZE size) 
	{
		getCurrentOrder().addNewBeverage(bevName, size);
	}
	
	
	public int findOrder(int orderNo) 
	{
		for (int i = 0; i < orders.size(); i++)
		{
			if (orders.get(i).getOrderNo() == orderNo)
				return i;
		}
		return -1;
	}
	
	public double totalOrderPrice(int orderNo) {
		return orders.get(findOrder(orderNo)).calcOrderTotal();
	}
	
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) 
	{
		getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtien);
	}

	public double totalMonthlySale() {
		double total = 0;
		for (int i = 0; i < orders.size(); i++)
		{
			total += orders.get(i).calcOrderTotal();
		}
		return total;
	}

	public void sortOrders() 
	{
		int min;
		 
        for (int i = 0; i < orders.size() - 1; i++)
        {
            min = i;
            for (int j = i + 1; j < orders.size(); j++)
                if (orders.get(j).getOrderNo() < orders.get(min).getOrderNo())
                	min = j;
 
            Order temp = orders.get(min);
            orders.set(min,  orders.get(i));
            orders.set(i, temp);
        }
	}
	
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}
	
	
	public boolean validTime(int time) 
	{
		return MIN_TIME <= time && time <= MAX_TIME;
	}
	
	public boolean validAge(int age) 
	{
		return age > MIN_AGE_FOR_ALCOHOL;
	}

	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}
	
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	public int getNumOfAlcoholDrink() {
		return getCurrentOrder().findNumOfBeveType(TYPE.ALCOHOL);
	}

	public Order getCurrentOrder() {
		return orders.get(orders.size() - 1);
	}
	
	public boolean eligibleForMore() 
	{
		return getCurrentOrder().findNumOfBeveType(TYPE.ALCOHOL) < MAX_ORDER_FOR_ALCOHOL;
	}

	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}
	
	public ArrayList<Order> getOrders()
	{
		return orders;
	}
		
	public int getAlcoholCount() {
		return alcoholNum;
	}

	public void setAlcoholCount(int alcoholNum) {
		this.alcoholNum = alcoholNum;
	}
	
	public boolean isMaxFruit(int numOfFruits) {
		return numOfFruits > 5;
	}
	
	public String toString()
	{
		String out = "Beverage Shop";
		for (int i = 0; i < orders.size(); i++)
		{
			out += '\n' + orders.get(i).toString();
		}
		out += "\nTotal Monthly Sale: " + totalMonthlySale();
		return out;
	}
}