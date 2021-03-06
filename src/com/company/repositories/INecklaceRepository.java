package com.company.repositories;

import com.company.entities.Necklace;
import com.company.entities.Stone;

import java.util.ArrayList;

public interface INecklaceRepository {

    void createNecklace(Necklace necklace);
    void addStone(Stone stone);
    int totalCost();
    Necklace getNecklace(Necklace necklace);
    ArrayList <Necklace> getAllNecklaces();

}
