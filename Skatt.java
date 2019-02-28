import javax.swing.JOptionPane;

/* Uppgift 8.4 i javaboken
 */

public class Skatt {

	public static double MOMS = 25;
	public static double ARB_AVG = 28.97;
	public static double STAT_LÅG = 0;
	public static double STAT_MEDEL = 20;
	public static double STAT_HÖG = 25;
	public static int LÅG = 1;
	public static int MEDEL = 2;
	public static int HÖG = 3;

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("Kommunalskatt i procent?");
		double kom = Double.parseDouble(input);
		input = JOptionPane.showInputDialog("Inkomstnivå? 1, 2 eller 3");
		int nivå = Integer.parseInt(input);
		while (true) {
			input = JOptionPane.showInputDialog("Önskat belopp?");
			if (input == null) {
				break;
			}
			double ö = Double.parseDouble(input);
			JOptionPane.showMessageDialog(null, "Begärt pris: " + beräknaSkatt(ö, kom, nivå));
		}
	}
	
	// Beräkar skatt utifrån olika parametrar
	public static double beräknaSkatt(double belopp, double kommunalskatt, int inkomstnivå) {
		double p;
		if (inkomstnivå == LÅG) {
			p = kommunalskatt + STAT_LÅG;
		} else if (inkomstnivå == MEDEL) {
			p = kommunalskatt + STAT_MEDEL;
		} else {
			p = kommunalskatt + STAT_HÖG;
		}
		double lön = belopp / (1 - 0.01 * p);
		double totalt = lön + lön * 0.01 * ARB_AVG;
		double inklMoms = totalt + totalt * 0.01 * MOMS;
		return inklMoms;
	}

}
