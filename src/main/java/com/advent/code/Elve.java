package com.advent.code;

import java.util.List;

public class Elve {

    private List<Items> itemsCarried;

    public Elve(List<Items> itemsCarried) {
        this.itemsCarried = itemsCarried;
    }

    public List<Items> getItemsCarried() {
        return itemsCarried;
    }

    public void setItemsCarried(List<Items> itemsCarried) {
        this.itemsCarried = itemsCarried;
    }
}
