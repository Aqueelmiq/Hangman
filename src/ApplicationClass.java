import java.io.FileNotFoundException;


public class ApplicationClass {

	public static void main(String[] args) {
		Menu menu = new Menu();
		try {
			menu.mainMenu();
		} catch (FileNotFoundException e) {
			System.out.println("Please check if ou have the default file loaded in the source folder");
		}

	}

}
