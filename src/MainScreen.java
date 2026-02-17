//import java.awt.BorderLayout;
import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.Font;

public class MainScreen implements ActionListener
{
	private JFrame frame;
	private JButton button, button2, button3;
	private JLabel label;
	
	
	private static Sport[] sports = new Sport[5];
	private static Facility[] facilities = new Facility[5];
	private static TrainingProgram[] trainingPrograms = new TrainingProgram[10];
	private static Coach[] coachs = new Coach[5];
	private static ArrayList<Athlete> athleteList = new ArrayList<Athlete>();
    
	
	MainScreen()
	{
		//To GUI Για την πρωτη οθωνη
		frame = new JFrame();
		frame.setResizable(false);
		button = new JButton();
		button.setForeground(new Color(0, 0, 0));
		button.setBackground(new Color(255, 255, 255));
		button.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button2 = new JButton();
		button2.setForeground(new Color(0, 0, 0));
		button2.setBackground(new Color(255, 255, 255));
		button2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button3 = new JButton();
		button3.setForeground(new Color(0, 0, 0));
		button3.setBackground(new Color(255, 255, 255));
		button3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label = new JLabel("Διάλεξε μια από τις παρακάτω ενέργειες");
		label.setForeground(new Color(0, 0, 0));
		
		
		
		//logo PAPEI
		ImageIcon icon = new ImageIcon("UNIPI.jpg");
		
		
		
		label.setBounds(232,78,726,61);
		label.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		button3.setBounds(682,224,210,79);
		button3.setText("Διαχείριση Κρατήσεων");
		button3.addActionListener(this);
		button3.setFocusable(false);
		
		button2.setBounds(386, 224, 210, 79);
		button2.setText("Διαχείριση Συνδρομών");
		button2.addActionListener(this);
		button2.setFocusable(false);
		
		
		
		button.setBounds(96, 224, 210, 79);
		button.setText("Διαχείριση Αθλητών");
		button.addActionListener(this);
		button.setFocusable(false);
		button.setVerticalTextPosition(JButton.TOP);
		button.setHorizontalTextPosition(JButton.CENTER);
		

		frame.getContentPane().setBackground(new Color(230, 230, 230));
		frame.setIconImage(icon.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setSize(1000,500);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().add(button3);
		frame.getContentPane().add(button);
		frame.getContentPane().add(button2);
		frame.getContentPane().add(label);
		frame.setTitle("Διαχείση Αθλητικών Ακαδημιών");
		frame.setVisible(true);
		
		
		
		
		
		//Αρχικοποιηση των παρακάτω κλάσεων
		
		sports[0] = new Sport("football", false);
	    sports[1] = new Sport("basketball", false);
	    sports[2] = new Sport("volleyball", true);
	    sports[3] = new Sport("badminton", false);
	    sports[4] = new Sport("rugby", true);
	    
	    
	    facilities[0] = new Facility("Elite Performance Center", 120);
        facilities[1] = new Facility("Pro Fitness Hub", 150);
        facilities[2] = new Facility("Next Level Training Academy", 200);
        facilities[3] = new Facility("Champion's Gym", 100);
        facilities[4] = new Facility("Peak Athletic Complex", 180);
        
        coachs[0] = new Coach(0, "M", "F", "male", "15/3/1990" , "mfmath<3@gmail.com", sports[0], "Mathimatics");
        coachs[1] = new Coach(1, "Μήτσος", "Πόρφας", "male", "13/7/1993" , "Brawls43@gmail.com", sports[1], "TEFA");
        coachs[2] = new Coach(2, "Λαμπ", "Ζάρης", "male", "22/5/2001" , "roolem@gmail.com", sports[2], "TEFA");
        coachs[3] = new Coach(3, "Βάσια", "Λαστίχου", "female", "11/3/1986" , "velis6yt@gmail.com", sports[3], "History");
        coachs[4] = new Coach(4, "Βερόνικα", "Πεήδου", "female", "25/12/1991" , "lampradoros3@gmail.com", sports[4], "TEFA");
        
        
        
		
        trainingPrograms[0] = new TrainingProgram(0 , sports[0] , facilities[0], coachs[0], 1, false , "male", 45, "Monday");
        trainingPrograms[2] = new TrainingProgram(2 , sports[1] , facilities[1], coachs[1], 2, false , "male", 60, "Tuesday");
        trainingPrograms[4] = new TrainingProgram(4 , sports[2] , facilities[2], coachs[2], 3, false , "male", 30, "Wednesday");
        trainingPrograms[6] = new TrainingProgram(6 , sports[3] , facilities[3], coachs[3], 4, false , "male", 25, "Thursday");
        trainingPrograms[8] = new TrainingProgram(8 , sports[4] , facilities[4], coachs[4], 5, false , "female", 30, "Friday");
        trainingPrograms[1] = new TrainingProgram(1 , sports[0] , facilities[4], coachs[0], 1, true , "female", 40, "Monday");
        trainingPrograms[3] = new TrainingProgram(3 , sports[1] , facilities[3], coachs[1], 2, true , "female", 60, "Tuesday");
        trainingPrograms[5] = new TrainingProgram(5 , sports[2] , facilities[2], coachs[2], 3, true , "both", 90, "Saturday");
        trainingPrograms[7] = new TrainingProgram(7 , sports[3] , facilities[1], coachs[3], 4, true , "both", 90, "Thursday");
        trainingPrograms[9] = new TrainingProgram(9 , sports[4] , facilities[0], coachs[4], 2, true , "both", 45, "Friday");
		
		

	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()== button)
		{

			new AthleteScreen();
			frame.dispose();
		}
		else if(e.getSource() == button2)
		{
			new SubscriptionScreen();
			frame.dispose();
			
		}
		else if(e.getSource() == button3)
		{
			new Reservation_gui();
			frame.dispose();
			
		}
	}
	
	//Getters edw
	static public Coach[] getCoachs()
	{
		return coachs;
	}
	static public Facility[] getFacilities()
	{
		return facilities;
	}
	static public Sport[] getSport()
	{
		return sports;
	}
	public static TrainingProgram[] getTrainingProgram()
	{
		return trainingPrograms;
	}
}




