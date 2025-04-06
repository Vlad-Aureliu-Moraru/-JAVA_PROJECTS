public class PlayerClass {
    private String name;
    private int level=1;
    private int experience=0;
    private int maxExperience;
    private int maxLevel;
    private int Coins=0;
    private int Gems=0;
    private SeedsClass equipedSeeds;

    private ToolClass equipedTool;
    private Inventory inventory = new Inventory();
    private InventoryCollected inventoryCollected = new InventoryCollected();
    private GamePanel gamePanel;
    private InventoryPanel inventoryPanel;
    private InventoryCollectedPanel inventoryCollectedPanel;


    public PlayerClass() {
    }

    public void setInventoryCollectedPanel(InventoryCollectedPanel inventoryCollectedPanel) {
        this.inventoryCollectedPanel = inventoryCollectedPanel;
    }
    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        System.out.println(gamePanel==null);
    }
    public void setInventoryPanel(InventoryPanel inventoryPanel) {
        this.inventoryPanel = inventoryPanel;
        System.out.println(inventoryPanel==null);
    }
    public void setEquipedTool(ToolClass equipedTool) {
        this.equipedTool = equipedTool;
    }
    public ToolClass getEquipedTool() {
        return equipedTool;
    }

    public int getCoins() {
        return Coins;
    }

    public int getExperience() {
        return experience;
    }

    public int getGems() {
        return Gems;
    }

    public int getLevel() {
        return level;
    }

    public int getMaxExperience() {
        return maxExperience;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public String getName() {
        return name;
    }
    public void setCoins(int coins) {
        Coins = coins;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
    public void setGems(int gems) {
        Gems = gems;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void setMaxExperience(int maxExperience) {
        this.maxExperience = maxExperience;
    }
    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Inventory getInventory() {
        return inventory;
    }
    public InventoryCollected getInventoryCollected() {
        return inventoryCollected;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    public void addToInventory(SeedsClass seedsClass , int amount) {
        System.out.println("Adding " + amount + " " + seedsClass.getName());
        this.inventory.addSeeds(seedsClass,amount);
        if (inventoryPanel != null) {
            inventoryPanel.updateInventory();
        }else {
            System.out.println("InventoryPanel is null");
            System.out.println(gamePanel==null);
        }

    }
    public void addToInventoryCollected(SeedsClass seedsClass , int amount) {
        System.out.println("Adding " + amount + " " + seedsClass.getName());
        this.inventoryCollected.addSeeds(seedsClass,amount);
        if (inventoryCollectedPanel!= null) {
            inventoryCollectedPanel.updateInventory();
        }else {
            System.out.println("InventoryPanel is null");
            System.out.println(gamePanel==null);
        }

    }
    public void useSeedFromInventory(SeedsClass seedsClass) {
        System.out.println("Use seed from inventory");
        inventory.useSeeds(seedsClass);
        if (!inventory.getSeeds().contains(seedsClass)) {
            setEquipedSeeds(null);
        }
        if (inventoryPanel != null) {
            inventoryPanel.updateInventory();
        }else {
            System.out.println("No inventory found");
        }
    }
    public void clearInventory() {
        this.inventory.clearInventory();
        if (inventoryPanel != null) {
            inventoryPanel.updateInventory();
            equipedSeeds = null;
        }else {
            System.out.println("No inventory found");
        }
    }
    public SeedsClass getEquipedSeeds() {
        return equipedSeeds;
    }
    public void setEquipedSeeds(SeedsClass equipedSeeds) {
        this.equipedSeeds = equipedSeeds;
    }


    public InventoryCollectedPanel getInventoryCollectedPanel() {
        return inventoryCollectedPanel;
    }

}
