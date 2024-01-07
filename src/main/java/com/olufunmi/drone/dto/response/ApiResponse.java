package com.joe.drone.dto.response;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {
    private  int statusCode;
    private Object data;
    private boolean successful;


}
