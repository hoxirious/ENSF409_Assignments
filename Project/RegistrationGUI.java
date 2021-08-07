import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class RegistrationGUI.
 */
public class RegistrationGUI extends JFrame {
	/** The Constant programName. */
	private final static String programName = "Registration Application";

	/** The Constant buttonList. */
	private final static String[] buttonList = { "Show courses", "Student Courses", "Add Course", "Search Course",
			"Save Database", "Delete Course " };

	/** The Constant questionList. */
	private final static String[] questionList = { "Please enter course name: ", "Please enter course number: ",
			"Please enter student's id: ", "Please enter section number: " };

	/* Variables Declaration */
	private PrintWriter socketOut;
	private BufferedReader socketIn;
	private JTextArea mainScreen;
	private JButton showCatalogueBtn, showStudentCoursesBtn, addCourseBtn, searchCourseBtn, saveDatabaseBtn,
			deleteCourseBtn;
	private JPanel titlePanel, buttonPanel, containerPanel, searchPanel, coursePanel;
	private JLabel title, courseName1LB, courseNum1LB, courseName2LB, courseNum2LB, studentIdLB, secNumLB;
	private JTextField courseName1TF, courseNum1TF, courseName2TF, courseNum2TF, studentIdTF, secNumTF;

	/**
	 * Instantiates a new registration GUI.
	 *
	 * @param in  the in
	 * @param out the out
	 */
	public RegistrationGUI(BufferedReader in, PrintWriter out) {
		super(programName);
		socketOut = out;
		socketIn = in;
		initComponents();
		onActionListener();
		setVisible(true);
	}

	/**
	 * Initializes the components.
	 */
	private void initComponents() {
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(230, 230, 250));
		this.setBounds(100, 100, 800, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/** Initializes new compononents **/
		mainScreen = new JTextArea();
		mainScreen.setEditable(false);
		showCatalogueBtn = new JButton(buttonList[0]);
		showStudentCoursesBtn = new JButton(buttonList[1]);
		addCourseBtn = new JButton(buttonList[2]);
		searchCourseBtn = new JButton(buttonList[3]);
		deleteCourseBtn = new JButton(buttonList[5]);
		courseName1TF = new JTextField("ENSF");
		courseNum1TF = new JTextField("409");
		courseName2TF = new JTextField("ENSF");
		courseNum2TF = new JTextField("409");
		studentIdTF = new JTextField("1");
		secNumTF = new JTextField("1");
		title = new JLabel(programName);
		courseName1LB = new JLabel(questionList[0]);
		courseName2LB = new JLabel(questionList[0]);
		courseNum1LB = new JLabel(questionList[1]);
		courseNum2LB = new JLabel(questionList[1]);
		studentIdLB = new JLabel(questionList[2]);
		secNumLB = new JLabel(questionList[3]);

		titlePanel = new JPanel();
		buttonPanel = new JPanel(new GridLayout(5, 1));
		searchPanel = new JPanel();
		coursePanel = new JPanel();
		containerPanel = new JPanel(new BorderLayout());
		containerPanel.setBorder(new EmptyBorder(0, 10, 10, 10));

		/** Set background color **/
		buttonPanel.setBackground(new Color(230, 230, 250));
		titlePanel.setBackground(new Color(230, 230, 250));
		coursePanel.setBackground(new Color(230, 230, 250));
		searchPanel.setBackground(new Color(230, 230, 250));

		/** Add components to panels **/
		titlePanel.add(title, BorderLayout.CENTER);
		buttonPanel.add(showCatalogueBtn);
		buttonPanel.add(showStudentCoursesBtn);
		buttonPanel.add(addCourseBtn);
		buttonPanel.add(deleteCourseBtn);
		buttonPanel.add(searchCourseBtn);

		coursePanel.add(studentIdLB);
		coursePanel.add(studentIdTF);
		coursePanel.add(Box.createHorizontalStrut(15));
		coursePanel.add(courseName1LB);
		coursePanel.add(courseName1TF);
		coursePanel.add(Box.createHorizontalStrut(15));
		coursePanel.add(courseNum1LB);
		coursePanel.add(courseNum1TF);
		coursePanel.add(Box.createHorizontalStrut(15));
		coursePanel.add(secNumLB);
		coursePanel.add(secNumTF);

		searchPanel.add(courseName2LB);
		searchPanel.add(courseName2TF);
		searchPanel.add(Box.createHorizontalStrut(15));
		searchPanel.add(courseNum2LB);
		searchPanel.add(courseNum2TF);

		JScrollPane screenPanel = new JScrollPane(mainScreen);

		/** Add panels to frame **/
		containerPanel.add(titlePanel, BorderLayout.NORTH);
		containerPanel.add(buttonPanel, BorderLayout.EAST);
		containerPanel.add(screenPanel, BorderLayout.CENTER);
		this.add(containerPanel, BorderLayout.CENTER);
	}

	/**
	 * On action listener.
	 */
	private void onActionListener() {

		searchCourseBtn.addActionListener((ActionEvent e) -> {
			socketOut.println("1");
			int result = JOptionPane.showConfirmDialog(this, searchPanel, "Please Enter Course Name and Number",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				String s = courseName2TF.getText() + " " + courseNum2TF.getText();
				socketOut.println(s);

			} else {
				String s = "CANCEL" + " " + "0";
				socketOut.println(s);
			}

			String response, content = "";
			try {
				while ((response = socketIn.readLine()) != null && socketIn.ready()) {
					content += response + "\n";

				}
				mainScreen.setText(content);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});
		addCourseBtn.addActionListener((ActionEvent e) -> {
			socketOut.println("2");

			int result = JOptionPane.showConfirmDialog(this, coursePanel, "Please Enter Course Name and Number",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				String s = studentIdTF.getText() + " " + courseName1TF.getText() + " " + courseNum1TF.getText() + " "
						+ secNumTF.getText();
				socketOut.println(s);
			} else {
				String s = "0" + " " + "CANCEL" + " " + "0" + " " + "0";
				socketOut.println(s);
			}
			String response, content = "";
			try {
				while ((response = socketIn.readLine()) != null && socketIn.ready()) {
					content += response + "\n";
				}
				mainScreen.setText(content);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		deleteCourseBtn.addActionListener((ActionEvent e) -> {
			socketOut.println("3");

			int result = JOptionPane.showConfirmDialog(this, coursePanel, "Please Enter Course Name and Number",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				String s = studentIdTF.getText() + " " + courseName1TF.getText() + " " + courseNum1TF.getText() + " "
						+ secNumTF.getText();
				socketOut.println(s);
			} else {
				String s = "0" + " " + "CANCEL" + " " + "0" + " " + "0";
				socketOut.println(s);
			}

			String response, content = "";
			try {
				while ((response = socketIn.readLine()) != null && socketIn.ready()) {
					content += response + "\n";
				}
				mainScreen.setText(content);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});

		showCatalogueBtn.addActionListener((ActionEvent e) -> {
			socketOut.println("4");
			String response, content = "";
			try {
				while ((response = socketIn.readLine()) != null && socketIn.ready()) {
					content += response + "\n";
				}
				mainScreen.setText(content);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		showStudentCoursesBtn.addActionListener((ActionEvent e) -> {
			socketOut.println("5");

			String result = JOptionPane.showInputDialog(this, "Please student's id: ", "1");

			if (result != null && result != "") {
				socketOut.println(result);
			} else {
				socketOut.println("0");
			}
			String response, content = "";
			try {
				while ((response = socketIn.readLine()) != null && socketIn.ready()) {
					content += response + "\n";
				}
				mainScreen.setText(content);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				socketOut.println("6");
			}

			@Override
			public void windowClosed(WindowEvent e) {
				socketOut.println("6");
			}

		});

	}

}
