// Lars Niemann

// Oberfläche eines Quartettspiels

// 25.11.2004


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class EinAus extends JFrame implements ActionListener

{
	Main myMain;
	ImageIcon rueckseite = new ImageIcon("Images\\rückseite.gif");
	JButton gebenButton, endeButton, weiterButton;
	JButton wert1Button, wert2Button, wert3Button, wert4Button, wert5Button;
	JTextField wertSpieler, wertComputer, kartenAnzahl, unentschAnzeige;
	JTextField ihreWahlAusgabe;
	JTextField kartenSpieler, kartenPc;
	JLabel ihrWertLabel, pcWertLabel, zuVergleichenLabel;
	JLabel blattGegner, blattSpieler, unentschLabel;
	JLabel amZugLabelPC, amZugLabelSp;
	JLabel spieler1Stapel, spieler2Stapel;
	int schwierig;
	int variante; //0 = Züge, 1 = Traktoren, 2 = Panzer
	String name;
	String buttonName1, buttonName2, buttonName3, buttonName4, buttonName5;


   	public EinAus(int pSchwierig, int pVariante, String pName)

	{

		super("Eisenbahn-Quartett");
	 	this.getContentPane().setBackground(Color.lightGray);
	  	this.getContentPane().setLayout(null);

		schwierig = pSchwierig;
		name = pName;
		variante = pVariante;
		myMain = new Main(this, variante);

		if (variante == 0)
		{
			buttonName1 = "Geschwindigkeit";
			buttonName2 = "Leistung";
			buttonName3 = "Gewicht";
			buttonName4 = "Länge";
			buttonName5 = "Baujahr";
		}
		if (variante == 1)
		{
			buttonName1 = "Hubraum";
			buttonName2 = "Leistung";
			buttonName3 = "Drehzahl";
			buttonName4 = "Länge";
			buttonName5 = "Gewicht";
		}
		if (variante == 2)
		{
			buttonName1 = "Leistung";
			buttonName2 = "Geschwindigkeit";
			buttonName3 = "Reichweite";
			buttonName4 = "Gewicht";
			buttonName5 = "Länge";
		}


		//Geben-Button
	  	gebenButton = new JButton("Geben");
		gebenButton.setBounds (20, 470, 150, 30);
	  	gebenButton.addActionListener(this);
	  	this.getContentPane().add(gebenButton);

		//Nächste Runde-Button
	  	weiterButton = new JButton("Nächste Runde");
		weiterButton.setBounds (180, 470, 150, 30);
	  	weiterButton.addActionListener(this);
	  	this.getContentPane().add(weiterButton);
		//Ende-Button
	  	endeButton = new JButton("Ende");
	  	endeButton.setBounds (340, 470, 150, 30);
	  	endeButton.addActionListener(this);
	  	this.getContentPane().add(endeButton);
		//Auswahlbutton
		wert1Button = new JButton(buttonName1);
	  	wert1Button.setBounds (20, 220, 150, 30);
	  	wert1Button.addActionListener(this);
	  	this.getContentPane().add(wert1Button);

		wert3Button = new JButton(buttonName3);
	  	wert3Button.setBounds (20, 300, 150, 30);
	  	wert3Button.addActionListener(this);
	  	this.getContentPane().add(wert3Button);

		wert2Button = new JButton(buttonName2);
	  	wert2Button.setBounds (20, 260, 150, 30);
	  	wert2Button.addActionListener(this);
	  	this.getContentPane().add(wert2Button);

		wert4Button = new JButton(buttonName4);
	  	wert4Button.setBounds (20, 340, 150, 30);
	  	wert4Button.addActionListener(this);
	  	this.getContentPane().add(wert4Button);

		wert5Button = new JButton(buttonName5);
	  	wert5Button.setBounds (20, 380, 150, 30);
	  	wert5Button.addActionListener(this);
	  	this.getContentPane().add(wert5Button);


		//Labels für die Karten
		spieler1Stapel = new JLabel();
		spieler1Stapel.setBounds (200, 10, 220, 347);
		this.getContentPane().add(spieler1Stapel);
		spieler2Stapel = new JLabel();
		spieler2Stapel.setBounds (450, 10, 220, 347);
		this.getContentPane().add(spieler2Stapel);
		//Labels zur Beschriftung der Textfelder
		ihrWertLabel = new JLabel("Ihr Wert :");
		ihrWertLabel.setBounds (700, 50, 100, 20);
		this.getContentPane().add(ihrWertLabel);
		pcWertLabel = new JLabel("Gegner-Wert :");
		pcWertLabel.setBounds (700, 80, 100, 20);
		this.getContentPane().add(pcWertLabel);
		zuVergleichenLabel = new JLabel("Vergleichswert :");
		zuVergleichenLabel.setBounds (700, 20, 100, 20);
		this.getContentPane().add(zuVergleichenLabel);

		//Textfelder zum Vergleichen der Werte
		wertSpieler = new JTextField();
		wertSpieler.setBounds(800, 50, 60, 20);
		this.getContentPane().add(wertSpieler);
		wertComputer = new JTextField();
		wertComputer.setBounds(800, 80, 60, 20);
		this.getContentPane().add(wertComputer);
		ihreWahlAusgabe = new JTextField();
		ihreWahlAusgabe.setBounds(800, 20, 70, 20);
		this.getContentPane().add(ihreWahlAusgabe);

		//Textfelder und Labels zur Anzeige der Anzahl der Karten im Blatt
		kartenSpieler = new JTextField();
		kartenSpieler.setBounds(800,120,60,20);
		this.getContentPane().add(kartenSpieler);
		kartenPc = new JTextField();
		kartenPc.setBounds(800,150,60,20);
		this.getContentPane().add(kartenPc);
		blattSpieler = new JLabel("Ihre Karten :");
		blattSpieler.setBounds (700, 120, 100, 20);
		this.getContentPane().add(blattSpieler);
		blattGegner = new JLabel("Gegner-Karten :");
		blattGegner.setBounds (700, 150, 100, 20);
		this.getContentPane().add(blattGegner);

		//Label und Textfeld für die "Unentschieden"-Anzeige
		unentschLabel = new JLabel("Stock:");
		unentschLabel.setBounds (700, 180, 100, 20);
		this.getContentPane().add(unentschLabel);
		unentschAnzeige = new JTextField();
		unentschAnzeige.setBounds(800,180,60,20);
		this.getContentPane().add(unentschAnzeige);

		//"AmZug"-Labels
		amZugLabelPC = new JLabel("Ihr Gegner ist am Zug");
		amZugLabelPC.setBounds (700, 230, 160, 20);
		this.getContentPane().add(amZugLabelPC);
		amZugLabelPC.setVisible(false);
		amZugLabelSp = new JLabel(name + ", Sie sind am Zug");
		amZugLabelSp.setBounds (700, 230, 160, 20);
		this.getContentPane().add(amZugLabelSp);
		amZugLabelSp.setVisible(false);

   }


   	public void actionPerformed(ActionEvent event)

	{
    	String cmd = event.getActionCommand();
    	myMain.knopfdruck(cmd);
   	}



}

