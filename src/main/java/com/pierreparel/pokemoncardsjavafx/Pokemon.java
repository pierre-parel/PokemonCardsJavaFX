package com.pierreparel.pokemoncardsjavafx;

public abstract class Pokemon {
    protected String name, weight, height, type;
    protected double attack,defense,speed;
    protected boolean multiclass;

    public void setMulticlass(Boolean isMulti) {this.multiclass=isMulti;}
    public Boolean getMulticlass(){return multiclass;}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + this.name + '\'' +
                ", weight='" + this.weight + '\'' +
                ", height='" + this.height + '\'' +
                ", type='" + this.type + '\'' +
                ", attack=" + this.attack +
                ", defense=" + this.defense +
                ", speed=" + this.speed +
                '}';
    }
}
