package com.xy1m.cci.chapter05_bit_manipulation;

public class Q5_08_DrawLine {
    public static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
        int start_offset = x1 % 8;
        int first_full_byte = x1 / 8;
        if (start_offset != 0) {
            first_full_byte++;
        }

        int end_offset = x2 % 8;
        int last_full_byte = x2 / 8;
        if (end_offset != 7) {
            last_full_byte--;
        }

        for (int b = first_full_byte; b <= last_full_byte; b++) {
            screen[width / 8 * y + b] = (byte) 0xFF;
        }

        byte start_mask = (byte) (0xFF >> start_offset);
        byte end_mask = (byte) ~(0xFF >> (end_offset + 1));

        // x1 and x2 are in same byte
        if (x1 / 8 == x2 / 8) {
            screen[width / 8 * y + x1 / 8] |= start_mask & end_mask;
        }
        else {
            if (x1 % 8 != 0) {
                int byte_number = width / 8 * y + first_full_byte - 1;
                screen[byte_number] |= start_mask;
            }
            if (x2 % 8 != 7) {
                int byte_number = width / 8 * y + last_full_byte + 1;
                screen[byte_number] |= end_mask;
            }
        }
    }

    public static void main(String[] args) {
        //drawLine(new byte[64], 24, 0, 11, 1);
        byte[] screen = new byte[20];
        int width = 32;
        drawLine(screen, width, 3, 65, 0);

        for (int i = 0; i < screen.length; i++) {
            if (i * 8 % width == 0) {
                System.out.println();
            }
            System.out.print(byte2str(screen[i]));
            System.out.print(" ");
        }
    }

    private static String byte2str(byte b) {
        return String.format("%8s", Integer.toBinaryString(b & 0xff)).replace(" ", "0");
    }
}
