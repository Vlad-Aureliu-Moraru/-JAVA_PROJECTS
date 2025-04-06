import javax.swing.*;
import java.awt.*;

public class SeedsClass implements Cloneable {
    private int ammount;
    private int collectAmount;
    private String name;
    private int growingTime;
    private int sellAmmount;
    private int buyAmmount;
    private int stackLimit = 35;
    private Image state0;
    private Image state1;
    private Image state2;
    private Image state3;
    private Image state4;
    private Image state5;
    private int maxGrowth;
    private int minGrowth;

    private TraitClass trait;

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxGrowth() {
        return maxGrowth;
    }
    public void setMaxGrowth(int maxGrowth) {
        this.maxGrowth = maxGrowth;
    }
    public int getMinGrowth() {
        return minGrowth;
    }
    public void setMinGrowth(int minGrowth) {
        this.minGrowth = minGrowth;
    }


    public String getName() {
        return name;
    }
    public void setAmmount(int ammount) {
        System.out.println(ammount+" ammount");
        this.ammount = ammount;
    }
    public int getAmmount() {
        return ammount;
    }
    public void addAmmount(int ammount) {
        if (this.ammount+ammount<=stackLimit) {
            this.ammount += ammount;
        }else {
            this.ammount=stackLimit;
        }
    }
    public int getCollectAmount() {
        return collectAmount;
    }
    public void setCollectAmount(int collectAmount) {
        this.collectAmount = collectAmount;
    }
    public void addCollectAmount(int collectAmount) {
        if (this.collectAmount+collectAmount<=stackLimit) {
            this.collectAmount += collectAmount;
        }else {
            this.collectAmount=stackLimit;
        }
    }

    public int getStackLimit() {
        return stackLimit;
    }
    public void setStackLimit(int stackLimit) {
        this.stackLimit = stackLimit;
    }

    public int getBuyAmmount() {
        return buyAmmount;
    }
    public void setBuyAmmount(int buyAmmount) {
        this.buyAmmount = buyAmmount;
    }
    public int getGrowthAmmount(){
        return (int)(Math.random() * (maxGrowth - minGrowth + 1)) + minGrowth;
    }
    public int getGrowingTime() {
        return growingTime;
    }

    public int getSellAmmount() {
        return sellAmmount;
    }

    public void setGrowingTime(int growingTime) {
        this.growingTime = growingTime;
    }

    public void setSellAmmount(int sellAmmount) {
        this.sellAmmount = sellAmmount;
    }
    public void setState0(Image state0) {
        this.state0 = state0;
    }
    public void setState1(Image state1) {
        this.state1 = state1;
    }
    public void setState2(Image state2) {
        this.state2 = state2;
    }
    public void setState3(Image state3) {
        this.state3 = state3;
    }
    public void setState4(Image state4) {
        this.state4 = state4;
    }
    public void setState5(Image state5) {
        this.state5 = state5;
    }
    public Image getState5() {
        return state5;
    }
    public Image getState0() {
        return state0;
    }
    public Image getState1() {
        return state1;
    }
    public Image getState2() {
        return state2;
    }
    public Image getState3() {
        return state3;
    }
    public Image getState4() {
        return state4;
    }
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name+" ; "+ammount+"\n");
        return builder.toString();
    }

    @Override
    public SeedsClass clone() throws CloneNotSupportedException {
        return (SeedsClass) super.clone();
    }
}
