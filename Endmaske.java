//Klasse zur Erstellung eines Endfensters in welchem Sieg oder Niederlage
//des Spieler angezeigt wird

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Endmaske extends JFrame implements ActionListener
{

	private JLabel siegerLabel, pokalLabel, gewonnenLabel;
	private JLabel verliererLabel, loserLabel, verlorenLabel;
	private int sieg;
	private ImageIcon pokal = new ImageIcon("Images\\pokal.gif");
	private ImageIcon loser = new ImageIcon("Images\\loser.gif");
	private JButton endeButton;


   //Konstruktor
	public Endmaske()
    {
		super("Spielende");
		this.getContentPane().setBackground(Color.white);
	   	this.getContentPane().setLayout(null);

		//Labels für Pokal- oder Looserbild
		pokalLabel = new JLabel(pokal);
		pokalLabel.setBounds (75, 10, 150, 218);
		this.getContentPane().add(pokalLabel);
		pokalLabel.setVisible(false);

		loserLabel = new JLabel(loser);
		loserLabel.setBounds (43, 10, 213, 200);
		this.getContentPane().add(loserLabel);
		loserLabel.setVisible(false);

		//Labels für "Gewonnen" oder "Verloren"
		siegerLabel = new JLabel("Sie haben gewonnen!");
		siegerLabel.setBounds (100, 230, 150, 20);
		this.getContentPane().add(siegerLabel);
		siegerLabel.setVisible(false);

		verliererLabel = new JLabel("Sie haben verloren!");
		verliererLabel.setBounds (100, 230, 150, 20);
		this.getContentPane().add(verliererLabel);
		verliererLabel.setVisible(false);

		//Der Ende-Button
		endeButton = new JButton("Ende");
		endeButton.setBounds (75, 260, 150, 30);
		endeButton.addActionListener(this);
	  	this.getContentPane().add(endeButton);
	}

	//Methode zur Anzeige der richtigen Labels
	void machSichtbar(int pSieg)
	{
		int sieg = pSieg;
		//SIEG
		if(sieg == 1)
		{
			pokalLabel.setVisible(true);
			siegerLabel.setVisible(true);
		}
		//Niederlage
		else if(sieg == 0)
		{
			loserLabel.setVisible(true);
			verliererLabel.setVisible(true);
		}

	}

	public void actionPerformed(ActionEvent event)
	{

    	String cmd = event.getActionCommand();

    	if (cmd.equals("Ende"))
		{
			setVisible(false);
			dispose();
			System.exit(0);
    	}
	}
}
