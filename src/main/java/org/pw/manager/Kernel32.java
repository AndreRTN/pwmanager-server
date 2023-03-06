package org.pw.manager;


import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

public interface Kernel32 extends Library {
    Kernel32 INSTANCE = (Kernel32) Native.load("kernel32", Kernel32.class);

    Pointer OpenProcess(int dwDesiredAccess, boolean bInheritHandle, int dwProcessId);
}
