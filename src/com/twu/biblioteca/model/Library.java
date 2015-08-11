package com.twu.biblioteca.model;

import java.util.ArrayList;
import java.util.Objects;

public class Library {
    private ArrayList<Item> items;

    public Library(ArrayList<Item> items) {
        this.items = items;
    }

    public String listItemDetails() {
        String itemDetails = "";
        for (Item item : items) {
            if (item.getStatus()) {
                itemDetails += item.toString();
            }
        }
        return itemDetails;
    }

    public boolean checkoutItem(String itemName, User user) {
        for (Item item : items) {
            if (item.equals(itemName) && (item.getStatus())) {
                item.setStatus(false);
                item.setIssuedBy(user.details());
                return true;
            }
        }
        return false;
    }

    public boolean returnItem(String itemName, User user) {
        for (Item item : items) {
            if (isLiableToReturn(itemName, user, item)) {
                item.setStatus(true);
                return true;
            }
        }
        return false;
    }

    private boolean isLiableToReturn(String itemName, User user, Item item) {
        return item.equals(itemName) && !(item.getStatus()) && Objects.equals(user.getUserId(), item.getIssuedId());
    }

    public String checkedOutItemList() {
        String itemDetails = "";
        for (Item item : items) {
            if (!item.getStatus()) {
                itemDetails += item.getDetailsAlongWithIssuedBy();
            }
        }
        return itemDetails;
    }
}