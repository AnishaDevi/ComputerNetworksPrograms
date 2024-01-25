import java.util.Scanner;

public class RSA {
    public static int mult(int x , int y , int n)
    {
        int k = 1;
        for(int i=1 ; i <= y ; i++)
            k = (k * x) % n;
        return k;
    }
    public static int gcd(int m, int n) {
        if (n == 0)
            return m;
        else
            return gcd(n, m % n);
    }
    public static int isprime(int num) {
        int temp;
        boolean isprime = true;
        for (int k = 2; k <= num / 2; k++) {
            temp = num % k;
            if (temp == 0) {
                isprime = false;
                break;
            }
        }
        if (!isprime) {
            System.out.println(num + " is not a prime number");
            return 0;
        } else {
            System.out.println(num + " is a prime number");
            return num;
        }

    }
    public static void main(String[] args) {
        int message, plaintext, ciphertext;
        int d = 0, e, n, z, i = 0, p, q, a, b;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of two prime numbers");
        p = sc.nextInt();
        q = sc.nextInt();

        a = isprime(p);
        b = isprime(q);

        if ((a == p && b == q) && (a != 0 && b != 0)) {
            System.out.println("Enter the message");
            message = sc.nextInt();

            n = p * q;
            z = (p - 1) * (q - 1);
            do {
                System.out.println("Select the value of e such that gcd(z,e)=1");
                e = sc.nextInt();
            } while (gcd(z, e) != 1);
            while(((i * e) % z) != 1)
            {
                i++;
                d = i;
            }
            System.out.println("The public key pair is ( " + e + " , " + n + ")" );
            System.out.println("The public key pair is ( " + d + " , " + n + ")" );
            ciphertext = mult(message , e , n);
            System.out.println("The Ciphered text is " + ciphertext);
            plaintext = mult(ciphertext , d , n);
            System.out.println("The plain text is :"+ plaintext);
        }
        sc.close();
    }
}

