package com.blueJ;
public class Main{

    public static void main(String[] args){
        
        int preis = 105;	// Preis des Produkts in Rappen
		int bezahlt = 500;	// Eingeworfener Betrag in Rappen
		
		// Dein Code
		int rueckgeld = bezahlt - preis;
		
		System.out.println("Preis: " + preis + " Rappen");
		System.out.println("Erhalten: " + bezahlt + " Rappen");
		System.out.println("Rückgeld: " + rueckgeld + " Rappen");
		
        int fuenfer = rueckgeld / 500;
		rueckgeld %= 500;
		int zweier = rueckgeld / 200;
		rueckgeld %= 200;
		int einer = rueckgeld / 100;
		rueckgeld %= 100;
		int fuenfziger = rueckgeld / 50;
		rueckgeld %= 50;
		int zwanziger = rueckgeld / 20;
		rueckgeld %= 20;
		int zehner = rueckgeld / 10;
		rueckgeld %= 10;
		int fuenferchen = rueckgeld / 5;
		rueckgeld %= 5;
		
		System.out.println("5 FR: " + fuenfer + " Stück");
		System.out.println("2 FR: " + zweier + " Stück");
		System.out.println("1 FR: " + einer + " Stück");
		System.out.println("50 Rp: " + fuenfziger + " Stück");
		System.out.println("20 Rp: " + zwanziger + " Stück");
		System.out.println("10 Rp: " + zehner + " Stück");
		System.out.println("5 Rp: " + fuenferchen + " Stück");

    }
}