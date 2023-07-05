package co.zw.company.employeemanager.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
public class ApiResponse<T> {
    private int status;
    private String message;
    private T body;
}
