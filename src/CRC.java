import java.util.Scanner;

public class CRC {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the message bits:");
        String message = sc.nextLine();
        System.out.println("Enter the generator bits:");
        String generator = sc.nextLine();

        int data[] = new int[message.length() + generator.length() - 1];
        int divisor[] = new int[generator.length()];

        for (int i = 0; i < message.length(); i++)
            data[i] = Integer.parseInt(message.charAt(i) + "");
        for (int i = 0; i < generator.length(); i++)
            divisor[i] = Integer.parseInt(generator.charAt(i) + "");

        //calculation of CRC
        for (int i = 0; i < message.length(); i++) {
            if (data[i] == 1)
                for (int j = 0; j < generator.length(); j++)
                    data[i + j] ^= divisor[j];
        }
        System.out.println("The reminder is");
        for(int i = message.length() ; i < data.length ; i++)
            System.out.print(data[i]);
        System.out.println();
        //Display CRC
        System.out.println("The checksum code is: ");
        for (int i = 0; i < message.length(); i++)
            data[i] = Integer.parseInt(message.charAt(i) + "");
        for (int i = 0; i < data.length; i++)
            System.out.print(data[i]);
        System.out.println();

        //check for input CRC code
        System.out.println("Enter the checksum code: ");
        message = sc.nextLine();
        System.out.println("Enter the generator bits");
        generator = sc.nextLine();

        for (int i = 0; i < message.length(); i++)
            data[i] = Integer.parseInt(message.charAt(i) + "");
        for (int i = 0; i < generator.length(); i++)
            divisor[i] = Integer.parseInt(generator.charAt(i) + "");

        for (int i = 0; i < message.length(); i++)
            if (data[i] == 1)
                for (int j = 0; j < generator.length(); j++)
                    data[i + j] ^= divisor[j];

        //Display validity of data
        boolean valid = true;
        for (int i = 0; i < data.length; i++)
            if (data[i] == 1) {
                valid = false;
                break;
            }
        if (valid == true)
            System.out.println("The data stream is valid.");
        else
            System.out.println("The datastream is invalid.");
    }
}
