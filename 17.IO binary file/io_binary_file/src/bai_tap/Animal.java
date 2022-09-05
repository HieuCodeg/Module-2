package bai_tap;

public class Animal implements Comparable<Animal>{
    private boolean alive;
    private String name;
    private int power;

    public Animal(boolean alive, String name, int power) {
        this.alive = alive;
        this.name = name;
        this.power = power;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "alive=" + alive +
                ", name='" + name + '\'' +
                ", power=" + power +
                '}';
    }

    @Override
    public int compareTo(Animal o) {
        return this.power - o.power;
    }
}
