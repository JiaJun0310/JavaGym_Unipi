import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.time.LocalDate;


public class AthleteScreen implements ActionListener
{
	//Όλα τα global ορίσματα της κλάσης
	private JButton addButton, backButton, deleteButton, updateButton;
	private JFrame frame;
	private Object[] data;
	private static String genderString = "Άνδρας";
	private JComboBox<?> expBox, payBox, dofBox, dof1Box, dof2Box;
	private JCheckBox profesionalBox;
	private JTextField codeText, fnameText, lnameText, contactText;
	private JRadioButton maleButton, femaleButton;
	private DefaultTableModel tableModel;
	private static ArrayList<Athlete> athleteList = new ArrayList<Athlete>();
	private static ArrayList<Payment> paymentList = new ArrayList<Payment>();
	private static ArrayList<Enrollment> enrollmentList = new ArrayList<Enrollment>();
	private static int numOfAthletes ;
	private JTable table;
	
	public AthleteScreen()
	{
		
		//Φτιάχνω το frame με Swing
		ImageIcon icon = new ImageIcon("UNIPI.jpg");
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(230, 230, 230));
		
		BorderLayout borderLayout = new BorderLayout();
		frame.getContentPane().setLayout(borderLayout);
		
		//Τα LABELS
		JLabel codeLabel = new JLabel("Κωδικός:");
		codeLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        JLabel fnameLabel = new JLabel("Όνομα:");
        fnameLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        JLabel lnameLabel = new JLabel("Επώνυμο:");
        lnameLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        JLabel genderLabel = new JLabel("Φύλο:");
        genderLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        JLabel dofLabel = new JLabel("Έτος Γέννησης:");
        dofLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        JLabel dof1Label = new JLabel("Μήνας:");
        dof1Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
        JLabel dof2Label = new JLabel("Ημέρα:");
        dof2Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
        JLabel contactLabel = new JLabel("Στοιχεία Επικοινωνίας:");
        contactLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        JLabel expLabel = new JLabel("Επίπεδο Εμπειρίας:");
        expLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        JLabel payLabel = new JLabel("Τρόπος Πληρωμής:");
        payLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        
        codeLabel.setBounds(10,-19,122,100);
        fnameLabel.setBounds(10,48,100,100);
        lnameLabel.setBounds(10,107,100,100);
        genderLabel.setBounds(10,175,100,100);
        dofLabel.setBounds(10,256,159,100);
        dof1Label.setBounds(251,256,122,100);
        dof2Label.setBounds(458,256,100,100);
        contactLabel.setBounds(10,336,216,100);
        expLabel.setBounds(369,450,216,100);
        payLabel.setBounds(369,556,216,100);
        
        
        
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
        
        
        
        
        
        
        //Το Table
        
        String[] columnNames = {"Κωδικός", "Όνομα", "Επώνυμο", "Φύλο", "Ημερομηνία Γέννησης", "Στοιχεία Επικοινωνίας", "παγγελματίας", "Eπίπεδο Εμπειρίας"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        table.setDefaultEditor(Object.class, null);
        table.getTableHeader().setReorderingAllowed(false);
        table.removeEditor();
        table.setBounds(37,38,763,709);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,0,816,747);
        
        Object[] newRow = new Object[8];
        for (int i = 0; i < athleteList.size(); i++) 
        {
            newRow[0] = athleteList.get(i).getId();
            newRow[1] = athleteList.get(i).getFirstName();              
            newRow[2] = athleteList.get(i).getLastName();
            newRow[3] = athleteList.get(i).getGender();
            newRow[4] = athleteList.get(i).getBirthDate();
            newRow[5] = athleteList.get(i).getContactDetails();
            newRow[6] = athleteList.get(i).getProfessional();
            newRow[7] = athleteList.get(i).getExperienceLevel();
            tableModel.addRow(newRow);
            
        }
        


        
        
        //koutakia gia text
        
        codeText = new JTextField();
        codeText.setBackground(new Color(192, 192, 192));
        codeText.setDisabledTextColor(new Color(128, 128, 128));
        codeText.setForeground(new Color(255, 255, 255));
        codeText.setCaretColor(new Color(0, 0, 0));
        codeText.setFont(new Font("Tahoma", Font.PLAIN, 17));
        codeText.setPreferredSize(new Dimension(250,40));
        codeText.setBounds(189, 12, 427, 40);
        codeText.setEnabled(false);
        codeText.setText(Integer.toString(numOfAthletes));
        
        fnameText = new JTextField();
        fnameText.setFont(new Font("Tahoma", Font.PLAIN, 17));
        fnameText.setPreferredSize(new Dimension(250,40));
        fnameText.setBounds(189, 79, 427, 40);
        
        lnameText = new JTextField();
        lnameText.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lnameText.setPreferredSize(new Dimension(250,40));
        lnameText.setBounds(189, 138, 427, 40);
        
        
        contactText = new JTextField();
        contactText.setFont(new Font("Tahoma", Font.PLAIN, 17));
        contactText.setPreferredSize(new Dimension(250,40));
        contactText.setBounds(189, 367, 427, 40);
        
        
        maleButton = new JRadioButton("Άνδρας");
        maleButton.setBackground(new Color(230, 230, 230));
        maleButton.addActionListener(this);
        maleButton.setFocusable(false);
        maleButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
        maleButton.setBounds(241, 208, 90, 35);
        maleButton.setSelected(true);
        
        
        femaleButton = new JRadioButton("Γυναίκα");
        femaleButton.setBackground(new Color(230, 230, 230));
        femaleButton.setFocusable(false);
        femaleButton.addActionListener(this);
        femaleButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
        femaleButton.setBounds(458, 208, 90, 35);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(femaleButton);
        genderGroup.add(maleButton);

		//check boxes
        profesionalBox = new JCheckBox();
        profesionalBox.setBackground(new Color(230, 230, 230));
        profesionalBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
        profesionalBox.setText("Επαγγελματίας");
        profesionalBox.setHorizontalTextPosition(JCheckBox.LEFT);
        profesionalBox.setBounds(48, 464, 189, 73);
        profesionalBox.setFocusable(false);
        
        
        //combo boxes
        String[] expOptions = {"1","2","3","4","5"};
        expBox = new JComboBox<>(expOptions);
        expBox.setFocusable(false);
        expBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
        expBox.setBounds(518,480,106,40);
        
        String[] payOptions = {"Μετρητά","Κάρτα"};
        payBox = new JComboBox<>(payOptions);
        payBox.setFocusable(false);
        payBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
        payBox.setBounds(518,586,106,40);
        
        String[] dofOptions = 
        {
            "2023", "2022", "2021", "2020", 
            "2019", "2018", "2017", "2016", "2015", 
            "2014", "2013", "2012", "2011", "2010", 
            "2009", "2008", "2007", "2006", "2005", 
            "2004", "2003", "2002", "2001", "2000", 
            "1999", "1998", "1997", "1996", "1995", 
            "1994", "1993", "1992", "1991", "1990", 
            "1989", "1988", "1987", "1986", "1985", 
            "1984", "1983", "1982", "1981", "1980", 
            "1979", "1978", "1977", "1976", "1975", 
            "1974", "1973", "1972", "1971", "1970", 
            "1969", "1968", "1967", "1966", "1965", 
            "1964", "1963", "1962", "1961", "1960", 
            "1959", "1958", "1957", "1956", "1955", 
            "1954", "1953", "1952", "1951", "1950", 
            "1949", "1948", "1947", "1946", "1945", 
            "1944", "1943", "1942", "1941", "1940", 
            "1939", "1938", "1937", "1936", "1935", 
            "1934", "1933", "1932", "1931", "1930", 
            "1929", "1928", "1927", "1926", "1925", 
            "1924", "1923", "1922", "1921", "1920", 
            "1919", "1918", "1917", "1916", "1915", 
            "1914", "1913", "1912", "1911", "1910", 
            "1909", "1908", "1907", "1906", "1905", 
            "1904", "1903", "1902", "1901", "1900"
        };
        
        dofBox = new JComboBox<>(dofOptions);
        dofBox.setFocusable(false);
        dofBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
        dofBox.setBounds(135,286,106,40);
        
        String[] dof1Options = 
        {
            "1", "2", "3", "4", "5", 
            "6", "7", "8", "9", "10", 
            "11", "12"
        };
        dof1Box = new JComboBox<>(dof1Options);
        dof1Box.setFocusable(false);
        dof1Box.setFont(new Font("Tahoma", Font.PLAIN, 17));
        dof1Box.setBounds(325,286,106,40);
        
        String[] dof2Options = 
        {
            "1", "2", "3", "4", "5", 
            "6", "7", "8", "9", "10", 
            "11", "12", "13", "14", "15", 
            "16", "17", "18", "19", "20", 
            "21", "22", "23", "24", "25", 
            "26", "27", "28", "29", "30", 
            "31"
        };
        dof2Box = new JComboBox<>(dof2Options);
        dof2Box.setFocusable(false);
        dof2Box.setFont(new Font("Tahoma", Font.PLAIN, 17));
        dof2Box.setBounds(518,286,106,40);
        
        //Ολα τα Buttons
        addButton = new JButton();
        addButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
        addButton.setBounds(320, 11, 147, 62);
        addButton.setText("Καταχώρηση");
        addButton.addActionListener(this);
        addButton.setFocusable(false);
        
        updateButton = new JButton();
        updateButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
        updateButton.setBounds(544, 11, 147, 62);
        updateButton.setText("Ενημέρωση");
        updateButton.addActionListener(this);
        updateButton.setFocusable(false);
        
        deleteButton = new JButton();
        deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
        deleteButton.setBounds(769, 11, 147, 62);
        deleteButton.setText("Διαγραφή");
        deleteButton.addActionListener(this);
        deleteButton.setFocusable(false);
        
        
		
		//ότι έχει να κάνει με το Frame
		frame.setSize(1480,900);
		frame.setLocationRelativeTo(null);
		
		rightPanel.add(codeLabel);
		rightPanel.add(fnameLabel);
		rightPanel.add(lnameLabel);
		rightPanel.add(genderLabel);
		rightPanel.add(dofLabel);
		rightPanel.add(dof1Label);
		rightPanel.add(dof2Label);
		rightPanel.add(contactLabel);
		rightPanel.add(expLabel);
		rightPanel.add(payLabel);
		
		bottomPanel.add(addButton);
		bottomPanel.add(deleteButton);
		bottomPanel.add(updateButton);
		
		backButton = new JButton();
		backButton.setBounds(976, 11, 147, 62);
		bottomPanel.add(backButton);
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		backButton.setText("Επιστροφή");
		backButton.addActionListener(this);
		backButton.setFocusable(false);
		
		rightPanel.add(codeText);
		rightPanel.add(fnameText);
		rightPanel.add(lnameText);
		rightPanel.add(contactText);
		
		rightPanel.add(femaleButton);
		rightPanel.add(maleButton);
		
		rightPanel.add(profesionalBox);
		
		rightPanel.add(expBox);
		rightPanel.add(payBox);
		rightPanel.add(dofBox);
		rightPanel.add(dof1Box);
		rightPanel.add(dof2Box);
		
		frame.getContentPane().add(scrollPane);
		
		
		frame.setIconImage(icon.getImage());
		frame.setTitle("Διαχείριση Αθλητών");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		
	}
	//μέθοδος που κάνει τις εντολές των κουμπιών
	@Override
	//κουμπί επιστροφής
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== backButton)
		{
			new MainScreen();
			frame.dispose();
		}
		//κουμπί καταχώρησης
		if (e.getSource() == addButton)
		{
			
			if( (fnameText.getText().isEmpty()) ||
				(lnameText.getText().isEmpty()) ||
				(contactText.getText().isEmpty()))
			
			{
				JOptionPane.showMessageDialog(null, "πρέπει να συμπληρώσεις όλα τα κενά για να καταχωρίσεις έναν αθλητή!", "Warning", JOptionPane.WARNING_MESSAGE);
			}
			else if
			(
				(((dof1Box.getSelectedIndex() + 1) == 4 || (dof1Box.getSelectedIndex() + 1) == 6 || (dof1Box.getSelectedIndex() + 1) == 9 || (dof1Box.getSelectedIndex() + 1) == 11) && (dof2Box.getSelectedIndex() + 1) == 31)                   
			)
				
			{
				JOptionPane.showMessageDialog(null, "Αυτός ο μήνας δεν έχει "+ (dof2Box.getSelectedIndex() + 1) +" μέρες", "Warning", JOptionPane.WARNING_MESSAGE);
			}
			else if ((dof1Box.getSelectedIndex() + 1) == 2 && (dof2Box.getSelectedIndex() + 1) >= 29)
			{
				JOptionPane.showMessageDialog(null, "Αυτός ο μήνας δεν έχει "+ (dof2Box.getSelectedIndex() + 1) +" μέρες", "Warning", JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				
				String profesional = "Όχι";
				if(profesionalBox.isSelected())
				{
					profesional = "Ναι";
				}
				String fname = fnameText.getText();
				String lname = lnameText.getText();
				String dof ="" + (2023 - dofBox.getSelectedIndex())+ "-" + (dof1Box.getSelectedIndex() + 1) + "-" + (dof2Box.getSelectedIndex() + 1);
				String contact = contactText.getText();
				int exp = expBox.getSelectedIndex() + 1;
				Object[] newRow = {numOfAthletes, fname , lname, genderString , dof, contact, profesional ,exp};
				tableModel.addRow(newRow);
				
				
				Athlete tmpathlete = new Athlete(numOfAthletes, fname , lname, genderString , dof, contact, profesionalBox.isSelected() ,exp);
				athleteList.add(tmpathlete);
				
				
				
				int discount;
				if (expBox.getSelectedIndex() + 1 == 1 || expBox.getSelectedIndex() + 1 == 2)
				{
					discount = 10;
				}
				else if (expBox.getSelectedIndex() + 1 == 3 || expBox.getSelectedIndex() + 1 == 4)
				{
					discount = 20;
				}
				else
				{
					discount = 30;
				}
				
				double enrollmentPrice = 50;
				if (profesionalBox.isSelected())
				{
					enrollmentPrice = 20;
					discount = discount + 20;
				}
				JOptionPane.showMessageDialog(null, "Το ποσό πληρωμής για την έγγραφη σας είναι " + enrollmentPrice +"€\nΠαρακαλώ πατήστε ΟΚ για να πραγματοποιηθεί η πληρωμή", "Message", JOptionPane.PLAIN_MESSAGE);
				JOptionPane.showMessageDialog(null, "Η πληρωμή ολοκληρώθηκε επιτυχώς! \nΗ έκπτωση που δικαιούστε για τις συνδρομές είναι " + discount +"%", "Message", JOptionPane.PLAIN_MESSAGE);
				
				LocalDate today = LocalDate.now();
				Enrollment enr = new Enrollment(numOfAthletes, tmpathlete, today, enrollmentPrice, discount);
				enrollmentList.add(enr);
				
				String payMethod = "Μετρητά";
				if(payBox.getSelectedIndex() == 1)
				{
					payMethod = "Κάρτα";
				}
				if(numOfAthletes == 0)
				{
					Payment pay = new Payment(0, today, payMethod, enr, enrollmentPrice);
					paymentList.add(pay);
				}
				else
				{
					Payment pay = new Payment(paymentList.getLast().getId() + 1, today, payMethod, enr, enrollmentPrice);
					paymentList.add(pay);
				}
				
				
				
				
				
				numOfAthletes++;
				codeText.setText(Integer.toString(numOfAthletes));
				
				
				
				fnameText.setText(null);
				lnameText.setText(null);
				contactText.setText(null);
				profesionalBox.setSelected(false);
				expBox.setSelectedIndex(0);
				dofBox.setSelectedIndex(0);
				dof1Box.setSelectedIndex(0);
				dof2Box.setSelectedIndex(0);
			}
			
			
		}
		//Radio buttons
		if (e.getSource() == femaleButton)
		{
			genderString = "Γυνέκα";
			
		}
		if (e.getSource() == maleButton)
		{
			genderString = "Άνδρας";
		}
		//κουμπι Διαγραφης
		if (e.getSource() == deleteButton)
		{
			int selectedRow = table.getSelectedRow();
			
			if (selectedRow == -1)
			{
            	JOptionPane.showMessageDialog(null, "Πρέπει να επιλέξεις έναν αθλητή για να τον διαγράψεις!", "Warning", JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				tableModel.removeRow(selectedRow);
				athleteList.remove(selectedRow);
				enrollmentList.remove(selectedRow);
			}
		}
		//κουμπι update
		if (e.getSource() == updateButton)
		{
			int selectedRow = table.getSelectedRow();
			if (selectedRow == -1)
			{
            	JOptionPane.showMessageDialog(null, "Πρέπει να επιλέξεις έναν αθλητή!", "Warning", JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				if( (fnameText.getText().isEmpty()) ||
					(lnameText.getText().isEmpty()) ||
					(contactText.getText().isEmpty()))
				{
					JOptionPane.showMessageDialog(null, "πρέπει να συμπληρώσεις όλα τα κενά για να ενημέρωση έναν αθλητή!", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					String profesional = "Όχι";
					if(profesionalBox.isSelected())
					{
						profesional = "Ναι";
					}
					
					tableModel.setValueAt(fnameText.getText(), selectedRow, 1);
					tableModel.setValueAt(lnameText.getText(), selectedRow, 2);
					tableModel.setValueAt(genderString, selectedRow, 3);
					tableModel.setValueAt("" + (2023 - dofBox.getSelectedIndex())+ "-" + (dof1Box.getSelectedIndex() + 1) + "-" + (dof2Box.getSelectedIndex() + 1), selectedRow, 4);
					tableModel.setValueAt(contactText.getText(), selectedRow, 5);
					tableModel.setValueAt(profesional, selectedRow, 6);
					tableModel.setValueAt(expBox.getSelectedIndex() + 1, selectedRow, 7);
					
					fnameText.setText(null);
					lnameText.setText(null);
					contactText.setText(null);
					profesionalBox.setSelected(false);
					expBox.setSelectedIndex(0);
					dofBox.setSelectedIndex(0);
					dof1Box.setSelectedIndex(0);
					dof2Box.setSelectedIndex(0);
				}
			}
		}
		
	}
	
	
	//getters για τα ArrayLists
	static public ArrayList<Athlete> getAthleteList()
	{
		return athleteList;
	}
	static public ArrayList<Payment> getPaymentList()
	{
		return paymentList;
	}
	static public ArrayList<Enrollment> getEnrollmentList()
	{
		return enrollmentList;
	}
}


