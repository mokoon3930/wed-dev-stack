package com.project.erp.model.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class Project {
	private int proNo;
    private String proName;
    private String destination;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String status;
    private int managerNo;
}
