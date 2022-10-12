
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		HashSet<String> home = new HashSet<>();
		HashSet<String> away = new HashSet<>();
		ArrayList<String> team = new ArrayList<>();
		ArrayList<String> last = new ArrayList<>();
		ArrayList<String> reverse = new ArrayList<>();
		System.out.println("how much you want to add team ?"); // Kac tane takım olacağını gir
		int value = inputScanner.nextInt();
		int c = 0;
		while (c <= value) {
			System.out.print("Enter the name of the team: "); // Takımların ismini gir
			String b = inputScanner.next();
			team.add(b);
			System.out.println();
			c++;
			if (value % 2 == 0 && c == value) { // Eger takım sayısı cift hane ise öyle kalsın
				break;
			} else if (value % 2 != 0 && c == value) { // Eger takım sayısı tek ise bay ekle.
				team.add("Bay");
				break;
			}
		}
		System.out.println(team);
		System.out.println();
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
																// için.

						home.add(home1);
						away.add(away1);
					}
				}
				home.clear();
				away.clear();
				for (int i = last.size() / 2; i < last.size(); i++) { // Takım sayısının yarısını kadarını yazdırmak
																		// ıcın.
					System.out.println(last.get(i));
				}
			}
			if (j >= team.size()) {
				for (int i = reverse.size() / 2; i < reverse.size(); i++) { // İlk yarı bittikten sonraki fikstür için
																			// tekrardan takım sayısının yarısını
																			// yazdırmak için.
					System.out.println(reverse.get(i));
				}
			}
			System.out.println();
		}
	}

	static int rand(int a) {
		Random random = new Random();
		return random.nextInt(a);
	}
}
