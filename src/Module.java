
public class Module {
	protected static final int HPCHARLENGTH = 3;
	protected static final int UHEIGHT = 10;
	protected int HP;
	protected static final int U = 3;

	
	
	
	public Module(int HP) {

		
		this.HP = HP;
		
	}
	
	public String toString() {
		String pic = "";
		pic += "|";
		for (int h = 0; h < HP*HPCHARLENGTH; h++) {
			pic += "-";
		}
		for (int i = 0; i < U*UHEIGHT; i++) {
			pic += '|';
			for (int j = 0; j < HP*HPCHARLENGTH; j++) {
				pic += ' ';
			}
			pic += "|" + "\n";

		}
		pic += "|";
		for (int h = 0; h < HP*HPCHARLENGTH; h++) {
			pic += "-";
		}
		pic += "|";
		return pic;
	}
}
