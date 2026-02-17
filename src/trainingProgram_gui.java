import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class trainingProgram_gui extends JFrame implements ActionListener {

	JComboBox<String> trainingProgram_box;
	JButton end_button, return_button;
	TrainingProgram[] obj;
	String TrainingProgram;

	trainingProgram_gui() {

		// ΔΗΜΙΟΥΡΓΙΑ ΤΟΥ ΠΙΝΑΚΑ ΜΕ ΤΑ ΟΝΟΜΑΤΑ ΤΩΝ ΠΡΟΓΡΑΜΜΑΤΩΝ ΕΚΠΑΙΔΕΥΣΗΣ ΚΑΙ ΤΩΝ
		// ΟΝΟΜΑΤΩΝ ΤΩΝ ΕΓΚΑΤΑΣΤΑΣΕΩΝ
		obj = MainScreen.getTrainingProgram();
		String[] trainingProgram = new String[10];
		int i;
		for (i = 0; i < 10; i = i + 1) {

			trainingProgram[i] = (String) (obj[i].getSport().getName() + "-" + obj[i].getFacility().getName());

		}

		// ΔΙΑΧΕΙΡΙΣΗ ΟΛΩΝ ΤΩΝ ΑΠΑΡΑΙΤΗΤΩΝ ΠΡΑΓΜΑΤΩΝ ΓΙΑ Τ0 COMBO BOX
		trainingProgram_box = new JComboBox<>(trainingProgram);
		trainingProgram_box.setFocusable(false);
		trainingProgram_box.setFont(new Font("Tahoma", Font.PLAIN, 17));
		trainingProgram_box.setBounds(215, 140, 415, 40);
		getContentPane().add(trainingProgram_box);

		// ΔΙΑΧΕΙΡΙΣΗ ΟΛΩΝ ΤΩΝ ΑΠΑΡΑΙΤΗΤΩΝ ΠΡΑΓΜΑΤΩΝ ΓΙΑ ΤΟ LABEL
		JLabel text_Label = new JLabel(
				"ΕΠΙΛΕΞΤΕ ΤΑ ΣΤΟΙΧΕΙΑ ΤΟΥ ΠΡΟΓΡΑΜΜΑ ΕΚΠΑΙΔΕΥΣΗΣ ΠΟΥ ΘΑ ΘΕΛΑΤΕ ΝΑ ΠΡΟΒΑΛΛΕΤΕ ΣΤΟ ΠΙΝΑΚΑ:");
		text_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		text_Label.setBounds(24, 0, 800, 150);
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
		end_button.setBounds(570, 260, 175, 50);
		end_button.setFont(new Font("Tahoma", Font.PLAIN, 17));
		getContentPane().add(end_button);
		getContentPane().setLayout(null);
		end_button.addActionListener(this);
		end_button.setFocusable(false);

		// ΔΙΑΧΕΙΡΙΣΗ ΟΛΩΝ ΤΩΝ ΑΠΑΡΑΙΤΗΤΩΝ ΠΡΑΓΜΑΤΩΝ ΓΙΑ ΤΟ FRAME
		setVisible(true);
		setSize(850, 350);
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
			// ΕΚΧΩΡΕΙΤΕ ΤΟ ΠΡΟΓΡΑΜΜΑ ΕΚΠΑΙΔΕΥΣΗΣ ΠΟΥ ΕΧΕΙ ΕΠΙΛΕΧΘΕΙ ΣΕ ΜΙΑ ΜΕΤΑΒΛΗΤΗ ΓΙΑ ΝΑ
			// ΠΕΡΑΣΤΕΙ ΣΑΝ
			// ΟΡΙΣΜΑ

			TrainingProgram = (String) trainingProgram_box.getSelectedItem();
			show_gui.sortTrainingProgram(TrainingProgram);
			dispose();
		}

	}

}