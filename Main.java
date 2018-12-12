import java.util.Date;

import javax.swing.*;


class Main
{
	private Date myDate = new Date();
	Gegner myGegner;
	Spiel mySpiel = new Spiel();
	Vergleich myVergleich = new Vergleich();
	Endmaske myEndmaske = new Endmaske();
	EinAus myEinAus;
	ImageIcon rueckseite = new ImageIcon("Images\\rückseite.gif");

	int spielerKarten, pcKarten, stockKarten;
	private int amZug=0; // 0=Mensch 1=Computer
	private int anzahl = 32;
	private int auswahl; //0=Vmax 1=Leistung 2=Länge 3=Gewicht 4=Baujahr
	private int sieger;
	private double wertPC, wertSp;
	private int pcWahl;

	Main(EinAus pEinAus)
	{
		myEinAus = pEinAus;
		myGegner = new Gegner(myDate.getTime(), this);
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
				wertSp = obersteKarte.getVmax();
				wertPC = gegnerKarte.getVmax();
			}
			else if (auswahl == 1)
			{
				wertSp = obersteKarte.getLeistung();
				wertPC = gegnerKarte.getLeistung();
			}
			else if (auswahl == 2)
			{
				wertSp = obersteKarte.getLaenge();
				wertPC = gegnerKarte.getLaenge();
			}
			else if (auswahl == 3)
			{
				wertSp = obersteKarte.getGewicht();
				wertPC = gegnerKarte.getGewicht();
			}
			else if (auswahl == 4)
			{
				wertSp = obersteKarte.getBaujahr();
				wertPC = gegnerKarte.getBaujahr();
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
				myEinAus.vmaxButton.setVisible(false);
				myEinAus.leistungButton.setVisible(false);
				myEinAus.gewichtButton.setVisible(false);
				myEinAus.laengeButton.setVisible(false);
				myEinAus.baujahrButton.setVisible(false);
				auswahl = myGegner.sucheAus(myEinAus.schwierig);
				Karte sp2Karte = (Karte)mySpiel.blattSp2.get(0);
				Karte sp1Karte = (Karte)mySpiel.blattSp1.get(0);
				if (auswahl == 0)
				{
					int vmax1 = (int) sp1Karte.getVmax();
					int vmax2 = (int) sp2Karte.getVmax();
					myEinAus.wertComputer.setText(""+vmax2);
					myEinAus.wertSpieler.setText(""+vmax1);
					myEinAus.ihreWahlAusgabe.setText("Vmax");
					myEinAus.spieler2Stapel.setIcon(sp2Karte.getBild());
				}
				else if (auswahl == 1)
				{
					int leistung1 = (int) sp1Karte.getLeistung();
					int leistung2 = (int) sp2Karte.getLeistung();
					myEinAus.wertComputer.setText(""+leistung2);
					myEinAus.wertSpieler.setText(""+leistung1);
					myEinAus.ihreWahlAusgabe.setText("Leistung");
					myEinAus.spieler2Stapel.setIcon(sp2Karte.getBild());
				}
				else if (auswahl == 2)
				{
					myEinAus.wertComputer.setText(""+sp2Karte.getLaenge());
					myEinAus.wertSpieler.setText(""+sp1Karte.getLaenge());
					myEinAus.ihreWahlAusgabe.setText("Länge");
					myEinAus.spieler2Stapel.setIcon(sp2Karte.getBild());
				}
				else if (auswahl == 3)
				{
					int gewicht1 = (int) sp1Karte.getGewicht();
					int gewicht2 = (int) sp2Karte.getGewicht();
					myEinAus.wertComputer.setText(""+gewicht2);
					myEinAus.wertSpieler.setText(""+gewicht1);
					myEinAus.ihreWahlAusgabe.setText("Gewicht");
					myEinAus.spieler2Stapel.setIcon(sp2Karte.getBild());
				}
				else if (auswahl == 4)
				{
					int baujahr1 = (int) sp1Karte.getBaujahr();
					int baujahr2 = (int) sp2Karte.getBaujahr();
					myEinAus.wertComputer.setText(""+baujahr2);
					myEinAus.wertSpieler.setText(""+baujahr1);
					myEinAus.ihreWahlAusgabe.setText("Baujahr");
					myEinAus.spieler2Stapel.setIcon(sp2Karte.getBild());
				}
			}

			if(amZug == 0)
			{
				myEinAus.wertComputer.setText("");
				myEinAus.wertSpieler.setText("");
				myEinAus.ihreWahlAusgabe.setText("");
				myEinAus.vmaxButton.setVisible(true);
				myEinAus.leistungButton.setVisible(true);
				myEinAus.gewichtButton.setVisible(true);
				myEinAus.laengeButton.setVisible(true);
				myEinAus.baujahrButton.setVisible(true);
				myEinAus.spieler2Stapel.setIcon(rueckseite);
			}
	    }

		else if (cmd.equals("Vmax"))
		{
			auswahl=0;
			Karte obersteKarte = (Karte)mySpiel.blattSp1.get(0);
			int vmax1 = (int) obersteKarte.getVmax();
			myEinAus.wertSpieler.setText(""+vmax1);
			myEinAus.ihreWahlAusgabe.setText("Vmax");
			Karte gegnerKarte = (Karte)mySpiel.blattSp2.get(0);
			int vmax2 = (int) gegnerKarte.getVmax();
			myEinAus.wertComputer.setText(""+vmax2);
			myEinAus.vmaxButton.setVisible(false);
			myEinAus.leistungButton.setVisible(false);
			myEinAus.gewichtButton.setVisible(false);
			myEinAus.laengeButton.setVisible(false);
			myEinAus.baujahrButton.setVisible(false);
			Karte anzeige = (Karte)mySpiel.blattSp2.get(0);
			myEinAus.spieler2Stapel.setIcon(anzeige.getBild());

		}
	    else if (cmd.equals("Leistung"))
		{
			auswahl=1;
			Karte obersteKarte = (Karte)mySpiel.blattSp1.get(0);
			int leistung1 = (int) obersteKarte.getLeistung();
			myEinAus.wertSpieler.setText(""+leistung1);
			myEinAus.ihreWahlAusgabe.setText("Leistung");
			Karte gegnerKarte = (Karte)mySpiel.blattSp2.get(0);
			int leistung2 = (int) gegnerKarte.getLeistung();
			myEinAus.wertComputer.setText(""+leistung2);
			myEinAus.vmaxButton.setVisible(false);
			myEinAus.leistungButton.setVisible(false);
			myEinAus.gewichtButton.setVisible(false);
			myEinAus.laengeButton.setVisible(false);
			myEinAus.baujahrButton.setVisible(false);
			Karte anzeige = (Karte)mySpiel.blattSp2.get(0);
			myEinAus.spieler2Stapel.setIcon(anzeige.getBild());
	    }
	    else if (cmd.equals("Länge"))
		{
			auswahl=2;
			Karte obersteKarte = (Karte)mySpiel.blattSp1.get(0);
			myEinAus.wertSpieler.setText(""+obersteKarte.getLaenge());
			myEinAus.ihreWahlAusgabe.setText("Länge");
			Karte gegnerKarte = (Karte)mySpiel.blattSp2.get(0);
			myEinAus.wertComputer.setText(""+gegnerKarte.getLaenge());
			myEinAus.vmaxButton.setVisible(false);
			myEinAus.leistungButton.setVisible(false);
			myEinAus.gewichtButton.setVisible(false);
			myEinAus.laengeButton.setVisible(false);
			myEinAus.baujahrButton.setVisible(false);
			Karte anzeige = (Karte)mySpiel.blattSp2.get(0);
			myEinAus.spieler2Stapel.setIcon(anzeige.getBild());

	    }
	    else if (cmd.equals("Gewicht"))
		{
			auswahl=3;
			Karte obersteKarte = (Karte)mySpiel.blattSp1.get(0);
			int gewicht1 = (int) obersteKarte.getGewicht();
			myEinAus.wertSpieler.setText(""+gewicht1);
			myEinAus.ihreWahlAusgabe.setText("Gewicht");
			Karte gegnerKarte = (Karte)mySpiel.blattSp2.get(0);
			int gewicht2 = (int) gegnerKarte.getGewicht();
			myEinAus.wertComputer.setText(""+gewicht2);
			myEinAus.vmaxButton.setVisible(false);
			myEinAus.leistungButton.setVisible(false);
			myEinAus.gewichtButton.setVisible(false);
			myEinAus.laengeButton.setVisible(false);
			myEinAus.baujahrButton.setVisible(false);
			Karte anzeige = (Karte)mySpiel.blattSp2.get(0);
			myEinAus.spieler2Stapel.setIcon(anzeige.getBild());

		}
	    else if (cmd.equals("Baujahr"))
		{
			auswahl=4;
			Karte obersteKarte = (Karte)mySpiel.blattSp1.get(0);
			int baujahr1 = (int) obersteKarte.getBaujahr();
			myEinAus.wertSpieler.setText(""+baujahr1);
			myEinAus.ihreWahlAusgabe.setText("Baujahr");
			Karte gegnerKarte = (Karte)mySpiel.blattSp2.get(0);
			int baujahr2 = (int) gegnerKarte.getBaujahr();
			myEinAus.wertComputer.setText(""+baujahr2);
			myEinAus.vmaxButton.setVisible(false);
			myEinAus.leistungButton.setVisible(false);
			myEinAus.gewichtButton.setVisible(false);
			myEinAus.laengeButton.setVisible(false);
			myEinAus.baujahrButton.setVisible(false);
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