//In dieser Klasse sind die drei Strategien des Computergegners definiert

import java.util.Random;


class Gegner
{
	private int ergebnis = 0;
	private Random	myRandom;
	Main myMain;
	Kartenspiel kSpiel = new Kartenspiel();

	public Gegner (long start, Main pMain)
	{
		myRandom = new Random(start);
		myMain = pMain;
	}

	//Diese Methode führt nach Abfrage des Schwierigkeitsgrades
	//die passende Strategie aus
	int sucheAus(int schwierigkeit)
	{
		if(schwierigkeit == 0)
		{
			ergebnis = zufall();
		}
		else if(schwierigkeit == 1)
		{
			ergebnis = normal();
		}
		else if(schwierigkeit == 2)
		{
			ergebnis = optimal();
		}
		return ergebnis;

	}

	//Der Zufallsgenerator
	int zufall()
	{
		int zwerg = this.myRandom.nextInt(5);
		return zwerg;
	}
	//Diese Strategie berücksichtigt Spitzenwerte und den Mittelwert
	int normal()
	{
		Karte karte = (Karte) myMain.mySpiel.blattSp2.get(0);
		int retValue = -1;
		if(karte.getBesonderheit() != -1)
		{
			if(karte.getBesonderheit() == 0)
			{
				retValue = 0;
			}
			else if(karte.getBesonderheit() == 1)
			{
				retValue = 1;
			}
			else if(karte.getBesonderheit() == 2)
			{
				retValue = 2;
			}
			else if(karte.getBesonderheit() == 3)
			{
				retValue = 3;
			}
			else if(karte.getBesonderheit() == 4)
			{
				retValue = 4;
			}
		}
		else
		{

			int vmaxWert = getMittelVmax();
			int leistungWert = getMittelLeistung();
			int laengeWert = getMittelLaenge();
			int gewichtWert = getMittelGewicht();
			int baujahrWert = getMittelBaujahr();

			if(karte.getVmax() > vmaxWert)
				retValue = 0;
			else if(karte.getLeistung() > leistungWert)
				retValue = 1;
			else if(karte.getLaenge() > laengeWert)
				retValue = 2;
			else if(karte.getGewicht() < gewichtWert)
				retValue = 3;
			else if(karte.getBaujahr() < baujahrWert)
				retValue = 4;
			else
			{
				int zwerg = this.myRandom.nextInt(5);
				retValue = zwerg;
			}

		}
		return retValue;

	}


	//Diese Methode berücksichtigt in der Strategie die 75% und 50%-Marke
	//sowie natürlich die Spitzenwerte
	int optimal()
	{
		Karte karte = (Karte) myMain.mySpiel.blattSp2.get(0);
		int retValue = -1;
		if(karte.getBesonderheit() != -1)
		{
			if(karte.getBesonderheit() == 0)
			{
				retValue = 0;
			}
			else if(karte.getBesonderheit() == 1)
			{
				retValue = 1;
			}
			else if(karte.getBesonderheit() == 2)
			{
				retValue = 2;
			}
			else if(karte.getBesonderheit() == 3)
			{
				retValue = 3;
			}
			else if(karte.getBesonderheit() == 4)
			{
				retValue = 4;
			}
		}
		else
		{
			int vmax75 = pro75Vmax();
			int leistung75 = pro75Leistung();
			int laenge75 = pro75Laenge();
			int gewicht75 = pro75Gewicht();
			int baujahr75 = pro75Baujahr();

			if(karte.getVmax() > vmax75)
				retValue = 0;
			else if(karte.getLeistung() > leistung75)
				retValue = 1;
			else if(karte.getLaenge() > laenge75)
				retValue = 2;
			else if(karte.getGewicht() < gewicht75)
				retValue = 3;
			else if(karte.getBaujahr() < baujahr75)
				retValue = 4;
			else
			{
				int vmaxWert = getMittelVmax();
				int leistungWert = getMittelLeistung();
				int laengeWert = getMittelLaenge();
				int gewichtWert = getMittelGewicht();
				int baujahrWert = getMittelBaujahr();

				if(karte.getVmax() > vmaxWert)
					retValue = 0;
				else if(karte.getLeistung() > leistungWert)
					retValue = 1;
				else if(karte.getLaenge() > laengeWert)
					retValue = 2;
				else if(karte.getGewicht() < gewichtWert)
					retValue = 3;
				else if(karte.getBaujahr() < baujahrWert)
					retValue = 4;
				else
				{
					int zwerg = this.myRandom.nextInt(5);
					retValue = zwerg;
				}
			}
		}
		return retValue;
	}
	//-------------------------------------------------------------
	//-------------------------------------------------------------


	// Methoden zur Ermittlung des Mittelwertes einer bestimmten Eigenschaft

	int getMittelVmax()
	{
		int vmaxWert=0;
		for (int i=0; i<32; i++)
		{
			vmaxWert += kSpiel.stapel[i].getVmax();
		}
		vmaxWert /=  32;
		return vmaxWert;
	}

	int getMittelLeistung()
	{
		int leistungWert=0;
		for (int i=0; i<32; i++)
		{
			leistungWert += kSpiel.stapel[i].getLeistung();
		}
		leistungWert /= 32;
		return leistungWert;
	}

	int getMittelGewicht()
	{
		int gewichtWert=0;
		for (int i=0; i<32; i++)
		{
			gewichtWert += kSpiel.stapel[i].getGewicht();
		}
		gewichtWert /= 32;
		return gewichtWert;
	}

	int getMittelLaenge()
	{
		int laengeWert=0;
		for (int i=0; i<32; i++)
		{
			laengeWert += kSpiel.stapel[i].getLaenge();
		}
		laengeWert /= 32;
		return laengeWert;
	}

	int getMittelBaujahr()
	{
		int baujahrWert=0;
		for (int i=0; i<32; i++)
		{
			baujahrWert += kSpiel.stapel[i].getBaujahr();
		}
		baujahrWert /= 32;
		return baujahrWert;
	}

	//Methoden zur Ermittlung der 75%-Marke einer Eigentschaft

 	int pro75Vmax()
 	{
		kSpiel.sortVmax();
		int anzahl = 0;
		int wert75 = 0;
		int mittelwert = getMittelVmax();
		for(int i=31; mittelwert<kSpiel.stapel[i].getVmax(); i--)
		{
			wert75 += kSpiel.stapel[i].getVmax();
			anzahl++;
		}
		wert75 /= anzahl;
		return wert75;
	}
 	int pro75Leistung()
 	{
		kSpiel.sortLeistung();
		int anzahl = 0;
		int wert75 = 0;
		int mittelwert = getMittelLeistung();
		for(int i=31; mittelwert<kSpiel.stapel[i].getLeistung(); i--)
		{
			wert75 += kSpiel.stapel[i].getLeistung();
			anzahl++;
		}
		wert75 /= anzahl;
		return wert75;
	}
 	int pro75Gewicht()
 	{
		kSpiel.sortGewicht();
		int anzahl = 0;
		int wert75 = 0;
		int mittelwert= getMittelGewicht();
		for(int i=0; mittelwert>kSpiel.stapel[i].getGewicht(); i++)
		{
			wert75 += kSpiel.stapel[i].getGewicht();
			anzahl++;
		}
		wert75 /= anzahl;
		return wert75;
	}
 	int pro75Laenge()
 	{
		kSpiel.sortLaenge();
		int anzahl = 0;
		int wert75 = 0;
		int mittelwert = getMittelLaenge();
		for(int i=31; mittelwert<kSpiel.stapel[i].getLaenge(); i--)
		{
			wert75 += kSpiel.stapel[i].getLaenge();
			anzahl++;
		}
		wert75 /= anzahl;
		return wert75;
	}
 	int pro75Baujahr()
 	{
		kSpiel.sortBaujahr();
		int anzahl = 0;
		int wert75 = 0;
		int mittelwert= getMittelBaujahr();
		for(int i=0; mittelwert>kSpiel.stapel[i].getBaujahr(); i++)
		{
			wert75 += kSpiel.stapel[i].getBaujahr();
			anzahl++;
		}
		wert75 /= anzahl;
		return wert75;
	}
}