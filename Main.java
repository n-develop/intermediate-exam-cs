import java.util.Date;

import javax.swing.*;


class Main
{
	private Date myDate = new Date();
	Gegner myGegner;
	Spiel mySpiel;
	Vergleich myVergleich = new Vergleich();
	Endmaske myEndmaske = new Endmaske();
	EinAus myEinAus;
	ImageIcon rueckseite = new ImageIcon("Images\\rückseite.gif");

	int spielerKarten, pcKarten, stockKarten;
	int variante;
	private int amZug=0; // 0=Mensch 1=Computer
	private int anzahl = 32;
	private int auswahl; //0=Vmax 1=Leistung 2=Länge 3=Gewicht 4=Baujahr
	private int sieger;
	private double wertPC, wertSp;
	private int pcWahl;
	private String bezeichnung1, bezeichnung2, bezeichnung3, bezeichnung4, bezeichnung5;

	Main(EinAus pEinAus, int pVariante)
	{
		variante = pVariante;
		myEinAus = pEinAus;
		myGegner = new Gegner(myDate.getTime(), this);
		mySpiel = new Spiel(variante);
		if (variante == 0)
		{
			bezeichnung1 = "Vmax";
			bezeichnung2 = "Leistung";
			bezeichnung3 = "Länge";
			bezeichnung4 = "Gewicht";
			bezeichnung5 = "Baujahr";
		}
		else if (variante == 1)
		{
			bezeichnung1 = "Hubraum";
			bezeichnung2 = "Leistung";
			bezeichnung3 = "Länge";
			bezeichnung4 = "Gewicht";
			bezeichnung5 = "Drehzahl";
		}
		else if (variante == 2)
		{
			bezeichnung1 = "Vmax";
			bezeichnung2 = "Leistung";
			bezeichnung3 = "Länge";
			bezeichnung4 = "Gewicht";
			bezeichnung5 = "Reichweite";
		}
	}

	int getVariante()
	{
		return variante;
	}

	void knopfdruck(String cmd)
	{
      	if (cmd.equals("Geben"))

	    {
			mySpiel.meinKSpiel.mischen();
			mySpiel.verteilen();
			Karte anzeige = (Karte)mySpiel.blattSp1.get(0);
			myEinAus.spieler1Stapel.setIcon(anzeige.getBild());
			myEinAus.spieler2Stapel.setIcon(rueckseite);
			spielerKarten = mySpiel.blattSp1.size();
			pcKarten = mySpiel.blattSp2.size();
			myEinAus.kartenSpieler.setText(""+spielerKarten);
			myEinAus.kartenPc.setText(""+pcKarten);
			myEinAus.amZugLabelSp.setVisible(true);
			myEinAus.gebenButton.setVisible(false);
	    }

	    else if (cmd.equals("Nächste Runde"))
	    {
			Karte obersteKarte = (Karte)mySpiel.blattSp1.get(0);
			Karte gegnerKarte = (Karte)mySpiel.blattSp2.get(0);
			if (auswahl == 0)
			{
				wertSp = obersteKarte.getWert1();
				wertPC = gegnerKarte.getWert1();
			}
			else if (auswahl == 1)
			{
				wertSp = obersteKarte.getWert2();
				wertPC = gegnerKarte.getWert2();
			}
			else if (auswahl == 2)
			{
				wertSp = obersteKarte.getWert4();
				wertPC = gegnerKarte.getWert4();
			}
			else if (auswahl == 3)
			{
				wertSp = obersteKarte.getWert3();
				wertPC = gegnerKarte.getWert3();
			}
			else if (auswahl == 4)
			{
				wertSp = obersteKarte.getWert5();
				wertPC = gegnerKarte.getWert5();
			}
			sieger = myVergleich.vergleiche(auswahl, wertSp, wertPC);
			if(sieger == 1)
			{
				mySpiel.blattSp1.add(mySpiel.blattSp1.get(0));
				mySpiel.blattSp1.add(mySpiel.blattSp2.get(0));
				int umkaempft = mySpiel.unentschieden.size();
				for(int i=0; i<umkaempft; i++)
				{
					mySpiel.blattSp1.add(mySpiel.unentschieden.get(0));
					mySpiel.unentschieden.remove(0);
				}
				amZug = 0;
				myEinAus.amZugLabelPC.setVisible(false);
				myEinAus.amZugLabelSp.setVisible(true);
			}
			else if(sieger == 2)
			{
				mySpiel.blattSp2.add(mySpiel.blattSp1.get(0));
				mySpiel.blattSp2.add(mySpiel.blattSp2.get(0));
				int umkaempft = mySpiel.unentschieden.size();
				for(int i=0; i<umkaempft; i++)
				{
					mySpiel.blattSp2.add(mySpiel.unentschieden.get(0));
					mySpiel.unentschieden.remove(0);
				}
				amZug = 1;
				myEinAus.amZugLabelSp.setVisible(false);
				myEinAus.amZugLabelPC.setVisible(true);

			}
			else if(sieger == 0)
			{
				mySpiel.unentschieden.add(mySpiel.blattSp1.get(0));
				mySpiel.unentschieden.add(mySpiel.blattSp2.get(0));
			}
			mySpiel.blattSp1.remove(0);
			mySpiel.blattSp2.remove(0);
			myEinAus.spieler2Stapel.setIcon(null);
			spielerKarten = mySpiel.blattSp1.size();
			pcKarten = mySpiel.blattSp2.size();
			stockKarten = mySpiel.unentschieden.size();
			myEinAus.unentschAnzeige.setText(""+stockKarten);
			myEinAus.kartenSpieler.setText(""+spielerKarten);
			myEinAus.kartenPc.setText(""+pcKarten);

			if(mySpiel.blattSp1.size()==0)
			{
				myEndmaske.setSize(300, 350);
				myEndmaske.setVisible(true);
				myEndmaske.machSichtbar(0);
				myEinAus.setVisible(false);
         		myEinAus.dispose();
         		amZug = -1;
         		auswahl = -1;
			}
			else if(mySpiel.blattSp2.size()==0)
			{
				myEndmaske.setSize(300, 350);
				myEndmaske.setVisible(true);
				myEndmaske.machSichtbar(1);
				myEinAus.setVisible(false);
				myEinAus.dispose();
				amZug = -1;
         		auswahl = -1;
			}
			else
			{
				Karte anzeige = (Karte)mySpiel.blattSp1.get(0);
				myEinAus.spieler1Stapel.setIcon(anzeige.getBild());
			}


			if(amZug == 1)
			{
				myEinAus.wert1Button.setVisible(false);
				myEinAus.wert2Button.setVisible(false);
				myEinAus.wert3Button.setVisible(false);
				myEinAus.wert4Button.setVisible(false);
				myEinAus.wert5Button.setVisible(false);
				auswahl = myGegner.sucheAus(myEinAus.schwierig);
				Karte sp2Karte = (Karte)mySpiel.blattSp2.get(0);
				Karte sp1Karte = (Karte)mySpiel.blattSp1.get(0);
				if (auswahl == 0)
				{
					int wert11 = (int) sp1Karte.getWert1();
					int wert12 = (int) sp2Karte.getWert1();
					myEinAus.wertComputer.setText(""+wert12);
					myEinAus.wertSpieler.setText(""+wert11);
					myEinAus.ihreWahlAusgabe.setText("Vmax");
					myEinAus.spieler2Stapel.setIcon(sp2Karte.getBild());
				}
				else if (auswahl == 1)
				{
					int wert21 = (int) sp1Karte.getWert2();
					int wert22 = (int) sp2Karte.getWert2();
					myEinAus.wertComputer.setText(""+wert22);
					myEinAus.wertSpieler.setText(""+wert21);
					myEinAus.ihreWahlAusgabe.setText("Leistung");
					myEinAus.spieler2Stapel.setIcon(sp2Karte.getBild());
				}
				else if (auswahl == 2)
				{
					myEinAus.wertComputer.setText(""+sp2Karte.getWert4());
					myEinAus.wertSpieler.setText(""+sp1Karte.getWert4());
					myEinAus.ihreWahlAusgabe.setText("Länge");
					myEinAus.spieler2Stapel.setIcon(sp2Karte.getBild());
				}
				else if (auswahl == 3)
				{
					int wert31 = (int) sp1Karte.getWert3();
					int wert32 = (int) sp2Karte.getWert3();
					myEinAus.wertComputer.setText(""+wert32);
					myEinAus.wertSpieler.setText(""+wert31);
					myEinAus.ihreWahlAusgabe.setText("Gewicht");
					myEinAus.spieler2Stapel.setIcon(sp2Karte.getBild());
				}
				else if (auswahl == 4)
				{
					int wert51 = (int) sp1Karte.getWert5();
					int wert52 = (int) sp2Karte.getWert5();
					myEinAus.wertComputer.setText(""+wert52);
					myEinAus.wertSpieler.setText(""+wert51);
					myEinAus.ihreWahlAusgabe.setText("Baujahr");
					myEinAus.spieler2Stapel.setIcon(sp2Karte.getBild());
				}
			}

			if(amZug == 0)
			{
				myEinAus.wertComputer.setText("");
				myEinAus.wertSpieler.setText("");
				myEinAus.ihreWahlAusgabe.setText("");
				myEinAus.wert1Button.setVisible(true);
				myEinAus.wert2Button.setVisible(true);
				myEinAus.wert3Button.setVisible(true);
				myEinAus.wert4Button.setVisible(true);
				myEinAus.wert5Button.setVisible(true);
				myEinAus.spieler2Stapel.setIcon(rueckseite);
			}
	    }

		else if (cmd.equals("Geschwindigkeit") || cmd.equals("Hubraum"))
		{
			auswahl=0;
			Karte obersteKarte = (Karte)mySpiel.blattSp1.get(0);
			int wert11 = (int) obersteKarte.getWert1();
			myEinAus.wertSpieler.setText(""+wert11);
			myEinAus.ihreWahlAusgabe.setText(bezeichnung1);
			Karte gegnerKarte = (Karte)mySpiel.blattSp2.get(0);
			int wert12 = (int) gegnerKarte.getWert1();
			myEinAus.wertComputer.setText(""+wert12);
			myEinAus.wert1Button.setVisible(false);
			myEinAus.wert2Button.setVisible(false);
			myEinAus.wert3Button.setVisible(false);
			myEinAus.wert4Button.setVisible(false);
			myEinAus.wert5Button.setVisible(false);
			Karte anzeige = (Karte)mySpiel.blattSp2.get(0);
			myEinAus.spieler2Stapel.setIcon(anzeige.getBild());

		}
	    else if (cmd.equals("Leistung"))
		{
			auswahl=1;
			Karte obersteKarte = (Karte)mySpiel.blattSp1.get(0);
			int wert21 = (int) obersteKarte.getWert2();
			myEinAus.wertSpieler.setText(""+wert21);
			myEinAus.ihreWahlAusgabe.setText(bezeichnung2);
			Karte gegnerKarte = (Karte)mySpiel.blattSp2.get(0);
			int wert22 = (int) gegnerKarte.getWert2();
			myEinAus.wertComputer.setText(""+wert22);
			myEinAus.wert1Button.setVisible(false);
			myEinAus.wert2Button.setVisible(false);
			myEinAus.wert3Button.setVisible(false);
			myEinAus.wert4Button.setVisible(false);
			myEinAus.wert5Button.setVisible(false);
			Karte anzeige = (Karte)mySpiel.blattSp2.get(0);
			myEinAus.spieler2Stapel.setIcon(anzeige.getBild());
	    }
	    else if (cmd.equals("Länge"))
		{
			auswahl=2;
			Karte obersteKarte = (Karte)mySpiel.blattSp1.get(0);
			myEinAus.wertSpieler.setText(""+obersteKarte.getWert4());
			myEinAus.ihreWahlAusgabe.setText(bezeichnung3);
			Karte gegnerKarte = (Karte)mySpiel.blattSp2.get(0);
			myEinAus.wertComputer.setText(""+gegnerKarte.getWert4());
			myEinAus.wert1Button.setVisible(false);
			myEinAus.wert2Button.setVisible(false);
			myEinAus.wert3Button.setVisible(false);
			myEinAus.wert4Button.setVisible(false);
			myEinAus.wert5Button.setVisible(false);
			Karte anzeige = (Karte)mySpiel.blattSp2.get(0);
			myEinAus.spieler2Stapel.setIcon(anzeige.getBild());

	    }
	    else if (cmd.equals("Gewicht"))
		{
			auswahl=3;
			Karte obersteKarte = (Karte)mySpiel.blattSp1.get(0);
			int wert31 = (int) obersteKarte.getWert3();
			myEinAus.wertSpieler.setText(""+wert31);
			myEinAus.ihreWahlAusgabe.setText(bezeichnung4);
			Karte gegnerKarte = (Karte)mySpiel.blattSp2.get(0);
			int wert32 = (int) gegnerKarte.getWert3();
			myEinAus.wertComputer.setText(""+wert32);
			myEinAus.wert1Button.setVisible(false);
			myEinAus.wert2Button.setVisible(false);
			myEinAus.wert3Button.setVisible(false);
			myEinAus.wert4Button.setVisible(false);
			myEinAus.wert5Button.setVisible(false);
			Karte anzeige = (Karte)mySpiel.blattSp2.get(0);
			myEinAus.spieler2Stapel.setIcon(anzeige.getBild());

		}
	    else if (cmd.equals("Baujahr") || cmd.equals("Drehzahl") || cmd.equals("Reichweite"))
		{
			auswahl=4;
			Karte obersteKarte = (Karte)mySpiel.blattSp1.get(0);
			int wert51 = (int) obersteKarte.getWert5();
			myEinAus.wertSpieler.setText(""+wert51);
			myEinAus.ihreWahlAusgabe.setText(bezeichnung5);
			Karte gegnerKarte = (Karte)mySpiel.blattSp2.get(0);
			int wert52 = (int) gegnerKarte.getWert5();
			myEinAus.wertComputer.setText(""+wert52);
			myEinAus.wert1Button.setVisible(false);
			myEinAus.wert2Button.setVisible(false);
			myEinAus.wert3Button.setVisible(false);
			myEinAus.wert4Button.setVisible(false);
			myEinAus.wert5Button.setVisible(false);
			Karte anzeige = (Karte)mySpiel.blattSp2.get(0);
			myEinAus.spieler2Stapel.setIcon(anzeige.getBild());

	    }

      	else if (cmd.equals("Ende"))

	    {
	    	myEinAus.setVisible(false);
         	myEinAus.dispose();
         	System.exit(0);
      	}

	}

}