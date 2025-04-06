import java.util.ArrayList;

public class InventoryCollected {
    private ArrayList<SeedsClass> itemBag = new ArrayList<>();
    private int inventoryLimit =5;
    private boolean inventoryFull = false;
    public InventoryCollected() {}

    public ArrayList<SeedsClass> getSeeds() {
        return itemBag;
    }

    public void addSeeds(SeedsClass seeds,int amount) {
        boolean found = false;
        if(amount > seeds.getStackLimit()) {
            amount = seeds.getStackLimit();
        }
        if (itemBag.size()>0) {
            for(SeedsClass seed : itemBag) {
                if(seed.getName().equals(seeds.getName())) {
                    seed.addAmmount(amount);
                    found = true;
                    break;
                }
            }
        }
        if(!found && itemBag.size()<inventoryLimit) {
            seeds.setAmmount(amount);
            itemBag.add(seeds);
        }else if(!found && itemBag.size()>=inventoryLimit) {
            System.out.println("Inventory Full");
            inventoryFull = true;
        }
    }
    public void useSeeds(SeedsClass seeds) {
        for (SeedsClass seed : this.itemBag) {
            if (seed.equals(seeds)) {
                if (seed.getAmmount()>0){
                    seed.setAmmount(seed.getAmmount()-1);
                }if (seed.getAmmount()==0){
                    removeSeeds(seeds);
                    break;
                }
            }
        }
    }
    public int getInventoryLimit() {
        return inventoryLimit;
    }
    public void setInventoryLimit(int inventoryLimit) {
        this.inventoryLimit = inventoryLimit;
    }
    public boolean isInventoryFull() {
        return inventoryFull;
    }
    public void setInventoryFull(boolean inventoryFull) {
        this.inventoryFull = inventoryFull;
    }
    public void clearInventory() {
        itemBag.clear();
    }
    public void removeSeeds(SeedsClass seeds) {
        itemBag.remove(seeds);
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (SeedsClass seed : this.itemBag) {
            str.append("Seed: " + seed.getName() + " #");
            str.append(seed.getAmmount() + "\n");
        }
        return str.toString();
    }
}

