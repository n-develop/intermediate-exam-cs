import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Willkommen extends JFrame implements ActionListener
{
	JRadioButton[] schwierigkeit = new JRadioButton[3];
	JRadioButton[] quartett = new JRadioButton[3];
	JLabel schwierigLabel,varianteLabel, bildLabel, willkommen;
	JButton startButton, infoButton;
	ImageIcon zugBild, willkommenBild;
	JTextField namensEingabe;
	JLabel namensLabel;


	public Willkommen()
    {
		super("Willkommen");
		this.getContentPane().setBackground(Color.white);
	   	this.getContentPane().setLayout(null);
		schwierigkeit[0] = new JRadioButton("Leicht");
		schwierigkeit[0].setBounds(10, 400, 100, 20);
		schwierigkeit[0].setBackground(Color.white);
		this.getContentPane().add(schwierigkeit[0]);
		schwierigkeit[1] = new JRadioButton("Normal", true);
		schwierigkeit[1].setBounds(10, 420, 100, 20);
		schwierigkeit[1].setBackground(Color.white);
		this.getContentPane().add(schwierigkeit[1]);
		schwierigkeit[2] = new JRadioButton("Schwer");
		schwierigkeit[2].setBounds(10, 440, 100, 20);
		schwierigkeit[2].setBackground(Color.white);
		this.getContentPane().add(schwierigkeit[2]);
		ButtonGroup group = new ButtonGroup();
		for (int i = 0; i<schwierigkeit.length; i++)
		{
			group.add(schwierigkeit[i]);
		}

		quartett[0] = new JRadioButton("Züge", true);
		quartett[0].setBounds(180, 400, 100, 20);
		quartett[0].setBackground(Color.white);
		this.getContentPane().add(quartett[0]);
		quartett[1] = new JRadioButton("Traktoren");
		quartett[1].setBounds(180, 420, 100, 20);
		quartett[1].setBackground(Color.white);
		this.getContentPane().add(quartett[1]);
		quartett[2] = new JRadioButton("Panzer");
		quartett[2].setBounds(180, 440, 100, 20);
		quartett[2].setBackground(Color.white);
		this.getContentPane().add(quartett[2]);
		ButtonGroup group1 = new ButtonGroup();
		group1.add(quartett[0]);
		group1.add(quartett[1]);
		group1.add(quartett[2]);

		varianteLabel = new JLabel ("Variante:");
		varianteLabel.setBounds(180, 380, 150, 20);
		this.getContentPane().add(varianteLabel);
		schwierigLabel = new JLabel ("Schwierigkeitsgrad:");
		schwierigLabel.setBounds(10, 380, 150, 20);
		this.getContentPane().add(schwierigLabel);
		zugBild = new ImageIcon ("Images\\start.gif");
		willkommenBild = new ImageIcon ("Images\\Willkommen.gif");
		bildLabel = new JLabel(zugBild);
		bildLabel.setBounds(10, 110, 470, 260);
		this.getContentPane().add(bildLabel);
		willkommen = new JLabel(willkommenBild);
		willkommen.setBounds(110, 10, 271, 95);
		this.getContentPane().add(willkommen);

		startButton = new JButton("Start");
		startButton.setBounds(10, 490, 150, 30);
		startButton.addActionListener(this);
		this.getContentPane().add(startButton);
		infoButton = new JButton("Info");
		infoButton.setBounds(300, 490, 150, 30);
		infoButton.addActionListener(this);
		this.getContentPane().add(infoButton);

		namensLabel = new JLabel ("Ihr Name:");
		namensLabel.setBounds(300, 380, 100, 20);
		this.getContentPane().add(namensLabel);
		namensEingabe = new JTextField();
		namensEingabe.setBounds(370, 380, 100, 20);
		this.getContentPane().add(namensEingabe);


	}


	public void actionPerformed(ActionEvent event)
	{
		String cmd = event.getActionCommand();

		if(cmd.equals("Start"))
		{
			int pSchwierig = -1;
			if (schwierigkeit[0].isSelected())
			{
				pSchwierig = 0;
			}
			else if(schwierigkeit[1].isSelected())
			{
				pSchwierig = 1;
			}
			else if (schwierigkeit[2].isSelected())
			{
				pSchwierig = 2;
			}

			int pVariante = -1;
			if (quartett[0].isSelected())
			{
				pVariante = 0;
			}
			else if(quartett[1].isSelected())
			{
				pVariante = 1;
			}
			else if(quartett[2].isSelected())
			{
				pVariante = 2;
			}

			String spName = namensEingabe.getText();
			EinAus wnd = new EinAus(pSchwierig, pVariante, spName);
			wnd.setSize(900,550);
      		wnd.setVisible(true);

      		setVisible(false);
      		dispose();
		}
		else if(cmd.equals("Info"))
		{
			InfoMaske myInfomaske = new InfoMaske();
			myInfomaske.setSize(300, 350);
			myInfomaske.setVisible(true);
		}
	}
}