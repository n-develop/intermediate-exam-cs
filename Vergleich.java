class Vergleich
{
	//Return-Werte für Sieg, Niederlage oder Unentschieden
 	int spieler1 = 1;
 	int spieler2 = 2;
 	int unentschieden = 0;

 	public int vergleiche(int wertIndex, double sp1Wert, double sp2Wert)
	{
 		int retValue = -1;

 		if(wertIndex == 3)
		{
			double iTmp = sp1Wert;
 			sp1Wert = sp2Wert;
 			sp2Wert = iTmp;
 		}

 		if (sp1Wert > sp2Wert)
 			retValue = spieler1;
 		else if (sp1Wert < sp2Wert)
 			retValue = spieler2;
 		else
 			retValue = unentschieden;

 		return retValue;
 	}
}