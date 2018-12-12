//In dieser Klasse sind die drei Strategien des Computergegners definiert

import java.util.Random;


class Gegner
{
	private int ergebnis = 0;
	private Random	myRandom;
	Main myMain;
	Kartenspiel kSpiel;

	public Gegner (long start, Main pMain)
	{
		myRandom = new Random(start);
		myMain = pMain;
		kSpiel = new Kartenspiel(myMain.getVariante());
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

			int wert1Wert = getMittelWert1();
			int wert2Wert = getMittelWert2();
			int wert4Wert = getMittelWert4();
			int wert3Wert = getMittelWert3();
			int wert5Wert = getMittelWert5();

			if(karte.getWert1() > wert1Wert)
				retValue = 0;
			else if(karte.getWert2() > wert2Wert)
				retValue = 1;
			else if(karte.getWert4() > wert4Wert)
				retValue = 2;
			else if(karte.getWert3() < wert3Wert)
				retValue = 3;
			else if(karte.getWert5() < wert5Wert)
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
			int wert175 = pro75Wert1();
			int wert275 = pro75Wert2();
			int wert475 = pro75Wert4();
			int wert375 = pro75Wert3();
			int wert575 = pro75Wert5();

			if(karte.getWert1() > wert175)
				retValue = 0;
			else if(karte.getWert2() > wert275)
				retValue = 1;
			else if(karte.getWert4() > wert475)
				retValue = 2;
			else if(karte.getWert3() < wert375)
				retValue = 3;
			else if(karte.getWert5() < wert575)
				retValue = 4;
			else
			{
				int wert1Wert = getMittelWert1();
				int wert2Wert = getMittelWert2();
				int wert4Wert = getMittelWert4();
				int wert3Wert = getMittelWert3();
				int wert5Wert = getMittelWert5();

				if(karte.getWert1() > wert1Wert)
					retValue = 0;
				else if(karte.getWert2() > wert2Wert)
					retValue = 1;
				else if(karte.getWert4() > wert4Wert)
					retValue = 2;
				else if(karte.getWert3() < wert3Wert)
					retValue = 3;
				else if(karte.getWert5() < wert5Wert)
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

	int getMittelWert1()
	{
		int wert1Wert=0;
		for (int i=0; i<32; i++)
		{
			wert1Wert += kSpiel.stapel[i].getWert1();
		}
		wert1Wert /=  32;
		return wert1Wert;
	}

	int getMittelWert2()
	{
		int wert2Wert=0;
		for (int i=0; i<32; i++)
		{
			wert2Wert += kSpiel.stapel[i].getWert2();
		}
		wert2Wert /= 32;
		return wert2Wert;
	}

	int getMittelWert3()
	{
		int wert3Wert=0;
		for (int i=0; i<32; i++)
		{
			wert3Wert += kSpiel.stapel[i].getWert3();
		}
		wert3Wert /= 32;
		return wert3Wert;
	}

	int getMittelWert4()
	{
		int wert4Wert=0;
		for (int i=0; i<32; i++)
		{
			wert4Wert += kSpiel.stapel[i].getWert4();
		}
		wert4Wert /= 32;
		return wert4Wert;
	}

	int getMittelWert5()
	{
		int wert5Wert=0;
		for (int i=0; i<32; i++)
		{
			wert5Wert += kSpiel.stapel[i].getWert5();
		}
		wert5Wert /= 32;
		return wert5Wert;
	}

	//Methoden zur Ermittlung der 75%-Marke einer Eigentschaft

 	int pro75Wert1()
 	{
		kSpiel.sortWert1();
		int anzahl = 0;
		int wert75 = 0;
		int mittelwert = getMittelWert1();
		for(int i=31; mittelwert<kSpiel.stapel[i].getWert1(); i--)
		{
			wert75 += kSpiel.stapel[i].getWert1();
			anzahl++;
		}
		wert75 /= anzahl;
		return wert75;
	}
 	int pro75Wert2()
 	{
		kSpiel.sortWert2();
		int anzahl = 0;
		int wert75 = 0;
		int mittelwert = getMittelWert2();
		for(int i=31; mittelwert<kSpiel.stapel[i].getWert2(); i--)
		{
			wert75 += kSpiel.stapel[i].getWert2();
			anzahl++;
		}
		wert75 /= anzahl;
		return wert75;
	}
 	int pro75Wert3()
 	{
		kSpiel.sortWert3();
		int anzahl = 0;
		int wert75 = 0;
		int mittelwert= getMittelWert3();
		for(int i=0; mittelwert>kSpiel.stapel[i].getWert3(); i++)
		{
			wert75 += kSpiel.stapel[i].getWert3();
			anzahl++;
		}
		wert75 /= anzahl;
		return wert75;
	}
 	int pro75Wert4()
 	{
		kSpiel.sortWert4();
		int anzahl = 0;
		int wert75 = 0;
		int mittelwert = getMittelWert4();
		for(int i=31; mittelwert<kSpiel.stapel[i].getWert4(); i--)
		{
			wert75 += kSpiel.stapel[i].getWert4();
			anzahl++;
		}
		wert75 /= anzahl;
		return wert75;
	}
 	int pro75Wert5()
 	{
		kSpiel.sortWert5();
		int anzahl = 0;
		int wert75 = 0;
		int mittelwert= getMittelWert5();
		for(int i=0; mittelwert>kSpiel.stapel[i].getWert5(); i++)
		{
			wert75 += kSpiel.stapel[i].getWert5();
			anzahl++;
		}
		wert75 /= anzahl;
		return wert75;
	}
}