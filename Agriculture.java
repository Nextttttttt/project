import java.io.Serializable;
import java.util.Scanner;

public class Agriculture extends AnestheticLand implements Serializable{
    private String cropToBeSeeded;
 public Agriculture(){
        cropToBeSeeded="";
    }
 public Agriculture(int Nb,String name,int id,double Ar,double pr,String crop){
  super(Nb,name,id,Ar,pr);
  cropToBeSeeded=crop;
    }
public String getCropToBeSeeded() {
	return cropToBeSeeded;
}
public void setCropToBeSeeded(String cropToBeSeeded) {
	this.cropToBeSeeded = cropToBeSeeded;
}
public Agriculture(String cropToBeSeeded) {
	this.cropToBeSeeded = cropToBeSeeded;
}
 public void Display() {
	 super.Display();
	 System.out.println("Crop to be seeded is  "+cropToBeSeeded);
	 System.out.println("Price of the land: "+priceOfLand()+"$");
 }
 public void ReadDetailsOfAgricultureLand() {
	 Scanner in=new Scanner(System.in);
	 super.ReadAnestheticLandInformation();
	 System.out.println("Enter the name of the seed you want to crop");
	 setCropToBeSeeded(in.next());
 }
 public double priceOfLand() {
	 return PriceOfOneMeter*area;
 }
}
