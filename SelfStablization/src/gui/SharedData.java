package gui;

public class SharedData {
	
    private static SharedData instance = null;
    private String Nvalue;
    private String Kvalue;
    private int[] N_vals_array = new int[20];
    private boolean stabilityflag = true;
    private boolean TSM_string = false;
    private boolean TSM_ring = true;
    private SharedData() {
        // private constructor to enforce singleton pattern
    }

    public static SharedData getInstance() {
        if (instance == null) {
            instance = new SharedData();
        }
        return instance;
    }

    public String getNValue() {
        return Nvalue;
    }

    public void setNValue(String Nvalue) {
        this.Nvalue = Nvalue;
    }

    public String getKValue() {
        return Kvalue;
    }

    public void setKValue(String Kvalue) {
        this.Kvalue = Kvalue;
    }

	public int[] getN_vals_array() {
		return N_vals_array;
	}

	public void setN_vals_array(int[] n_vals_array) {
		N_vals_array = n_vals_array;
	}

	public boolean isStabilityflag() {
		return stabilityflag;
	}

	public void setStabilityflag(boolean stabilityflag) {
		this.stabilityflag = stabilityflag;
	}

	public boolean isTSM_string() {
		return TSM_string;
	}

	public void setTSM_string(boolean tSM_string) {
		TSM_string = tSM_string;
	}

	public boolean isTSM_ring() {
		return TSM_ring;
	}

	public void setTSM_ring(boolean tSM_ring) {
		TSM_ring = tSM_ring;
	}
}
