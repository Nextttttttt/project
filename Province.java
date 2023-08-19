import java.io.*;
import java.util.*;
public class Province {
private String name;
private int NumberOfAnestheticLands;
private AnestheticLand L[];
private static int a,c;
public Province(int size,String s) {
	name=s;
	L=new AnestheticLand[size];
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getNumberOfAnestheticLands() {
	return NumberOfAnestheticLands;
}
public void setNumberOfAnestheticLands(int numberOfAnestheticLands) {
	NumberOfAnestheticLands = numberOfAnestheticLands;
}
public boolean isFull() {
	for(int i=0;i<L.length;i++) {
		if(L[i]==null) {
			return false;
		}
	}
	return true;
}
public boolean isEmpty() {
	for(int i=0;i<L.length;i++) {
		if(L[i]!=null) {
			return false;
		}
	}
	return true;
}
public boolean AddAnestheticLand(AnestheticLand land) {
	if(NumberOfAnestheticLands<L.length) {
		for(int i=0;i<NumberOfAnestheticLands;i++) {
			if(L[i].idOfLand==land.idOfLand) {
				return false;
			}
		}
		L[NumberOfAnestheticLands]=land;
		NumberOfAnestheticLands++;
		return true;
	}
	return false;
}
public boolean DeleteAnestheticLand(int land) {
	if(searchLandById(land)!=-1) {
		for(int i=searchLandById(land);i<NumberOfAnestheticLands-1;i++) {
			L[i]=L[i+1];
		}
		NumberOfAnestheticLands--;
		return true;
	}
	return false;
}
public int searchLandById(int l) {
	for(int i=0;i<NumberOfAnestheticLands;i++) {
		if(L[i].getIdOfLand()==l) {
          return i;
		}
	}
	return -1;
}
public void displayAllLandds() {
	for(int i=0;i<NumberOfAnestheticLands;i++) {
		L[i].Display();
	}
}
public int FindNumberOfAgricultureLands() {
	int count=0;
    for(int i=0;i<NumberOfAnestheticLands;i++) {
    	if(L[i] instanceof Agriculture) {
    		count++;
    	}
    }
    return count;
}
public int FindNumberOfConstructionLands() {
	int count=0;
    for(int i=0;i<NumberOfAnestheticLands;i++) {
    	if(L[i] instanceof Construction) {
    		count++;
    	}
    }
    return count;
}
public boolean UpdateLandInformation(int idLand) {
	for(int i=0;i<NumberOfAnestheticLands;i++) {
		if(L[i].getIdOfLand()==idLand) {
			L[i].ReadAnestheticLandInformation();
		}
		return true;
	}
	return false;
}
public boolean MergeTwoLands(int idOfLand1,int idOfLand2) {
	int id1=searchLandById(idOfLand1);
	int id2=searchLandById(idOfLand2);
	if(id1!=-1 && id2!=-1) {
		L[id1].setArea(L[id1].getArea()+L[id2].getArea());
		L[id1].setPriceOfOneMeter(L[id1].getPriceOfOneMeter()+L[id2].getPriceOfOneMeter());
		return DeleteAnestheticLand(idOfLand2);
	}
	return false;
}
public boolean SplitLand(int idPre,int idNew,double Percent) {
	int id=searchLandById(idPre);
	int idn=searchLandById(idNew);
	if(id == -1) {
	   return false;
	}
	if(idn == -1) {
	     AnestheticLand l =null;

	        if (L[idPre] instanceof Agriculture) {
	        	l = new Agriculture();
	        } else if (L[idPre] instanceof Construction) {
	            l = new Construction();
	        }
		l.setIdOfLand(idNew);
		l.setArea(L[idPre].getArea()*Percent/100);
		L[idPre].setArea(L[idPre].getArea()-l.getArea());
		l.setPriceOfOneMeter(L[idPre].getPriceOfOneMeter());
		l.setNameOfPerson(L[idPre].getNameOfPerson());
		l.CountryNumber=L[idPre].CountryNumber;
		return AddAnestheticLand(l);
	}
	return false;
}

public void storeData(String AgrFileName, String ConFileName) throws IOException {
    ObjectOutputStream Agr = new ObjectOutputStream(new FileOutputStream(AgrFileName));
    ObjectOutputStream Con = new ObjectOutputStream(new FileOutputStream(ConFileName));
    for (int i = 0; i < NumberOfAnestheticLands; i++) {
        if (L[i] instanceof Agriculture) {
            Agr.writeObject(L[i]);
            a++;
        } else {
            Con.writeObject(L[i]);
            c++;
        }
    }
    Agr.close();
    Con.close();
}
public Agriculture[] TakeAgricultureInfoFromFile(String fName) throws IOException, ClassNotFoundException{

    FileInputStream fileInputStream = new FileInputStream(fName);
    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

    Agriculture[] agr = new  Agriculture[a];
    for (int i = 0; i < a; i++) {
    	 Agriculture  agr1 = ( Agriculture ) objectInputStream.readObject();
    	 agr[i] = agr1;
    }
    objectInputStream.close();
    fileInputStream.close();
    return agr;
}

public Construction[] TakeConstructionInfoFromFile(String fName) throws IOException, ClassNotFoundException{

 Construction[] con = new  Construction[c];
FileInputStream fileInputStream = new FileInputStream(fName);
ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
for (int i = 0; i < c; i++) {
	 Construction  con1 = ( Construction ) objectInputStream.readObject();
	 con[i] = con1;
}
objectInputStream.close();
fileInputStream.close();
return con;
}

public double priceOfAgricultureLandById(String fName,int id) throws ClassNotFoundException, IOException {
	double price=0;
	 Agriculture agr[]=TakeAgricultureInfoFromFile(fName);
	for(int i=0;i<a;i++) {
		if(agr[i].getIdOfLand()==id) {
			price=agr[i].priceOfLand();
			break;
		}
	}
	return price;
}
public double priceOfConstructionLandById(String fName,int id) throws ClassNotFoundException, IOException {
	double price=0;
	 Construction con[]=TakeConstructionInfoFromFile(fName);
	for(int i=0;i<c;i++) {
		if(con[i].getIdOfLand()==id) {
			price=con[i].priceOfLand();
			break;
		}
	}
	return price;
}

public double SecondMethodToFindPriceOfLandId(int id) {
int iD=searchLandById(id);
if(iD!=-1) 
return (L[iD].getArea()*L[iD].PriceOfOneMeter);

   return 0;
}































}
