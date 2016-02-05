import javax.swing.plaf.synth.SynthScrollBarUI;

public class CrossProccess {
	RubikMoves moves = new RubikMoves();

	// CALCUL PENTRU FACUT CRUCEA

	public boolean isCross(Cube cub) {

		String aux = cub.up[1][1];
		if (cub.up[0][1].compareTo(aux) == 0 && cub.up[1][0].compareTo(aux) == 0 && cub.up[1][2].compareTo(aux) == 0
				&& cub.up[2][1].compareTo(aux) == 0) {
			if (cub.left[0][1].compareTo(cub.left[1][1]) == 0 && cub.right[0][1].compareTo(cub.right[1][1]) == 0
					&& cub.front[0][1].compareTo(cub.front[1][1]) == 0
					&& cub.back[0][1].compareTo(cub.back[1][1]) == 0) {
				System.out.println("este cruce");
				return true;
			}

		}
		return false;
	}

	void moveUpFromDown(String culoare, Cube cub) {
		/*
		 * invartim partea de jos si cubul spre stanga pana cand ajunge piesa
		 * din pozitia 2 1 de pe cub.front sa fie egala cu piesa de pe
		 * cub.front[1][1] adica aducem piesa la centru
		 */
		int ok = 1;
		int sum = 0;
		if (cub.front[1][1].equals(culoare) && cub.down[0][1].equals(cub.up[1][1])) {
			ok = 0;
		}
		while (ok == 1 && sum < 4) {

			System.out.println(culoare + " " + cub.front[1][1]);
			sum++;
			moves.josDreapta(cub);
			moves.cubStanga(cub);
			if (cub.front[1][1].equals(culoare) && cub.down[0][1].equals(cub.up[1][1])) {
				ok = 0;
			}
		}
		if (cub.front[1][1].equals(culoare) && cub.down[0][1].equals(cub.up[1][1]) && sum < 4) {
			moves.fataSus(cub);
			moves.fataSus(cub);
		}
	}

	void moveUpFromBottomLine(String culoare, Cube cub) {
		int ok = 1;
		if (cub.front[1][1].equals(culoare) && cub.front[2][1].equals(cub.up[1][1])) {
			ok = 0;
		}
		while (ok == 1) {

			System.out.println(culoare + " " + cub.front[1][1]);
			moves.josDreapta(cub);
			moves.cubStanga(cub);
			if (cub.front[1][1].equals(culoare) && cub.front[2][1].equals(cub.up[1][1])) {
				ok = 0;
			}
		}
		if (cub.front[1][1].equals(culoare) && cub.front[2][1].equals(cub.up[1][1])) {
			moves.fataJos(cub);
			moves.susStanga(cub);
			moves.stangaSus(cub);
			moves.susDreapta(cub);
		}
	}

	public boolean searchDown(Cube cub) {

		/*
		 * cautam culoarea de sus pe centrele muchiilor de jos daca gasim la unu
		 * din centre invartim cubul astfel incat sa ajunga piesa cu acea
		 * culoare pe cub.front
		 */
		if (cub.down[0][1].compareTo(cub.up[1][1]) == 0) {

			System.out.println(cub.up[1][1] + " jos in pozitia (0,1)");

			moveUpFromDown(cub.front[2][1], cub);
			return true;

		}

		if (cub.down[1][0].compareTo(cub.up[1][1]) == 0) {
			System.out.println(cub.up[1][1] + "  jos in pozitia (1,0)");
			moves.cubDreapta(cub);
			moveUpFromDown(cub.front[2][1], cub);
			return true;
		}

		if (cub.down[1][2].compareTo(cub.up[1][1]) == 0) {
			System.out.println(cub.up[1][1] + " jos in pozitia (1,2)");
			moves.cubStanga(cub);
			moveUpFromDown(cub.front[2][1], cub);
			return true;
		}

		if (cub.down[2][1].compareTo(cub.up[1][1]) == 0) {
			System.out.println(cub.up[1][1] + "  jos in pozitia (2,1)");
			moves.cubStanga(cub);
			moves.cubStanga(cub);
			moveUpFromDown(cub.front[2][1], cub);
			return true;
		}
		System.out.println("nici un " + cub.up[1][1] + " jos");
		return false;
	}

	public boolean searchTheBottomLine(Cube cub) {

		int ok = 0;
		while (!cub.front[2][1].equals(cub.up[1][1]) && ok < 4) {
			moves.cubStanga(cub);

			ok++;
		}

		if (ok >= 4) {
			System.out.println("nici un " + cub.up[1][1] + " pe muchia de jos");
			return false;
		} else {
			System.out.println("este albastru pe linia de jos");
			moveUpFromBottomLine(cub.down[0][1], cub);
			return true;

		}

	}

	public boolean searchTheRightLine(Cube cub) {

		int ok = 0, ok1 = 0;
		int md = 0, ms = 0;
		if (cub.front[1][2].equals(cub.up[1][1])) {
			ok1 = 1;
			md = 1;
		} else if (cub.front[1][0].equals(cub.up[1][1])) {
			ok1 = 1;
			ms = 1;
		}

		while (ok1 == 0 && ok < 4) {
			ok++;
			moves.cubStanga(cub);

			if (cub.front[1][2].equals(cub.up[1][1])) {
				ok1 = 1;
				md = 1;
			} else if (cub.front[1][0].equals(cub.up[1][1])) {
				ok1 = 1;
				ms = 1;
			}
		}

		if (ok >= 4) {

			System.out.println("nu este albastru pe muchia dreapta sau pe cea stanga");
			return false;
		} else {
			if (md == 1) {

				System.out.println("este albastru pe muchia dreapta");
				if (cub.right[1][0].equals(cub.right[1][1])) {
					moves.dreaptaSus(cub);
					return true;
				}
				moves.dreaptaJos(cub);
				moves.josStanga(cub);
				moves.dreaptaSus(cub);
				moves.cubStanga(cub);
				moves.josDreapta(cub);
				moveUpFromDown(cub.front[2][1], cub);
				return true;
			}
			if (ms == 1) {
				System.out.println("e pe muchia  stanga ");
				if (cub.left[1][2].equals(cub.left[1][1])) {
					moves.stangaSus(cub);
					return true;
				}
				moves.stangaJos(cub);
				moves.josDreapta(cub);
				moves.stangaSus(cub);
				moveUpFromDown(cub.front[2][1], cub);
			}
			return true;
		}

	}

	public boolean searchTheTopLine(Cube cub) {
		int ok = 0;
		while (!cub.front[0][1].equals(cub.up[1][1]) && ok < 4) {
			moves.cubStanga(cub);
			ok++;
		}

		if (ok >= 4) {
			System.out.println("nu este pe muchia de sus:");
			return false;
		} else {
			System.out.println("este pe linia de sus");
			moves.fataJos(cub);
			moves.fataJos(cub);
			moveUpFromBottomLine(cub.down[0][1], cub);
			return true;
		}

	}

	public boolean searchTheTopFace(Cube cub) {

		int ok = 0;

		if (cub.up[2][1].equals(cub.up[1][1]) && !cub.front[0][1].equals(cub.front[1][1])) {
			System.out.println("gasit sus");
			moves.fataJos(cub);
			moves.fataJos(cub);
			moveUpFromDown(cub.front[2][1], cub);
			return true;
		}
		while (ok < 4) {
			moves.cubStanga(cub);
			ok++;
			if (cub.up[2][1].equals(cub.up[1][1]) && !cub.front[0][1].equals(cub.front[1][1])) {
				System.out.println("gasit sus");
				moves.fataJos(cub);
				moves.fataJos(cub);
				moveUpFromDown(cub.front[2][1], cub);
				return true;
			}
		}
		System.out.println("nici un albastru pe fata de sus ");
		return false;
	}

}
