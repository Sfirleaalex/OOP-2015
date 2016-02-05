
public class CompleteLine extends RubikMoves {

	private boolean findCenter(String color,Cube cub){
		
		
		return false;
	}
	private boolean putCenter(Cube cub,int caz){
		
		return false;
	}
	
	public boolean searchLine(Cube cub){
		
		int ok =0;
		
		if(cub.left[0][1].equals(cub.front[1][1] )&& cub.up[1][0].equals(cub.right[1][1])){
			System.out.println("a intrat aici");
			dreaptaSus(cub);
			susDreapta(cub);
			dreaptaJos(cub);
			susDreapta(cub);
			fataSus(cub);
			susStanga(cub);
			fataJos(cub);
			return true;
		}
		
		
		if(!cub.up[2][1].equals(cub.up[1][1]) && !cub.front[0][1].equals(cub.up[1][1])){
			System.out.println("centru de culorile "+ cub.front[0][1] +" "+cub.up[2][1] );
			putCenter(cub,0);
			return true;
		}
		
		while( (cub.up[2][1].equals(cub.up[1][1]) || cub.front[0][1].equals(cub.up[1][1]))&& ok<4){
			System.out.println("a intrat in for");
			cubStanga(cub);
			if(!cub.up[2][1].equals(cub.up[1][1]) && !cub.front[0][1].equals(cub.up[1][1])){
				putCenter(cub,0);
				return true;
			}
		}
		System.out.println("nici un centru bun");
		
		
		
		return false;
	}
}
