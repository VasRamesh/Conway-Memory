package conway;

public class JavaCodeUtils {
	public static String toJavaCode(Conway conway) {
		String coder = "conway.clear(); \n"; 
		
		for(int i = 0; i < conway.getRows(); i++) {
			for(int j = 0; j < conway.getColumns(); j++) {
				if (conway.isAlive(i, j) == true) {
					coder = coder + "conway.setAlive(true, " + i + ", "+ j + "); \n";
				}
			}
		}
		return coder; 
		
		
		
		
	}
	
}
