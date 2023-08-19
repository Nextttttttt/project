import java.io.Serializable;
import java.util.Scanner;

public class Construction extends AnestheticLand implements Serializable{
private int numberOfLevels;
private String typeOfSoil;
 public Construction() {
	numberOfLevels=0;
	typeOfSoil="";
}
public Construction(int Nb, String nameOfPerson, int idOfLand, double area, double priceOfOneMeter,int nbLv,String soil) {
	super(Nb, nameOfPerson, idOfLand, area, priceOfOneMeter);
	numberOfLevels=nbLv;
	typeOfSoil=soil;
	
}
public Construction(int numberOfLevels, String typeOfSoil) {
	this.numberOfLevels = numberOfLevels;
	this.typeOfSoil = typeOfSoil;
}
public int getNumberOfLevels() {
	return numberOfLevels;
}
public void setNumberOfLevels(int numberOfLevels) {
	this.numberOfLevels = numberOfLevels;
}
public String getTypeOfSoil() {
	return typeOfSoil;
}
public void setTypeOfSoil(String typeOfSoil) {
	this.typeOfSoil = typeOfSoil;
}
public void Display() {
	super.Display();
	System.out.println("Number of levels: "+numberOfLevels+", Type of soil: "+typeOfSoil);
	System.out.println("Price of the land: "+priceOfLand()+"$");
}
public void ReadDetailsOfConstructionLand() {
	Scanner in=new Scanner (System.in);
	super.ReadAnestheticLandInformation();
	System.out.println("Enter the number of levels:");
	setNumberOfLevels(in.nextInt());
	System.out.println("Enter the type of soil:");
	setTypeOfSoil(in.next());

}
public double priceOfLand() {
	 return PriceOfOneMeter*area;
}
}
