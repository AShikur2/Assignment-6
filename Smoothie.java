class Smoothie extends Beverage {
    private int numberOfFruits;
    private boolean proteinPowder;
    private final double PROTEIN_PRICE = 1.5;
    private final double FRUIT_PRICE = 0.5;

    public Smoothie(String name, SIZE size, int numberOfFruits, boolean proteinPowder) {
        super(name, TYPE.SMOOTHIE, size);
        this.numberOfFruits = numberOfFruits;
        this.proteinPowder = proteinPowder;
    }

    @Override
    public double calcPrice() {
        double price = getBasePrice();

        if (getSize() == SIZE.MEDIUM) {
            price += getSizePrice();
        } else if (getSize() == SIZE.LARGE) {
            price += 2 * getSizePrice();
        }

        if (proteinPowder) {
            price += PROTEIN_PRICE;
        }
        price += numberOfFruits * FRUIT_PRICE;

        return price;
    }

    @Override
    public String toString() {
        return super.toString() + ", Number of Fruits: " + numberOfFruits + ", Protein Powder: " +
                proteinPowder + ", Price: $" + calcPrice();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        Smoothie smoothie = (Smoothie) obj;
        return numberOfFruits == smoothie.numberOfFruits && proteinPowder == smoothie.proteinPowder;
    }

    // Getters and Setters
    public int getNumOfFruits() {
        return numberOfFruits;
    }

    public void setNumberOfFruits(int numberOfFruits) {
        this.numberOfFruits = numberOfFruits;
    }

    public void setProteinPowder(boolean proteinPowder) {
        this.proteinPowder = proteinPowder;
    }

	public String getBevName() {
		return getName();
	}

	public boolean getAddProtein() {
		return proteinPowder;
	}

}