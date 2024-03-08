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
	final JButton button4name = new JButton("Button4");
	private JPanel east;
	private JPanel search;
	private Component current;
	

	private JLabel searchLabel = new JLabel("Search:");;
	private JTextField searchText = new JTextField(25);;
	private JButton buttonSearch = new JButton("Search");
	private JButton buttonBack = new JButton("Back");
	
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
	    
	    buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
	    
	    this.east = new JPanel(new FlowLayout());
	    this.east.setBackground(Color.RED);
	    this.east.add(button4name);
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
	    
	}
	
	private void east() {
		this.remove(this.current);
	    this.setTitle("Yorku Library Home");
	    
	    this.east = new JPanel(new FlowLayout());
	    this.east.setBackground(Color.RED);
	    this.east.add(button4name);
	    
	    this.add(this.east);
	    this.validate();
	    this.current=this.east;
		
	}
	
	private void subs() {
		this.remove(this.current);
	    this.setTitle("Yorku Library Subscriptions");
	    
	    JPanel subs = new JPanel();
	    subs.setBackground(Color.ORANGE);
	    
	    
	    this.add(subs);
	    this.validate();
	    this.current=subs;
	}
	
	private void courses() {
		this.remove(this.current);
	    this.setTitle("Yorku Library Courses");
	    
	    JPanel courses = new JPanel();
	    courses.setBackground(Color.YELLOW);
	    
	    
	    this.add(courses);
	    this.validate();
	    this.current=courses;
	}
	
	private void requests() {
		this.remove(this.current);
	    this.setTitle("Yorku Library Home");
	    
	    JPanel requests = new JPanel();
	    requests.setBackground(Color.BLUE);
	    
	    this.add(requests);
	    this.validate();
	    this.current=requests;
		
	}
	
	private void discounts() {
		this.remove(this.current);
	    this.setTitle("Yorku Library Home");
	    
	    JPanel discounts = new JPanel();
	    discounts.setBackground(Color.MAGENTA);
	    
	    this.add(discounts);
	    this.validate();
	    this.current=discounts;
		
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
	    this.search.add(buttonBack);
	    this.add(search);
	    this.validate();
	    this.current=this.search;
	}
	
	
	
	
	

}
