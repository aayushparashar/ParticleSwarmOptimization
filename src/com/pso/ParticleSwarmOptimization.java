package com.pso;

public class ParticleSwarmOptimization {
	private double[] globalBestSolution;
	private Particle[] particleSwarm;
	private int epochs;

	public ParticleSwarmOptimization() {
		// TODO Auto-generated constructor stub
		this.globalBestSolution = new double[Constants.numDimensions];
		this.particleSwarm = new Particle[Constants.numParticles];
		initializeGlobalBest();
	}

	private void initializeGlobalBest() {
		for (int i = 0; i < globalBestSolution.length; i++) {
			this.globalBestSolution[i] = random(Constants.min, Constants.max);
//			System.out.println(globalBestSolution[i]);
		}

	}

	public void showSolution() {
		System.out.println("Best solution is : "+Constants.f(this.globalBestSolution));
		System.out.println("Best solution is: x=" + this.globalBestSolution[0] + " y=" + this.globalBestSolution[1]);
	}

	private void initializeParticles() {
		for (int i = 0; i < particleSwarm.length; i++) {
			particleSwarm[i] = new Particle(initializePosition(), intializeVelocity());
			particleSwarm[i].checkBestSolution(globalBestSolution);
		}
	}

	private double[] intializeVelocity() {
		double[] newVelocity = new double[Constants.numDimensions];
		for (int i = 0; i < newVelocity.length; i++)
			newVelocity[i] = random(-(Constants.max - Constants.min), Constants.max - Constants.min);
		return newVelocity;
	}

	private double[] initializePosition() {
		double[] newPosition = new double[Constants.numDimensions];
		for (int i = 0; i < newPosition.length; i++)
			newPosition[i] = random(Constants.min, Constants.max);
		return newPosition;
	}

	private double random(double min, double max) {
		return min + Math.random() * (max - min);
	}

	public void solve() {

		initializeParticles();
		while (epochs < Constants.maxIterations) {
			for (Particle pp : particleSwarm) {
				for (int i = 0; i < pp.getVelocity().length; i++) {
					double rp = Math.random();
					double rg = Math.random();
					pp.getVelocity()[i] = pp.getVelocity()[i] * Constants.w
							+ rp * Constants.c1 * (pp.getBestPosition()[i] - pp.getPosition()[i])
							+ rg * Constants.c2 * (globalBestSolution[i] - pp.getPosition()[i]);
				}
				for (int i = 0; i < pp.getPosition().length; i++) {
					pp.getPosition()[i] = Math.max(Constants.min,
							Math.min(Constants.max, pp.getPosition()[i] + pp.getVelocity()[i]));
				}
				if (Constants.f(pp.getPosition()) < Constants.f(pp.getBestPosition()))
					pp.setBestPosition(pp.getPosition());
				if (Constants.f(pp.getBestPosition()) < Constants.f(this.globalBestSolution))
					this.globalBestSolution = pp.getBestPosition();
			}
			epochs++;
		}
	}

}
