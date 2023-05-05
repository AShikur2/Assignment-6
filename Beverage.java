import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Enumerated Type - DAY
enum DAY {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

// Enumerated Type - SIZE
enum SIZE {
    SMALL, MEDIUM, LARGE
}

// Enumerated Type - TYPE
enum TYPE {
    COFFEE, SMOOTHIE, ALCOHOL
}

// Data Element - Beverage
abstract class Beverage {
    private String name;
    private TYPE type;
    private SIZE size;
    private final double BASE_PRICE = 2.0;
    private final double SIZE_PRICE = 1.0;

    public Beverage(String name, TYPE type, SIZE size) {
        this.name = name;
        this.type = type;
        this.size = size;
    }

    public abstract double calcPrice();

    @Override
    public String toString() {
        return "Beverage: " + name + ", Size: " + size;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Beverage beverage = (Beverage) obj;
        return name.equals(beverage.name) && type == beverage.type && size == beverage.size;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public SIZE getSize() {
        return size;
    }

    public void setSize(SIZE size) {
        this.size = size;
    }

    public double getBasePrice() {
        return BASE_PRICE;
    }

    public double getSizePrice() {
        return SIZE_PRICE;
    }

	public String getBevName() {
		return getName();
	}
}
