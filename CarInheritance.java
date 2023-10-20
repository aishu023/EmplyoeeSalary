package com.cg.havherrank;

class WagonR extends Car {
    private int mileage;

    public WagonR(int mileage) {
        super(false, "4");
        this.mileage = mileage;
    }

    @Override
    public String getMileage() {
        return this.mileage + " kmpl";
    }
}

class HondaCity extends Car {
    private int mileage;

    public HondaCity(int mileage) {
        super(true, "4");
        this.mileage = mileage;
    }

    @Override
    public String getMileage() {
        return this.mileage + " kmpl";
    }
}

class InnovaCrysta extends Car {
    private int mileage;

    public InnovaCrysta(int mileage) {
        super(false, "6");
        this.mileage = mileage;
    }

    @Override
    public String getMileage() {
        return this.mileage + " kmpl";
    }
}
