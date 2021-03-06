package com.company;

import com.company.controllers.NecklaceController;
import com.company.controllers.StoneController;
import com.company.entities.Necklace;
import com.company.entities.Stone;
import com.company.repositories.INecklaceRepository;
import com.company.repositories.IStoneRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    private final StoneController controller;
    private final NecklaceController necklaceController;
    private final Scanner scanner;

    public Application(IStoneRepository stoneRepository, INecklaceRepository repo) {
        controller = new StoneController(stoneRepository);
        necklaceController = new NecklaceController(repo);
        scanner = new Scanner(System.in);
    }

    public void start() {  //head method that contains all menu methods
        while (true) {
            System.out.println();
            System.out.println("Welcome!");
            System.out.println("Select option:");
            System.out.println("1. Get all stones");
            System.out.println("2. Get stone by id");
            System.out.println("3. Add stone");
            System.out.println("4. Create necklace");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-4): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllStonesMenu();
                } else if (option == 2) {
                    getStoneByIdMenu();
                } else if (option == 3) {
                    createStoneMenu();
                } else if (option == 4) {
                    createNecklaceMenu();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }

            System.out.println("*************************");

        }
    }

    public void getAllStonesMenu() {
        String response = controller.getAllStones();
        System.out.println(response);
    }

    public void getStoneByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getStone(id);
        System.out.println(response);
    }

    public void createStoneMenu() {
        System.out.println("Please enter the name of stone (diamond,ruby,sapphire,etc.)");
        String name = scanner.next();
        System.out.println("Please enter weight of the stone (carat)");
        int weight=scanner.nextInt();
        System.out.println("Please enter cost of the stone");
        scanner.nextLine();
        int cost=scanner.nextInt();
        System.out.println("Is this stone precious(true/false)?");
        boolean precious=scanner.nextBoolean();
        String response = controller.createStone(name, weight,cost,precious);
        System.out.println(response);
    }

    public void createNecklaceMenu() {
        System.out.println("Enter the number of stones that make up the necklace. Then enter stone's ids (2 1 2):");
        scanner.nextLine();
        int n = scanner.nextInt();   //get number of employees
        int[] id = new int[n]; //creating an array
        for (int i = 0; i < n; i++) {
            id[i] = scanner.nextInt();  //get identifiers from console
        }
        ArrayList<Stone> stoneList = new ArrayList<Stone>();
        ArrayList<Stone> necklaceStoneList = new ArrayList<Stone>();  //for inputted identifiers
        stoneList = controller.getAllStonesList();  //all list of employees
        System.out.println("Stone list:");
        for (int i = 0; i < stoneList.size(); i++) {
            for (int j = 0; j < n; j++) {
                if (stoneList.get(i).getId() == id[j]) {   //find only inputted employees by id and add it
                    necklaceStoneList.add(stoneList.get(i));
                    System.out.println(stoneList.get(i).toString());

                }
            }
        }

        Necklace necklace=new Necklace(stoneList);
        necklaceController.setNecklace(necklace);
        System.out.println("Total cost of your necklace: "+necklaceController.totalCost()+" KZT");

    }
}
