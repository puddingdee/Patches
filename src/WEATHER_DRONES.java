
public class WEATHER_DRONES extends Module{
	private static final int HP = 24;

	private Jack[] allJacks = new Jack[9];
	String name;
	
	public WEATHER_DRONES() {
		super(HP);
		
		this.name = "WEATHER_DRONES";
		
		
		
		Jack out = new Jack("out", 55, 25);
		Jack CVin = new Jack("cv in", 4, 4);
		Jack FMin = new Jack("fm in", 8, 6);
		Jack VCA = new Jack("vca", 8, 4);
		Jack altOut = new Jack("alt out", 12, 4);
		Jack altIn = new Jack("alt in", 10, 6);
		Jack noise = new Jack("noise", 4, 6);
		Jack slewOut = new Jack("slew", 11, 8);
		Jack squareOut = new Jack("square", 50, 4);
		
		
		allJacks[0] = out;
		allJacks[1] = CVin;
		allJacks[2] = FMin;
		allJacks[3] = VCA;
		allJacks[4] = altOut;
		allJacks[5] = altIn;
		allJacks[6] = noise;
		allJacks[7] = slewOut;
		allJacks[8] = squareOut;


		
	}
	
	public String toString() {
		String pic = "";
		String spaceComp = "";
		int compensation = 1;
		int jackCounter = 0;
		pic += "|";
		for (int h = 0; h < HP*HPCHARLENGTH; h++) {
			pic += "-";
		}
		pic += "|" + "\n";
		for (int i = 0; i < U*UHEIGHT; i++) {
			pic += '|';
			for (int j = 0; j < HP*HPCHARLENGTH; j++) {
				for (int k = 0; k < allJacks.length; k++) {
					if (j == allJacks[k].x-compensation && i == allJacks[k].y-1) {
						pic += Jack.JACKCHAR + "." + allJacks[k].name;
						compensation += allJacks[k].name.length()+1;
						jackCounter++;
						for (int l = 0; l < compensation; l++) {
							spaceComp += ' ';
							
						}
						
					}
					else {
						
					}

					
					
				}

				pic += " ";
				
				
			}
			pic = pic.substring(0, pic.length() - compensation - jackCounter);
			pic += "|" + "\n";
			compensation = 1;
			jackCounter = 0;
			

		}
		
		pic += "|";
		for (int h = 0; h < HP*HPCHARLENGTH; h++) {
			pic += "-";
		}
		pic += "|" + "\n";
		pic += name;
		
		return pic;
	}
}
