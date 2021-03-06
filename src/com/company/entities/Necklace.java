package com.company.entities;

import java.util.ArrayList;

public class Necklace {
    private int id;     //Project has id, name, total cost of project and array list to collect all needed employees
    private int totalCost;
    private ArrayList<Stone> stoneList;
    private int id_gen=0;
    //constructors;getters and setter for all fields
    public Necklace(){
        id_gen++;
    }

    public Necklace( ArrayList<Stone> stoneList) {
        setStoneList(stoneList);
    }

    public int getId() {
        return id;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public ArrayList<Stone> getStoneList() {
        return stoneList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public void setStoneList(ArrayList<Stone> stoneList) {
        this.stoneList = stoneList;
    }
    //method toString from class Object
    @Override
    public String toString(){
        return "Necklace| Total cost: "+totalCost;
    }
}
