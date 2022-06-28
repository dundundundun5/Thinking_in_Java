package net.mindview.util;

public class Hex {
    public static String format(byte[] data) {
        StringBuilder result = new StringBuilder();
        int n = 0;
        for (byte b : data) {
            if (n % 16 == 0)
                result.append(String.format("%05X: ", n));
            result.append(String.format("%02x ", b));
            n++;
            if (n % 16 == 0)
                result.append("\n");
        }
        return result.toString();
    }

    public static void main(String[] args) throws Exception{
        if (args.length == 0) {
            //TODO System.out.println(BinaryFile.read("Hex.class"));


        } else {
            //TODO System.out.println(BinaryFile.read(new File(args[0])));
        }

    }
}
