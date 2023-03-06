package org.pw.process;

import lombok.*;

@Getter
@Builder
@ToString
public class ProcessInfo {

    private final String name;
    private final Long pid;
    private final String user;
}
