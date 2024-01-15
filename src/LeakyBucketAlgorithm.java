import java.util.Scanner;

public class LeakyBucketAlgorithm {
    public static void main(String args[])
    {
        int i;
        int a[]=new int[20];
        int buck_rem = 0 , buck_cap = 4 , rate = 3 , sent , recv;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the bucket");
        int n = sc.nextInt();
        System.out.println("Enter the packets");
        for(i = 1 ; i <= n ; i++)
            a[i]=sc.nextInt();
        System.out.println("clock\tpacket_size\taccepted\tsent\trem");

        for(i = 1 ; i <= n ; i++)
        {
            if(a[i] != 0 )
            {
                if(buck_rem + a[i] > buck_cap)
                    recv = -1;
                else
                {
                    recv = a[i];
                    buck_rem += a[i];
                }
            }
            else
                recv = 0;

            if(buck_rem != 0 )
            {
                if(buck_rem < rate)
                {
                    sent = buck_rem;
                    buck_rem = 0;
                }
                else
                {
                    sent = rate;
                    buck_rem = buck_rem - rate;
                }
            }
            else
                sent = 0;
            if(recv == -1)
                System.out.println(+i+"\t\t"+a[i]+"\t\t\tdropped\t\t"+sent+"\t\t"+buck_rem);
            else
                System.out.println(+i+"\t\t"+a[i]+"\t\t\t"+recv+"\t\t\t"+sent+"\t\t"+buck_rem);
        }
    }
}
