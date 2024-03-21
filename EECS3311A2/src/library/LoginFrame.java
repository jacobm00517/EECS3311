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
                Facade f = new Facade();
                f.initializeGUI();
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
                Facade f = new Facade();
                if (f.loginUser(emailField.getText(), passwordField.getPassword())==null){
                    jlblStatus.setText("Invalid username or password");
                } else {
                    parent.setVisible(true);
                    setVisible(false);
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
                Facade f = new Facade();
            	jlblStatus.setText(f.makeUser(userTypeField.getText(), emailField.getText(), new String(passwordField.getPassword())));
                
            }
        });
    }
}