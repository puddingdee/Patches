
public class WEATHER_DRONES extends Module{
	private static final int HP = 24;

	protected Jack[] allJacks = new Jack[14];
	String name;
	
	public WEATHER_DRONES() {
		super(HP);
		
		this.name = "WEATHER_DRONES";
		
		
		
		Jack out = new Jack("out", 55, 26);
		Jack CVin = new Jack("cv_in", 4, 4);
		Jack FMin = new Jack("fm", 13, 5);
		Jack VCA = new Jack("vca", 25, 8);
		Jack altOut = new Jack("alt_out", 30, 8);
		Jack altIn = new Jack("alt_in", 23, 10);
		Jack noise = new Jack("noise", 4, 6);
		Jack slewOut = new Jack("slew_out", 11, 14);
		Jack squareOut = new Jack("square", 35, 4);
		Jack triOut = new Jack("triangle", 60, 7);
		Jack lfoMod = new Jack("lfo_mod", 40, 14);
		Jack filterMod = new Jack("filter_mod", 30, 20);
		Jack envTrig = new Jack("envelope_trig", 4, 25);
		Jack envOut = new Jack("envelope_out", 8, 27);
		
		
		allJacks[0] = out;
		allJacks[1] = CVin;
		allJacks[2] = FMin;
		allJacks[3] = VCA;
		allJacks[4] = altOut;
		allJacks[5] = altIn;
		allJacks[6] = noise;
		allJacks[7] = slewOut;
		allJacks[8] = squareOut;
		allJacks[9] = triOut;
		allJacks[10] = lfoMod;
		allJacks[11] = filterMod;
		allJacks[12] = envTrig;
		allJacks[13] = envOut;


		
	}
	
	public Jack[] getAllJacks() {
		return allJacks;
	}
	
	public String toString() {
		String pic = "";
		pic += name + "\n";
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
					if (j == allJacks[k].x-1 && i == allJacks[k].y-1) {
						pic += allJacks[k].getConnection() + "." + allJacks[k].name;
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
			pic += " |" + "\n";
			compensation = 1;
			jackCounter = 0;
			

		}
		
		pic += "|";
		for (int h = 0; h < HP*HPCHARLENGTH; h++) {
			pic += "-";
		}
		pic += "|" + "\n";
		
		
		return pic;
	}
}
