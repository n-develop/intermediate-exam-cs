import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class InfoMaske extends JFrame implements ActionListener
{
	JButton okButton;

	public InfoMaske()
	{
		super("Info");
		this.getContentPane().setBackground(Color.white);
	   	this.getContentPane().setLayout(null);


	   	okButton = new JButton("OK");
		okButton.setBounds (75, 260, 150, 30);
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