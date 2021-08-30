import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        //need to count how many points exist in an object shape called s
        // use the shape object to get the list/array of points
        // declare a variable int set to 0
        //iterate over the number of points in a shape updating the variable each point
        // return the int
        int counter = 0;
        
        for (Point currPt: s.getPoints()) {
            counter = counter + 1;
        }
        return counter;
    }

    public double getAverageLength(Shape s) {
        double perimeter = getPerimeter(s);
        double totalPoints = getNumPoints(s);
        double averageLen = perimeter / totalPoints;
        
        return averageLen;
    }

    public double getLargestSide(Shape s) {
        Point prevPt = s.getLastPoint();
        double largestSide = 0.0;
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            
            if (currDist > largestSide){
                largestSide = currDist;
            }
        }
        
        return largestSide;
    }

    public double getLargestX(Shape s) {
        
        int largestX = s.getLastPoint().getX();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            int currentX = currPt.getX();
            
            if(currentX > largestX){
            // Update totalPerim by currDist
            largestX = currentX;
        }
    }
     return largestX;
        }
       
    

    public double getLargestPerimeterMultipleFiles() {
        
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0.0;
        FileResource largestFile = null;
        for (File f : dr.selectedFiles()) {
            FileResource file = new FileResource(f);
            Shape s = new Shape(file);
            double currentPeri = getPerimeter(s);
            if (currentPeri > largestPerimeter){
            largestPerimeter = currentPeri;
            }
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
               DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0.0;
        File largestFile = null;

        for(File f : dr.selectedFiles()){
            FileResource file = new FileResource(f);
            Shape shape = new Shape(file);
            double perim = getPerimeter(shape);
            if(perim > largestPerim) {
                largestPerim = perim;
                largestFile = f;
            }
        }

        return largestFile.getName();

    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numpoints = getNumPoints(s);
        double avgLength = getAverageLength(s);
        double getLargestSide = getLargestSide(s);
        double largestX = getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("number of points = " + numpoints);
        System.out.println("avg length = " + avgLength);
        System.out.println("largestSide = " + getLargestSide);
        System.out.println("largestX = " + largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        double largestPeri = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter is: " +  largestPeri);
    }

    public void testFileWithLargestPerimeter() {
        String largestFile = getFileWithLargestPerimeter();
        System.out.println("Largest perimeter file is: " + largestFile);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
