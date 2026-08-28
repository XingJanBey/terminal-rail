package com.jbhard;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // 组合指令：先清屏，再将光标移到左上角
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.print("\r\n" + //
                "\r\n" + //
                "              _______________________\r\n" + //
                "             /                       \\  \r\n" + //
                "  __________/ ________________________________________\r\n" + //
                "\r\n" + //
                "\r\n" + "\r\n");

        System.out.print("\033[8;0H" + "                                \r");

        // 道岔初始化
        boolean[] yard = new boolean[2];
        yard[0] = false;
        yard[1] = true;
        boolean selec = false;
        int junc = 0;
        String opr = "";

        while (true) {
            // 核心操作扫描代码
            opr = scan.nextLine();

            // 以下为变量设置
            if (opr.equals("quit") || opr.equals("exit")) // 退出操作
                break;

            if (opr.equals("x")) // x键切换光标显示
                selec = !selec;

            if (selec) { // 以下操作必须在光标点亮情况下

                if (opr.equals("z")) // 切换道岔
                    yard[junc] = !yard[junc];

                if (opr.equals("a")) // 光标左移
                    if (junc > 0)
                        junc -= 1;

                if (opr.equals("d")) // 光标右移
                    if (junc < yard.length - 1)
                        junc += 1;
            }

            // 以下为图像渲染
            if (yard[0])
                System.out.print("\033[5;13H" + "__");
            else
                System.out.print("\033[5;13H" + "/ ");

            if (yard[1])
                System.out.print("\033[5;38H" + "__");
            else
                System.out.print("\033[5;38H" + " \\");

            if (junc == 0 && selec)
                System.out.print("\033[6;13H" + "▲");
            else
                System.out.print("\033[6;13H" + " ");

            if (junc == 1 && selec)
                System.out.print("\033[6;39H" + "▲");
            else
                System.out.print("\033[6;39H" + " ");

            System.out.print("\033[8;0H" + "                                \r");

        }
        scan.close();
    }
}
// PS D:\lenovo\coding\Java\11.rail> d:; cd 'd:\lenovo\coding\Java\11.rail'; &
// 'D:\ProgramFiles\Java\jdk-17\bin\java.exe'
// '@C:\Users\lenovo\AppData\Local\Temp\cp_4jemy353o1qcq6j9twyaz35m9.argfile'
// 'com.jbhard.App'