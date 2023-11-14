// Generated with g9.

package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class LoginHistory implements Serializable {
    private int loginId;
    private LocalDateTime loginTime;
    private String status;
    private CustomerAccount customerAccount;
}
