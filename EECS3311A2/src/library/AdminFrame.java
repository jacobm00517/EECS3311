package library;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class AdminFrame extends JFrame {

	private User user;
	private Account account;
	
	final JButton homeButton = new JButton("Unregistered Users");
	final JButton itemButton = new JButton("Items");
	final JButton addItemsButton = new JButton("Add an Item");
	final JButton requestButton = new JButton("Book Requests");
	final JButton exitApp = new JButton("Exit app");
	
	private JPanel east;
	private Component current;
	
	//east
	
	private JTextArea subscriptionsList = new JTextArea("BlahBlahBlahBalH subscriptions\n");
	
	private JTextArea courseList = new JTextArea("BlahBlahBlahBalH courses and their books\n");
	
	private JLabel searchLabel = new JLabel("Search:");
	private JTextField searchText = new JTextField(25);
	private JButton buttonSearch = new JButton("Search");
	private final JLabel searchStatus = new JLabel(" ");
	
	private JLabel requestLabel = new JLabel("Request (Item name, Publication date, Author)");
	private JTextField requestText = new JTextField(25);
	private JButton requestInputButton = new JButton("Submit");
	
	private JTextArea discountItems = new JTextArea("Place discounted items. Will likely have to have buttons.");
	
	
	
	
	public AdminFrame(User u) {
		this.user = u;
		this.account = new Account(u);


		this.setVisible(true);
	    this.getContentPane().setBackground(Color.WHITE);
	    this.setTitle("Yorku Library Admin");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.validate();
	    
	    JPanel buttons = new JPanel();
	    buttons.add(homeButton);
        buttons.add(itemButton);
        buttons.add(addItemsButton);
	    buttons.add(requestButton);
	    buttons.add(exitApp);
	    buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
	    buttons.setBackground(Color.DARK_GRAY);
	    
	    
	    
	    this.east = new JPanel(new FlowLayout());
	    this.east.setBackground(Color.LIGHT_GRAY);
	    this.current = this.east;
	    
	    this.setLayout(new BorderLayout());
	    this.add(buttons, BorderLayout.WEST);
	    this.add(east);
	    
	    homeButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	
	            east();
	        }
	    });

        itemButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	
	            item();
	        }
	    });
	    
	    
	    requestButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            requests();
	            
	        }
	    });
	    
	    buttonSearch.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	//send searchText.getText() to search() method
	            
	        }
	    });
	    
	    exitApp.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	//To Do: Save everything to databases
				MaintainUnregisteredUser URUserDB = new MaintainUnregisteredUser();
				UserDatabase userDB = new MaintainUserProxy();
				ItemDatabase itemDB = new MaintainItemsProxy();

				try {
					URUserDB.update(pathNames.unregisteredDBPath);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {
					userDB.update();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {
					itemDB.update();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
	        	setVisible(false);
                dispose();
	            
	        }
	    });
	    
	}
	
	private void east() {
		this.remove(this.current);
	    this.setTitle("Yorku Library Home");
	    

	    this.east = new JPanel(new FlowLayout());
	    this.east.setBackground(Color.LIGHT_GRAY);
	    

	    this.add(this.east);
	    this.validate();
	    this.current=this.east;
		
	}

    private void item() {
		this.remove(this.current);
	    this.setTitle("Yorku Library Items");
	    
	    JPanel items = new JPanel();
	    this.east.setBackground(Color.LIGHT_GRAY);
	    

	    this.add(items);
	    this.validate();
	    this.current=items;
		
	}
	
	
	private void requests() {
		this.remove(this.current);
	    this.setTitle("Yorku Library Home");
	    
	    JPanel requests = new JPanel();
	    requests.setBackground(Color.LIGHT_GRAY);
	    requests.add(requestLabel);
	    requests.add(requestText );
	    requests.add(requestInputButton);
	    
	    this.add(requests);
	    this.validate();
	    this.current=requests;
		
	}
	
	


	
	
	
	
	
	

}
