import javax.swing.JOptionPane;

/* Uppgift 8.4 i javaboken
 */

public class Skatt {

	public static double MOMS = 25;
	public static double ARB_AVG = 28.97;
	public static double STAT_L�G = 0;
	public static double STAT_MEDEL = 20;
	public static double STAT_H�G = 25;
	public static int L�G = 1;
	public static int MEDEL = 2;
	public static int H�G = 3;

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("Kommunalskatt i procent?");
		double kom = Double.parseDouble(input);
		input = JOptionPane.showInputDialog("Inkomstniv�? 1, 2 eller 3");
		int niv� = Integer.parseInt(input);
		while (true) {
			input = JOptionPane.showInputDialog("�nskat belopp?");
			if (input == null) {
				break;
			}
			double � = Double.parseDouble(input);
			JOptionPane.showMessageDialog(null, "Beg�rt pris: " + ber�knaSkatt(�, kom, niv�));
		}
	}
	
	// Ber�kar skatt utifr�n olika parametrar
	public static double ber�knaSkatt(double belopp, double kommunalskatt, int inkomstniv�) {
		double p;
		if (inkomstniv� == L�G) {
			p = kommunalskatt + STAT_L�G;
		} else if (inkomstniv� == MEDEL) {
			p = kommunalskatt + STAT_MEDEL;
		} else {
			p = kommunalskatt + STAT_H�G;
		}
		double l�n = belopp / (1 - 0.01 * p);
		double totalt = l�n + l�n * 0.01 * ARB_AVG;
		double inklMoms = totalt + totalt * 0.01 * MOMS;
		return inklMoms;
	}

}
