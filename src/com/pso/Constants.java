package com.pso;

public class Constants {
	private Constants() {
	}

	public static int maxIterations = 1000;
	public static int numDimensions = 2;
	public static int numParticles = 5;
	public static double min = -10;
	public static double max = 10;
	public static double w = 0.729;
	public static double c1 = 1.49445;
	public static double c2 = 1.49445;

	public static double f(double[] pos) {
		return Math.exp(-pos[0]*pos[0]-pos[1]*pos[1]) * Math.sin(pos[0]);
	}
}
