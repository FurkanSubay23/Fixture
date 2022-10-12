package Fixt;

import java.net.Socket;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Fixture {

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		HashSet<String> home = new HashSet<>();
		HashSet<String> away = new HashSet<>();
		ArrayList<String> team = new ArrayList<>();
		ArrayList<String> last = new ArrayList<>();
		ArrayList<String> reverse = new ArrayList<>();
		team.add("Galatasaray");
		team.add("Fener");
		team.add("Besiktas");
		team.add("Trabzon");
		team.add("Elazig");
		team.add("Real madrid");
		team.add("Manchester");
		team.add("Barcelona");

		/*
		 * System.out.println("how much you want to add team ?"); // Kac tane takım
		 * olacağını gir int value = inputScanner.nextInt(); int c = 0; while (c <=
		 * value) { System.out.print("Enter the name of the team: "); // Takımların
		 * ismini gir String b = inputScanner.next(); team.add(b); System.out.println();
		 * c++; if (value % 2 == 0 && c == value) { // Eger takım sayısı cift hane ise
		 * öyle kalsın break; } else if (value % 2 != 0 && c == value) { // Eger takım
		 * sayısı tek ise bay ekle. team.add("Bay"); break; } }
		 */
		System.out.println(team);
		System.out.println();
		int d = 0;
		for (int j = 1; j <= team.size() * 2 - 2; j++) {
			System.out.println("Round: " + j);
			if (j < team.size()) {
				while (last.size() != j * team.size() / 2) { // İlk roundda yazdırılacak takımların sayısı için.
					String home1 = team.get(rand(team.size()));
					String away1 = team.get(rand(team.size()));
					while (home1.equals(away1)) { // Birbirine eşit ise boz.
						home1 = team.get(rand(team.size()));
						away1 = team.get(rand(team.size()));
					}
					if (!last.contains(home1 + " vs " + away) && !home.contains(home1) && !away.contains(away1)
							&& !away.contains(home1) && !home.contains(away1)) { // o verilerin listlerde olup
																					// olmadığını bul, yoksa ekle varsa
																					// boz.
						last.add(home1 + " vs " + away1);
						reverse.add(away1 + " vs " + home1); // o verileri tersten ekleme, tekrardan fiksturu yazdırmak
						// System.out.println(last.size()); // için.
						/*
						 * System.out.println(last.get(j - 1)); System.out.println(reverse.get(j - 1));
						 * System.out.println(); System.out.println("##############");
						 */
						home.add(home1);
						away.add(away1);
					}
				}
				home.clear();
				away.clear();
				for (int i = last.size() - team.size() / 2; i < last.size(); i++) {
					System.out.println(last.get(i));
				}
				System.out.println();
			}
			if (j >= team.size()) {
				for (int i = 0; i < team.size() / 2; i++) {
					System.out.println(reverse.get(d));
					d++;
				}
				System.out.println();
			}

		}
	}

	static int rand(int a) {
		Random random = new Random();
		return random.nextInt(a);
	}
}
