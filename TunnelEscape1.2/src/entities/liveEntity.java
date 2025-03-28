package entities;

public class liveEntity extends entity {
   private int HEALTH=100;
   private int HEALTHMAX=100;
   private int SPEED;
   private int SPEEDMAX;
   private String NAME;
   private int ENERGY;
   private int ENERGYMAX;
   private boolean hasBeenAttacked;
   private boolean DEAD=false;

   public liveEntity(int x,int y) {
       super(x,y);

   }

    public void setHasBeenAttacked(boolean hasBeenAttacked) {
        this.hasBeenAttacked = hasBeenAttacked;
    }
    public boolean getHasBeenAttacked() {
       return hasBeenAttacked;
    }

    public int getHealth() {
        return HEALTH;
    }
    public void setHealth(int health) {
        if (health >= 0) {
            HEALTH = health;
        } else {
            System.out.println("Health cannot be negative.");
        }
    }
    public void addHealth(int health) {
       if (health <= HEALTHMAX) {
           HEALTH += health;
           System.out.println(HEALTH);
       }else {
           HEALTH = HEALTHMAX;
       }
       if (HEALTH<=0){
           DEAD = true;
           this.setVisible(false);
       }
    }
    public int getSpeed() {
        return SPEED;
    }
    public void addSpeed(int speed) {
       if (speed <= SPEEDMAX) {
           SPEED += speed;
       }else {
           SPEED = SPEEDMAX;
       }
    }
    public void setSpeed(int speed) {
        if (speed >= 0) {
            SPEED = speed;
        } else {
            System.out.println("Speed cannot be negative.");
        }
    }
    public String getName() {
        return NAME;
    }
    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            NAME = name;
        } else {
            System.out.println("Name cannot be null or empty.");
        }
    }
    public int getEnergy() {
        return ENERGY;
    }
    public void addEnergy(int energy) {
       if (energy <= ENERGYMAX) {
           ENERGY += energy;
       }else {
       ENERGY = ENERGYMAX;
       }
   }
    public void setEnergy(int energy) {
        if (energy >= 0) {
            ENERGY = energy;
        } else {
            System.out.println("Energy cannot be negative.");
        }
    }
    public int getEnergyMax() {
       return ENERGYMAX;
    }
    public void addEnergyMax(int energyMax) {
       ENERGYMAX += energyMax;
    }
    public void setEnergyMax(int energyMax) {
       ENERGYMAX = energyMax;
    }
    public int getHealthMax() {
       return HEALTHMAX;
    }
    public void addHealthMax(int healthMax) {
       HEALTHMAX += healthMax;
    }
    public void setHealthMax(int healthMax) {
       HEALTHMAX = healthMax;
    }
    public boolean isDead() {
       return DEAD;
    }
    public void setDead(boolean dead) {
       DEAD = dead;
    }
    public int getSpeedMax() {
       return SPEEDMAX;
    }
    public void addSpeedMax(int speed) {
       SPEEDMAX += speed;
    }
    public void setSpeedMax(int speedMax) {
       this.SPEEDMAX = speedMax;
    }
}

