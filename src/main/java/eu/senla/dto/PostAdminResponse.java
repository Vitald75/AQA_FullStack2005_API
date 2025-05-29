package eu.senla.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class PostAdminResponse {
    private List<AdminResponseData> data;
    private String requestId;
}
