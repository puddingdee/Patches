
public class Jack {
	boolean connected = false;
	int x;
	int y;
	String name;	
	int connectedTo;
	
	public Jack(String name, int x, int y) {
		this.x = x;
		this.y = y;
		this.name = name;
		this.connectedTo = 0;
	}
	
	public void setConnection(int count){
		connected = true;
		connectedTo = count;
	}
	
	public int getConnection() {
		return connectedTo;
	}
}
