import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class show_gui extends JFrame implements ActionListener {
	JTable table;
	static String[] columnNames = { "Κωδικός", "Αθλητής", "Πρόγραμμα Εκπαίδευσης", "Ημερομηνία", "Διάρκεια σε λεπτά" };
	static DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

	show_gui() {
		// ΔΙΑΧΕΙΡΙΣΗ ΟΛΩΝ ΤΩΝ ΑΠΑΡΑΙΤΗΤΩΝ ΠΡΑΓΜΑΤΩΝ ΓΙΑ ΤΟ TABLE
		table = new JTable(tableModel);
		table.getTableHeader().setReorderingAllowed(false);
		table.setDefaultEditor(Object.class, null);
        table.removeEditor();

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(6, 6, 814, 779);
		getContentPane().add(scrollPane);
		scrollPane.setPreferredSize(new Dimension(763, 709));

		// ΔΙΑΧΕΙΡΙΣΗ ΟΛΩΝ ΤΩΝ ΑΠΑΡΑΙΤΗΤΩΝ ΠΡΑΓΜΑΤΩΝ ΓΙΑ ΤΟ FRAME
		this.setSize(1100, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		getContentPane().setLayout(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	// ΜΕΘΟΔΟΣ ΠΟΥ ΘΑ ΥΛΟΠΟΙΕΙ ΤΗΝ ΕΜΑΦΑΝΙΣΗ ΤΩΝ ΣΤΟΙΧΕΙΩΝ ΤΟΥ ΠΙΝΑΚΑ ΜΕ ΒΑΣΗ ΤΟΝ
	// ΑΘΛΗΤΗ ΠΟΥ ΕΧΕΙ ΕΠΙΛΕΞΕΙ Ο ΧΡΗΣΤΗΣ
	static public void sortAthlete(String athlete) {

		Object[] newRow2 = new Object[5];
		tableModel.setRowCount(0);
		for (int i = 0; i < Reservation_gui.getReservationList().size(); i++) {
			if (athlete.equals(Reservation_gui.getReservationList().get(i).getAthlete().getFirstName() + " "
					+ Reservation_gui.getReservationList().get(i).getAthlete().getLastName())) {
				newRow2[0] = Reservation_gui.getReservationList().get(i).getId();
				newRow2[1] = Reservation_gui.getReservationList().get(i).getAthlete().getFirstName() + " "
						+ Reservation_gui.getReservationList().get(i).getAthlete().getLastName();
				newRow2[2] = Reservation_gui.getReservationList().get(i).getTrainingProgram().getSport().getName() + "-"
						+ Reservation_gui.getReservationList().get(i).getTrainingProgram().getFacility().getName();
				newRow2[3] = Reservation_gui.getReservationList().get(i).getTrainingDate();
				newRow2[4] = Reservation_gui.getReservationList().get(i).getTrainingProgram().getDuration();
				tableModel.addRow(newRow2);
			}

		}
	}

	// ΜΕΘΟΔΟΣ ΠΟΥ ΘΑ ΥΛΟΠΟΙΕΙ ΤΗΝ ΕΜΑΦΑΝΙΣΗ ΤΩΝ ΣΤΟΙΧΕΙΩΝ ΤΟΥ ΠΙΝΑΚΑ ΜΕ ΒΑΣΗ ΤΟ
	// ΠΡΟΓΡΑΜΜΑ ΕΚΠΑΙΔΕΥΣΗΣ ΠΟΥ ΕΧΕΙ ΕΠΙΛΕΞΕΙ Ο ΧΡΗΣΤΗΣ
	static public void sortTrainingProgram(String TrainingProgram) {

		Object[] newRow2 = new Object[5];
		tableModel.setRowCount(0);
		for (int i = 0; i < Reservation_gui.getReservationList().size(); i++) {
			if (TrainingProgram.equals(Reservation_gui.getReservationList().get(i).getTrainingProgram().getSport().getName()
					+ "-" + Reservation_gui.getReservationList().get(i).getTrainingProgram().getFacility().getName())) {
				newRow2[0] = Reservation_gui.getReservationList().get(i).getId();
				newRow2[1] = Reservation_gui.getReservationList().get(i).getAthlete().getFirstName() + " "
						+ Reservation_gui.getReservationList().get(i).getAthlete().getLastName();
				newRow2[2] = Reservation_gui.getReservationList().get(i).getTrainingProgram().getSport().getName() + "-"
						+ Reservation_gui.getReservationList().get(i).getTrainingProgram().getFacility().getName();
				newRow2[3] = Reservation_gui.getReservationList().get(i).getTrainingDate();
				newRow2[4] = Reservation_gui.getReservationList().get(i).getTrainingProgram().getDuration();
				tableModel.addRow(newRow2);
			}
		}
	}

	// ΜΕΘΟΔΟΣ ΠΟΥ ΘΑ ΥΛΟΠΟΙΕΙ ΤΗΝ ΕΜΑΦΑΝΙΣΗ ΤΩΝ ΣΤΟΙΧΕΙΩΝ ΤΟΥ ΠΙΝΑΚΑ ΜΕ ΒΑΣΗ ΑΝ
	// ΕΙΝΑΙ ΜΕΛΛΟΝΤΙΚΗ Η ΚΡΑΤΗΣΗ
	static public void sortReservation() {

		Object[] newRow2 = new Object[5];
		LocalDate current = LocalDate.now();
		tableModel.setRowCount(0);
		for (int i = 0; i < Reservation_gui.getReservationList().size(); i++) {

			if (current.isBefore(Reservation_gui.getReservationList().get(i).getTrainingDate())
					|| current.isEqual(Reservation_gui.getReservationList().get(i).getTrainingDate())) {
				newRow2[0] = Reservation_gui.getReservationList().get(i).getId();
				newRow2[1] = Reservation_gui.getReservationList().get(i).getAthlete().getFirstName() + " "
						+ Reservation_gui.getReservationList().get(i).getAthlete().getLastName();
				newRow2[2] = Reservation_gui.getReservationList().get(i).getTrainingProgram().getSport().getName() + "-"
						+ Reservation_gui.getReservationList().get(i).getTrainingProgram().getFacility().getName();
				newRow2[3] = Reservation_gui.getReservationList().get(i).getTrainingDate();
				newRow2[4] = Reservation_gui.getReservationList().get(i).getTrainingProgram().getDuration();
				tableModel.addRow(newRow2);
			}
		}
	}

	// ΜΕΘΟΔΟΣ ΠΟΥ ΘΑ ΥΛΟΠΟΙΕΙ ΤΗΝ ΕΜΑΦΑΝΙΣΗ ΤΩΝ ΣΤΟΙΧΕΙΩΝ ΤΟΥ ΠΙΝΑΚΑ ΜΕ ΒΑΣΗ ΑΝ
	// ΕΙΝΑΙ ΠΑΡΕΛΘΟΝΤΙΚΗ Η ΚΡΑΤΗΣΗ
	static public void sortHistory() {

		Object[] newRow2 = new Object[5];
		LocalDate current = LocalDate.now();
		tableModel.setRowCount(0);
		for (int i = 0; i < Reservation_gui.getReservationList().size(); i++) {
			if (current.isAfter(Reservation_gui.getReservationList().get(i).getTrainingDate())) {
				newRow2[0] = Reservation_gui.getReservationList().get(i).getId();
				newRow2[1] = Reservation_gui.getReservationList().get(i).getAthlete().getFirstName() + " "
						+ Reservation_gui.getReservationList().get(i).getAthlete().getLastName();
				newRow2[2] = Reservation_gui.getReservationList().get(i).getTrainingProgram().getSport().getName() + "-"
						+ Reservation_gui.getReservationList().get(i).getTrainingProgram().getFacility().getName();
				newRow2[3] = Reservation_gui.getReservationList().get(i).getTrainingDate();
				newRow2[4] = Reservation_gui.getReservationList().get(i).getTrainingProgram().getDuration();
				tableModel.addRow(newRow2);
			}
		}
	}

}
