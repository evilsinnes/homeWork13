package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basePrice;
    public int discount;

    public DiscountedProduct (String name, int basePrice, int discount) {
        super(name);
        if (basePrice <=0){
            throw  new IllegalArgumentException("Базовая цена продукта должна быть строго больше 0.");
        }
        if (discount<0 || discount >100) {
            throw new IllegalArgumentException("Скидка должна быть в диапазоне от 0 до 100 включительно.");
        }
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return basePrice * (100 - discount)/100;

    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + discount + "%)";
    }
}
