package gui;

public class Comp_SharedData {

	private static Comp_SharedData instance = null;
	private int[] Nvalue = new int[5]; // private constructor to enforce singleton pattern
	private int Kvalue;
	private boolean algorithm; // if = true; K-state algorithm
								// if = false; Three-state algorithm
	private int NumofRuns;
	private Comp_SharedData() {

	}

	public static Comp_SharedData getInstance() {
		if (instance == null) {
			instance = new Comp_SharedData();
		}
		return instance;
	}

	public int[] getNValue() {
		return Nvalue;
	}

	public void setNValue(int[] Nvalue) {
		this.Nvalue = Nvalue;
	}

	public int getKValue() {
		return Kvalue;
	}

	public void setKValue(int Kvalue) {
		this.Kvalue = Kvalue;
	}

	public boolean isAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(boolean algorithm) {
		this.algorithm = algorithm;
	}

	public int getNumofRuns() {
		return NumofRuns;
	}

	public void setNumofRuns(int numofRuns) {
		NumofRuns = numofRuns;
	}
}
