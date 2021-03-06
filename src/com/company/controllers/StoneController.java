package com.company.controllers;

import com.company.entities.Stone;
import com.company.repositories.IStoneRepository;

import java.util.ArrayList;
import java.util.List;

public class StoneController {
    private final IStoneRepository repo;
    public StoneController(IStoneRepository repo){
        this.repo=repo;
    }
    public String createStone(String name, int weight, int cost, boolean precious) {

         Stone stone=new Stone(name,weight,cost,precious);


        boolean created = repo.createStone(stone);

        return (created ? "Stone creation was failed!" : "Stone was created!");
    }

    public String getStone(int id) {
        Stone stone = repo.getStone(id);

        return (stone == null ? "Stone was not found!" : stone.toString());
    }

    public String getAllStones() {
        List<Stone> stones = repo.getAllStones();
        return stones.toString();
    }
    public ArrayList<Stone> getAllStonesList(){

        return (ArrayList<Stone>) repo.getAllStones();
    }

}
