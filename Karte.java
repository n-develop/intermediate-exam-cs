//Der "Bauplan" einer Karte

import javax.swing.*;



class Karte

{

	private double wert1 = 0;
	private double wert2 = 0;
	private double wert3 = 0;
	private double wert4 = 0;
	private double wert5 = 0;
	private int  besonderheit = 0;

	private ImageIcon bild;



	Karte(String pName, double pWert1, double pWert2, double pWert3, double pWert4, double pWert5, ImageIcon pBild, int  pBesonderheit)

	{

		wert1 = pWert1;
		wert2 = pWert2;
		wert3 = pWert3;
		wert4 = pWert4;
		wert5 = pWert5;
		bild = pBild;
		besonderheit = pBesonderheit;
	}


	public double getWert1()
	{
		return wert1;
	}
	public double getWert2()
	{
		return wert2;
	}
	public double getWert3()
	{
		return wert3;
	}
	public double getWert4()
	{
		return wert4;
	}
	public double getWert5()
	{
		return wert5;
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

