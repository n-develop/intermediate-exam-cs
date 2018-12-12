// Lars Niemann

// Oberfläche eines Quartettspiels

// 25.11.2004


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class EinAus extends JFrame implements ActionListener
{
	Main myMain = new Main(this);

	ImageIcon rueckseite = new ImageIcon("Images\\rückseite.gif");
	JButton gebenButton, endeButton, weiterButton;
	JButton vmaxButton, leistungButton, gewichtButton, laengeButton, baujahrButton;
	JTextField wertSpieler, wertComputer, kartenAnzahl, unentschAnzeige;
	JTextField ihreWahlAusgabe;
	JTextField kartenSpieler, kartenPc;
	JLabel ihrWertLabel, pcWertLabel, zuVergleichenLabel;
	JLabel blattGegner, blattSpieler, unentschLabel;
	JLabel amZugLabelPC, amZugLabelSp;
	JLabel spieler1Stapel, spieler2Stapel;
	int schwierig;
	String name;


   	public EinAus(int pSchwierig, String pName)

	{

		super("Eisenbahn-Quartett");
	 	this.getContentPane().setBackground(Color.lightGray);
	  	this.getContentPane().setLayout(null);

		schwierig = pSchwierig;
		name = pName;

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
		vmaxButton = new JButton("Vmax");
	  	vmaxButton.setBounds (20, 220, 150, 30);
	  	vmaxButton.addActionListener(this);
	  	this.getContentPane().add(vmaxButton);

		gewichtButton = new JButton("Gewicht");
	  	gewichtButton.setBounds (20, 300, 150, 30);
	  	gewichtButton.addActionListener(this);
	  	this.getContentPane().add(gewichtButton);

		leistungButton = new JButton("Leistung");
	  	leistungButton.setBounds (20, 260, 150, 30);
	  	leistungButton.addActionListener(this);
	  	this.getContentPane().add(leistungButton);

		laengeButton = new JButton("L�nge");
	  	laengeButton.setBounds (20, 340, 150, 30);
	  	laengeButton.addActionListener(this);
	  	this.getContentPane().add(laengeButton);

		baujahrButton = new JButton("Baujahr");
	  	baujahrButton.setBounds (20, 380, 150, 30);
	  	baujahrButton.addActionListener(this);
	  	this.getContentPane().add(baujahrButton);


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
		ihreWahlAusgabe.setBounds(800, 20, 60, 20);
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

