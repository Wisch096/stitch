package com.curd.stitch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DepartmentSummaryDTO {
    private String department;
    private int numberOfPeople;
    private int numberOfTasks;
}
