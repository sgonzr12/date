package es.unileon.prg1.date;

public class MainDate {

	public static void main(String[] args) {
		try {
			MenuOpciones menu = new MenuOpciones();


		} catch (DateException e) {
			System.out.println(e.getMessage());
		}
	}

}