package ie.tcd.AESOP.test;

public class MathVector {
	double x, y, z;

	public MathVector(double i, double d, double j) {
		x = i;
		y = d;
		z = j;
	}

	public static double angleBetween(MathVector a, MathVector b) {
		double dp = dot_product(a, b, 3);
		int size = 3;
		double divisor = FallDetection.vectorMagnitude(a)
				* FallDetection.vectorMagnitude(b);
		double cos_inverse = dp / divisor;
		return Math.acos(cos_inverse);
	}

	static double dot_product(MathVector first, MathVector second, int size) {
		double[] a = new double[3];
		double[] b = new double[3];
		a[0] = first.x;
		a[1] = first.y;
		a[2] = first.z;
		b[0] = second.x;
		b[1] = second.y;
		b[2] = second.z;
		float dp = 0;
		int i = 0;
		for (i = 0; i < size; i++)
			dp += a[i] * b[i];
		return dp;
	}

}
