import java.util.Scanner;

public class MainRubik {
	public static RubikMoves moves = new RubikMoves();
	public static Cube cube = new Cube();
	public static CrossProccess cross = new CrossProccess();
	public static FirstFace firstFace = new FirstFace();
	public static CompleteLine line = new CompleteLine();

	public static void main(String[] args) {

		moves.generateRandomCube(cube);
		printer();
		makeCross();
		printer();
		boolean ok = upFinish();
		if (ok) {
			moves.cubInSus(cube);
			moves.cubInSus(cube);
		}
		
		printer();
		moves.cubStanga(cube);
		printer();
		line.searchLine(cube);
		printer();
		System.out.println("intorduceti miscarile : ");
		makeTheCube();

	}

	static boolean upFinish() {

		boolean ok;
		boolean gata = firstFace.upFinished(cube);
		int ok1 = 0;

		while (!firstFace.upFinished(cube) && ok1 < 10) {
			ok1++;
			if (!gata) {
				ok = firstFace.searchCornerDownFace(cube);
				gata = firstFace.upFinished(cube);
				while (ok && !gata) {
					printer();
					ok = firstFace.searchCornerDownFace(cube);
					gata = firstFace.upFinished(cube);
				}
			}

			if (!gata) {
				ok = firstFace.searchCornerDownLine(cube);
				gata = firstFace.upFinished(cube);
				while (ok && !gata) {
					printer();
					ok = firstFace.searchCornerDownLine(cube);
					gata = firstFace.upFinished(cube);
				}
			}

			if (!gata) {
				ok = firstFace.searchTopCorners(cube);
				gata = firstFace.upFinished(cube);
				while (ok && !gata) {
					printer();
					ok = firstFace.searchTopCorners(cube);
				}
			}

			if (!gata) {
				ok = firstFace.searchUpCorners(cube);
				gata = firstFace.upFinished(cube);
				while (ok && !gata) {
					printer();
					ok = firstFace.searchUpCorners(cube);
					gata = firstFace.upFinished(cube);
				}
			}
		}
		return true;
	}

	static boolean makeCross() {
		boolean isCross = cross.isCross(cube);
		boolean ok = true;
		int ok1 = 0;
		while (!isCross && ok1 < 15) {

			if (!isCross) {
				ok = cross.searchDown(cube);
				isCross = cross.isCross(cube);
				while (ok && !isCross) {
					printer();
					isCross = cross.isCross(cube);
					ok = cross.searchDown(cube);

					ok1++;
				}
			}

			if (!isCross) {
				ok = cross.searchTheBottomLine(cube);
				isCross = cross.isCross(cube);
				while (ok && !isCross) {
					printer();
					isCross = cross.isCross(cube);
					ok = cross.searchTheBottomLine(cube);

					ok1++;
				}
			}
			if (!isCross) {
				ok = cross.searchTheRightLine(cube);
				isCross = cross.isCross(cube);
				while (ok && !isCross) {
					printer();
					isCross = cross.isCross(cube);
					ok = cross.searchTheRightLine(cube);

					ok1++;
				}
			}
			if (!isCross) {
				ok = cross.searchTheTopLine(cube);
				isCross = cross.isCross(cube);
				while (ok && !isCross) {
					printer();
					isCross = cross.isCross(cube);
					ok = cross.searchTheTopLine(cube);

					ok1++;
				}
			}
			if (!isCross) {
				ok = cross.searchTheTopFace(cube);
				isCross = cross.isCross(cube);
				while (ok && !isCross) {
					printer();
					isCross = cross.isCross(cube);
					ok = cross.searchTheTopFace(cube);

					ok1++;
				}
			}
		}
		return isCross;
	}

	static String readMove() {
		Scanner read = new Scanner(System.in);

		String text = new String();
		text = read.next();

		return text;
	}

	public static boolean makeTheCube() {
		String text;
		text = readMove();

		while (text.compareTo("end") != 0) {
			System.out.println(text);
			proccesMove(text, moves);

			text = readMove();
		}
		return false;
	}

	static void proccesMove(String text, RubikMoves moves) {
		if (text.compareTo("SS") == 0) {
			moves.susStanga(cube);
			printer();
		}

		if (text.compareTo("SD") == 0) {
			moves.susDreapta(cube);
			printer();
		}
		if (text.compareTo("JS") == 0) {
			moves.josStanga(cube);
			printer();
		}
		if (text.compareTo("JD") == 0) {
			moves.josDreapta(cube);
			printer();
		}
		if (text.compareTo("RS") == 0) {
			moves.dreaptaSus(cube);
			printer();
		}
		if (text.compareTo("RJ") == 0) {
			moves.dreaptaJos(cube);
			printer();
		}
		if (text.compareTo("LS") == 0) {
			moves.stangaSus(cube);
			printer();
		}
		if (text.compareTo("LJ") == 0) {
			moves.stangaJos(cube);
			printer();
		}
		if (text.compareTo("CJ") == 0) {
			moves.cubInJos(cube);
			printer();
		}
		if (text.compareTo("CS") == 0) {
			moves.cubInSus(cube);
			printer();
		}
		if (text.compareTo("CL") == 0) {
			moves.cubStanga(cube);
			printer();
		}
		if (text.compareTo("CR") == 0) {
			moves.cubDreapta(cube);
			printer();
		}
		if (text.compareTo("FS") == 0) {
			moves.fataSus(cube);
			printer();
		}
		if (text.compareTo("FJ") == 0) {
			moves.fataJos(cube);
			printer();
		}

	}

	static void printer() {
		System.out.println("fata sus: ");
		System.out.println();
		moves.print(cube.up);

		System.out.println();
		System.out.println();
		System.out.println("face");
		System.out.println();
		moves.print(cube.front);

		System.out.println();
		System.out.println();
		System.out.println("stanga");
		System.out.println();
		moves.print(cube.left);

		System.out.println();
		System.out.println();
		System.out.println("dreapta");
		System.out.println();
		moves.print(cube.right);

		System.out.println();
		System.out.println();
		System.out.println("jos");
		System.out.println();
		moves.print(cube.down);

		System.out.println();
		System.out.println();
		System.out.println("spate");
		System.out.println();
		moves.print(cube.back);

		System.out.println();
		System.out.println();
	}
}
