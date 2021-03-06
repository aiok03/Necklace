package com.company.repositories;

import com.company.entities.Stone;

import java.util.List;

public interface IStoneRepository {
    boolean createStone(Stone stone);
    Stone getStone(int id);
    List<Stone> getAllStones();
}
