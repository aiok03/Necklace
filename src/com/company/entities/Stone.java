package com.company.entities;

public class Stone {
     private int id;
     private String name;
     private int weight;
     private int cost;
     boolean precious;
     public Stone(){

     }

    public Stone(int id, String name, int weight, int cost, boolean precious){
         setId(id);
         setName(name);
         setWeight(weight);
         setCost(cost);
         setPrecious(precious);
     }
    public Stone(String name,int weight,int cost,boolean precious){
        setName(name);
        setWeight(weight);
        setCost(cost);
        setPrecious(precious);
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    public int getWeight(){return weight;}
    public void setWeight(int weight){this.weight=weight;}
    public boolean isPrecious() {
        return precious;
    }

    public void setPrecious(boolean precious) {
        this.precious = precious;
    }


    @Override
    public String toString(){
        return "Stone "+id+"{ Name:"+name+", Weight: "+weight+", Cost: "+cost+", Precious: "+precious+ "}";
    }
}
