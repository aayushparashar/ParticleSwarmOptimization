package com.pso;

import java.util.Arrays;


public class Particle {
	private double[] position;
	private double[] velocity;
	private double[] bestPosition;

	Particle(double[] pos, double[] velocity) {
		this.position = Arrays.copyOf(pos, pos.length);
		this.velocity = Arrays.copyOf(velocity, velocity.length);
		this.bestPosition = Arrays.copyOf(pos, pos.length);

	}

	public double[] getPosition() {
		return position;
	}

	public void setPosition(double[] position) {
		this.position = Arrays.copyOf(position, position.length);
	}

	public double[] getVelocity() {
		return velocity;
	}

	public void setVelocity(double[] velocity) {
		this.velocity = Arrays.copyOf(velocity, velocity.length);
	}

	public double[] getBestPosition() {
		return bestPosition;
	}

	public void setBestPosition(double[] bestPosition) {
		this.bestPosition = Arrays.copyOf(bestPosition, bestPosition.length);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Best Position is: (" + bestPosition[0] + "-" + bestPosition[1] + ")";
	}
	public void checkBestSolution(double[] globalBestSolution){
		if( Constants.f(this.bestPosition)  < Constants.f(globalBestSolution)){
			globalBestSolution = this.bestPosition;
		}
	}

}
