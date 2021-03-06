package com.company;

import com.company.data.IDB;
import com.company.data.PostgresDB;
import com.company.repositories.INecklaceRepository;
import com.company.repositories.IStoneRepository;
import com.company.repositories.NecklaceRepository;
import com.company.repositories.StoneRepository;

public class Main {

    public static void main(String[] args) {
	// write your code here
         //executing console app
            IDB db = new PostgresDB();

            IStoneRepository repo=new StoneRepository(db);
            INecklaceRepository repo1=new NecklaceRepository(db);

            Application app = new Application(repo,repo1);

            app.start();


    }
}
