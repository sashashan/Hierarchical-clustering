import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;


public class Hcluster {
	
	static int n;
	BufferedReader reader = null;
	LineNumberReader lnr;

	/*
	* You can change the number of final clusters for your data here:
	*/
	int k = 2;


	
	static Point [] data; // set of all data points
	int cluster_count;
	
	public Hcluster (String path) throws IOException
	{
		n = 0; // number of data points 
		
		
		// count the number of data points
		lnr = new LineNumberReader(new FileReader(new File(path)));
		lnr.skip(Long.MAX_VALUE);
		//System.out.println(lnr.getLineNumber() + 1); //Add 1 because line index starts at 0
		n = lnr.getLineNumber() + 1; // n is updated
		// Finally, the LineNumberReader object should be closed to prevent resource leak
		lnr.close();
		
		data = new Point [n];
		int i = 0;
		cluster_count = n;
		
		try {
		    File file = new File(path);
		    reader = new BufferedReader(new FileReader(file));

		    String line= reader.readLine();
		   
		    while (line != null) {

		    	String[] parts = line.split("\\s+"); // separating by space

		    	double x_val = Double.parseDouble(parts[0]); // x	    	
		    	double y_val = Double.parseDouble(parts[1]); // y

		    	data[i] = new Point(x_val, y_val, i, i);

		    	i++;
		    	line = reader.readLine();
		    }

		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        reader.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}

		
		while (cluster_count > k)
		{

			mergePoints ();
			
		}
		
		System.out.println("Compelted.");
		System.out.println("Cluster count - "+cluster_count);
		
		
		Frame draw = new Frame("The resulting clustered data.");
		
	}
	
	
	// Merging points and removing one cluster from the total cluster count
	public void mergePoints ()
	{
		double min_dist = Double.MAX_VALUE;
		Point min_c1 = new Point(), min_c2 = new Point();
		
		for (int i = 0; i < (n-1); i++)
		{
			for (int j = i+1; j < n; j++)
			if ((data[i].cluster != data[j].cluster) & distance(data[i], data[j]) < min_dist)
			{

				min_c1 = data[i];
				min_c2 = data[j];
				
				min_dist = distance(data[i], data[j]);

			}
			
		}

		double replaceFrom=min_c2.cluster;
		double replaceWith=min_c1.cluster;
		
		for(int i=0; i< data.length; i++)
		{
			if(data[i].cluster==replaceFrom)
			{
				data[i].cluster=replaceWith;
				
			}
		}
			
		cluster_count --;
	}
	
	public double distance (Point p1, Point p2)
	{
		double distance_val = Math.sqrt(Math.pow(p2.x-p1.x, 2) + Math.pow(p2.y-p1.y, 2));

		return distance_val;
	}
	
	public void printList() 		// expected runtime: O(N)
	{
		System.out.println("List: ");
		
		for (int m = 0; m < (n); m++)
		{
			System.out.println(data[m].x + "     " + data[m].y + "  " + data[m].cluster);
		}
		
	}

}
