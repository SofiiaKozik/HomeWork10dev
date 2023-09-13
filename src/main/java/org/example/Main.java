package org.example;

public class Main {
    public static void main(String[] args) {
        ClientCrudService clientCrudService = new ClientCrudService();
        //clientCrudService.create("Kieran");
        //System.out.println(clientCrudService.read(5));
        //clientCrudService.delete(4);
        //clientCrudService.update("Jude", 5);
        //System.out.println(clientCrudService.read(5));
        PlanetCrudService planetCrudService = new PlanetCrudService();
        //planetCrudService.create("Pluton", "PLU");
        //System.out.println(planetCrudService.read("MARS"));
        planetCrudService.update("Ploo","PLU");
        //System.out.println(planetCrudService.read("PLU"));
        //planetCrudService.delete("PLU");
    }
}