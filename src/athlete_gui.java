import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class athlete_gui extends JFrame implements ActionListener {

	JButton end_button, return_button;
	String athleteOptions[] = new String[AthleteScreen.getAthleteList().size()];
	JComboBox<String> athlete_box;
	String athlete;

	athlete_gui() {
		int i;

		// ΔΗΜΙΟΥΡΓΙΑ ΠΙΝΑΚΑ ΜΕ ΤΑ ΟΝΟΜΑΤΕΠΩΝΥΜΑ ΤΟΝ ΑΘΛΗΤΩΝ
		for (i = 0; i < AthleteScreen.getAthleteList().size(); i++) {
			athleteOptions[i] = AthleteScreen.getAthleteList().get(i).getFirstName() + " "
					+ AthleteScreen.getAthleteList().get(i).getLastName();
		}

		// ΔΙΑΧΕΙΡΙΣΗ ΟΛΩΝ ΤΩΝ ΑΠΑΡΑΙΤΗΤΩΝ ΠΡΑΓΜΑΤΩΝ ΓΙΑ Τ0 COMBO BOX
		athlete_box = new JComboBox<>(athleteOptions);
		athlete_box.setFocusable(false);
		athlete_box.setFont(new Font("Tahoma", Font.PLAIN, 17));
		athlete_box.setBounds(135, 140, 415, 40);
		getContentPane().add(athlete_box);

		// ΔΙΑΧΕΙΡΙΣΗ ΟΛΩΝ ΤΩΝ ΑΠΑΡΑΙΤΗΤΩΝ ΠΡΑΓΜΑΤΩΝ ΓΙΑ ΤΟ LABEL
		JLabel text_Label = new JLabel("ΕΠΙΛΕΞΤΕ ΤΑ ΣΤΟΙΧΕΙΑ ΤΟΥ ΑΘΛΗΤΗ ΠΟΥ ΘΑ ΘΕΛΑΤΕ ΝΑ ΠΡΟΒΑΛΛΕΤΕ ΣΤΟ ΠΙΝΑΚΑ:");
		text_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		text_Label.setBounds(19, 0, 675, 150);
		getContentPane().add(text_Label);

		// ΔΙΑΧΕΙΡΙΣΗ ΟΛΩΝ ΤΩΝ ΑΠΑΡΑΙΤΗΤΩΝ ΠΡΑΓΜΑΤΩΝ ΓΙΑ ΤΑ BUTΤΟΝ
		return_button = new JButton("Επιστροφή");
		return_button.setBounds(110, 260, 175, 50);
		return_button.setFont(new Font("Tahoma", Font.PLAIN, 17));
		getContentPane().add(return_button);
		getContentPane().setLayout(null);
		return_button.addActionListener(this);
		return_button.setFocusable(false);

		end_button = new JButton("Tέλος");
		end_button.setBounds(414, 260, 175, 50);
		end_button.setFont(new Font("Tahoma", Font.PLAIN, 17));
		getContentPane().add(end_button);
		getContentPane().setLayout(null);
		end_button.addActionListener(this);
		end_button.setFocusable(false);

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
		// ΕΛΕΓΧΟΣ ΓΙΑ ΤΟ ΑΝ ΠΑΤΗΘΗΚΕ ΤΟ ΚΟΥΜΠΙ ΤΗΣ ΕΠΙΣΤΡΟΦΗΣ
		if (e.getSource() == return_button) {
			new choice_gui();
			dispose();
		}
		// ΕΛΕΓΧΟΣ ΓΙΑ ΤΟ ΑΝ ΠΑΤΗΘΗΚΕ ΤΟ ΚΟΥΜΠΙ ΤΟΥ ΤΕΛΟΥΣ
		if (e.getSource() == end_button) {
			new show_gui();
			// ΕΚΧΩΡΕΙΤΕ Ο ΑΘΛΗΤΗΣ ΠΟΥ ΕΧΕΙ ΕΠΙΛΕΧΘΕΙ ΣΕ ΜΙΑ ΜΕΤΑΒΛΗΤΗ ΓΙΑ ΝΑ ΠΕΡΑΣΤΕΙ ΣΑΝ
			// ΟΡΙΣΜΑ
			athlete = (String) athlete_box.getSelectedItem();
			show_gui.sortAthlete(athlete);
			dispose();

		}

	}
}