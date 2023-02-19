package checkiesGUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CheckiesApp implements ActionListener {
	private JFrame frame;
	private JPanel panel;
	private JLabel headingLabel;
	private JButton loginButton;
	private JButton signUpButton;
	private JButton submitButton;
	private JButton submitButton2;
	private JButton submitButton3;
	private JButton proceedToCart;
	private JButton scanAnother;
	private JButton applePay;
	private JButton gPay;
	private JButton payPal;
	private JButton cards;
	private JTextField usernameTextField;
	private JPasswordField passwordTextField;
	private JTextField nameTextField;
	private JTextField emailTextField;
	private JTextField phoneTextField;
	private JTextField addressTextField;
	private JTextField storeNameTextField;
	private JTextField quantityTextField;
	private JButton uploadButton;
	private JLabel imageLabel;

	
	// constructor to initialize the UI components
	public CheckiesApp() {
		frame = new JFrame();
		panel = new JPanel();
		headingLabel = new JLabel("Checkies");
		loginButton = new JButton("Login");
		signUpButton = new JButton("Sign Up");
		submitButton = new JButton("Submit");
		submitButton2 = new JButton("Submit Store");
		submitButton3 = new JButton("Proceed To Payment");
		uploadButton = new JButton("Upload BarCode");
		imageLabel = new JLabel();
		proceedToCart = new JButton("Go To Cart");
		scanAnother = new JButton("Add More Items");
		
		applePay = new JButton("Pay With Apple Pay");
		gPay = new JButton("Pay With Google Pay");
		payPal = new JButton("Pay With PayPal");
		cards = new JButton("Pay With Debit/Credit Card");

		usernameTextField = new JTextField(20);
		passwordTextField = new JPasswordField(20);
		nameTextField = new JTextField(20);
		emailTextField = new JTextField(20);
		phoneTextField = new JTextField(20);
		addressTextField = new JTextField(20);
		storeNameTextField = new JTextField(20);
		quantityTextField = new JTextField(20);

		// adding the components to the panel
		panel.add(headingLabel);
		panel.add(loginButton);
		panel.add(signUpButton);

		// adding the panel to the frame and displaying it
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);

		// add action listeners to the buttons:) Click know
		loginButton.addActionListener(this);
		signUpButton.addActionListener(this);

	}

	// A method that dictates actions to be performed
	public void actionPerformed(ActionEvent e) {
		
		// clearing the panel
		panel.removeAll();

		// checking which button was clicked
		if (e.getSource() == loginButton) {
			
			// adding the labelText to the panel when clicked LogIn button
			panel.add(new JLabel("Username:"));
			
			// creating textField
			panel.add(usernameTextField);
			panel.add(new JLabel("Password:"));
			panel.add(passwordTextField);
			panel.add(submitButton);
			submitButton.addActionListener(this);

		} else if (e.getSource() == signUpButton) {
			
			// adding the sign up textLabels and boxes to the panel
			panel.add(new JLabel("Name:"));
			panel.add(nameTextField);
			panel.add(new JLabel("Email:"));
			panel.add(emailTextField);
			panel.add(new JLabel("Phone:"));
			panel.add(phoneTextField);
			panel.add(new JLabel("Address:"));
			panel.add(addressTextField);
			
			// adding submit button
			panel.add(submitButton);
			
			// lets perform nextEvents if submit button clicked
			submitButton.addActionListener(this);

		// checking if submit button clicked	
		} else if (e.getSource() == submitButton) {

			// clearing the panel
			panel.removeAll();

			// adding textLabel for the store
			panel.add(new JLabel("Store Name:"));
			
			/// adding text field for the Store Name
			panel.add(storeNameTextField);
			panel.add(submitButton2);
			submitButton2.addActionListener(this);

		} else if (e.getSource() == submitButton2) {

			// clears the panel
			panel.removeAll();

			// Adds Option to upload image
			panel.add(uploadButton);
			uploadButton.addActionListener(this);
			panel.add(uploadButton, BorderLayout.NORTH);

			imageLabel = new JLabel();
			panel.add(imageLabel, BorderLayout.CENTER);
			frame.setVisible(true);

			// checks if image was uploaded
		} else if (e.getSource() == uploadButton) {

			JFileChooser fileChooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
			fileChooser.setFileFilter(filter);

			int returnValue = fileChooser.showOpenDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
				imageLabel.setIcon(imageIcon);
			}

			// adding textLabel for the quantity of an item
			panel.add(new JLabel("Quantity:"));
			
			// adds text field for the quantity
			panel.add(quantityTextField);

			// adds a button to finish shopping and checkout  
			panel.add(proceedToCart);
			
			// adds a button to scan more items
			panel.add(scanAnother);
			
			// in response when button clicked
			proceedToCart.addActionListener(this);
			scanAnother.addActionListener(this);

			// checks if button 'proceedToCart' was clicked
		} else if (e.getSource() == proceedToCart) {

			// clears the panel
			panel.removeAll();

			// showing cart
			panel.add(new JLabel("Shopping Cart"));
			panel.add(new JLabel("-----------------"));
			panel.add(new JLabel(""));
			panel.add(new JLabel("Total Items: 2"));
			panel.add(new JLabel("Item #1: Apple iPhone Charger"));
			panel.add(new JLabel("Serial #: 6547"));
			panel.add(new JLabel("Cost Per Piece: $19.99"));
			panel.add(new JLabel("Quantity: 2"));
			panel.add(new JLabel("Total Cost: $39.98"));
			panel.add(new JLabel("-------------------------"));
			panel.add(new JLabel("Final Cost: $39.98"));

			// adds a button to proceed for payment
			panel.add(submitButton3);
			
			// in response to when 'Proceed to Payment' button clicked
			submitButton3.addActionListener(this);

			// checks if 'Proceed to Payment' button clicked
		} else if (e.getSource() == submitButton3) {

			// clears the panel
			panel.removeAll();

			// adding buttons for different transaction methods
			panel.add(applePay);
			applePay.addActionListener(this);
			panel.add(gPay);
			gPay.addActionListener(this);
			panel.add(payPal);
			payPal.addActionListener(this);
			panel.add(cards);
			cards.addActionListener(this);

		} else if (e.getSource() == applePay || e.getSource() == gPay || e.getSource() == payPal
				|| e.getSource() == cards) {

			// clears the panel
			panel.removeAll();

			// displaying message when shopping completed
			panel.add(new JLabel("Your Transaction is successful!"));
			panel.add(new JLabel("Hope CHECKIES helped you CHECK-OUT With EASE"));

		}

		// clear the text boxes
		usernameTextField.setText("");
		passwordTextField.setText("");
		nameTextField.setText("");
		emailTextField.setText("");
		phoneTextField.setText("");
		addressTextField.setText("");
		storeNameTextField.setText("");

		// redraw the panel
		panel.revalidate();
		panel.repaint();

	}

	public static void main(String[] args) {
		new CheckiesApp();
	}
}