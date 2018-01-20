package bcpack;

public class Item {

    private String name;
    private String rarity;
    private int minStr;
    private int maxStr;
    private int currStr;

    public Item(String pName, String pRarity, int pMinStr, int pMaxStr){
        this.setName(pName);
        this.setRarity(pRarity);
        this.setMinStr(pMinStr);
        this.setMaxStr(pMaxStr);
        this.setCurrStr(0);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public int getMinStr() {
        return minStr;
    }

    public void setMinStr(int minStr) {
        this.minStr = minStr;
    }

    public int getMaxStr() {
        return maxStr;
    }

    public void setMaxStr(int maxStr) {
        this.maxStr = maxStr;
    }

    public int getCurrStr() {
        return currStr;
    }

    public void setCurrStr(int currStr) {
        this.currStr = currStr;
    }
}
