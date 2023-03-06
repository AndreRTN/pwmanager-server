package org.pw.process;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data

/**
 * Classe usada para ler quantos processos existem com o nome informado no construtor e retornar algumas
 * informações como nome do usuário do processo, PID
 */
public class ProcessReader {
    List<ProcessInfo> processHandlers;
    public ProcessReader(String processName) {
        Stream<ProcessHandle> liveProcesses = ProcessHandle.allProcesses();

        List<ProcessHandle> processHandles = liveProcesses.filter(p -> p.info().command().isPresent())
                .filter(p -> StringUtils.containsIgnoreCase(p.info().command().orElse(""), processName))
                .toList();

        processHandlers = processHandles.stream().map(ph -> convertProcessHandleToInfo(ph, processName))
                .collect(Collectors.toList());

    }

    public ProcessInfo convertProcessHandleToInfo(ProcessHandle process, String processName) {
        return ProcessInfo.builder()
                .user(process.info().user().orElse(""))
                .pid(process.pid())
                .name(processName)
                .build();
    }
}
