import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class InfoMaske extends JFrame implements ActionListener
{
	JButton okButton;
	String infoText, infoText1, infoText2, infoText3, infoText4;
	JLabel infoArea, infoArea1, infoArea2, infoArea3, infoArea4;

	public InfoMaske()
	{
		super("Info");
		this.getContentPane().setBackground(Color.white);
	   	this.getContentPane().setLayout(null);

		infoText = "Das unglaubliche Eisnbahnquartett";
		infoText1 = "Version 1.0";
		infoText2 = "Copyright by Lars Niemann";
		infoText3 = "Weitere Infos unter";
		infoText4 = "http://www.diese-website-existiert-nicht-mehr.de";

		infoArea = new JLabel(infoText);
		infoArea.setBounds(10, 10, 200, 20);
		this.getContentPane().add(infoArea);

		infoArea1 = new JLabel(infoText1);
		infoArea1.setBounds(10, 30, 200, 20);
		this.getContentPane().add(infoArea1);

		infoArea2 = new JLabel(infoText2);
		infoArea2.setBounds(10, 50, 200, 20);
		this.getContentPane().add(infoArea2);

		infoArea3 = new JLabel(infoText3);
		infoArea3.setBounds(10, 70, 200, 20);
		this.getContentPane().add(infoArea3);

		infoArea4 = new JLabel(infoText4);
		infoArea4.setBounds(10, 90, 200, 20);
		this.getContentPane().add(infoArea4);

	   	okButton = new JButton("OK");
		okButton.setBounds (75, 160, 150, 30);
		okButton.addActionListener(this);
	  	this.getContentPane().add(okButton);

	}

	public void actionPerformed(ActionEvent event)
	{

    	String cmd = event.getActionCommand();

    	if (cmd.equals("OK"))
		{
			setVisible(false);
			dispose();
    	}
	}
}