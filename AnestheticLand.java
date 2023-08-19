import java.util.*;
public abstract class AnestheticLand extends Country implements LandPrice{
protected String NameOfPerson;
protected int idOfLand;
protected double area;
protected double PriceOfOneMeter;
public AnestheticLand() {
	NameOfPerson="";
	idOfLand=0;
	area=0;
	PriceOfOneMeter=0;
}
public AnestheticLand(int Nb,String nameOfPerson, int idOfLand, double area, double priceOfOneMeter) {
	CountryNumber=Nb;
	NameOfPerson = nameOfPerson;
	this.idOfLand = idOfLand;
	this.area = area;
	PriceOfOneMeter = priceOfOneMeter;
	
}
public AnestheticLand(AnestheticLand L) {
	    this.NameOfPerson = L.NameOfPerson;
	    this.idOfLand = L.idOfLand;
	    this.area = L.area;
	    this.PriceOfOneMeter = L.PriceOfOneMeter;
	    CountryNumber=L.CountryNumber;
	    
}
public String getNameOfPerson() {
	return NameOfPerson;
}
public void setNameOfPerson(String nameOfPerson) {
	NameOfPerson = nameOfPerson;
}
public int getIdOfLand() {
	return idOfLand;
}
public void setIdOfLand(int idOfLand) {
	this.idOfLand = idOfLand;
}
public double getArea() {
	return area;
}
public void setArea(double area) {
	this.area = area;
}
public double getPriceOfOneMeter() {
	return PriceOfOneMeter;
}
public void setPriceOfOneMeter(double priceOfOneMeter) {
	PriceOfOneMeter = priceOfOneMeter;
}
public void Display() {
	System.out.println("Name: "+NameOfPerson+", Id: "+idOfLand+", Area: "+area+", PriceOfOneMeter:  "+PriceOfOneMeter+" Country Number: "+super.CountryNumber);
	System.out.println();
}
public void ReadAnestheticLandInformation() {
	Scanner in=new Scanner (System.in);
	System.out.println("Enter the name:");
	setNameOfPerson(in.next());
	System.out.println("Enter the id of land");
	setIdOfLand(in.nextInt());
	System.out.println("Enter the area");
	setArea(in.nextDouble());
	System.out.println("Enter the price Of one meter");
	setPriceOfOneMeter(in.nextDouble());
	System.out.println("Enter the country number");
	int c=in.nextInt();
	CountryNumber=c;
}
}
