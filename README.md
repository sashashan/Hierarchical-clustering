# Hierarchical-clustering
Written in Java. (2015)


 By Aleksandra Shanina

 ******** Hierarchical clustering

The idea is to build a binary tree of the data that successively merges similar groups of points (e.g. based on distance, color, or some other quality). 


* Implementation of the hierarchical clustering algorithm. *
	The number of clusters was chosen as 2. The input
	data is a set of 2-D points found in “B.txt”. The reasonable clustering result is that the points in the center is a group while the points surrounding them is the other group. 

	The results will be displayed in a new window once the program is run.

	Running instructions:
	cd to the source foulder
	javac Test.java
	java Test


Algorithm:
1) Assign each point into its own cluster. 
2) Iteratively merge the closest two groups.
3) Repeat step two until a base condition is met - in this example until the number of clusters is 2.
