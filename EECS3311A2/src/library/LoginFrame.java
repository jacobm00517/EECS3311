package library;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

public class LoginFrame extends JFrame {

    private static final long serialVersionUID = -4411941358015018712L;
	private PassWordDialog passDialog;

    public LoginFrame() {
        passDialog = new PassWordDialog(this, true);
        passDialog.setVisible(true);
    }

    public static void main(String[] args) {
    	
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame mainFrame = new LoginFrame();
                mainFrame.setVisible(false);
                mainFrame.dispose();
                new MainFrame();
            }
            
        });
        
    }
    
}

class PassWordDialog extends JDialog {

    private final JLabel emailLabel = new JLabel("email");
    private final JLabel passwordLabel = new JLabel("Password");
    private final JLabel userTypeLabel = new JLabel("User type");

    private final JTextField emailField = new JTextField(15);
    private final JPasswordField passwordField = new JPasswordField();
    private final JTextField userTypeField = new JTextField(15);

    private final JButton buttonOk = new JButton("Login");
    private final JButton buttonCancel = new JButton("Cancel");
    private final JButton buttonRegister = new JButton("Register");

    private final JLabel jlblStatus = new JLabel(" ");

    public PassWordDialog() {
        this(null, true);
    }

    public PassWordDialog(final JFrame parent, boolean modal) {
        super(parent, modal);

        
        JPanel namePanel = new JPanel(new GridLayout(3, 1));
        namePanel.add(emailLabel);
        namePanel.add(passwordLabel);
        namePanel.add(userTypeLabel);

        
        JPanel fieldsPanel = new JPanel(new GridLayout(3, 1));
        fieldsPanel.add(emailField);
        fieldsPanel.add(passwordField);
        fieldsPanel.add(userTypeField);

        JPanel inputsPanel = new JPanel();
        inputsPanel.add(namePanel);
        inputsPanel.add(fieldsPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(buttonOk);
        buttonPanel.add(buttonRegister);
        buttonPanel.add(buttonCancel);

        JPanel statusPanel = new JPanel(new BorderLayout());
        statusPanel.add(buttonPanel, BorderLayout.CENTER);
        statusPanel.add(jlblStatus, BorderLayout.NORTH);
        jlblStatus.setForeground(Color.RED);
        jlblStatus.setHorizontalAlignment(SwingConstants.CENTER);

        setLayout(new BorderLayout());
        add(inputsPanel, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.SOUTH);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addWindowListener(new WindowAdapter() {  
            @Override
            public void windowClosing(WindowEvent e) {  
                System.exit(0);  
            }  
        });


        // To do: Implement so that fields are verified and validated in backend using database.
        buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Arrays.equals("p".toCharArray(), passwordField.getPassword())
                        && "e".equals(emailField.getText())) {
                    parent.setVisible(true);
                    setVisible(false);
                } else {
                    jlblStatus.setText("Invalid username or password");
                }
            }
        });
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                parent.dispose();
                System.exit(0);
            }
        });
        buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("student".equals(userTypeField.getText())||"faculty".equals(userTypeField.getText())||"non-faculty".equals(userTypeField.getText())) {
                	User newURUser = new User(userTypeField.getText(), emailField.getText(), new String(passwordField.getPassword()));
                	String pathUR = "/Users/jacobabarrota/Downloads/CSV_Example/URuser.csv";
            		MaintainUnregisteredUser maintainUR = new MaintainUnregisteredUser();
            	
            		try {
						maintainUR.load(pathUR);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            		
            		maintainUR.users.add(newURUser);
            		
            		try {
						maintainUR.update(pathUR);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
            		
            		jlblStatus.setText("Please wait for admin approval.");
                }
                
                else if ("visitor".equals(userTypeField.getText())) {
                	User newUser = new User(userTypeField.getText(), emailField.getText(), new String(passwordField.getPassword()));
                	String path = "/Users/jacobabarrota/Downloads/CSV_Example/user.csv";
            		MaintainUser maintain = new MaintainUser();
            	
            		try {
						maintain.load(path);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            		
            		maintain.users.add(newUser);
            		
            		try {
						maintain.update(path);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
            		
            		jlblStatus.setText("Registration successful.");
                }
                
                else {
                	jlblStatus.setText("<html>Use a valid email and pick one of the following user types:<br/>student, faculty, non-faculty, or visitor</html>");
                	
                	
                }
                
            }
        });
    }
}