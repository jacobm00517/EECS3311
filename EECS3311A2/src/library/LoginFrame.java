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

    private final JTextField emailField = new JTextField(15);
    private final JPasswordField passwordField = new JPasswordField();

    private final JButton buttonOk = new JButton("Login");
    private final JButton buttonCancel = new JButton("Cancel");

    private final JLabel jlblStatus = new JLabel(" ");

    public PassWordDialog() {
        this(null, true);
    }

    public PassWordDialog(final JFrame parent, boolean modal) {
        super(parent, modal);

        
        JPanel namePanel = new JPanel(new GridLayout(2, 1));
        namePanel.add(emailLabel);
        namePanel.add(passwordLabel);

        
        JPanel fieldsPanel = new JPanel(new GridLayout(2, 1));
        fieldsPanel.add(emailField);
        fieldsPanel.add(passwordField);

        JPanel inputsPanel = new JPanel();
        inputsPanel.add(namePanel);
        inputsPanel.add(fieldsPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(buttonOk);
        buttonPanel.add(buttonCancel);

        JPanel statusPanel = new JPanel(new BorderLayout());
        statusPanel.add(buttonPanel, BorderLayout.CENTER);
        statusPanel.add(jlblStatus, BorderLayout.NORTH);
        jlblStatus.setForeground(Color.RED);
        jlblStatus.setHorizontalAlignment(SwingConstants.CENTER);

        setLayout(new BorderLayout());
        add(inputsPanel, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.SOUTH);
        pack();
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
    }
}