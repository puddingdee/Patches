
public class Jack {
	boolean connected = false;
	int x;
	int y;
	String name;	
	static final char JACKCHAR = 'O';
	
	public Jack(String name, int x, int y) {
		this.x = x;
		this.y = y;
		this.name = name;
	}
	
	public void makeConnection(){
		connected = true;
	}
}
