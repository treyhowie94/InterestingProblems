
public class CalculateSqrtWithoutUsingMathSqrtFunction {

	/**
	 * Write a function that finds the square root of a given number without using Math.sqrt
	 */
	
	public static void main(String[] args) {
		System.out.println(sqrt(3));
		System.out.println(sqrt(81, 1E-25));
	}
	
	// return the square root of c, computed using Newton's method
    private static double sqrt(double c) {
       // check to see if invalid (negative) number is passed
    	if (c < 0) {
        	return Double.NaN;
        }
        
    	double EPSILON = 1E-15; // margin of error
        double t = c;
        while (Math.abs(t - c/t) > EPSILON*t) {
            t = (c/t + t) / 2.0;
        }
        
        return t;
    }

    // overloaded version in which user specifies the error tolerance EPSILON
    private static double sqrt(double c, double EPSILON) {
        if (c < 0) return Double.NaN;
        double t = c;
        while (Math.abs(t - c/t) > EPSILON * t)
            t = (c/t + t) / 2.0;
        return t;
    }
}
