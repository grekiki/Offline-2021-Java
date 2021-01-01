import java.io.*;
import java.util.ArrayList;

public class SolutionWriter {
	public static final int submissionCode = 333137;

	public static void writeSolution(ArrayList<CubePosition> solution, TestCase tc,int tcase) throws Exception {
		int dimx = tc.dimensions[0];
		int dimy = tc.dimensions[1];
		int dimz = tc.dimensions[2];
		int[][][] grid = makeGrid(tc);
		int[][][] output = new int[dimx][dimy][dimz];
		int p=0;
		for (CubePosition cp : solution) {
			p++;
			for (int dx = 0; dx < cp.b.dim[0]; dx++) {
				for (int dy = 0; dy < cp.b.dim[1]; dy++) {
					for (int dz = 0; dz < cp.b.dim[2]; dz++) {
						if (grid[cp.x + dx][cp.y + dy][cp.z + dz] == 0) {
							System.out.println("Resitev je napacna");
							return;
						} else {
							grid[cp.x + dx][cp.y + dy][cp.z + dz] = 0;
							output[cp.x + dx][cp.y + dy][cp.z + dz] = p;
						}
					}
				}
			}
		}
		// Check if grid contains any unfilled positions
		for (int x = 0; x < dimx; x++) {
			for (int y = 0; y < dimy; y++) {
				for (int z = 0; z < dimz; z++) {
					if (grid[x][y][z] == 1) {
						System.out.println("Resitev je napacna, ne zapolnimo polja"+x+" "+y+" "+z);
						return;
					}
				}
			}
		}
		//Write the solution
		PrintWriter out=new PrintWriter(new FileWriter(new File("outputs\\output"+tcase+".txt")));
		out.println(submissionCode);
		out.println("Pokrajina");
		out.println();
		out.println(tcase);
		for(int z=0;z<dimz;z++) {
			for(int y=0;y<dimy;y++) {
				for(int x=0;x<dimx;x++) {
					out.print(output[x][y][z]+" ");
				}
				out.println();
			}
		}
		out.close();
		
	}

	public static int[][][] makeGrid(TestCase tc) {
		int dimx = tc.dimensions[0];
		int dimy = tc.dimensions[1];
		int dimz = tc.dimensions[2];
		int[][][] grid = new int[dimx][dimy][dimz];
		for (int x = 0; x < dimx; x++) {
			for (int y = 0; y < dimy; y++) {
				for (int z = 0; z < dimz; z++) {
					if (tc.hmap[x][y] > z) {
						grid[x][y][z] = 1;
					}
				}
			}
		}
		return grid;
	}
}
