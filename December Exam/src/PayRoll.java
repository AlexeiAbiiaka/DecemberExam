
/* **********************************************************
 * Programmer:	r.sveinson
 * Class:		CS30S
 * 
 * Assignment:	a3  q1
 *
 * Description:	this program will calculate the gross pay for an 
 *				employee
 *
 * Input:		id, hours worked, hourly wage
 *
 * Output:		id, hours, wage, regular pay, overtime pay, gross pay
 * *************************************************************
 */

// import files here as needed

// needed for dialog box i/o
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JOptionPane;

public class PayRoll { // begin class
	private static NumberFormat format = new DecimalFormat("$#,###.##");
	public static void main(String[] args) throws Exception { // begin main
																// ********** declare constants **********

		final int MAXHOUR = 40; // maximum hours before overtime
		final double OTRATE = 1.5; // overtime is time and a half

		// *********** declare variables **********

		String strin; // input string
		String strout; // output string
		String delim = "[ ]+"; // set delimiter to space

		int id = 1000; // employee id number
		int hours; // number of hours worked
		double rate; // hourly pay rate

		double regPay; // regular pay
		double otPay; // overtime pay
		double grossPay; // gross pay
		int otHours = 0; // number of overtime hours worked

		// create a console reader to get input from keyboard

		ConsoleReader console = new ConsoleReader(PayRoll.class.getResourceAsStream("payrollData.txt"));

		// ***** create output banner for message dialog *****

		strout = "*********************************\n";
		strout += "NAME:		r.sveinson\n";
		strout += "CLASS:		CS30S\n";
		strout += "ASSIGNMENT:	A3 Q1\n";
		strout += "**********************************\n";

		// ******** print banner **********

		System.out.println("*********************************");
		System.out.println("NAME:		r.svienson");
		System.out.println("CLASS:		CS30S");
		System.out.println("ASSIGNMENT:	A3 Q1");
		System.out.println("**********************************");

		// to message dialog

		JOptionPane.showMessageDialog(null, strout);

		// ********** get input **********

		//System.out.println("enter id, hours, wage");
		System.out.println("Id\t\tHours\t\tRate\t\tRegular Pay\tOvertime Pay\tGross Pay");
		while ((strin = console.readLine()) != null) {
			// System.out.println(strin);

			String tokens[] = strin.split(delim);
			if (tokens.length!=2)
				continue;

			id++;
			// id = Integer.parseInt(tokens[0]);
			rate = Double.parseDouble(tokens[0]);
			hours = Integer.parseInt(tokens[1]);

			// System.out.println("id " + id + " hours " + hours + " wage " + rate);

			// ********** calculations **********

			if (hours > MAXHOUR) { // begin ot pay
									// System.out.println("overtime pay");
				otHours = hours - MAXHOUR; // calculate overtime hours
				otPay = otHours * rate * OTRATE; // calculate overtime pay
				regPay = MAXHOUR * rate; // calculate regular pay
			} // end ot Pay
			else { // begin no ot
					// System.out.println("no overtime pay");
				regPay = hours * rate; // calculate regular pay
				otPay = 0; // set otPay to 0
				/*
				 * System.out.println("otHours = " + otHours); System.out.println("otPay = " +
				 * otPay); System.out.println("regPay = " + regPay);
				 * System.out.println("grossPay = " + grossPay);
				 */

			} // end no ot

			// *** calculate the total pay ****

			grossPay = regPay + otPay; // calculate gross pay

			// ********** output **********

			System.out.print(id + "\t\t");
			System.out.print(hours + "\t\t");
			System.out.print(format(rate) + "\t\t");
			System.out.print(format(regPay) + "\t\t");
			System.out.print(format(otPay) + "\t\t");
			System.out.println(format(grossPay));

		}

		// ********** closing message **********
		System.out.println("end of processing");

	} // end main

	private static String format(double num) {
		return format.format(num);
	}
} // end class
