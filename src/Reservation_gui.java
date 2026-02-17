//ΕΙΣΑΓΩΓΗ ΤΩΝ ΑΠΑΡΑΙΤΗΤΩΝ ΠΑΚΕΤΩΝ
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Reservation_gui implements ActionListener

{
	// ΔΗΛΩΣΗ BUTTONS, TEXT_FIELDS, TABLE, COMBO_BOX, ARRAY_LIST,
	private JFrame frame;
	private JButton reserve_button, cancel_button, return_button, show_button;
	private JTextField code_text, year_text, month_text, date_text;
	private JTable table;
	private JComboBox<String> athlete_box, training_program_box;
	private static ArrayList<TrainingProgramReservation> reservationList = new ArrayList<TrainingProgramReservation>();

	// ΔΗΜΙΟΥΡΓΙΑ ΜΕΤΑΒΛΗΤΗΣ ΠΟΥ ΑΝΑΠΑΡΙΣΤΑ ΤΗΝ ΤΡΕΧΟΥΣΑ ΗΜΕΡΟΜΗΝΙΑ
	private LocalDate currentDate = LocalDate.now();

	// ΑΡΧΙΚΟΠΟΙΗΣΗ ΤΩΝ ΟΝΟΜΑΤΩΝ ΤΩΝ ΣΤΗΛΩΝ ΤΟΥ ΠΙΝΑΚΑ
	private static String[] columnNames = { "Κωδικός", "Αθλητής", "Πρόγραμμα Εκπαίδευσης", "Ημερομηνία", "Διάρκεια σε λεπτά" };

	private static DefaultTableModel tableModel;

	// ΑΡΧΙΚΟΠΟΙΗΣΗ ΑΠΑΡΑΙΤΗΤΩΝ ΠΙΝΑΚΩΝ
	private TrainingProgram[] obj;
	private String[] trainingProgram;
	private String athleteOptions[] = new String[AthleteScreen.getAthleteList().size()];
	private String sub_athleteOptions[] = new String[SubscriptionScreen.getPliromilist().size()];
	private String sub_trainingProgramOptions[] = new String[SubscriptionScreen.getPliromilist().size()];

	Reservation_gui() {
		
		
		
		ImageIcon icon = new ImageIcon("UNIPI.jpg");		
		frame = new JFrame();
		frame.setIconImage(icon.getImage());
		//frame.setBackground(new Color(230, 230, 230));
		
		BorderLayout borderLayout = new BorderLayout();
		frame.getContentPane().setLayout(borderLayout);
		frame.setSize(1480, 900);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Διαχείση Κρατήσεων");
		//frame.setResizable(true);
		
		JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(100,110));
        bottomPanel.setLayout(null);
        bottomPanel.setBackground(new Color(230, 230, 230));
        frame.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        
        
        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(650,100));
        rightPanel.setLayout(null);
        rightPanel.setBackground(new Color(230, 230, 230));
        frame.getContentPane().add(rightPanel, BorderLayout.EAST);
        
		// ΔΙΑΧΕΙΡΙΣΗ ΟΛΩΝ ΤΩΝ ΑΠΑΡΑΙΤΗΤΩΝ ΠΡΑΓΜΑΤΩΝ ΓΙΑ ΤΑ TEXTFIELD
		code_text = new JTextField();
		code_text.setBounds(211, 43, 414, 40);
		rightPanel.add(code_text);
		code_text.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		code_text.setPreferredSize(new Dimension(250, 40));
		code_text.setEnabled(false);
		code_text.setBackground(Color.LIGHT_GRAY);
		
		// ΔΙΑΧΕΙΡΙΣΗ ΟΛΩΝ ΤΩΝ ΑΠΑΡΑΙΤΗΤΩΝ ΠΡΑΓΜΑΤΩΝ ΓΙΑ ΤΑ LABEL
		JLabel code_Label = new JLabel("Κωδικός:");
		code_Label.setBounds(117, 12, 94, 100);
		rightPanel.add(code_Label);
		code_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		
		
		
		

		
		
		year_text = new JTextField();
		year_text.setBounds(109, 356, 80, 40);
		rightPanel.add(year_text);
		year_text.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		year_text.setPreferredSize(new Dimension(250, 40));
		year_text.setBackground(Color.WHITE);
								
		month_text = new JTextField();
		month_text.setBounds(325, 356, 80, 40);
		rightPanel.add(month_text);
		month_text.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		month_text.setPreferredSize(new Dimension(250, 40));
		month_text.setBackground(Color.WHITE);
		
		date_text = new JTextField();
		date_text.setBounds(530, 356, 80, 40);
		rightPanel.add(date_text);
		date_text.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		date_text.setPreferredSize(new Dimension(250, 40));
		date_text.setBackground(Color.WHITE);
		JLabel athlete_Label = new JLabel("Αθλητής:");
		athlete_Label.setBounds(117, 108, 72, 100);
		rightPanel.add(athlete_Label);
		athlete_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		JLabel training_program_Label = new JLabel("Πρόγραμμα Εκπαίδευσης:");
		training_program_Label.setBounds(10, 219, 235, 100);
		rightPanel.add(training_program_Label);
		training_program_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		JLabel date_of_training_program_Label = new JLabel("Ημέρα:");
		date_of_training_program_Label.setBounds(448, 325, 136, 100);
		rightPanel.add(date_of_training_program_Label);
		date_of_training_program_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		JLabel month_of_training_program_Label = new JLabel("Μήνας:");
		month_of_training_program_Label.setBounds(244, 325, 136, 100);
		rightPanel.add(month_of_training_program_Label);
		month_of_training_program_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		JLabel year_of_training_program_Label = new JLabel("Έτος:");
		year_of_training_program_Label.setBounds(10, 325, 136, 100);
		rightPanel.add(year_of_training_program_Label);
		year_of_training_program_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));

		// ΔΙΑΧΕΙΡΙΣΗ ΟΛΩΝ ΤΩΝ ΑΠΑΡΑΙΤΗΤΩΝ ΠΡΑΓΜΑΤΩΝ ΓΙΑ ΤΑ BUTTONS
		reserve_button = new JButton("Κράτηση");
		reserve_button.setFont(new Font("Tahoma", Font.PLAIN, 17));
		reserve_button.setBounds(125, 33, 175, 50);
		bottomPanel.add(reserve_button);
		reserve_button.addActionListener(this);
		reserve_button.setFocusable(false);

		cancel_button = new JButton("Ακύρωση");
		cancel_button.setFont(new Font("Tahoma", Font.PLAIN, 17));
		cancel_button.setBounds(371, 33, 175, 50);
		bottomPanel.add(cancel_button);
		cancel_button.addActionListener(this);
		cancel_button.setFocusable(false);

		show_button = new JButton("Εμφάνιση");
		show_button.setFont(new Font("Tahoma", Font.PLAIN, 17));
		show_button.setBounds(629, 33, 175, 50);
		bottomPanel.add(show_button);
		show_button.addActionListener(this);
		show_button.setFocusable(false);

		return_button = new JButton("Επιστροφή");
		return_button.setFont(new Font("Tahoma", Font.PLAIN, 17));
		return_button.setBounds(881, 33, 175, 50);
		bottomPanel.add(return_button);
		return_button.addActionListener(this);
		return_button.setFocusable(false);

		Dimension buttonSize = new Dimension(200, 50);
		reserve_button.setPreferredSize(buttonSize);
		cancel_button.setPreferredSize(buttonSize);
		return_button.setPreferredSize(buttonSize);
		show_button.setPreferredSize(buttonSize);

		// ΔΙΑΧΕΙΡΙΣΗ ΟΛΩΝ ΤΩΝ ΑΠΑΡΑΙΤΗΤΩΝ ΠΡΑΓΜΑΤΩΝ ΓΙΑ ΤΟ TABLE
		tableModel = new DefaultTableModel(columnNames,0);
		table = new JTable(tableModel);
		table.setDefaultEditor(Object.class, null);
		table.getTableHeader().setReorderingAllowed(false);
        table.removeEditor();
        table.setBounds(37,38,763,709);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 814, 779);


		// ΔΗΜΙΟΥΡΓΙΑ ΤΟΥ ΠΙΝΑΚΑ ΜΕ ΟΛΑ ΤΑ ΣΤΟΙΧΕΙΑ ΠΟΥ ΕΙΧΕ ΠΡΟΗΓΟΥΜΕΝΩΣ ΚΑΙ ΤΗΝ
		// ΕΜΦΑΝΙΣΗ ΑΥΤΩΝ
		Object[] newRow = new Object[5];
		tableModel.setRowCount(0);
		for (int i = 0; i < reservationList.size(); i++) {
			newRow[0] = reservationList.get(i).getId();
			newRow[1] = reservationList.get(i).getAthlete().getFirstName() + " "
					+ reservationList.get(i).getAthlete().getLastName();
			newRow[2] = reservationList.get(i).getTrainingProgram().getSport().getName() + "-"
					+ reservationList.get(i).getTrainingProgram().getFacility().getName();
			newRow[3] = reservationList.get(i).getTrainingDate();
			newRow[4] = reservationList.get(i).getTrainingProgram().getDuration();
			tableModel.addRow(newRow);

		}

		// ΔΗΜΙΟΥΡΓΙΑ ΤΟΥ ΠΙΝΑΚΑ ΜΕ ΤΑ ΟΝΟΜΑΤΑ ΤΩΝ ΠΡΟΓΡΑΜΜΑΤΩΝ ΕΚΠΑΙΔΕΥΣΗΣ ΚΑΙ ΤΩΝ
		// ΟΝΟΜΑΤΩΝ ΤΩΝ ΕΓΚΑΤΑΣΤΑΣΕΩΝ
		obj = MainScreen.getTrainingProgram();
		trainingProgram = new String[10];

		int i;
		for (i = 0; i < 10; i = i + 1) {

			trainingProgram[i] = (String) (obj[i].getSport().getName() + "-" + obj[i].getFacility().getName());

		}

		// ΔΗΜΙΟΥΡΓΙΑ ΤΟΥ ΠΙΝΑΚΑ ΜΕ ΤΟ ΟΝΟΜΑΤΕΠΩΝΥΜΑ ΤΩΝ ΑΘΛΗΤΩΝ
		for (i = 0; i < AthleteScreen.getAthleteList().size(); i++) {
			athleteOptions[i] = AthleteScreen.getAthleteList().get(i).getFirstName() + " "
					+ AthleteScreen.getAthleteList().get(i).getLastName();
		}

		// ΔΗΜΙΟΥΡΓΙΑ ΤΟΥ ΠΙΝΑΚΑ ΜΕ ΤΟ ΟΝΟΜΑΤΕΠΩΝΥΜΑ ΤΩΝ ΑΘΛΗΤΩΝ ΠΟΥ ΕΧΟΥΝ ΣΥΝΔΡΟΜΗ
		for (i = 0; i < SubscriptionScreen.getPliromilist().size(); i++) {
			sub_athleteOptions[i] = SubscriptionScreen.getPliromilist().get(i).getAthlete().getFirstName() + " "
					+ SubscriptionScreen.getPliromilist().get(i).getAthlete().getLastName();
		}

		// ΔΗΜΙΟΥΡΓΙΑ ΤΟΥ ΠΙΝΑΚΑ ΜΕ ΤΑ ΟΝΟΜΑΤΑ ΤΩΝ ΠΡΟΓΡΑΜΜΑΤΩΝ ΕΚΠΑΙΔΕΥΣΗΣ ΚΑΙ ΤΩΝ
		// ΟΝΟΜΑΤΩΝ ΤΩΝ ΕΓΚΑΤΑΣΤΑΣΕΩΝ ΠΟΥ ΕΧΟΥΝ ΟΙ ΑΘΛΗΤΕΣ ΣΥΝΔΡΟΜΗ ΣΕ ΑΥΤΑ
		for (i = 0; i < SubscriptionScreen.getPliromilist().size(); i++) {
			sub_trainingProgramOptions[i] = SubscriptionScreen.getPliromilist().get(i).getTrainingProgram().getSport().getName()
					+ "-" + SubscriptionScreen.getPliromilist().get(i).getTrainingProgram().getFacility().getName();

		}
		// ΔΙΑΧΕΙΡΙΣΗ ΟΛΩΝ ΤΩΝ ΑΠΑΡΑΙΤΗΤΩΝ ΠΡΑΓΜΑΤΩΝ ΓΙΑ ΤΑ COMBO BOX
				athlete_box = new JComboBox<>(athleteOptions);
				athlete_box.setBounds(211, 144, 414, 40);
				rightPanel.add(athlete_box);
				
				athlete_box.setFocusable(false);
				athlete_box.setFont(new Font("Tahoma", Font.PLAIN, 17));
				
				
				//EDW PROVLIMA
				training_program_box = new JComboBox<>(trainingProgram);
				training_program_box.setBounds(211, 250, 414, 40);
				rightPanel.add(training_program_box);

				training_program_box.setFocusable(false);
				training_program_box.setFont(new Font("Tahoma", Font.PLAIN, 17));
				//MEXRI EDW
		
		frame.getContentPane().add(scrollPane);
		// ΔΙΑΧΕΙΡΙΣΗ ΟΛΩΝ ΤΩΝ ΑΠΑΡΑΙΤΗΤΩΝ ΠΡΑΓΜΑΤΩΝ ΓΙΑ ΤΟ FRAME
		



	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// ΕΛΕΓΧΟΣ ΓΙΑ ΤΟ ΑΝ ΠΑΤΗΘΗΚΕ ΤΟ ΚΟΥΜΠΙ ΤΗΣ ΚΡΑΤΗΣΗΣ
		if (e.getSource() == reserve_button) {

			// ΕΛΕΓΧΟΣ ΓΙΑ ΤΟ ΑΝ ΕΧΟΥΝ ΣΥΜΠΛΗΡΩΘΕΙ ΟΛΑ ΤΑ ΠΕΔΙΑ
			if ((date_text.getText().isEmpty()) || (month_text.getText().isEmpty())
					|| (year_text.getText().isEmpty())) {

				JOptionPane.showMessageDialog(null,
						"Πρέπει να συμπληρώσεις όλα τα κενά για να καταχωρίσεις μία κράτηση!", "Warning",
						JOptionPane.WARNING_MESSAGE);
			} else {

				//ΔΗΛΩΣΗ ΚΑΙ ΑΡΧΙΚΟΠΟΙΗΣΗ ΜΕΤΑΒΛΗΤΩΝ
				int k = 0, l = 0, x = 0, y = 0, i;

				// ΑΝΑΖΗΤΗΣΕΙ ΤΟΥ ΕΠΙΛΕΓΜΕΝΟΥ ΑΘΛΗΤΗ ΣΤΟ ΠΙΝΑΚΑ ΜΕ ΤΑ ΣΤΟΙΧΕΙΑ ΤΩΝ ΑΘΛΗΤΩΝ ΕΤΣΙ
				// ΩΣΤΕ ΝΑ ΠΑΡΩ ΤΟ ID ΤΟΥ ΑΘΛΗΤΗ ΚΑΙ ΤΗΝ ΘΕΣΗ ΣΤΗΝ ΟΠΟΙΑ ΒΡΙΣΚΕΤΑΙ ΣΤΟ ΠΙΝΑΚΑ
				// ΤΩΝ ΑΘΛΗΤΩΝ
				for (i = 0; i < AthleteScreen.getAthleteList().size(); i++) {
					if (athlete_box.getSelectedItem().equals(athleteOptions[i])) {
						k = AthleteScreen.getAthleteList().get(i).getId();
						x = i;
						break;

					}
				}
				
				// ΑΝΑΖΗΤΗΣΕΙ ΤΟΥ ΕΠΙΛΕΓΜΕΝΟΥ ΠΡΟΓΡΑΜΜΑΤΟΣ ΕΚΠΑΙΔΕΥΣΗΣ ΣΤΟ ΠΙΝΑΚΑ ΜΕ ΤΑ ΣΤΟΙΧΕΙΑ ΤΩΝ ΠΡΟΓΡΑΜΜΑΤΩΝ ΕΚΠΑΙΔΕΥΣΗΣ ΕΤΣΙ
				// ΩΣΤΕ ΝΑ ΠΑΡΩ ΤΟ ID ΤΟΥ ΠΡΟΓΡΑΜΜΑΤΟΣ ΕΚΠΑΙΔΕΥΣΗΣ ΚΑΙ ΤΗΝ ΘΕΣΗ ΣΤΗΝ ΟΠΟΙΑ ΒΡΙΣΚΕΤΑΙ ΣΤΟ ΠΙΝΑΚΑ
				// ΤΩΝ ΠΡΟΓΡΑΜΜΑΤΩΝ ΕΚΠΑΙΔΕΥΣΗΣ
				for (i = 0; i < 10; i++) {
					if (training_program_box.getSelectedItem().equals(trainingProgram[i])) {
						l = obj[i].getId();
						y = i;
						break;
					}
				}

				
				try {
					
					//ΕΚΧΩΡΩ ΤΑ ΣΤΟΙΧΕΙΑ ΤΟΥ ΕΔΩΣΕ Ο ΧΡΗΣΤΗΣ ΣΕ ΜΕΤΑΒΛΗΤΕΣ ΓΙΑ ΠΑΡΑΚΑΤΩ ΕΝΕΡΓΕΙΕΣ
					String athletes = (String) athlete_box.getSelectedItem();
					String training_programs = (String) training_program_box.getSelectedItem();
					String dates = (String) date_text.getText();
					String months = (String) month_text.getText();
					String years = (String) year_text.getText();
					//ΕΚΧΩΡΩ ΤΟΝ ΧΡΟΝΟ ΔΙΑΡΚΕΙΑΣ ΤΟΥ ΑΝΤΙΣΤΟΙΧΟΥ ΠΡΟΓΡΑΜΜΑΤΟΣ ΕΚΠΑΙΔΕΥΣΗΣ ΣΕ ΜΙΑ ΜΕΤΑΒΛΗΤΗ
					int times = obj[y].getDuration();

					//ΚΑΝΩ ΤΑ ΝΟΥΜΕΡΑ ΠΟΥ ΕΔΩΣΕ Ο ΧΡΗΣΤΗΣ ΠΟΥ ΕΙΝΑΙ ΜΟΝΟΨΗΦΙΑ ΣΕ ΔΙΨΗΦΙΑ ΓΙΑ ΠΑΡΑΚΑΤΩ ΕΝΕΡΓΕΙΕΣ
					if (months.length() == 1) {
						months = "0" + months;
					}
					if (dates.length() == 1) {
						dates = "0" + dates;
					}
					
					//ΔΗΜΙΟΥΡΓΙΑ ΜΙΑΣ ΜΕΤΑΒΛΗΤΗΣ ΠΟΥ ΝΑ ΕΧΕΙ ΤΗΝ ΟΛΟΚΛΗΡΗ ΗΜΕΡΟΜΗΝΙΑ
					String date = years + "-" + months + "-" + dates;
					//ΚΑΝΩ ΤΗΝ ΗΜΕΡΟΜΗΝΙΑ ΠΟΥ ΔΟΘΗΚΕ ΣΕ ΜΟΡΦΗ LOCAL DATE
					LocalDate given = LocalDate.parse(date);
					// ΔΗΜΙΟΥΡΓΙΑ ΜΕΤΑΒΛΗΤΗΣ ΠΟΥ ΑΝΑΠΑΡΙΣΤΑ ΤΗΝ ΤΡΕΧΟΥΣΑ ΗΜΕΡΟΜΗΝΙΑ
					LocalDate current = LocalDate.now();
					//ΔΗΜΙΟΥΡΓΙΑ ΜΕΤΑΒΛΗΤΗΣ ΠΟΥ ΝΑ ΕΧΕΙ ΤΗΝ ΗΜΕΡΟΜΗΝΙΑ ΕΝΩΜΕΝΗ
					String id_date = (String) (years + months + dates);
					//ΔΗΜΙΟΥΡΓΙΑ ID ΚΡΑΤΗΣΗΣ
					String ids = (String) (l + "_" + k + "_" + id_date);

					//ΕΛΕΓΧΟΣ ΓΙΑ ΤΟ ΑΝ ΥΠΑΡΧΕΙ ΑΘΛΗΤΗΣ ΠΟΥ ΝΑ ΕΧΕΙ ΣΥΝΔΡΟΜΗ
					if (sub_athleteOptions.length == 0) {
						JOptionPane.showMessageDialog(null, "Δεν υπάρχει αθλητής που έχει συνδρομή!", "Warning",
								JOptionPane.WARNING_MESSAGE);

					} else {

						//ΕΛΕΓΧΟΣ ΓΙΑ ΤΟ ΑΝ Η ΗΜΕΡΟΜΗΝΙΑ ΠΟΥ ΔΟΘΗΚΕ ΔΕΝ ΕΙΝΑΙ ΠΑΡΕΛΘΟΝΤΙΚΗ
						if (given.isAfter(current) || given.isEqual(current)) {

							boolean flag1 = false;
							int j = 0;

							//ΕΠΑΝΑΛΗΨΗ ΓΙΑ ΝΑ ΕΛΕΓΧΕΙ ΑΝ Ο ΑΘΛΗΤΗΣ ΕΧΕΙ ΣΥΝΔΡΟΜΗ ΣΤΟ ΣΥΓΚΕΚΡΙΜΕΝΟ ΠΡΟΓΡΑΜΜΑ ΕΚΠΑΙΔΕΥΣΗΣ
							do {
								if (athlete_box.getSelectedItem().equals(sub_athleteOptions[j]) && training_program_box
										.getSelectedItem().equals(sub_trainingProgramOptions[j])) {
									//ΓΙΝΕΤΑΙ ΑΛΗΘΗΣ ΑΝ ΒΡΕΘΕΙ ΑΘΛΗΤΗΣ ΠΟΥ ΝΑ ΕΧΕΙ ΣΥΝΔΡΟΜΗ ΣΤΟ ΣΥΓΚΕΚΡΙΜΕΝΟ ΠΡΟΓΡΑΜΜΑ ΕΚΠΑΙΔΕΥΣΗΣ
									flag1 = true;

								}
								j = j + 1;

							} while (j < SubscriptionScreen.getPliromilist().size() && flag1 == false);

							
							int z = 0, a = 0;
							boolean flag5 = false;
							
							//ΔΗΜΙΟΥΡΓΙΑ ΠΙΝΑΚΑ ΠΟΥ ΘΑ ΚΡΑΤΑ ΤΙΣ ΘΕΣΕΙΣ ΠΟΥ Ο ΑΘΛΗΤΗΣ ΣΤΟ ΣΥΓΚΕΚΡΙΜΕΝΟ ΠΡΟΓΡΑΜΜΑ ΕΚΠΑΙΔΕΥΣΗΣ ΕΧΕΙ ΚΑΝΕΙ ΚΡΑΤΗΣΗ
							int index[] = new int[reservationList.size()];
							
							//ΕΛΕΓΧΟΣ ΓΙΑ ΤΟ ΑΝ ΤΟ ARRAY LIST ΕΙΝΑΙ ΑΔΕΙΑ
							if (!reservationList.isEmpty()) {
								
								//ΕΛΕΓΧΟΣ ΓΙΑ ΤΟΝ ΑΝ ΕΧΕΙ ΒΡΕΘΕΙ ΑΘΛΗΤΗΣ ΠΟΥ ΝΑ ΕΧΕΙ ΣΥΝΔΡΟΜΗ ΣΤΟ ΣΥΓΚΕΚΡΙΜΕΝΟ ΠΡΟΓΡΑΜΜΑ ΕΚΠΑΙΔΕΥΣΗΣ(ΣΕΙΡΑ 326)
								if (flag1 == true) {
									
									//ΕΠΑΝΑΛΗΨΗ ΓΙΑ ΝΑ ΚΑΤΑΧΩΡΙΘΟΥΝ ΟΙ ΘΕΣΕΙΣ ΠΟΥ Ο ΑΘΛΗΤΗΣ ΣΤΟ ΣΥΓΚΕΚΡΙΜΕΝΟ ΠΡΟΓΡΑΜΜΑ ΕΚΠΑΙΔΕΥΣΗΣ ΕΧΕΙ ΚΑΝΕΙ ΚΡΑΤΗΣΗ ΣΤΟΝ ΠΙΝΑΚΑ INDEX[]
									do {
										if (athlete_box.getSelectedItem()
												.equals(reservationList.get(z).getAthlete().getFirstName() + " "
														+ reservationList.get(z).getAthlete().getLastName())
												&& training_program_box.getSelectedItem().equals(
														reservationList.get(z).getTrainingProgram().getSport().getName()
																+ "-" + reservationList.get(z).getTrainingProgram()
																		.getFacility().getName())) {
											index[a] = z;
											a = a + 1;
											//ΑΛΗΘΗΣ ΟΤΑΝ ΒΡΕΙ ΚΑΠΟΙΟΝ ΑΘΛΗΤΗ ΠΟΥ ΝΑ ΕΧΕΙ ΣΥΝΔΡΟΜΗ ΣΤΟ ΣΥΓΚΕΚΡΙΜΕΝΟ ΠΡΟΓΡΑΜΜΑ ΕΚΠΑΙΔΕΥΣΗΣ ΚΑΙ ΝΑ ΒΡΙΣΚΕΤΑΙ ΣΤΟ RESERVATION LIST
											flag5 = true;
											
										}
										
										z = z + 1;

									} while (z < reservationList.size());

								}

							}

							int b = 0;
							boolean flag2 = false;
							
							//ΕΛΕΓΧΟΣ ΓΙΑ ΤΟ ΑΝ ΤΟ ARRAY LIST ΕΙΝΑΙ ΑΔΕΙΑ
							if (!reservationList.isEmpty()) {
								
								//ΕΛΕΓΧΟΣ ΓΙΑ ΑΝ ΒΡΗΚΕ ΚΑΠΟΙΟΝ ΑΘΛΗΤΗ ΠΟΥ ΝΑ ΕΧΕΙ ΣΥΝΔΡΟΜΗ ΣΤΟ ΣΥΓΚΕΚΡΙΜΕΝΟ ΠΡΟΓΡΑΜΜΑ ΕΚΠΑΙΔΕΥΣΗΣ ΚΑΙ ΝΑ ΒΡΙΣΚΕΤΑΙ ΣΤΟ RESERVATION LIST
								if (flag5 == true) {
									
									//ΕΠΑΝΑΛΗΨΗ ΓΙΑ ΝΑ ΕΛΕΓΧΕΙ ΑΝ ΣΥΜΠΙΤΕΙ ΚΑΠΟΙΑ ΗΜΕΡΟΜΗΝΙΑ ΣΤΟΝ ΙΔΙΟ ΑΘΛΗΤΗ ΣΤΟ ΙΔΙΟ ΠΡΟΓΡΑΜΜΑ ΕΚΠΑΙΔΕΥΣΗΣ
									do {
										if (given.equals(reservationList.get(index[b]).getTrainingDate())) {
											flag2 = true;
										}
										b = b + 1;

									} while (b < a);
								}
							}

							boolean flag3 = false, flag4 = false;
							int c = 0;

							//ΕΠΑΝΑΛΗΨΗ ΓΙΑ ΝΑ ΕΛΕΓΧΕΙ ΑΝ Ο ΑΘΛΗΤΗΣ ΕΧΕΙ ΣΥΝΔΡΟΜΗ ΚΑΙ ΑΝ ΝΑΙ ΑΝ ΕΧΕΙ ΣΤΟ ΣΥΓΚΕΚΡΙΜΕΝΟ ΠΡΟΓΡΑΜΜΑ ΕΚΠΑΙΔΕΥΣΗΣ
							do {
								if (athlete_box.getSelectedItem().equals(sub_athleteOptions[c])) {
									flag3 = true;
									if (training_program_box.getSelectedItem().equals(sub_trainingProgramOptions[c])) {
										flag4 = true;

									}
								}
								c = c + 1;

							} while (c < SubscriptionScreen.getPliromilist().size()); // && flag2 == true);

							//ΑΝ ΙΣΧΥΕΙ Η ΣΥΝΘΗΚΗ ΚΑΤΑΧΩΡΟΥΝΤΑΙ ΤΑ ΑΠΑΡΑΙΤΗΤΑ ΣΤΟΙΧΕΙΑ ΣΤΟ ΠΙΝΑΚΑ ΚΑΙ ΣΤΟ RESERVATION LIST	
							if (flag1 == true && flag2 == false) {
								tableModel.addRow(new Object[] { ids, athletes, training_programs, date, times });
								reservationList.add(new TrainingProgramReservation(ids,
										AthleteScreen.getAthleteList().get(x), obj[y], given));
							}
							
							//ΑΝ ΙΣΧΥΟΥΝ ΟΙ ΣΥΝΘΗΚΕΣ ΘΑ ΕΜΦΑΝΙΖΕΙ ΜΗΝΥΜΑ ΣΤΟΝ ΧΡΗΣΤΗ ΒΑΣΕΙ ΤΩΝ ΣΥΝΘΗΚΩΝ 
							if (flag2 == true) {
								JOptionPane.showMessageDialog(null,
										"Δεν μπορείς να κάνεις κράτηση για το ίδιο πρόγραμμα εκπαίδευσης στην ίδια ημερομήνια!",
										"Warning", JOptionPane.WARNING_MESSAGE);
							}
							if (flag3 == false) {

								JOptionPane.showMessageDialog(null, "Ο αθλητής που έχεις επιλέξει δεν έχει συνδρομή!",
										"Warning", JOptionPane.WARNING_MESSAGE);
							}
							if (flag3 == true && flag4 == false) {
								JOptionPane.showMessageDialog(null,
										"Ο αθλητής που έχεις επιλέξει δεν έχει συνδρομή στο συγκεκριμένο πρόγραμμα εκπαίδευσης!",
										"Warning", JOptionPane.WARNING_MESSAGE);
							}
						
						} 
						//ΕΜΦΑΝΙΣΕΙ ΜΗΝΥΜΑΤΟΣ ΑΝ ΔΩΘΕΙ ΠΑΡΕΛΘΟΝΤΙΚΗ ΗΜΕΡΟΜΗΝΙΑ
						else {
							JOptionPane.showMessageDialog(null, "Πρέπει να επιλέξεις μια μελλοντική ημερομηνία!",
									"Warning", JOptionPane.WARNING_MESSAGE);
						}

					}
				} 
				//ΕΜΦΑΝΙΣΕΙ ΜΗΝΥΜΑΤΟΣ ΑΝ ΔΟΘΕΙ ΜΗ ΕΓΚΥΡΗ ΗΜΕΡΟΜΗΝΙΑ Ή ΑΝ ΔΟΘΟΥΝ ΓΡΑΜΜΑΤΑ ΣΤΑ ΠΕΔΙΑ ΤΩΝ ΗΜΕΡΟΜΗΝΙΩΝ
				catch (DateTimeParseException e1) {
					JOptionPane.showMessageDialog(null, "Πρέπει να εισάγετε μια έγκυρη ημερονηνία με αριθμούς!",
							"Warning", JOptionPane.WARNING_MESSAGE);
				}
			}

		}
		
		//ΕΛΕΓΧΟΣ ΓΙΑ ΤΟ ΑΝ ΠΑΤΗΘΗΚΕ ΤΟ ΚΟΥΜΠΙ ΤΗΣ ΑΚΥΡΩΣΗΣ
		if (e.getSource() == cancel_button) {

			int selectedRow = table.getSelectedRow();

			//ΕΛΕΓΧΟΣ ΓΙΑ ΤΟ ΑΝ ΕΧΕΙ ΕΠΙΛΕΧΘΕΙ ΓΡΑΜΜΗ ΓΙΑ ΤΗΝ ΑΚΥΡΩΣΗ
			if (selectedRow == -1) {
				JOptionPane.showMessageDialog(null, "Πρέπει να επιλέξεις ένα πεδίο!", "Warning",
						JOptionPane.WARNING_MESSAGE);
			} else {
				//ΑΦΑΙΡΕΣΗ ΤΗΣ ΓΡΑΜΜΗΣ ΑΠΟ ΤΟΝ ΠΙΝΑΚΑ
				reservationList.remove(selectedRow);

				//ΠΑΙΡΝΩ ΤΗΝ ΗΜΕΡΟΜΗΝΙΑ ΑΠΟ ΤΗΝ ΕΠΙΛΕΓΜΕΝΗ ΓΡΑΜΜΗ
				String date = (String) table.getValueAt(selectedRow, 3); 

				//ΜΕΤΑΤΡΟΠΗ ΤΗΣ ΗΜΕΡΟΜΗΝΙΑΣ ΣΕ ΜΟΡΦΗ LOCAL DATE
				LocalDate reservationDate = LocalDate.parse(date); 

				//ΥΠΟΛΟΓΙΣΜΟΣ ΤΗΣ ΠΡΟΗΓΟΥΜΕΝΗΣ ΜΕΡΑΣ ΑΠΟ ΤΗΝ ΤΡΕΧΟΥΣΑ ΗΜΕΡΟΜΗΝΙΑ
				LocalDate oneDayBeforeReservationDate = reservationDate.minusDays(1); 

				//ΕΛΕΓΧΟΣ ΓΙΑ ΤΟ ΑΝ Η ΚΡΑΤΗΣΗ ΠΟΥ ΘΕΛΕΙ ΝΑ ΑΚΥΡΩΣΕΙ ΕΙΝΑΙ ΤΟΥΛΑΧΙΣΤΟΝ ΜΙΑ ΜΕΡΑ ΠΡΙΝ ΤΗΝ ΤΡΕΧΟΥΣΑ ΗΜΕΡΟΜΗΝΙΑ 
				if (currentDate.isBefore(oneDayBeforeReservationDate)
						|| currentDate.equals(oneDayBeforeReservationDate)) {
					tableModel.removeRow(selectedRow);
				} else {
					JOptionPane.showMessageDialog(null,
							"Δεν μπορείτε να ακυρώσετε αυτή την κράτηση. Απαιτείται τουλάχιστον 1 μέρα πριν την ημερομηνία κράτησης.",
							"Warning", JOptionPane.ERROR_MESSAGE);
				}
			}

		}
		//ΕΛΕΓΧΟΣ ΓΙΑ ΤΟΝ ΑΝ ΠΑΤΗΘΗΚΕ ΤΟ ΚΟΥΜΠΙ ΤΗΣ ΕΜΦΑΝΙΣΗΣ
		if (e.getSource() == show_button) {
			new choice_gui();

		}
		//ΕΛΕΓΧΟΣ ΓΙΑ ΤΟΝ ΑΝ ΠΑΤΗΘΗΚΕ ΤΟ ΚΟΥΜΠΙ ΤΗΣ ΕΠΙΣΤΡΟΦΗΣ
		if (e.getSource() == return_button) {
			new MainScreen();
			frame.dispose();
		}

	}
	
	static public ArrayList<TrainingProgramReservation> getReservationList()
	{
		return reservationList;
	}
	
	
	
}
