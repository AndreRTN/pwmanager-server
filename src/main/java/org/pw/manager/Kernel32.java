package org.pw.manager;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary;

/**
 * Essa classe corresponde ao kernel32 do win32, é preciso mapear as funções desejadas com a mesma assinatura das funções nativas
 *
 * @see <a href="https://github.com/java-native-access/jna/blob/master/contrib/platform/src/com/sun/jna/platform/win32/Kernel32.java">Kernel32</a>
 */
public interface Kernel32 extends StdCallLibrary {
    Kernel32 INSTANCE = (Kernel32) Native.load("kernel32", Kernel32.class);


    /**
     * @param dwDesiredAccess direitos de acesso ao processo que será aberto, para todos os acessos usamos 2035711U
     * @param bInheritHandle  se verdadeiro os processos criados por esse processo irão herdar o identificador, 0 por padrão
     * @param dwProcessId     id do processo (pid)
     * @return Se a função for bem-sucedida, o valor retornado será um identificador aberto para o processo especificado.
     */
    Pointer OpenProcess(int dwDesiredAccess, boolean bInheritHandle, int dwProcessId);


}
