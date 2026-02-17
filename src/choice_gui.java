import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.Font;
import javax.swing.JButton;

public class choice_gui extends JFrame implements ActionListener {

	// ΔΗΛΩΣΗ PANEL, RADIO BUTTON, BUTTON
	JPanel radioPanel;
	JRadioButton athlete_button, training_button, reservation_button, history_button;
	JButton return_button, next_button;

	choice_gui() {
		// ΔΙΑΧΕΙΡΙΣΗ ΟΛΩΝ ΤΩΝ ΑΠΑΡΑΙΤΗΤΩΝ ΠΡΑΓΜΑΤΩΝ ΓΙΑ ΤΑ RADIO BUTTONS
		athlete_button = new JRadioButton("Αθλητής");
		athlete_button.setBounds(40, 150, 140, 23);
		getContentPane().add(athlete_button);

		training_button = new JRadioButton("Πρόγραμμα Εκπαίδευσης");
		training_button.setBounds(150, 150, 213, 23);
		getContentPane().add(training_button);

		reservation_button = new JRadioButton("Μελλοντικές Κρατήσεις");
		reservation_button.setBounds(370, 150, 193, 23);
		getContentPane().add(reservation_button);

		history_button = new JRadioButton("Ιστορικό");
		history_button.setBounds(580, 150, 141, 23);
		getContentPane().add(history_button);

		ButtonGroup group = new ButtonGroup();
		group.add(athlete_button);
		group.add(training_button);
		group.add(reservation_button);
		group.add(history_button);

		// ΔΙΑΧΕΙΡΙΣΗ ΟΛΩΝ ΤΩΝ ΑΠΑΡΑΙΤΗΤΩΝ ΠΡΑΓΜΑΤΩΝ ΓΙΑ ΤΑ BUTTONS
		return_button = new JButton("Επιστροφή");
		return_button.setBounds(110, 260, 175, 50);
		return_button.setFont(new Font("Tahoma", Font.PLAIN, 17));
		getContentPane().add(return_button);
		getContentPane().setLayout(null);
		return_button.addActionListener(this);
		return_button.setFocusable(false);

		next_button = new JButton("Επόμενο");
		next_button.setBounds(414, 260, 175, 50);
		next_button.setFont(new Font("Tahoma", Font.PLAIN, 17));
		getContentPane().add(next_button);
		getContentPane().setLayout(null);
		next_button.addActionListener(this);
		next_button.setFocusable(false);

		// ΔΙΑΧΕΙΡΙΣΗ ΟΛΩΝ ΤΩΝ ΑΠΑΡΑΙΤΗΤΩΝ ΠΡΑΓΜΑΤΩΝ ΓIA TO LABEL
		JLabel text_Label = new JLabel("ΕΠΙΛΕΞΤΕ ΤΑ ΣΤΟΙΧΕΙΑ ΠΟΥ ΘΑ ΘΕΛΑΤΕ ΝΑ ΠΡΟΒΑΛΛΕΤΕ ΣΤΟ ΠΙΝΑΚΑ:");
		text_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		text_Label.setBounds(60, 0, 580, 150);
		getContentPane().add(text_Label);

		// ΔΙΑΧΕΙΡΙΣΗ ΟΛΩΝ ΤΩΝ ΑΠΑΡΑΙΤΗΤΩΝ ΠΡΑΓΜΑΤΩΝ ΓΙΑ ΤΟ FRAME
		setVisible(true);
		setSize(700, 350);
		setLocationRelativeTo(null);
		setTitle("Choice Window");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// ΕΛΕΓΧΟΣ ΓΙΑ ΤΟ ΑΝ ΠΑΤΗΘΗΚΕ ΤΟ ΚΟΥΜΠΙ ΤΟΥ ΕΠΟΜΕΝΟΥ
		if (e.getSource() == next_button) {
			// ΕΛΕΓΧΟΣ ΓΙΑ ΤΟ ΑΝ ΕΠΙΛΕΧΘΗΚΕ Ο ΑΘΛΗΤΗΣ
			if (athlete_button.isSelected()) {
				new athlete_gui();
				dispose();
			}
			// ΕΛΕΓΧΟΣ ΓΙΑ ΤΟ ΑΝ ΕΠΙΛΕΧΘΗΚΕ ΤΟ ΠΡΟΓΡΑΜΜΑ ΕΚΠΑΙΔΕΥΣΗΣ
			else if (training_button.isSelected()) {
				new trainingProgram_gui();
				dispose();
			}
			// ΕΛΕΓΧΟΣ ΓΙΑ ΤΟ ΑΝ ΕΠΙΛΕΧΘΗΚΕ ΤΟ ΜΕΛΛΟΝΤΙΚΕΣ ΚΡΑΤΗΣΕΙΣ
			else if (reservation_button.isSelected()) {
				new show_gui();
				show_gui.sortReservation();
				dispose();

			}
			// ΕΛΕΓΧΟΣ ΓΙΑ ΤΟ ΑΝ ΕΠΙΛΕΧΘΗΚΕ ΤΟ ΙΣΤΟΡΙΚΟ
			else if (history_button.isSelected()) {
				new show_gui();
				show_gui.sortHistory();
				dispose();
			}
			// ΜΗΝΥΜΑ ΠΟΥ ΘΑ ΕΜΦΑΝΙΖΕΤΑΙ ΟΤΑΝ Ο ΧΡΗΣΤΗΣ ΔΕΝ ΕΧΕΙ ΕΠΙΛΕΞΕΙ ΚΑΤΙ
			else {
				JOptionPane.showMessageDialog(null, "Πρέπει να επιλέξεις μια από τις επιλογές.", "Warning",
						JOptionPane.WARNING_MESSAGE);
			}
		}
		// ΕΛΕΓΧΟΣ ΓΙΑ ΤΟ ΑΝ ΠΑΤΗΘΗΚΕ ΤΟ ΚΟΥΜΠΙ ΤΗΣ ΕΠΙΣΤΡΟΦΗΣ
		if (e.getSource() == return_button) {
			dispose();
		}

	}
}