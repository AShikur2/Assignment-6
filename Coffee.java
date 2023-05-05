class Coffee extends Beverage {
    private boolean extraShot;
    private boolean extraSyrup;
    private final double EXTRA_SHOT_PRICE = 0.5;
    private final double EXTRA_SYRUP_PRICE = 0.5;

    public Coffee(String name, SIZE size, boolean extraShot, boolean extraSyrup) {
        super(name, TYPE.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    @Override
    public double calcPrice() {
        double price = getBasePrice();

        if (getSize() == SIZE.MEDIUM) {
            price += getSizePrice();
        } else if (getSize() == SIZE.LARGE) {
            price += 2 * getSizePrice();
        }

        if (extraShot) {
            price += EXTRA_SHOT_PRICE;
        }
        if (extraSyrup) {
            price += EXTRA_SYRUP_PRICE;
        }

        return price;
    }

    @Override
    public String toString() {
        return super.toString() + ", Extra Shot: " + extraShot + ", Extra Syrup: " + extraSyrup +
                ", Price: $" + calcPrice();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        Coffee coffee = (Coffee) obj;
        return extraShot == coffee.extraShot && extraSyrup == coffee.extraSyrup;
    }
    public boolean getExtraShot() {
        return extraShot;
    }

    public void setExtraShot(boolean extraShot) {
        this.extraShot = extraShot;
    }

    public boolean getExtraSyrup() {
        return extraSyrup;
    }

    public void setExtraSyrup(boolean extraSyrup) {
        this.extraSyrup = extraSyrup;
    }

	public String getBevName() {
		return getName();
	}
}


