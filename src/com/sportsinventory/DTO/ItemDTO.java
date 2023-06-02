package com.sportsinventory.DTO;

public class ItemDTO {

    private int itemID, quantity;
    private String name, condition;


    public int getItemID() { return itemID; }

    public void setItemID(int itemID) { this.itemID = itemID; }

    public String getItemName() { return name; }

    public void setItemName(String name) { this.name = name; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getCondition() { return condition; }

    public void setCondition(String condition) { this.condition = condition; }
}
