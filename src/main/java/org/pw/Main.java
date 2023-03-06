package org.pw;

import com.sun.jna.Platform;
import com.sun.jna.Pointer;
import org.pw.manager.CMathTest;
import org.pw.manager.Kernel32;
import org.pw.process.ProcessReader;

public class Main {
    public static void main(String[] args) {
        ProcessReader reader = new ProcessReader("elementclient");

        System.out.println(reader.getProcessHandlers());

        System.out.println(Platform.isWindows());

        double cMath = CMathTest.lib.sqrt(4);

        System.out.println("Test C Function: " + cMath);
    }
}