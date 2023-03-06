package org.pw.manager;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

public interface CMathTest extends Library {

    CMathTest lib = Native.load(Platform.isWindows()?"msvcrt":"c", CMathTest.class);
    double sqrt(double value);
}
