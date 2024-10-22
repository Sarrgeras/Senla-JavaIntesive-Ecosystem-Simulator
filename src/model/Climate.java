package model;

public class Climate {
    private int temperature;
    private int rainfall;

    public Climate(int initialTemperature, int initialRainfall) {
        this.temperature = initialTemperature;
        this.rainfall = initialRainfall;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getRainfall() {
        return rainfall;
    }

    public void changeClimate() {
        this.temperature += (int) (Math.random() * 11) - 5;
        this.rainfall += (int) (Math.random() * 21) - 10;

        this.temperature = Math.max(-30, Math.min(this.temperature, 50));
        this.rainfall = Math.max(0, this.rainfall);
    }
}
