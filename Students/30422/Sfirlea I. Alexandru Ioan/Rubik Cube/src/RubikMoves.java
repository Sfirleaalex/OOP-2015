
public class RubikMoves {

	public void generateRandomCube(Cube cube) {

		cube.up = Constants.up;
		cube.down = Constants.down;
		cube.right = Constants.right;
		cube.left = Constants.left;
		cube.front = Constants.face;
		cube.back = Constants.back;
		shuffle(cube);

	}

	String[][] faceToRight(String[][] face) {
		String[][] aux = new String[3][3];

		aux[0][0] = face[2][0];
		aux[0][1] = face[1][0];
		aux[0][2] = face[0][0];
		aux[1][0] = face[2][1];
		aux[1][1] = face[1][1];
		aux[1][2] = face[0][1];
		aux[2][0] = face[2][2];
		aux[2][1] = face[1][2];
		aux[2][2] = face[0][2];

		return aux;
	}

	String[][] faceToLeft(String[][] face) {
		String[][] aux = new String[3][3];

		aux[0][0] = face[0][2];
		aux[0][1] = face[1][2];
		aux[0][2] = face[2][2];
		aux[1][0] = face[0][1];
		aux[1][1] = face[1][1];
		aux[1][2] = face[2][1];
		aux[2][0] = face[0][0];
		aux[2][1] = face[1][0];
		aux[2][2] = face[2][0];
		return aux;
	}

	String[] getColumn(String[][] face, int index) {
		String[] column = new String[3];
		for (int i = 0; i < 3; i++) {
			column[i] = face[i][index];

		}

		return column;
	}

	String[] getColumnForBack(String[][] face, int index) {
		String[] column = new String[3];
		int k = 0;
		for (int i = 2; i >= 0; i--) {
			column[k++] = face[i][index];

		}
		k--;
		return column;
	}

	String[][] replaceColumnForBack(String[][] face, String[] coloana, int index) {
		for (int i = 2; i >= 0; i--) {
			face[i][index] = coloana[i];
		}
		return face;
	}

	String[][] replaceColumn(String[][] face, String[] coloana, int index) {

		for (int i = 0; i < 3; i++) {
			face[i][index] = coloana[i];
		}
		return face;
	}

	
	public void susStanga(Cube cub) {
		String[][] aux1 = cub.down;
		cub.up = faceToRight(cub.up);
		String[] aux = new String[] { "0", "0", "0" };
		aux = cub.front[0];
		cub.front[0] = cub.right[0];
		cub.right[0] = cub.back[0];
		cub.back[0] = cub.left[0];
		cub.left[0] = aux;
		
	}

	public void susDreapta(Cube cub) {
		String[][]aux1 = cub.down;
		cub.up = faceToLeft(cub.up);

		String[] aux = new String[] { "0", "0", "0" };
		aux = cub.front[0];
		cub.front[0] = cub.left[0];
		cub.left[0] = cub.back[0];
		cub.back[0] = cub.right[0];
		cub.right[0] = aux;
		
	
	}

	public void dreaptaSus(Cube cub) {

		String[][] aux2 = cub.left;
		cub.right = faceToRight(cub.right);
		String[] aux = new String[] { "0", "0", "0" };
		String[] aux1 = new String[3];

		aux = getColumn(cub.front, 2);
		aux1 = getColumn(cub.down, 2);
		cub.front = replaceColumn(cub.front, aux1, 2);

		aux1 = getColumnForBack(cub.back, 0);
		cub.down = replaceColumn(cub.down, aux1, 2);

		aux1 = getColumnForBack(cub.up, 2);
		cub.back = replaceColumnForBack(cub.back, aux1, 0);

		cub.up = replaceColumn(cub.up, aux, 2);

		
	}

	public void dreaptaJos(Cube cub) {
		cub.right = faceToLeft(cub.right);
		String[] aux = new String[] { "0", "0", "0" };
		String[] aux1 = new String[3];

		aux = getColumn(cub.front, 2);

		aux1 = getColumn(cub.up, 2);
		cub.front = replaceColumn(cub.front, aux1, 2);

		aux1 = getColumnForBack(cub.back, 0);
		cub.up = replaceColumn(cub.up, aux1, 2);

		aux1 = getColumnForBack(cub.down, 2);
		cub.back = replaceColumnForBack(cub.back, aux1, 0);

		cub.down = replaceColumn(cub.down, aux, 2);

	}

	public void stangaJos(Cube cub) {
		cub.left = faceToRight(cub.left);
		String[] aux = new String[] { "0", "0", "0" };
		String[] aux1 = new String[3];

		aux = getColumn(cub.front, 0);
	
		aux1 = getColumn(cub.up, 0);
		cub.front = replaceColumn(cub.front, aux1, 0);

		aux1 = getColumnForBack(cub.back, 2);
		cub.up = replaceColumn(cub.up, aux1, 0);

		aux1 = getColumnForBack(cub.down, 0);
		cub.back = replaceColumnForBack(cub.back, aux1, 2);

		cub.down = replaceColumn(cub.down, aux, 0);

	}

	public void stangaSus(Cube cub) {
		cub.left = faceToLeft(cub.left);
		String[] aux = new String[] { "0", "0", "0" };
		String[] aux1 = new String[3];

		aux = getColumn(cub.up, 0);

		aux1 = getColumn(cub.front, 0);
		cub.up = replaceColumn(cub.up, aux1, 0);

		aux1 = getColumn(cub.down, 0);
		cub.front = replaceColumn(cub.front, aux1, 0);

		aux1 = getColumnForBack(cub.back, 2);
		cub.down = replaceColumn(cub.down, aux1, 0);

		int k=0;
		for(int i=2;i>=0;i--){
			aux1[k++] = aux[i];
		}
		k--;
		cub.back = replaceColumnForBack(cub.back, aux1, 2);

	}

	public void josStanga(Cube cub) {
		cub.down = faceToLeft(cub.down);

		String[] aux = new String[] { "0", "0", "0" };
		aux = cub.front[2];
		cub.front[2] = cub.right[2];
		cub.right[2] = cub.back[2];
		cub.back[2] = cub.left[2];
		cub.left[2] = aux;
	}

	public void josDreapta(Cube cub) {
		cub.down = faceToRight(cub.down);

		String[] aux = new String[] { "0", "0", "0" };
		aux = cub.front[2];
		cub.front[2] = cub.left[2];
		cub.left[2] = cub.back[2];
		cub.back[2] = cub.right[2];
		cub.right[2] = aux;
	}

	public void fataSus(Cube cub) {
		cub.front = faceToLeft(cub.front);
		String[] aux = new String[] { "0", "0", "0" };
		String[] aux1;

		aux = cub.up[2];

		aux1 = getColumn(cub.right, 0);
		cub.up[2] = aux1;

		aux1 = cub.down[0];
		String[] aux2 = new String[3];
		int i, k = 0;
		for (i = 2; i >= 0; i--) {
			aux2[k++] = aux1[i];
		}
		k--;
		cub.right = replaceColumn(cub.right, aux2, 0);

		aux1 = getColumn(cub.left, 2);
		cub.down[0] = aux1;
		k = 0;
		String[] aux3 = new String[3];
		for (i = 2; i >= 0; i--) {
			aux3[k++] = aux[i];
		}
		k--;
		cub.left = replaceColumn(cub.left, aux3, 2);

	}

	public void fataJos(Cube cub) {
		cub.front = faceToRight(cub.front);
		String[] aux = new String[] { "0", "0", "0" };
		String[] aux1;

		aux = cub.up[2];

		aux1 = getColumnForBack(cub.left, 2);
		cub.up[2] = aux1;

		aux1 = cub.down[0];
		cub.left = replaceColumn(cub.left, aux1, 2);

		aux1 = getColumnForBack(cub.right, 0);
		cub.down[0] = aux1;

		cub.right = replaceColumn(cub.right, aux, 0);
	}

	public void cubInJos(Cube cub) {
		String[][] aux = new String[3][3];

		aux = cub.front;
		cub.front = cub.up;
		cub.up = cub.back;
		cub.back = cub.down;
		cub.down = aux;
		cub.left = faceToRight(cub.left);
		cub.right = faceToLeft(cub.right);

		cub.up = faceToLeft(cub.up);
		cub.up = faceToLeft(cub.up);
		cub.back = faceToRight(cub.back);
		cub.back = faceToRight(cub.back);
	}

	public void cubInSus(Cube cub) {
		String[][] aux = new String[3][3];

		aux = cub.up;
		cub.up = cub.front;
		cub.front = cub.down;
		cub.down = cub.back;
		cub.back = aux;
		cub.left = faceToLeft(cub.left);
		cub.right = faceToRight(cub.right);

		cub.down = faceToLeft(cub.down);
		cub.down = faceToLeft(cub.down);
		cub.back = faceToRight(cub.back);
		cub.back = faceToRight(cub.back);
	}

	public void cubDreapta(Cube cub) {
		String[][] aux = new String[3][3];

		aux = cub.front;
		cub.front = cub.left;
		cub.left = cub.back;
		cub.back = cub.right;
		cub.right = aux;
		cub.up = faceToLeft(cub.up);
		cub.down = faceToRight(cub.down);

	}

	public void cubStanga(Cube cub) {
		String[][] aux = new String[3][3];

		aux = cub.front;
		cub.front = cub.right;
		cub.right = cub.back;
		cub.back = cub.left;
		cub.left = aux;
		cub.up = faceToRight(cub.up);
		cub.down = faceToLeft(cub.down);

	}

	public void shuffle(Cube cub){
		//LJ-RJ-SS-JD-LJ-FJ-RS-SD-LJ-FS-LS
		
//		stangaJos(cub);
//		dreaptaJos(cub);
//		susStanga(cub);
//		josDreapta(cub);
//		stangaJos(cub);
//		fataJos(cub);
//		dreaptaSus(cub);
//		susDreapta(cub);
//		stangaJos(cub);
//		fataSus(cub);
//		stangaSus(cub);
		
		
		//LS-RJ-SS-JS-RS-LJ-SS-SS-RS
		stangaSus(cub);
		dreaptaJos(cub);
		susStanga(cub);
		josStanga(cub);
		dreaptaSus(cub);
		stangaJos(cub);
		susStanga(cub);
		susStanga(cub);
		dreaptaSus(cub);
	

	}
	
	public void print(String[][] face) {
		int i, j;

		for (i = 0; i < 3; i++) {
			for (j = 0; j < 3; j++) {
				System.out.print(face[i][j] + " ");
			}
			System.out.println();
		}
	}



}
