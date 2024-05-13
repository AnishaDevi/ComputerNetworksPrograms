import java.util.Scanner;

public class Ford
{
    public static final int MAX_VAL = 999;
    private int num_ver;
    private int D[];

    public Ford(int num_ver)
    {
        this.num_ver = num_ver;
        D = new int[num_ver + 1];
    }

    public void bellmanFordEvaluation(int source , int A[][]) {
        for (int node = 1; node <= num_ver; node++) {
            D[node] = MAX_VAL;
        }
        D[source] = 0;

        for (int node = 1; node <= num_ver - 1; node++) {
            for (int sn = 1; sn <= num_ver; sn++) {
                for (int dn = 1; dn <= num_ver; dn++) {
                    if (A[sn][dn] != MAX_VAL) {
                        if (D[dn] > D[sn] + A[sn][dn])
                            D[dn] = D[sn] + A[sn][dn];
                    }
                }
            }
        }

            for (int sn = 1; sn <= num_ver; sn++) {
                for (int dn = 1; dn <= num_ver; dn++) {
                    if (A[sn][dn] != MAX_VAL) {
                        if (D[dn] > D[sn] + A[sn][dn])
                            System.out.println("Graph contains negative loop");
                    }
                }
            }
        for(int vertex = 1 ; vertex <= num_ver ; vertex++)
        {
            System.out.println("Distance of source " + source + " to " + vertex + " is " + D[vertex]);
        }
    }

    public static void main(String args[])
    {
        int num_ver,source;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        num_ver = sc.nextInt();
        int A[][] = new int[num_ver + 1][num_ver + 1];
        System.out.println("Enter the adjacency matrix");
        for(int sn = 1;sn <= num_ver ; sn++)
        {
            for(int dn = 1 ; dn <= num_ver ; dn++)
            {
                A[sn][dn] = sc.nextInt();
                if(sn == dn)
                {
                    A[sn][dn] = 0;
                    continue;
                }
                if(A[sn][dn] == 0)
                    A[sn][dn] = MAX_VAL;
            }
        }
        System.out.println("Enter the source vertex");
        source = sc.nextInt();
        Ford b = new Ford(num_ver);
        b.bellmanFordEvaluation(source , A);
        sc.close();
    }
}

