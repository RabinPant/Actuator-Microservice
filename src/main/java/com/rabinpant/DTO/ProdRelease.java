package com.rabinpant.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdRelease {

    private String crq;
    private String releaseDate;
    private List<String> features;
}
