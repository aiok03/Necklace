package com.company.controllers;

import com.company.entities.Necklace;
import com.company.entities.Stone;
import com.company.repositories.INecklaceRepository;


import java.util.ArrayList;

public class NecklaceController {
    private final INecklaceRepository repo;
    public NecklaceController(INecklaceRepository repo) {
        this.repo = repo;
    }
    public String createNecklace(ArrayList<Stone> stoneList){

        Necklace necklace = new Necklace(stoneList);
        return "Necklace was created";
    }

    public String getNecklace(Necklace necklace){
        Necklace necklace1 = repo.getNecklace(necklace);

        return (necklace1 == null ? "Necklace didn't found" : necklace1.toString()); /*if project is not created return
                                                                                        that statement*/
    }

    public int totalCost(){
        return repo.totalCost();
    }  //

    public ArrayList<Necklace> getAllNecklaces(){
        ArrayList<Necklace> necklaces = repo.getAllNecklaces();
        return necklaces;
    }

    public void setNecklace(Necklace necklace){
        repo.createNecklace(necklace);
    }
}
