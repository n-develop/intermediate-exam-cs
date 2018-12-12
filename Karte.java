//Der "Bauplan" einer Karte

import javax.swing.*;



class Karte
{

	private double vmax = 0;

	private double leistung = 0;
	private double gewicht = 0;
	private double laenge = 0;
	private double baujahr = 0;
	private int  besonderheit = 0;

	private ImageIcon bild;



	Karte(String pName, double pVmax, double pLeistung, double pGewicht, double pLaenge, double pBaujahr, ImageIcon pBild, int  pBesonderheit)

	{

		vmax = pVmax;
		leistung = pLeistung;
		gewicht = pGewicht;
		laenge = pLaenge;
		baujahr = pBaujahr;
		bild = pBild;
		besonderheit = pBesonderheit;
	}


	public double getVmax()

	{

		return vmax;

	}



	public double getLeistung()

	{

		return leistung;

	}
	public double getGewicht()
	{
		return gewicht;
	}
	public double getLaenge()
	{
		return laenge;
	}
	public double getBaujahr()
	{
		return baujahr;
	}
	public int getBesonderheit()
	{
		return besonderheit;
	}
	public ImageIcon getBild()
	{
		return bild;
	}



}

