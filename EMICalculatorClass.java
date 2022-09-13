package JunitTesting;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class EMICalculatorClass implements  ActionListener{

    //private static final boolean False = false;
	//private static final boolean True = false;
	JPanel textPanel, panelForTextFields, completionPanel;
    JLabel titleLabel, loanLabel, yearsLabel, rateLabel, rate2Label, payLabel, statuslabel;
    JTextField loanField, yearsField, rateField, payField;
    JButton loginButton;
    private double loan, years, rate;
    //private static double monthly = 0.0;
    String statusArray;
	String[] emi;
	private static boolean flag = true;
	//private static String rawloan, rawyears, rawrate;

    public JPanel createContentPane(){

        // We create a bottom JPanel to place everything on.
        JPanel totalGUI = new JPanel();
        
        totalGUI.setLayout(null);

        titleLabel = new JLabel("EMI Calculator");
        titleLabel.setLocation(110,0);
        titleLabel.setSize(180, 30);
        titleLabel.setHorizontalAlignment(0);
        totalGUI.add(titleLabel);

        // Creation of a Panel to contain the JLabels
        textPanel = new JPanel();
        textPanel.setLayout(null);
        textPanel.setLocation(10, 35);
        textPanel.setSize(180, 190);
        totalGUI.add(textPanel);

        // Loan Label
        loanLabel = new JLabel("Loan Amount (Rs.)");
        loanLabel.setLocation(0, 10);
        loanLabel.setSize(150, 30);
        loanLabel.setHorizontalAlignment(4);
        textPanel.add(loanLabel);

        // Login Label
        yearsLabel = new JLabel("Number of Years");
        yearsLabel.setLocation(0, 50);
        yearsLabel.setSize(150, 30);
        yearsLabel.setHorizontalAlignment(4);
        textPanel.add(yearsLabel);
        
        rateLabel = new JLabel("Interest Rate");
        rateLabel.setLocation(0,90);
        rateLabel.setSize(150, 30);
        rateLabel.setHorizontalAlignment(4);
        textPanel.add(rateLabel);
        
        rate2Label = new JLabel("ex.(5.0 for 5%)");
        rate2Label.setLocation(0,110);
        rate2Label.setSize(150,30);
        rate2Label.setHorizontalAlignment(4);
        textPanel.add(rate2Label);
        
        payLabel = new JLabel("EMI (in Rs.)");
        payLabel.setLocation(0,160);
        payLabel.setSize(150,30);
        payLabel.setHorizontalAlignment(4);
        textPanel.add(payLabel);

        // TextFields Panel Container
        panelForTextFields = new JPanel();
        panelForTextFields.setLayout(null);
        panelForTextFields.setLocation(250, 40);
        panelForTextFields.setSize(100, 190);
        totalGUI.add(panelForTextFields);

        // Username Textfield
        loanField = new JTextField(8);
        loanField.setLocation(0, 10);
        loanField.setSize(100, 30);
        panelForTextFields.add(loanField);
        loanField.addActionListener(this);

        // Login Textfield
        yearsField = new JTextField(8);
        yearsField.setLocation(0, 50);
        yearsField.setSize(100, 30);
        panelForTextFields.add(yearsField);
        yearsField.addActionListener(this);
        
        //Rate Textfield
        rateField = new JTextField(8);
        rateField.setLocation(0, 100);
        rateField.setSize(100, 30);
        panelForTextFields.add(rateField);
        rateField.addActionListener(this);
        
        //PayField
        
        payField = new JTextField(8);
        payField.setEditable(false);
        payField.setLocation(0,155);
        payField.setSize(100,30);
        panelForTextFields.add(payField);
        payField.addActionListener(this);

        // Creation of a Panel to contain the completion JLabels
        completionPanel = new JPanel();
        completionPanel.setLayout(null);
        completionPanel.setLocation(40, 35);
        completionPanel.setSize(170, 180);
        totalGUI.add(completionPanel);
        
        
        
        
        
        
       
        statuslabel = new JLabel("Status : Executing...");
        statuslabel.setLocation(10, 250);
        statuslabel.setSize(300,40);
        statuslabel.setHorizontalAlignment(4);
        
        totalGUI.add(statuslabel);
        
        
        
        
        
    
        // Button for Computing
        loginButton = new JButton("Calculate");
        loginButton.setLocation(130, 300);
        loginButton.setSize(150, 30);
        loginButton.addActionListener(this);
        totalGUI.add(loginButton);

        totalGUI.setOpaque(true);    
        return totalGUI;
    }

    
   public String checkTextFields(String raw_loan,String raw_years,String raw_rate) {
	   
	   
	   if(raw_loan.equals("") || raw_years.equals("") || raw_rate.equals("")) {
		   return "Status : All fields are mandatory!";
		   
	   }
	   
	   
	   if(raw_loan.matches("[+-]?[0-9]+") == false) {
		   return "Status : Loan field should be numbers only.";
	   }
	   else if(raw_years.matches("[+-]?[0-9]+") == false) {
		   return "Status : Years field should be numbers only.";
	   }
	   else if(raw_rate.matches("[+-]?[0-9]+") == false) {
		   return "Status : Rate field should be numbers only.";
	   }
	   else {
		   return "OK";
	   }
	   
   }
    
    public String isEverythingAllRight(String raw_loan,String raw_years,String raw_rate) {
    	String result = "Status : All good";
    	
    	
    	String check = checkTextFields(raw_loan, raw_years, raw_rate);
    	if(check == "OK") {
    		loan = (Double.parseDouble(raw_loan));
    		years = (Double.parseDouble(raw_years));
    		rate = (Double.parseDouble(raw_rate));
    		
    		
    		if(loan <= 0) {
        		result = "Status : Loan amount should be greater than 0.";
        		return result;
        	}
        	if(years <= 0) {
        		result = "Status : No. of years should be greater than 0.";
        		return result;
        	}
        	if(rate <= 0) {
        		result = "Status : Interest should be greater than 0.";
        		return result;
        	}
    	}
    	else {
    		result = check;
    		
    	}
    	
    	
    	return result;
    }
    
    public double getEMI(double loan, double years, double rate) {
    	double mRate = (rate)/1200.0;
    	double months = (years)*12.0;
    	double denom = (Math.pow((1+mRate),months)-1);
    	double monthly = (mRate + mRate/denom)*loan;
    	DecimalFormat x = new DecimalFormat("#.##");
    	monthly = Double.valueOf(x.format(monthly));
    	return monthly;
    }
  
  
    public String[] computeEMI(String raw_loan,String raw_years,String raw_rate) {
    	//String[] resultArray;
    	String[] response = new String[2];
    	
    	statusArray = isEverythingAllRight(raw_loan, raw_years, raw_rate);
    	
    	if(statusArray == "Status : All good") {
    		
    		double monthly = getEMI(loan, years, rate);
        	
        	response[0] = String.valueOf(monthly);
        	response[1] = "Execution Successful !";
    	}
    	else {
    		flag = false;
    		response[0] = "NA";
        	response[1] = statusArray;
    	}
    	
    	
    	
    	//statuslabel.setText("Status : Execution Successful !");
    	
    	
    	return response;
    }  
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	String rawloan, rawyears, rawrate;
    	rawloan = loanField.getText();
 	    rawyears = yearsField.getText();
 	    rawrate = rateField.getText();
    	
    	emi = computeEMI(rawloan, rawyears, rawrate);
    	
    	payField.setText("");
    	if(flag == true) {
    		payField.setText(Double.parseDouble(emi[0])+"");
    	}
    	else {
    		payField.setText(emi[0]+"");
    	}

 
    	statuslabel.setText(emi[1]);
       
            
        
    }

    

    private static void createAndShowGUI() {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("EMI Calculator");

        EMICalculatorClass demo = new EMICalculatorClass();
        frame.setContentPane(demo.createContentPane());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}