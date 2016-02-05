
public class FirstFace extends RubikMoves {
	
	private boolean checkLine(String[] face, String color) {
		for (int i = 0; i < 3; i++) {
			if (!face[i].equals(color))
				return false;
		}
		return true;
	}

	private boolean fixLeftCorner(Cube cub) {
		// colt stanga jos(adica pe linia de jos)

		int ok = 1;
		int sum = 0;
		if (cub.left[2][2].equals(cub.left[1][1]) && cub.down[0][0].equals(cub.front[1][1])) {
			System.out.println("colt jos stanga culoarea:" + cub.left[2][2] + "si " + cub.down[0][0]);

			josDreapta(cub);
			stangaJos(cub);
			josStanga(cub);
			stangaSus(cub);
			return true;
		}
		while (ok == 1 && sum < 4) {

			System.out.println(cub.left[2][2] + " " + cub.front[1][1]);
			sum++;
			josDreapta(cub);
			cubStanga(cub);
			if (cub.left[2][2].equals(cub.left[1][1]) && cub.down[0][0].equals(cub.front[1][1])) {
				ok = 0;
				System.out.println("colt jos stanga culoarea:" + cub.left[2][2] + "si " + cub.down[0][0]);

				josDreapta(cub);
				stangaJos(cub);
				josStanga(cub);
				stangaSus(cub);
				return true;
			}
		}

		return false;
	}

	private boolean fixRightCorner(Cube cub) {
		// colt dreapta jos(adica pe linia de jos)
		int ok = 1;
		int sum = 0;
		if (cub.right[2][0].equals(cub.right[1][1]) && cub.down[0][2].equals(cub.front[1][1])) {
			System.out.println("colt jos dreapta culoarea: " + cub.right[2][0] + "si " + cub.down[0][2]);

			josStanga(cub);
			dreaptaJos(cub);
			josDreapta(cub);
			dreaptaSus(cub);

			return true;
		}
		while (ok == 1 && sum < 4) {

			System.out.println(cub.right[2][0] + " " + cub.front[1][1]);
			sum++;
			josDreapta(cub);
			cubStanga(cub);
			if (cub.right[2][0].equals(cub.right[1][1]) && cub.down[0][2].equals(cub.front[1][1])) {

				System.out.println("colt jos dreapta culoarea: " + cub.right[2][0] + "si " + cub.down[0][2]);

				josStanga(cub);
				dreaptaJos(cub);
				josDreapta(cub);
				dreaptaSus(cub);
				return true;
			}
		}

		return false;
	}

	private boolean fixDownCorner(Cube cub) {
		int ok = 0;
		if (cub.front[2][2].equals(cub.right[1][1]) && cub.right[2][0].equals(cub.front[1][1])) {
			dreaptaJos(cub);
			josDreapta(cub);
			dreaptaSus(cub);
			fataJos(cub);
			josStanga(cub);
			josStanga(cub);
			fataSus(cub);

			return true;
		}
		while (ok < 4) {
			cubStanga(cub);
			josDreapta(cub);
			if (cub.front[2][2].equals(cub.right[1][1]) && cub.right[2][0].equals(cub.front[1][1])) {
				dreaptaJos(cub);
				josDreapta(cub);
				dreaptaSus(cub);
				fataJos(cub);
				josStanga(cub);
				josStanga(cub);
				fataSus(cub);

				return true;
			}
			ok++;
		}

		return false;
	}

	private boolean fix(Cube cub) {
		if (cub.front[0][2].equals(cub.front[1][1]) && cub.right[0][0].equals(cub.right[1][1])) {
			System.out.println("e deja in pozitie");
			return false;
		} else {
			System.out.println("coltul a fost la loc");
			dreaptaJos(cub);
			josStanga(cub);
			dreaptaSus(cub);
			josDreapta(cub);
			fixRightCorner(cub);
			return true;

		}
	}

	/*
	 * Metodele pentru cautat colturile
	 * */
	
	public boolean upFinished(Cube cub) {

		for (int i = 0; i < 3; i++) {
			if (!checkLine(cub.up[i], cub.up[1][1]))
				return false;
		}

		if (!checkLine(cub.front[0], cub.front[1][1]))
			return false;
		if (!checkLine(cub.left[0], cub.left[1][1]))
			return false;
		if (!checkLine(cub.right[0], cub.right[1][1]))
			return false;
		if (!checkLine(cub.back[0], cub.back[1][1]))
			return false;
		System.out.println("e gata sus");
		return true;

	}

	// cauta colturile pe fata de sus
	public boolean searchUpCorners(Cube cub) {

		if (cub.up[2][2].equals(cub.up[1][1])) {
			return fix(cub);

		}
		if (cub.up[2][0].equals(cub.up[1][1])) {
			cubDreapta(cub);
			return fix(cub);

		}
		if (cub.up[0][0].equals(cub.up[1][1])) {
			cubStanga(cub);
			cubStanga(cub);
			return fix(cub);

		}
		if (cub.up[0][2].equals(cub.up[1][1])) {
			cubStanga(cub);
			return fix(cub);
		}
		System.out.println("nici un colt albastru pe fata de sus");
		return false;
	}

	// cauta colturile pe liniile de sus
	public boolean searchTopCorners(Cube cub) {

		int ok = 0;
		if (cub.front[0][2].equals(cub.up[1][1])) {

			System.out.println("colt sus dreapta");
			dreaptaJos(cub);
			josDreapta(cub);
			dreaptaSus(cub);
			fixRightCorner(cub);
			return true;
		}
		if (cub.front[0][0].equals(cub.up[1][1])) {
			System.out.println("colt sus stanga");
			stangaJos(cub);
//			moves.josDreapta(cub);
//			moves.stangaSus(cub);
//			fixDownCorner(cub);
			josStanga(cub);
			stangaSus(cub);
			fixLeftCorner(cub);
			return true;
		}

		while (ok < 4) {
			cubStanga(cub);
			if (cub.front[0][2].equals(cub.up[1][1])) {

				System.out.println("colt sus dreapta");
				dreaptaJos(cub);
				josDreapta(cub);
				dreaptaSus(cub);
				fixRightCorner(cub);
				return true;
			}
			if (cub.front[0][0].equals(cub.up[1][1])) {
				System.out.println("colt sus stanga");
				stangaJos(cub);
//				moves.josDreapta(cub);
//				moves.stangaSus(cub);
//				fixDownCorner(cub);
				josStanga(cub);
				stangaSus(cub);
				fixLeftCorner(cub);
				return true;
			}
			ok++;
		}

		System.out.println("nu sunt colturi sus");
		return false;

	}

	// cauta colturile pe fata de jos
	public boolean searchCornerDownFace(Cube cub) {
		int ok = 0;
		if (cub.down[0][2].equals(cub.up[1][1])) {
			System.out.println("este colt jos pozitia 0-2");
			fixDownCorner(cub);
			return true;
		}

		if (cub.down[0][0].equals(cub.up[1][1])) {
			System.out.println("este colt jos pozitia 0-0");
			cubDreapta(cub);
			fixDownCorner(cub);
			return true;
		}
		if (cub.down[2][0].equals(cub.up[1][1])) {
			System.out.println("este colt jos pozitia 2-0");
			cubDreapta(cub);
			cubDreapta(cub);
			fixDownCorner(cub);
			return true;
		}
		if (cub.down[2][2].equals(cub.up[1][1])) {
			System.out.println("este colt jos pozitia 2-2");
			cubStanga(cub);
			fixDownCorner(cub);
			return true;
		}
		System.out.println("nu este jos");
		return false;

	}

	// cauta colturile pe liniile de jos
	public boolean searchCornerDownLine(Cube cub) {
		int ok = 0;
		if (cub.front[2][0].equals(cub.up[1][1])) {
			fixLeftCorner(cub);
			return true;
		}
		if (cub.front[2][2].equals(cub.up[1][1])) {
			fixRightCorner(cub);
			return true;
		}
		while (ok < 4) {
			cubStanga(cub);
			ok++;
			if (cub.front[2][0].equals(cub.up[1][1])) {
				fixLeftCorner(cub);
				return true;
			}
			if (cub.front[2][2].equals(cub.up[1][1])) {
				fixRightCorner(cub);
				return true;
			}

		}
		if (ok >= 4) {
			System.out.println("nu este colt stanga sau dreapta pe muchia de jos");
		}

		return false;
	}

}
