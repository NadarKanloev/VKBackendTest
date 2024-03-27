package org.nadarkanloev.vkbackendtest.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ErrorDetails {
    private int status;
    private String message;
}
