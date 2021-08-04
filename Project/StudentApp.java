import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentApp.
 */
public class StudentApp extends JFrame {

	/** The input stream. */
	public static FileManager inputStream = new FileManager();

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant programName. */
	private final static String programName = "Student Records";
	private final static String[] buttonList = { "Insert", "Find", "Browse", "Create Tree from File" };
	private ArrayList<Data> studentList;

	/* Variables Declaration */
	private JPanel buttonPanel, titlePanel;
	private JLabel title;
	private JScrollPane screenPanel;
	private JButton insertBtn, findBtn, browseBtn, createTreeBtn;
	private JTextArea mainScreen;
	private BinSearchTree studentTree;

	/**
	 * Instantiates a new student app.
	 */
	public StudentApp() {
		super(programName);
		studentTree = new BinSearchTree();
		initComponents();
		onActionListener();
		setVisible(true);
	}

	/**
	 * Inititiates every component.
	 */
	private void initComponents() {
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(230, 230, 250));
		this.setBounds(100, 100, 800, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		buttonPanel = new JPanel(new GridLayout(1, 3, 30, 0));
		titlePanel = new JPanel();
		buttonPanel.setBackground(new Color(230, 230, 250));
		titlePanel.setBackground(new Color(230, 230, 250));

		insertBtn = new JButton(buttonList[0]);
		findBtn = new JButton(buttonList[1]);
		browseBtn = new JButton(buttonList[2]);
		createTreeBtn = new JButton(buttonList[3]);
		title = new JLabel(programName);

		mainScreen = new JTextArea(5, 30);

		screenPanel = new JScrollPane() {
			private static final long serialVersionUID = 1L;

			@Override
			public Dimension getPreferredSize() {
				return new Dimension(750, 200);
			}
		};
		screenPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		/* add buttons to panel */
		buttonPanel.add(insertBtn);
		buttonPanel.add(findBtn);
		buttonPanel.add(browseBtn);
		buttonPanel.add(createTreeBtn);
		titlePanel.add(title, BorderLayout.CENTER);
		JScrollPane scrollPane = new JScrollPane(mainScreen);

		/* Adds panels to frame */
		this.add(titlePanel, BorderLayout.NORTH);
		this.add(buttonPanel, BorderLayout.SOUTH);
		this.add(scrollPane, BorderLayout.CENTER);
	}

	/**
	 * On action listener.
	 */
	private void onActionListener() {
		insertBtn.addActionListener((ActionEvent e) -> {
			new InsertStudentGUI(studentTree);
		});
		findBtn.addActionListener((ActionEvent e) -> {
			String id = JOptionPane.showInputDialog(this, "Please enter the student's id: ", null);
			if (studentTree.find(studentTree.root, id) == null) {
				JOptionPane.showMessageDialog(this, "The student " + id + " is not found", "Not Found",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				String st = studentTree.find(studentTree.root, id).data.toString();
				JOptionPane.showMessageDialog(this, st, "Message", JOptionPane.INFORMATION_MESSAGE);
			}

		});
		browseBtn.addActionListener((ActionEvent e) -> {
			try {
				for (Data st : studentList) {
					mainScreen
							.append(st.id + "        " + st.faculty + "     " + st.major + "       " + st.year + "\n");
				}
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Please load students before browsing",
						"Student Record Unavailable", JOptionPane.ERROR_MESSAGE);
			}
		});
		createTreeBtn.addActionListener((ActionEvent e) -> {
			getFileName();
			try {
				PrintWriter output = new PrintWriter("input.txt");
				studentTree.print_tree(studentTree.root, output);
				output.close();
			} catch (Exception e2) {
				e2.getStackTrace();
			}
		});
	}

	/**
	 * Gets the file name.
	 *
	 */
	private void getFileName() {
		String inputLocation = JOptionPane.showInputDialog(this, "Enter the file name: ", null);

		try {
			studentList = inputStream.readInput(inputLocation);
			for (Data st : studentList) {
				studentTree.insert(st.id, st.faculty, st.major, st.year);
			}
		} catch (FileNotFoundException e1) {
			JOptionPane.showMessageDialog(this, "Please enter the valid file name", "Invalid Input",
					JOptionPane.ERROR_MESSAGE);
			getFileName();
		}
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		StudentApp myStudentApp = new StudentApp();

	}
}
