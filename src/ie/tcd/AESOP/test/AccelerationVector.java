package ie.tcd.AESOP.test;

import android.text.TextUtils;

public class AccelerationVector {
	double x, y, z;

	public AccelerationVector(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public MathVector toMathVector() {
		return new MathVector(x, y, z);
	}

	@Override
	public String toString() {

		return x + "|" + y + "|" + z;
	}

	public AccelerationVector(String string) {

		TextUtils.StringSplitter splitter = new TextUtils.SimpleStringSplitter(
				'|');

		splitter.setString(string);
		int count = 0;
		double x = 0;
		double y = 0;
		double z = 0;
		for (String s : splitter) {
			if (count == 0) {
				x = Double.parseDouble(s);
			}
			if (count == 1) {
				y = Double.parseDouble(s);
			}
			if (count == 2) {
				z = Double.parseDouble(s);
			}
			if (count > 2) {
				System.exit(-1);
			}
			count++;
		}
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public void fromString(String string) {
		TextUtils.StringSplitter splitter = new TextUtils.SimpleStringSplitter(
				'|');

		splitter.setString(string);
		int count = 0;
		double x = 0;
		double y = 0;
		double z = 0;
		for (String s : splitter) {
			if (count == 0) {
				x = Double.parseDouble(s);
			}
			if (count == 1) {
				y = Double.parseDouble(s);
			}
			if (count == 2) {
				z = Double.parseDouble(s);
			}
			if (count > 2) {
				System.exit(-1);
			}
			count++;
		}
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
