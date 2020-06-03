package nuc.lb.location.db;

import java.util.Arrays;
import java.util.Scanner;

public class distance_dij {
	static int[][] mapp = new int[20][120];
	static int[] dis = new int[1024];
	static int[][] e = new int[20][120];
	static boolean vis[] = new boolean[1220];
	private int[][][] dt = new int[20][20][20];
	static int st, ed, n, m, x, y, lens, aa, bb;
	static int inf = 0x3f3f3f3f;

	public distance_dij(int x, int y) {
		fun(x, y);
	}

	public static int fun(int x, int y) {
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<16;i++) {
			Arrays.fill(e[i], inf);
		}
	
		// n = sc.nextInt();
		n = 16;
		// m = sc.nextInt();
		m = 120;
		distance();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					e[i][j] = 0;
				else
					e[j][i] = e[i][j];
			}
		}
		
		for (int i = 0; i < 16; i++) {

			e[i][i] = 0;
		}
//		for (int i = 0; i < 16; i++) {
//			for (int j = 0; j < 16; j++) {
//				System.out.print(e[i][j] + " ");
//			}
//			System.out.println();
//		}
//				for(int i=0;i<m;i++)
//				{
//					 x = sc.nextInt();
//					 y = sc.nextInt();
//					 lens = sc.nextInt();
//					if(e[x][y]>lens)
//					e[x][y]=e[y][x]=lens;
//				}
		// st = sc.nextInt();
		st = x;
		ed = y;
		// ed = sc.nextInt();
		// scanf("%d %d",&st,&ed);
		dijkstra(st);
		if (dis[ed] == inf)
			System.out.println(-1);
//				else
//				System.out.println(dis[ed]);
		return dis[ed];
	}

	static void dijkstra(int st) {
	// memset(vis,false,sizeof(vis));
		Arrays.fill(vis, false);
		vis[st] = true;
		int n = 16;
		for (int i = 0; i < n; i++)
			dis[i] = e[st][i];
		dis[st] = 0;
//		for (int i = 0; i < n; i++)
//			System.out.println(dis[i]);
		int u = 0, minn;
		for (int i = 0; i < n - 1; i++)// 找原点到各个城市的最短路，找到标记为1;
		{
			minn = inf;
			for (int j = 0; j < n; j++) {
				if (!vis[j] && dis[j] < minn) {
					u = j;
					minn = dis[j];
				}
			}
			vis[u] = true;
			//System.out.println("节点是" + u);
			for (int v = 0; v < n; v++) {
				if (dis[v] > dis[u] + e[u][v])
					dis[v] = dis[u] + e[u][v];
			}
		}
//				for(int i=0;i<16;i++) {
//					System.out.println(dis[i]);
//				}
	}

	private static void distance() {
		// dt[0][1][] x-->y 距离
		e[0][1] = 300;
		e[0][2] = 979;
		e[0][3] = 1100;
		e[0][4] = 557;
		e[0][5] = 120;
		e[0][6] = 678;
		e[0][7] = 1400;
		e[0][8] = 422;
		e[0][9] = 178;
		e[0][10] = 626;
		e[0][11] = 171;
		e[0][12] = 1300;
		e[0][13] = 120;
		e[0][14] = 642;
		e[0][15] = 697;

		e[1][2] = 886;
		e[1][3] = 996;
		e[1][4] = 610;
		e[1][5] = 180;
		e[1][6] = 590;
		e[1][7] = 1400;
		e[1][8] = 414;
		e[1][9] = 288;
		e[1][10] = 932;
		e[1][11] = 144;
		e[1][12] = 1300;
		e[1][13] = 151;
		e[1][14] = 1000;
		e[1][15] = 533;

		e[2][3] = 136;
		e[2][4] = 1500;
		e[2][5] = 919;
		e[2][6] = 447;
		e[2][7] = 590;
		e[2][8] = 1000;
		e[2][9] = 1100;
		e[2][10] = 217;
		e[2][11] = 998;
		e[2][12] = 715;
		e[2][13] = 545;
		e[2][14] = 653;
		e[2][15] = 373;

		e[3][4] = 1600;
		e[3][5] = 1000;
		e[3][6] = 540;
		e[3][7] = 442;
		e[3][8] = 1200;
		e[3][9] = 1300;
		e[3][10] = 227;
		e[3][11] = 1100;
		e[3][12] = 725;
		e[3][13] = 638;
		e[3][14] = 2000;
		e[3][15] = 466;

		e[4][5] = 536;
		e[4][6] = 1200;
		e[4][7] = 2000;
		e[4][8] = 767;
		e[4][9] = 322;
		e[4][10] = 1500;
		e[4][11] = 728;
		e[4][12] = 1900;
		e[4][13] = 751;
		e[4][14] = 827;
		e[4][15] = 1200;

		e[5][6] = 801;
		e[5][7] = 1400;
		e[5][8] = 405;
		e[5][9] = 207;
		e[5][10] = 965;
		e[5][11] = 199;
		e[5][12] = 1300;
		e[5][13] = 226;
		e[5][14] = 807;
		e[5][15] = 744;

		e[6][7] = 1000;
		e[6][8] = 737;
		e[6][9] = 906;
		e[6][10] = 656;
		e[6][11] = 765;
		e[6][12] = 992;
		e[6][13] = 451;
		e[6][14] = 1600;
		e[6][15] = 1000;

		e[7][8] = 1600;
		e[7][9] = 1700;
		e[7][10] = 613;
		e[7][11] = 1500;
		e[7][12] = 1100;
		e[7][13] = 1000;
		e[7][14] = 2200;
		e[7][15] = 960;

		e[8][9] = 495;
		e[8][10] = 1100;
		e[8][11] = 597;
		e[8][12] = 1400;
		e[8][13] = 1000;
		e[8][14] = 1200;
		e[8][15] = 680;

		e[9][10] = 1200;
		e[9][11] = 406;
		e[9][12] = 1500;
		e[9][13] = 424;
		e[9][14] = 723;
		e[9][15] = 849;

		e[10][11] = 1000;
		e[10][12] = 497;
		e[10][13] = 576;
		e[10][14] = 2000;
		e[10][15] = 591;

		e[11][12] = 1400;
		e[11][13] = 30;
		e[11][14] = 1000;
		e[11][15] = 708;

		e[12][13] = 912;
		e[12][14] = 1800;
		e[12][15] = 935;

		e[13][14] = 888;
		e[13][15] = 1276;

		e[14][15] = 1500;

	}
}
