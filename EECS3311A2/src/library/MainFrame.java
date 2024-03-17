package library;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

public class MainFrame extends JFrame {
	
	final JButton homeButton = new JButton("Home");
	final JButton subsButton = new JButton("Subscriptions");
	final JButton coursesButton = new JButton("Courses");
	final JButton searchButton = new JButton("Book Search");
	final JButton requestButton = new JButton("Requests");
	final JButton discountButton = new JButton("Discounted items");
	final JButton exitApp = new JButton("Exit app");
	
	private JPanel east;
	private JPanel search;
	private Component current;
	
	//east
	private JTextArea notifications = new JTextArea("BlahBlahBlahBalH notifications will go here");
	
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
	
	
	
	
	public MainFrame() {
		
		this.setVisible(true);
	    this.getContentPane().setBackground(Color.WHITE);
	    this.setTitle("Yorku Library Home");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    
	    
	    JPanel buttons = new JPanel();
	    buttons.add(homeButton);
	    buttons.add(subsButton);
	    buttons.add(coursesButton);
	    buttons.add(searchButton);
	    buttons.add(requestButton);
	    buttons.add(discountButton);
	    buttons.add(exitApp);
	    buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
	    
	    
	    
	    this.east = new JPanel(new FlowLayout());
	    this.east.setBackground(Color.RED);
	    this.current = this.east;
	    this.east.add(notifications);
	    
	    this.setLayout(new BorderLayout());
	    this.add(buttons, BorderLayout.WEST);
	    this.add(east);
	    
	    homeButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	
	            east();
	        }
	    });
	    
	    subsButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	
	            subs();
	        }
	    });
	    
	    coursesButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            courses();
	            
	        }
	    });

	    searchButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            searchFrame();
	            
	        }
	    });
	    
	    requestButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            requests();
	            
	        }
	    });
	    
	    discountButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            discounts();
	            
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
	        	setVisible(false);
                dispose();
	            
	        }
	    });
	    
	}
	
	private void east() {
		this.remove(this.current);
	    this.setTitle("Yorku Library Home");
	    
	    this.east = new JPanel(new FlowLayout());
	    this.east.setBackground(Color.RED);
	    this.east.add(notifications);
	    

	    this.add(this.east);
	    this.validate();
	    this.current=this.east;
		
	}
	
	private void subs() {
		this.remove(this.current);
	    this.setTitle("Yorku Library Subscriptions");
	    
	    JPanel subs = new JPanel();
	    subs.setBackground(Color.ORANGE);
	    subs.add(subscriptionsList);
	    
	    this.add(subs);
	    this.validate();
	    this.current=subs;
	}
	
	private void courses() {
		this.remove(this.current);
	    this.setTitle("Yorku Library Courses");
	    
	    JPanel courses = new JPanel();
	    courses.setBackground(Color.YELLOW);
	    courses.add(this.courseList);
	    
	    
	    this.add(courses);
	    this.validate();
	    this.current=courses;
	}
	
	public void searchFrame() {
		this.remove(this.current);
	    this.setTitle("Yorku Library Search");
	    
	    buttonSearch.setBounds(10,80,80,25);
	    
	    this.search = new JPanel();
	    
	    this.search.setBackground(Color.GREEN);
	    
	    this.search.add(searchLabel);
	    this.search.add(searchText);
	    this.search.add(buttonSearch);
	    this.search.add(searchStatus);
	    
	    this.add(search);
	    this.validate();
	    this.current=this.search;
	}
	
	private void requests() {
		this.remove(this.current);
	    this.setTitle("Yorku Library Home");
	    
	    JPanel requests = new JPanel();
	    requests.setBackground(Color.BLUE);
	    requests.add(requestLabel);
	    requests.add(requestText );
	    requests.add(requestInputButton);
	    
	    this.add(requests);
	    this.validate();
	    this.current=requests;
		
	}
	
	private void discounts() {
		this.remove(this.current);
	    this.setTitle("Yorku Library Home");
	    
	    JPanel discounts = new JPanel();
	    discounts.setBackground(Color.MAGENTA);
	    discounts.add(discountItems);
	    
	    this.add(discounts);
	    this.validate();
	    this.current=discounts;
		
	}
	


	
	
	
	
	
	

}
