import java.util.*;
class Spiel
{
	//Attribute
	Vector blattSp1 = new Vector(0,1);
	Vector blattSp2 = new Vector(0,1);
	Vector unentschieden = new Vector();
	Kartenspiel meinKSpiel;

	Spiel (int pVariante)
	{
		meinKSpiel = new Kartenspiel(pVariante);
	}

	void verteilen()
	{
		for(int i=0; i<16; i++)

		{
			blattSp1.add(meinKSpiel.getKarte(i*2));
			blattSp2.add(meinKSpiel.getKarte(i*2+1));
		}

	}

}