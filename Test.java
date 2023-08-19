import java.io.*;

public class Test {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
	      Province province = new Province(10, "Sample Province");

	        // Create an instance of Agriculture
	        Agriculture agriculture1 = new Agriculture(1, "John Doe", 1, 100.5, 10.5, "Wheat");
	        Agriculture agriculture2 = new Agriculture(1, "Jane Smith", 2, 200.8, 8.7, "Corn");
System.out.println(agriculture1.priceOfLand());
	        // Create an instance of Construction
	        Construction construction1 = new Construction(1, "Mike Johnson", 3, 300.2, 15.2, 5, "Clay");
	        Construction construction2 = new Construction(2, "Emily Brown", 4, 400.6, 12.8, 8, "Sand");

	        // Add lands to the province
	        province.AddAnestheticLand(agriculture1);
	        province.AddAnestheticLand(agriculture2);
	        province.AddAnestheticLand(construction1);
	        province.AddAnestheticLand(construction2);

	        // Display all lands in the province
	        province.displayAllLandds();

	        // Find the number of agriculture lands in the province
	        int numOfAgricultureLands = province.FindNumberOfAgricultureLands();
	        System.out.println("Number of agriculture lands: " + numOfAgricultureLands);

	        // Find the number of construction lands in the province
	        int numOfConstructionLands = province.FindNumberOfConstructionLands();
	        System.out.println("Number of construction lands: " + numOfConstructionLands);

	        // Update land information
	        boolean isLandUpdated = province.UpdateLandInformation(2);
	        System.out.println("Land information updated: " + isLandUpdated);

	        // Merge two lands
	        boolean isLandsMerged = province.MergeTwoLands(3, 4);
	        System.out.println("Lands merged: " + isLandsMerged);

	        // Split a land
	        boolean isLandSplit = province.SplitLand(1, 5, 50);
	        System.out.println("Land split: " + isLandSplit);
	        Province p1 = new Province(10, "Example Province");

	        // Add some AnestheticLands to the province
	    //     p1.AddAnestheticLand(new Agriculture());
	    //     p1.AddAnestheticLand(new Construction());
        //     p1.storeData("agriculture.txt", "construction.dat");
        //    System.out.println( p1.TakeAgricultureInfoFromFile("agriculture.txt"));
        //     System.out.println(p1.priceOfAgricultureLandById("agriculture.txt", 1));

	    

	    


	}

}
