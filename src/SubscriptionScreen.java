import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SubscriptionScreen implements ActionListener {
	private JFrame frame; //Δήλωση frame για το gui
    private JButton epistrofi, akirosi, pliromi; //Δήλωση των 3 κουμπιών
    private JComboBox<String> program1; //Δήλωση του JComboBox που εμφανίζει τα προγράμματα εκμάθησης
    private DefaultTableModel tableModel; //Δήλωση του τύπου του πίνακα το οποίο θα εμφανίζει τους αθλητές που θα κάνουν Subscription
    private JTable table; ///Δήλωση του πίνακα ο οποίος μετά θα εμφανίζει όλους τους αθλητές οι οποίες έχουν πλήρωση ένα ή περισσότερα προγράμματα εκπαίδευσης
    private JComboBox<?> athleteBox; //Δήλωση του JComboBox που εμφανίζει τους αθλητές που έχουν κάνει εγγραφή
    private String athleteOptions[] = new String[AthleteScreen.getAthleteList().size()];//Δήλωση των ονομάτων  των αθλητών που κάνουν εγγραφή
    private String athleteFirstNames[] = new String[AthleteScreen.getAthleteList().size()];//Δήλωση των επιθέτων των αθλητών που κάνουν εγγραφή
    private static ArrayList<Subscription> Pliromilist = new ArrayList<Subscription>();//Δημιουργία ενός arraylist το οποίο θα αποθηκεύει όλα τα Subscription
    private static int numOfSubs = 0;//Αρχικοποίηση ενός μετρητή που θα μετράει τον αριθμό των συνδρομών


    SubscriptionScreen() {//Δημιουργία του constructor ο οποίος εμφανίζει την οθόνη Subscription

        frame = new JFrame();//Δημιουργία του frame της οθόνης με ονόμα διαχείριση συνδρομών.
    	ImageIcon icon = new ImageIcon("UNIPI.jpg");//Εικόνα frame
        frame.setIconImage(icon.getImage());//Εκχώρηση εικόνες στο frame
		frame.setTitle("Διαχείριση Συνδρομών");//Ονόμα frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Κλείσιμο του frame
		frame.setVisible(true);//Εμφάνιση του frame
		frame.getContentPane().setBackground(new Color(230, 230, 230));//Χρώμα του frame
		frame.setSize(1480,900);//Διαστασεις του frame
		frame.setLocationRelativeTo(null);//Εμφάνιση του frame στην μεσι της οθονης
		
        //Δημιουργία ενός borderLayout στο οποίο εισάγουμε το frame
		BorderLayout borderLayout = new BorderLayout();
		frame.getContentPane().setLayout(borderLayout);
    	
        //Δημιουργία ενός χώρου (JPanel) στο οποίο θα υπάρχουν τα 3 κουμπιά της οθόνη
    	JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(100, 110));
        bottomPanel.setLayout(null);
        bottomPanel.setBackground(new Color(230, 230, 230));
        frame.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        
        //Δημιουργία ενός χώρου (JPanel) στο οποίο θα υπάρχουν τα JComboBox στα οποία θα πρέπει να διαλέξει αθλητή και εκπαιδευτικό πρόγραμμα
        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(650, 100));
        rightPanel.setLayout(null);
        rightPanel.setBackground(new Color(230, 230, 230));
        frame.getContentPane().add(rightPanel, BorderLayout.EAST);
    	
    	//Δημιουργία 3 κουμπιών, Πληρωμή, Διαγραφή και Επιστροφή και οι χαρακτηριστικές τους δηλώσεις (η λειτουργία τους θα αναφερθεί λίγο πιο κάτω)
        //Κουμπί Πληρωμή
        pliromi = new JButton("Πληρωμή");
        pliromi.setFont(new Font("Tahoma", Font.PLAIN, 17));
        pliromi.setBounds(339, 28, 175, 50);
        bottomPanel.add(pliromi);
        pliromi.addActionListener(this);
        pliromi.setFocusable(false);

        //Κουμπί Διαγραφή
        akirosi = new JButton("Διαγραφή");
        akirosi.setFont(new Font("Tahoma", Font.PLAIN, 17));
        akirosi.setBounds(644, 28, 175, 50);
        bottomPanel.add(akirosi);
        akirosi.addActionListener(this);
        akirosi.setFocusable(false);

        //Κουμπί Επιστροφή
        epistrofi = new JButton("Επιστροφή");
        epistrofi.setFont(new Font("Tahoma", Font.PLAIN, 17));
        epistrofi.setBounds(966, 28, 175, 50);
        bottomPanel.add(epistrofi);
        epistrofi.addActionListener(this);
        epistrofi.setFocusable(false);

        //Δημιουργία 2 JLabel τα οποία θα προσδιορίζουν το περιεχόμενο των 2 JComboBox
        JLabel lblNewLabe = new JLabel("Αθλητή");
        lblNewLabe.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabe.setBounds(21, 63, 188, 71);

        JLabel lblNewLabel_2 = new JLabel("Πρόγραμμα Εκπαίδευσης");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_2.setBounds(11, 188, 188, 55);


        //Δημιουργία του πρώτου JComboBox το  οποίο θα εμφανίζει όλους τους αθλητές που έχουν κάνει εγγραφή στο προηγούμενο παράθυρο, ώστε να επιλεχθούν για να κάνουν πλέον πληρωμή
        for (int i = 0; i < AthleteScreen.getAthleteList().size(); i++) {
            athleteOptions[i] = AthleteScreen.getAthleteList().get(i).getFirstName() + " "
                    + AthleteScreen.getAthleteList().get(i).getLastName();
            athleteFirstNames[i] = AthleteScreen.getAthleteList().get(i).getFirstName();
        }
        athleteBox = new JComboBox<>(athleteOptions);
        athleteBox.setFocusable(false);
        athleteBox.addActionListener(athleteBox);
        athleteBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
        athleteBox.setBounds(209, 78, 414, 40);
       
        //Δημιουργία του δεύτερου JComboBox το  οποίο θα εμφανίζει όλα τα αθλητικά προγράμματα που προσφέρει η υπηρεσία
        String[] programs = { "football-Elite Performance Center", "football-Peak Athletic Complex",
                "basketball-Pro Fitness Hub", "basketball-Champion's Gym",
                "volleyball-Next Level Training Academy-Wednesday", "volleyball-Next Level Training Academy-Saturday",
                "badminton-Champion's Gym", "badminton-Pro Fitness Hub", "rugby-Peak Athletic Complex",
                "rugby-Elite Performance Center" };
        program1 = new JComboBox<>(programs);
        program1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        program1.setBounds(209, 198, 414, 40);
       
        //Εκχώρηση των 2 JLabel και των 2 JComboBox στο  rightPanel
        rightPanel.add(program1);
        rightPanel.add(athleteBox);
        rightPanel.add(lblNewLabe);
        rightPanel.add(lblNewLabel_2);

        //Δημιουργία του πίνακα, ο οποίος θα περιέχει όλους τους αθλητές που έχουν κάνει πληρωμή σε ένα πρόγραμμα εκπαίδευσης
        String[] namess = { "ID", "Athlete", "Program", "Cost" };
        tableModel = new DefaultTableModel(namess, 0);
        table = new JTable(tableModel);
        table.setBounds(34, 22, 812, 700);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 818, 726);
        frame.getContentPane().add(scrollPane);
        table.getTableHeader().setReorderingAllowed(false);
        table.setDefaultEditor(Object.class, null);
        table.removeEditor();
        
        

        //Εκχώρηση στοιχείων του αθλητή σε ένα Arraylist tο οποίο θα μεταβιβάσει τα στοιχεία τους στην επόμενη οθόνη
        Object[] newRow2 = new Object[4]; 
		for (int i = 0; i < Pliromilist.size(); i++) 
		{
			newRow2[0] = Pliromilist.get(i).getId();
			newRow2[1] = Pliromilist.get(i).getAthlete().getFirstName() + " " + Pliromilist.get(i).getAthlete().getLastName();
			newRow2[2] = Pliromilist.get(i).getTrainingProgram().getSport().getName() + "-" + Pliromilist.get(i).getTrainingProgram().getFacility().getName();
			newRow2[3] = Pliromilist.get(i).getCost();
			tableModel.addRow(newRow2);
		}
		
		}
    
    //Δημιουργία μιας μεθόδουη οποία ελέγχει κάθε φορά που ο χρήστης πατάει ένα από τα 3 κουμπιά και κάνει την αντίστοιχη λειτουργία
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == pliromi) {//Αν πατήσει το κουμπί πληρωμή τοτε
            int program = program1.getSelectedIndex();
            int currentAthlete = athleteBox.getSelectedIndex();
            String program2 = (String) program1.getSelectedItem();

            //Βρίσκει τη θέση του αθλητή στο arraylist και την αποθηκεύει
            int athletePosition = 0;
            for (int i = 0; i < AthleteScreen.getAthleteList().size(); i++) {
                if (athleteFirstNames[currentAthlete] == AthleteScreen.getAthleteList().get(i).getFirstName()) {
                    athletePosition = i;
                }
            }
            TrainingProgram[] obj = MainScreen.getTrainingProgram();//(δεν θημαμε:()
            
            //Βρίσκουμε και το φύλο του αθλητή, δηλαδή αν είναι άντρας η γυναίκα και το αποθηκεύει
            String tmpGender = "male";
            if(AthleteScreen.getAthleteList().get(athletePosition).getGender() == "Γυνέκα")
            {
            	tmpGender = "female";
            }
            //Βρίσκουμε αν ο χρήστης έχει εγγραφεί σε κάποιο πρόγραμμα εκπαίδευσης και το αποθηκεύει
            boolean flag = true;
            for (int i = 0; i < Pliromilist.size(); i++)
            {
            	
            	if (Pliromilist.get(i).getAthlete().getId() == AthleteScreen.getAthleteList().get(athletePosition).getId() && Pliromilist.get(i).getTrainingProgram().getId() == obj[program].getId())
            	{
            		flag = false;
            	}
            
            }

            if(flag)//Αν δεν έχει ήδη εγγραφεί τότε
            {
	            if (AthleteScreen.getAthleteList().get(athletePosition).getExperienceLevel() >= obj[program].getMinexperience() && (tmpGender == obj[program].getGender() ||  obj[program].getGender() == "both"))//Έλεγχος για το αν ο αθλητής τηρεί τις προϋποθέσεις εγγραφής στο συγκεκριμένο πρόγραμμα εκπαίδευσης δηλαδή φίλο και εμπειρία
	            {
	            	String subId = "" + AthleteScreen.getAthleteList().get(athletePosition).getId() + "_" + "" + obj[program].getId() + "_" + "" + numOfSubs;//Δημιουργία κωδικού πληρωμής
	            	
		            Subscription sud = new Subscription(subId ,AthleteScreen.getAthleteList().get(athletePosition), obj[program],AthleteScreen.getEnrollmentList().get(athletePosition).getCost()* (100 - AthleteScreen.getEnrollmentList().get(athletePosition).getDiscount()) / 100);//Δημιουργία νέας κλάσης πληρωμής Subscription με όλα τα απαραίτητα στοιχεία του αθλητή και το κόστος
		            tableModel.addRow(new Object[] {subId, AthleteScreen.getAthleteList().get(athletePosition).getFirstName()+ " " +AthleteScreen.getAthleteList().get(athletePosition).getLastName(), program2, AthleteScreen.getEnrollmentList().get(athletePosition).getCost() * (100 - AthleteScreen.getEnrollmentList().get(athletePosition).getDiscount()) / 100 });//Εκχώρηση της πληρωμής στο ταμπλ
		            Pliromilist.add(sud);//Εκχώρηση της πληρωμής στο ArrayList
		            numOfSubs++;//Αύξηση μετρητή
	            }
	            else//Αλλιώς εμφανίζει error
	            {
	            	JOptionPane.showMessageDialog(null, "αυτός ο χρήστης απαγορεύεται να εγγραφεί σε αυτό το πρόγραμμα εκπαίδευσης", "Warning", JOptionPane.WARNING_MESSAGE);
	            }
            }
            else//Αλλιώς εμφανίζει error 
            {
            	JOptionPane.showMessageDialog(null, "Αυτός ο αθλητής έχει ήδη γραφτεί σε αυτό το πρόγραμμα εκπαίδευσης", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } 

        if (e.getSource() == akirosi) {//Αν πατήσει το κουμπί ακυρωση τοτε
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {//Ελέγχει εάν ο χρήστης έχει επιλέξει άτομο που υπάρχει μέσα στο τέιμπλ των αθλητών, αν όχι, τότε εμφανίζει error
                JOptionPane.showMessageDialog(null, "Πρέπει να επιλέξεις έναν αθλητή!", "Warning",JOptionPane.WARNING_MESSAGE);
            } else {//Αν έχει επιλέξει άτομα μέσα στο ταμπλ  τότε τον διαγράφει
                tableModel.removeRow(selectedRow);
                Pliromilist.remove(selectedRow);
            }
        }
        if (e.getSource() == epistrofi) {//Αν πατήσει το κουμπί επιστροφη τοτε επιστρέφει πίσω στην MainScreen
            new MainScreen();
            frame.dispose();
        }
    }

    
	 static public ArrayList<Subscription> getPliromilist() {//(δεν θημαμε:()
		return Pliromilist;
	}
}
