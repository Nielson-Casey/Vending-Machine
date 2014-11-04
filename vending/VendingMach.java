package vending;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;



@SuppressWarnings({ "unused", "serial" })

public class VendingMach  extends JFrame
{
	public static void main(String[] args)
	{
		try {
			// Set the GUI look and feel to the same as the system.
			String laf = UIManager.getSystemLookAndFeelClassName();
			UIManager.setLookAndFeel(laf);
		}
		catch (Exception ex) { /* Do nothing */ }
		VendingMach frame = new VendingMach();
	}	
	private final String[] gpaLetters = 
		{
			"A1", "B1", "C1","D1",
			"A2", "B2", "C2","D2",
			"A3", "B3", "C3","D3", "F",
		};
	private final double[] gpaNumbers =
		{
			4.0,4.0,4.0,
			3.0,3.0,3.0,
			2.0,2.0,2.0,
			1.0,1.0,1.0,0,
		};	
	private JTextField txtGrade;
	private JTextField txtGpa;
    private JTextField txtCredit;
	
	public VendingMach()
	{
		JLabel lblCredit = new JLabel ("Credit Amount ");
		JTextField txtCredit = new JTextField(5);
		
		
		JLabel lblGrade = new JLabel ("Grade");
		txtGrade = new JTextField(5);	
		txtGrade.setEditable(false);
		
		JLabel lblGpa = new JLabel ("GPA");
		txtGpa = new JTextField(5);
		txtGpa.setEditable(false);
		
		JButton btnAP = new JButton("A+");
		JButton btnA = new JButton("A");
		JButton btnAM = new JButton("A-");
		JButton btnBP = new JButton("B+");
		JButton btnB = new JButton("B");
		JButton btnBM = new JButton("B-");
		JButton btnCP = new JButton("C+");
		JButton btnC = new JButton("C");
		JButton btnCM = new JButton("C-");
		JButton btnDP = new JButton("D+");
		JButton btnD = new JButton("D");
		JButton btnDM = new JButton("D-");
		JButton btnF = new JButton("F");
		
		JButton btnCancel = new JButton("\u2715");
		JButton btnOK = new JButton("\u2714");
		
		btnOK.setForeground(Color.green);
		btnCancel.setForeground(Color.red);
		
		// THESE ARE THE BUTTONS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>	
		btnAP.addActionListener(new ButtonHandler());
		btnA.addActionListener(new ButtonHandler());
		btnAM.addActionListener(new ButtonHandler());
		btnBP.addActionListener(new ButtonHandler());
		btnB.addActionListener(new ButtonHandler());
		btnBM.addActionListener(new ButtonHandler());
		btnCP.addActionListener(new ButtonHandler());
		btnC.addActionListener(new ButtonHandler());
		btnCM.addActionListener(new ButtonHandler());
		btnDP.addActionListener(new ButtonHandler());
		btnD.addActionListener(new ButtonHandler());
		btnDM.addActionListener(new ButtonHandler());
		btnF.addActionListener(new ButtonHandler());
		
		btnOK.addActionListener(new OkHandler());
		btnCancel.addActionListener(new CancelHandler());

		// THESE ARE THE PICTURES 
		//	ImageIcon icon = new ImageIcon(getClass().getResource("/turkey.png"));icon, JLabel.TRAILING);
//		JLabel lblA1 = new JLabel("A1"); >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//		JLabel lblA2 = new JLabel("A2");
//		JLabel lblA3 = new JLabel("A3");
//		JLabel lblB1 = new JLabel("B1");
//		JLabel lblB2 = new JLabel("B2");
//		JLabel lblB3 = new JLabel("B7");
		
		JLabel lblDispenser = new JLabel();		

		JPanel pnlinput = new JPanel();

		pnlinput.setLayout(new GridLayout(3, 2));
		pnlinput.add(lblCredit);
		pnlinput.add(txtCredit);
		pnlinput.add(lblGrade);
		pnlinput.add(txtGrade);
		pnlinput.add(lblGpa);
		pnlinput.add(txtGpa);

		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new GridLayout(6,3));
		pnlButtons.add(btnAP);
		pnlButtons.add(btnA);
		pnlButtons.add(btnAM);
		pnlButtons.add(btnBP);
		pnlButtons.add(btnB);
		pnlButtons.add(btnBM);
		pnlButtons.add(btnCP);
		pnlButtons.add(btnC);
		pnlButtons.add(btnCM);
		pnlButtons.add(btnDP);
		pnlButtons.add(btnD);
		pnlButtons.add(btnDM);
		pnlButtons.add(btnF);
	
		pnlButtons.add(btnCancel);
		
		pnlButtons.add(btnOK);

		JPanel pnlProducts = new JPanel();
		pnlProducts.setLayout(new GridLayout(6,3));
		pnlProducts.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
//		pnlProducts.add(lblA1); >>>>>>>>.......>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//		pnlProducts.add(lblA2);
//		pnlProducts.add(lblA3);
//		pnlProducts.add(lblB1);
//		pnlProducts.add(lblB2);
//		pnlProducts.add(lblB3);
		

		JPanel pnlTop = new JPanel();
		pnlTop.add(pnlinput);
		pnlTop.add(pnlButtons);

		JPanel pnlContent = new JPanel();
		BoxLayout layout = new BoxLayout(pnlContent, BoxLayout.Y_AXIS);	
		pnlContent.setLayout(layout);
		pnlContent.add(pnlTop);
		pnlContent.add(pnlProducts);
		pnlContent.add(lblDispenser);

		this.setTitle("GPA Calculator");
		this.setContentPane(pnlContent);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	private class ButtonHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent event) 
		{

			JButton button = (JButton)event.getSource();
			String text = txtGrade.getText();
			text += " " + button.getText();
			txtGrade.setText(text);
			for(int i = 0; i < gpaLetters.length; i++)
			{
				if(gpaLetters[i].equals(text))
				{		
					double gpa = gpaNumbers[i];
					txtGpa.setText(Double.toString(gpa));
					break;
				}
			}
		}	
	}	
	private class CancelHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			txtGpa.setText("");
			txtGrade.setText("");
			txtCredit.setText("");
		}		
	}
	private class OkHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			// This is how to add everything for the gpa.
			
		}
		
	}
}











