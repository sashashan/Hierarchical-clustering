
public class Point {
	double x, y, cluster, id;
	
	public Point()
	{
		x=0;
		y=0;
		id=0;
		cluster=-1;
	}
	public Point (double x, double y, int cluster, int id)
	{
		this.x=x;
		this.y=y;
		this.cluster = cluster;
		this.id = id;
	}
	public void addPoint(Point p2)
	{
		x+=p2.x;
		y+=p2.y;
	}
	public void divide(int num)
	{
		x = x/num;
		y = y/num;
	}
	public String toString()
	{
		return "x-coord: " + x + ", y-coord: "+ y + ", cluster number - "+ cluster + ", id - "+ id;
	}
}
