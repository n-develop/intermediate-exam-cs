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

	Kartenspiel (int variante)
	{
		if (variante == 1)
		{
			stapel[0] = new Karte("1A",2912,68, 2100, 3.50, 2500,new ImageIcon("Images\\Traktoren\\1a.gif"), -1);
			stapel[1] = new Karte("1B",3000, 56, 2880, 3.60, 2600,new ImageIcon("Images\\Traktoren\\1b.gif"), -1);
			stapel[2] = new Karte("1C",2925, 45, 1790, 2.73, 1400,new ImageIcon("Images\\Traktoren\\1c.gif"), -1);
			stapel[3] = new Karte("1D",3117, 55, 2810, 3.74, 2300,new ImageIcon("Images\\Traktoren\\1d.gif"), -1);
			stapel[4] = new Karte("2A",4000, 85, 3680, 4.05, 2200,new ImageIcon("Images\\Traktoren\\2a.gif"), -1);
			stapel[5] = new Karte("2B",3192, 84, 3800, 3.71, 2300,new ImageIcon("Images\\Traktoren\\2b.gif"), -1);
			stapel[6] = new Karte("2C",4530, 75, 3600, 3.83, 1300,new ImageIcon("Images\\Traktoren\\2c.gif"), -1);
			stapel[7] = new Karte("2D",4329, 81, 3930, 3.93, 2400,new ImageIcon("Images\\Traktoren\\2d.gif"), -1);
			stapel[8] = new Karte("3A",6870, 260, 8000, 4.94, 2300,new ImageIcon("Images\\Traktoren\\3a.gif"), -1);
			stapel[9] = new Karte("3B",5985, 158, 6500, 5.15, 2200,new ImageIcon("Images\\Traktoren\\3b.gif"), -1);
			stapel[10] = new Karte("3C",8268, 263, 8990, 4.90, 2000,new ImageIcon("Images\\Traktoren\\3c.gif"), -1);
			stapel[11] = new Karte("3D",8300, 255, 8940, 4.78, 2200,new ImageIcon("Images\\Traktoren\\3d.gif"), -1);
			stapel[12] = new Karte("4A",12500, 425, 15320, 7.34, 2100,new ImageIcon("Images\\Traktoren\\4a.gif"), 3);
			stapel[13] = new Karte("4B",12000, 410, 14500, 5.94, 2100,new ImageIcon("Images\\Traktoren\\4b.gif"), -1);
			stapel[14] = new Karte("4C",4580, 140, 6755, 5.42, 2300,new ImageIcon("Images\\Traktoren\\4c.gif"), -1);
			stapel[15] = new Karte("4D",14000, 360, 20290, 5.94, 2100,new ImageIcon("Images\\Traktoren\\4d.gif"), 0);
			stapel[16] = new Karte("5A",9400, 2000, 900, 3, 7500,new ImageIcon("Images\\Traktoren\\5a.gif"), 2);
			stapel[17] = new Karte("5B",9400, 2200, 900, 2.90, 8000,new ImageIcon("Images\\Traktoren\\5b.gif"), 2);
			stapel[18] = new Karte("5C",8400, 1900, 900, 2.90, 8000,new ImageIcon("Images\\Traktoren\\5c.gif"), 2);
			stapel[19] = new Karte("5D",7400, 1000, 900, 3, 7000,new ImageIcon("Images\\Traktoren\\5d.gif"), 2);
			stapel[20] = new Karte("6A",9500, 2300, 3500, 3.90, 7500,new ImageIcon("Images\\Traktoren\\6a.gif"), -1);
			stapel[21] = new Karte("6B",7536, 1900, 3500, 3.90, 6000,new ImageIcon("Images\\Traktoren\\6b.gif"), -1);
			stapel[22] = new Karte("6C",10300, 2800, 3500, 4, 7500,new ImageIcon("Images\\Traktoren\\6c.gif"), -1);
			stapel[23] = new Karte("6D",7500, 2000, 3500, 4, 5500,new ImageIcon("Images\\Traktoren\\6d.gif"), -1);
			stapel[24] = new Karte("7A",81000, 6885, 4400, 4.90, 4600,new ImageIcon("Images\\Traktoren\\7a.gif"), -1);
			stapel[25] = new Karte("7B",42600, 6500, 4400, 5, 6000,new ImageIcon("Images\\Traktoren\\7b.gif"), -1);
			stapel[26] = new Karte("7C",30700, 4000, 4400, 5.30, 7800,new ImageIcon("Images\\Traktoren\\7c.gif"), -1);
			stapel[27] = new Karte("7D",24496, 5700, 4400, 5.80, 8000,new ImageIcon("Images\\Traktoren\\7d.gif"), -1);
			stapel[28] = new Karte("8A",21480, 2450, 2400, 4.70, 4000,new ImageIcon("Images\\Traktoren\\8a.gif"), -1);
			stapel[29] = new Karte("8B",39000,9200, 5000, 5.80, 10200,new ImageIcon("Images\\Traktoren\\8b.gif"), 1);
			stapel[30] = new Karte("8C",55000, 6000, 5400, 4.90, 3900,new ImageIcon("Images\\Traktoren\\8c.gif"), -1);
			stapel[31] = new Karte("8D",44000, 8500, 5400, 5.20, 6500,new ImageIcon("Images\\Traktoren\\8d.gif"), -1);
		}
		else if (variante == 0)
		{
			stapel[0] = new Karte("1A",220,8700, 87, 19, 1996,new ImageIcon("Images\\Eisenbahn\\1a.gif"), -1);
			stapel[1] = new Karte("1B",230, 8160, 82, 18.5, 1995,new ImageIcon("Images\\Eisenbahn\\1b.gif"), -1);
			stapel[2] = new Karte("1C",240, 6400, 80, 19.1, 1988,new ImageIcon("Images\\Eisenbahn\\1c.gif"), -1);
			stapel[3] = new Karte("1D",220, 8160, 84, 18.9, 1994,new ImageIcon("Images\\Eisenbahn\\1d.gif"), -1);
			stapel[4] = new Karte("2A",160, 5440, 80, 19.4, 1986,new ImageIcon("Images\\Eisenbahn\\2a.gif"), -1);
			stapel[5] = new Karte("2B",140, 5700, 84, 19.9, 1997,new ImageIcon("Images\\Eisenbahn\\2b.gif"), -1);
			stapel[6] = new Karte("2C",160, 4600, 74, 17.5, 1993,new ImageIcon("Images\\Eisenbahn\\2c.gif"), -1);
			stapel[7] = new Karte("2D",220, 8700, 84, 19.5, 1995,new ImageIcon("Images\\Eisenbahn\\2d.gif"), -1);
			stapel[8] = new Karte("3A",120, 4000, 131, 27.1, 1948,new ImageIcon("Images\\Eisenbahn\\3a.gif"), -1);
			stapel[9] = new Karte("3B",130, 2240, 130, 23.9, 1925,new ImageIcon("Images\\Eisenbahn\\3b.gif"), -1);
			stapel[10] = new Karte("3C",120, 2400, 117, 25.6, 1954,new ImageIcon("Images\\Eisenbahn\\3c.gif"), -1);
			stapel[11] = new Karte("3D",128, 7000, 486, 37.2, 1942,new ImageIcon("Images\\Eisenbahn\\3d.gif"), -1);
			stapel[12] = new Karte("4A",166, 3670, 191, 20.3, 1991,new ImageIcon("Images\\Eisenbahn\\4a.gif"), -1);
			stapel[13] = new Karte("4B",160, 3600, 120, 21, 1995,new ImageIcon("Images\\Eisenbahn\\4b.gif"), -1);
			stapel[14] = new Karte("4C",120, 3300, 76, 22, 1996,new ImageIcon("Images\\Eisenbahn\\4c.gif"), -1);
			stapel[15] = new Karte("4D",80, 2510, 132, 21.7, 1996,new ImageIcon("Images\\Eisenbahn\\4d.gif"), -1);
			stapel[16] = new Karte("5A",105, 4620, 188, 22.6, 1994,new ImageIcon("Images\\Eisenbahn\\5a.gif"), -1);
			stapel[17] = new Karte("5B",120, 3346, 76, 22, 1998,new ImageIcon("Images\\Eisenbahn\\5b.gif"), -1);
			stapel[18] = new Karte("5C",100, 1650, 73, 15.5, 1996,new ImageIcon("Images\\Eisenbahn\\5c.gif"), 3);
			stapel[19] = new Karte("5D",120, 2140, 81, 17.4, 1996,new ImageIcon("Images\\Eisenbahn\\5d.gif"), -1);
			stapel[20] = new Karte("6A",500, 14960, 124, 54, 1999,new ImageIcon("Images\\Eisenbahn\\6a.gif"), 0);
			stapel[21] = new Karte("6B",300, 16590, 816, 394, 1993,new ImageIcon("Images\\Eisenbahn\\6b.gif"), 2);
			stapel[22] = new Karte("6C",330, 10880, 440, 200, 1997,new ImageIcon("Images\\Eisenbahn\\6c.gif"), -1);
			stapel[23] = new Karte("6D",300, 11970, 424, 200, 1996,new ImageIcon("Images\\Eisenbahn\\6d.gif"), -1);
			stapel[24] = new Karte("7A",160, 2700, 210, 101.8, 1989,new ImageIcon("Images\\Eisenbahn\\7a.gif"), -1);
			stapel[25] = new Karte("7B",200, 4500, 365, 165, 1990,new ImageIcon("Images\\Eisenbahn\\7b.gif"), -1);
			stapel[26] = new Karte("7C",120, 1390, 101, 52.2, 1998,new ImageIcon("Images\\Eisenbahn\\7c.gif"), -1);
			stapel[27] = new Karte("7D",120, 710, 75, 51, 1995,new ImageIcon("Images\\Eisenbahn\\7d.gif"), -1);
			stapel[28] = new Karte("8A",80, 2067, 220, 140, 1997,new ImageIcon("Images\\Eisenbahn\\8a.gif"), -1);
			stapel[29] = new Karte("8B",140,7208, 200, 162, 1997,new ImageIcon("Images\\Eisenbahn\\8b.gif"), -1);
			stapel[30] = new Karte("8C",160, 1900, 173, 92, 1997,new ImageIcon("Images\\Eisenbahn\\8c.gif"), -1);
			stapel[31] = new Karte("8D",230, 5440, 350, 185, 1998,new ImageIcon("Images\\Eisenbahn\\8d.gif"), -1);
		}
		else if (variante == 2) //Panzer noch bearbeiten
		{
			stapel[0] = new Karte("1A",75, 550, 24.5, 6.3, 660,new ImageIcon("Images\\Panzer\\1a.gif"), -1);
			stapel[1] = new Karte("1B",70, 388, 21.6, 6.7, 500,new ImageIcon("Images\\Panzer\\1b.gif"), -1);
			stapel[2] = new Karte("1C",72, 455, 19.5, 6.2, 480,new ImageIcon("Images\\Panzer\\1c.gif"), -1);
			stapel[3] = new Karte("1D",70, 500, 18.7, 7.14, 600,new ImageIcon("Images\\Panzer\\1d.gif"), -1);
			stapel[4] = new Karte("2A",67, 1500, 63, 9.8, 436,new ImageIcon("Images\\Panzer\\2a.gif"), -1);
			stapel[5] = new Karte("2B",72, 1500, 59.7, 9.9, 500,new ImageIcon("Images\\Panzer\\2b.gif"), -1);
			stapel[6] = new Karte("2C",55, 1200, 62, 7.6, 500,new ImageIcon("Images\\Panzer\\2c.gif"), -1);
			stapel[7] = new Karte("2D",75, 1500, 54, 9.8, 550,new ImageIcon("Images\\Panzer\\2d.gif"), -1);
			stapel[8] = new Karte("3A",64, 440, 28.8, 9.8, 344,new ImageIcon("Images\\Panzer\\3a.gif"), -1);
			stapel[9] = new Karte("3B",60, 840, 42, 11.9, 500,new ImageIcon("Images\\Panzer\\3b.gif"), -1);
			stapel[10] = new Karte("3C",28, 290, 53, 11, 250,new ImageIcon("Images\\Panzer\\3c.gif"), -1);
			stapel[11] = new Karte("3D",60, 1000, 55, 7.9, 420,new ImageIcon("Images\\Panzer\\3d.gif"), -1);
			stapel[12] = new Karte("4A",50, 700, 45, 6.6, 500,new ImageIcon("Images\\Panzer\\4a.gif"), -1);
			stapel[13] = new Karte("4B",100, 240, 15, 7.3, 800,new ImageIcon("Images\\Panzer\\4b.gif"), -1);
			stapel[14] = new Karte("4C",62, 240, 12.3, 6.6, 500,new ImageIcon("Images\\Panzer\\4c.gif"), -1);
			stapel[15] = new Karte("4D",70, 600, 27.9, 6.7, 600,new ImageIcon("Images\\Panzer\\4d.gif"), -1);
			stapel[16] = new Karte("5A",60, 518, 43.7, 12.1, 850,new ImageIcon("Images\\Panzer\\5a.gif"), -1);
			stapel[17] = new Karte("5B",90, 280, 20, 7.85, 500,new ImageIcon("Images\\Panzer\\5b.gif"), -1);
			stapel[18] = new Karte("5C",67, 507, 24.6, 6.8, 450,new ImageIcon("Images\\Panzer\\5c.gif"), -1);
			stapel[19] = new Karte("5D",65, 177, 20, 9.6, 570,new ImageIcon("Images\\Panzer\\5d.gif"), -1);
			stapel[20] = new Karte("6A",71, 550, 22.6, 9.35, 450,new ImageIcon("Images\\Panzer\\6a.gif"), -1);
			stapel[21] = new Karte("6B",75, 720, 30, 8.2, 550,new ImageIcon("Images\\Panzer\\6b.gif"), -1);
			stapel[22] = new Karte("6C",72, 550, 22.7, 9.2, 483,new ImageIcon("Images\\Panzer\\6c.gif"), -1);
			stapel[23] = new Karte("6D",72, 200, 8, 5.3, 756,new ImageIcon("Images\\Panzer\\6d.gif"), -1);
			stapel[24] = new Karte("7A",65, 740, 34, 7.9, 500,new ImageIcon("Images\\Panzer\\7a.gif"), -1);
			stapel[25] = new Karte("7B",60, 830, 47, 9.1, 500,new ImageIcon("Images\\Panzer\\7b.gif"), -1);
			stapel[26] = new Karte("7C",48, 560, 48, 9, 400,new ImageIcon("Images\\Panzer\\7c.gif"), -1);
			stapel[27] = new Karte("7D",45, 240, 15, 6.9, 250,new ImageIcon("Images\\Panzer\\7d.gif"), -1);
			stapel[28] = new Karte("8A",65, 1200, 51, 9.7, 500,new ImageIcon("Images\\Panzer\\8a.gif"), -1);
			stapel[29] = new Karte("8B",50, 720, 39.9, 9.8, 600,new ImageIcon("Images\\Panzer\\8b.gif"), -1);
			stapel[30] = new Karte("8C",70, 670, 20, 6.4, 300,new ImageIcon("Images\\Panzer\\8c.gif"), -1);
			stapel[31] = new Karte("8D",75, 1250, 46, 9.7, 400,new ImageIcon("Images\\Panzer\\8d.gif"), -1);
		}

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

	void sortWert1()
	{
		for (int i=0; i<32; i++)
		{
			for(int j=0; j<31; j++)
			{
				if(stapel[j].getWert1()>stapel[j+1].getWert1())
				{
					zwischen = stapel[j];
					stapel[j] = stapel[j+1];
					stapel[j+1] = zwischen;
				}
			}
		}
	}
	void sortWert2()
	{
		for (int i=0; i<32; i++)
		{
			for(int j=0; j<31; j++)
			{
				if(stapel[j].getWert2()>stapel[j+1].getWert2())
				{
					zwischen = stapel[j];
					stapel[j] = stapel[j+1];
					stapel[j+1] = zwischen;
				}
			}
		}
	}
	void sortWert4()
	{
		for (int i=0; i<31; i++)
		{
			for(int j=0; j<31; j++)
			{
				if(stapel[j].getWert4()>stapel[j+1].getWert4())
				{
					zwischen = stapel[j];
					stapel[j] = stapel[j+1];
					stapel[j+1] = zwischen;
				}
			}
		}
	}
	void sortWert3()
	{
		for (int i=0; i<32; i++)
		{
			for(int j=0; j<31; j++)
			{
				if(stapel[j].getWert3()>stapel[j+1].getWert3())
				{
					zwischen = stapel[j];
					stapel[j] = stapel[j+1];
					stapel[j+1] = zwischen;
				}
			}
		}
	}
	void sortWert5()
	{
		for (int i=0; i<32; i++)
		{
			for(int j=0; j<31; j++)
			{
				if(stapel[j].getWert5()>stapel[j+1].getWert5())
				{
					zwischen = stapel[j];
					stapel[j] = stapel[j+1];
					stapel[j+1] = zwischen;
				}
			}
		}
	}


}
