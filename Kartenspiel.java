import javax.swing.ImageIcon;
import java.util.Date;
import java.util.Random;

class Kartenspiel
{
	//Attribute
	private int anzahl = 32;
	Karte stapel[] = new Karte[anzahl];
	private Date myDate = new Date();
	private Random zZahl1 = new Random(myDate.getTime());
	private Random zZahl2 = new Random(myDate.getTime()+123);
	private int zz1, zz2;
	private Karte zwischen;

	//Konstruktor

	Kartenspiel ()
	{
		stapel[0] = new Karte("1A",220,8700, 87, 19, 1996,new ImageIcon("Images\\1a.gif"), -1);
		stapel[1] = new Karte("1B",230, 8160, 82, 18.5, 1995,new ImageIcon("Images\\1b.gif"), -1);
		stapel[2] = new Karte("1C",240, 6400, 80, 19.1, 1988,new ImageIcon("Images\\1c.gif"), -1);
		stapel[3] = new Karte("1D",220, 8160, 84, 18.9, 1994,new ImageIcon("Images\\1d.gif"), -1);
		stapel[4] = new Karte("2A",160, 5440, 80, 19.4, 1986,new ImageIcon("Images\\2a.gif"), -1);
		stapel[5] = new Karte("2B",140, 5700, 84, 19.9, 1997,new ImageIcon("Images\\2b.gif"), -1);
		stapel[6] = new Karte("2C",160, 4600, 74, 17.5, 1993,new ImageIcon("Images\\2c.gif"), -1);
		stapel[7] = new Karte("2D",220, 8700, 84, 19.5, 1995,new ImageIcon("Images\\2d.gif"), -1);
		stapel[8] = new Karte("3A",120, 4000, 131, 27.1, 1948,new ImageIcon("Images\\3a.gif"), -1);
		stapel[9] = new Karte("3B",130, 2240, 130, 23.9, 1925,new ImageIcon("Images\\3b.gif"), 4);
		stapel[10] = new Karte("3C",120, 2400, 117, 25.6, 1954,new ImageIcon("Images\\3c.gif"), -1);
		stapel[11] = new Karte("3D",128, 7000, 486, 37.2, 1942,new ImageIcon("Images\\3d.gif"), -1);
		stapel[12] = new Karte("4A",166, 3670, 191, 20.3, 1991,new ImageIcon("Images\\4a.gif"), -1);
		stapel[13] = new Karte("4B",160, 3600, 120, 21, 1995,new ImageIcon("Images\\4b.gif"), -1);
		stapel[14] = new Karte("4C",120, 3300, 76, 22, 1996,new ImageIcon("Images\\4c.gif"), -1);
		stapel[15] = new Karte("4D",80, 2510, 132, 21.7, 1996,new ImageIcon("Images\\4d.gif"), -1);
		stapel[16] = new Karte("5A",105, 4620, 188, 22.6, 1994,new ImageIcon("Images\\5a.gif"), -1);
		stapel[17] = new Karte("5B",120, 3346, 76, 22, 1998,new ImageIcon("Images\\5b.gif"), -1);
		stapel[18] = new Karte("5C",100, 1650, 73, 15.5, 1996,new ImageIcon("Images\\5c.gif"), 3);
		stapel[19] = new Karte("5D",120, 2140, 81, 17.4, 1996,new ImageIcon("Images\\5d.gif"), -1);
		stapel[20] = new Karte("6A",500, 14960, 124, 54, 1999,new ImageIcon("Images\\6a.gif"), 1);
		stapel[21] = new Karte("6B",300, 16590, 816, 394, 1993,new ImageIcon("Images\\6b.gif"), 2);
		stapel[22] = new Karte("6C",330, 10880, 440, 200, 1997,new ImageIcon("Images\\6c.gif"), -1);
		stapel[23] = new Karte("6D",300, 11970, 424, 200, 1996,new ImageIcon("Images\\6d.gif"), -1);
		stapel[24] = new Karte("7A",160, 2700, 210, 101.8, 1989,new ImageIcon("Images\\7a.gif"), -1);
		stapel[25] = new Karte("7B",200, 4500, 365, 165, 1990,new ImageIcon("Images\\7b.gif"), -1);
		stapel[26] = new Karte("7C",120, 1390, 101, 52.2, 1998,new ImageIcon("Images\\7c.gif"), -1);
		stapel[27] = new Karte("7D",120, 710, 75, 51, 1995,new ImageIcon("Images\\7d.gif"), -1);
		stapel[28] = new Karte("8A",80, 2067, 220, 140, 1997,new ImageIcon("Images\\8a.gif"), -1);
		stapel[29] = new Karte("8B",140,7208, 200, 162, 1997,new ImageIcon("Images\\8b.gif"), -1);
		stapel[30] = new Karte("8C",160, 1900, 173, 92, 1997,new ImageIcon("Images\\8c.gif"), -1);
		stapel[31] = new Karte("8D",230, 5440, 350, 185, 1998,new ImageIcon("Images\\8d.gif"), -1);
	}


	Karte getKarte(int i)
	{
		return stapel[i];
	}

	void mischen()
	{
		for (int i=0; i<300; i++)
		{
			zz1 = this.zZahl1.nextInt(32);
			zz2 = this.zZahl2.nextInt(32);
			zwischen = stapel[zz1];
			stapel[zz1] = stapel[zz2];
			stapel[zz2] = zwischen;
		}
	}

	void sortVmax()
	{
		for (int i=0; i<32; i++)
		{
			for(int j=0; j<31; j++)
			{
				if(stapel[j].getVmax()>stapel[j+1].getVmax())
				{
					zwischen = stapel[j];
					stapel[j] = stapel[j+1];
					stapel[j+1] = zwischen;
				}
			}
		}
	}
	void sortLeistung()
	{
		for (int i=0; i<32; i++)
		{
			for(int j=0; j<31; j++)
			{
				if(stapel[j].getLeistung()>stapel[j+1].getLeistung())
				{
					zwischen = stapel[j];
					stapel[j] = stapel[j+1];
					stapel[j+1] = zwischen;
				}
			}
		}
	}
	void sortLaenge()
	{
		for (int i=0; i<31; i++)
		{
			for(int j=0; j<31; j++)
			{
				if(stapel[j].getLaenge()>stapel[j+1].getLaenge())
				{
					zwischen = stapel[j];
					stapel[j] = stapel[j+1];
					stapel[j+1] = zwischen;
				}
			}
		}
	}
	void sortGewicht()
	{
		for (int i=0; i<32; i++)
		{
			for(int j=0; j<31; j++)
			{
				if(stapel[j].getGewicht()>stapel[j+1].getGewicht())
				{
					zwischen = stapel[j];
					stapel[j] = stapel[j+1];
					stapel[j+1] = zwischen;
				}
			}
		}
	}
	void sortBaujahr()
	{
		for (int i=0; i<32; i++)
		{
			for(int j=0; j<31; j++)
			{
				if(stapel[j].getBaujahr()>stapel[j+1].getBaujahr())
				{
					zwischen = stapel[j];
					stapel[j] = stapel[j+1];
					stapel[j+1] = zwischen;
				}
			}
		}
	}


}
