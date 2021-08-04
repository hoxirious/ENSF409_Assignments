import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// TODO: Auto-generated Javadoc
/**
 * The Class InsertStudentGUI.
 */
public class InsertStudentGUI extends JFrame {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant programName. */
	private final static String programName = "Insert new node";
	private final static String[] questionList = { "Enter the Student ID", "Enter Faculty", "Enter Student's Major",
			"Enter Year" };
	private final static String[] buttonList = { "Insert" };
	
	/* Variables Declaration */
	private BinSearchTree studentTree;
	private JTextField idTF, facultyTF, majorTF, yearTF;
	private JLabel idLbl, facultyLbl, majorLbl, yearLbl, title;
	private JButton insertBtn;
	private JPanel buttonPanel, textFieldPanel, textFieldPanel1, textFieldPanel2, titlePanel;

	/**
	 * Instantiates a new insert student GUI.
	 *
	 * @param studentTree the student tree
	 */
	public InsertStudentGUI(BinSearchTree studentTree) {
		super(programName);
		initComponents();
		this.studentTree = studentTree;
		onActionListener();
		setVisible(true);
	}

	/**
	 * Inititiates every component.
	 */
	private void initComponents() {
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(230, 230, 250));
		this.setBounds(100, 100, 700, 200);

		buttonPanel = new JPanel();
		textFieldPanel1 = new JPanel(new GridLayout(1, 2, 60, 0));
		textFieldPanel2 = new JPanel(new GridLayout(1, 2, 60, 0));
		titlePanel = new JPanel();
		buttonPanel.setBackground(new Color(230, 230, 250));
		titlePanel.setBackground(new Color(230, 230, 250));

		idTF = new JTextField();
		facultyTF = new JTextField();
		majorTF = new JTextField();
		yearTF = new JTextField();
		title = new JLabel(programName);

		idLbl = new JLabel(questionList[0]);
		facultyLbl = new JLabel(questionList[1]);
		majorLbl = new JLabel(questionList[2]);
		yearLbl = new JLabel(questionList[3]);

		insertBtn = new JButton(buttonList[0]);

		textFieldPanel = new JPanel(new FlowLayout()) {
			private static final long serialVersionUID = 1L;
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(660, 100);
			}
		};

		/* add components to panel */
		textFieldPanel.add(textFieldPanel1, BorderLayout.CENTER);
		textFieldPanel.add(textFieldPanel2, BorderLayout.SOUTH);
		titlePanel.add(title, BorderLayout.CENTER);
		buttonPanel.add(insertBtn, BorderLayout.CENTER);
		textFieldPanel1.add(idLbl);
		textFieldPanel1.add(idTF);
		textFieldPanel1.add(facultyLbl);
		textFieldPanel1.add(facultyTF);
		textFieldPanel2.add(majorLbl);
		textFieldPanel2.add(majorTF);
		textFieldPanel2.add(yearLbl);
		textFieldPanel2.add(yearTF);

		/*Adds panels to frame*/
		this.add(titlePanel, BorderLayout.NORTH);
		this.add(textFieldPanel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);

	}

	/**
	 * On action listener.
	 */
	private void onActionListener() {
		insertBtn.addActionListener((ActionEvent e) -> {
			studentTree.insert(idTF.getText(), facultyTF.getText(), majorTF.getText(), yearTF.getText());
		});
	}

}
