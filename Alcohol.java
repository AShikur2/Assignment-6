// Data Element - Alcohol
class Alcohol extends Beverage {
    private boolean offeredInWeekend;
    private final double WEEKEND_COST = 0.6;

    public Alcohol(String name, SIZE size, boolean offeredInWeekend) {
        super(name, TYPE.ALCOHOL, size);
        this.offeredInWeekend = offeredInWeekend;
    }

    @Override
    public double calcPrice() {
        double price = getBasePrice();

        if (getSize() == SIZE.MEDIUM) {
            price += getSizePrice();
        } else if (getSize() == SIZE.LARGE) {
            price += 2 * getSizePrice();
        }

        if (offeredInWeekend) {
            price += WEEKEND_COST;
        }

        return price;
    }

    @Override
    public String toString() {
        return super.toString() + ", Offered in Weekend: " + offeredInWeekend +
                ", Price: $" + calcPrice();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        Alcohol alcohol = (Alcohol) obj;
        return offeredInWeekend == alcohol.offeredInWeekend;
    }

    // Getters and Setters
    public boolean isOfferedInWeekend() {
        return offeredInWeekend;
    }

    public void setOfferedInWeekend(boolean offeredInWeekend) {
        this.offeredInWeekend = offeredInWeekend;
    }

	public String getBevName() {
		return getName();
	}
}
