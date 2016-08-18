import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		int a, b;
		double suma = 0;
		String linia;
		String kwota;
		double dKwota;
		File f;
		try
		{
			f = new File(args[0]);
		}
		catch( Exception e)
		{
			f = new File("Plik z danymi.txt");
		}
		
		Scanner sc = new Scanner(f);

		do {
			linia = sc.nextLine();
			a = linia.indexOf("@amount:");
			b = linia.indexOf("PLN");
			if (a != -1) {
				a += 8;
				kwota = linia.substring(a, b);
				kwota = kwota.replace(",", ".");
				dKwota = Double.parseDouble(kwota);
				suma += dKwota;
			}
		} while (sc.hasNextLine());
		
		System.out.printf("Suma kwot to: %.2fPLN\n", suma);
	}
	
	public double liczSume(File file) throws FileNotFoundException
	{
		int a, b;
		double suma = 0;
		String linia;
		String kwota;
		double dKwota;
		File f = file;

		Scanner sc = new Scanner(f);

		do {
			linia = sc.nextLine();
			a = linia.indexOf("@amount:");
			b = linia.indexOf("PLN");
			if (a != -1) {
				a += 8;
				kwota = linia.substring(a, b);
				kwota = kwota.replace(",", ".");
				dKwota = Double.parseDouble(kwota);
				suma += dKwota;
			}
		} while (sc.hasNextLine());
		
		return suma;
	}

}
