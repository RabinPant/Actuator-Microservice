package com.rabinpant.endpoint;

import com.rabinpant.DTO.ProdRelease;
import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Endpoint(id="releases")
public class FeatureReleaseEndpoint {

    List<ProdRelease> prodReleases = new ArrayList<>();
    @WriteOperation
    public void addNewReleaseInfo(@Selector String crq,@Selector String date, String features){
        ProdRelease release = ProdRelease.builder()
                .crq(crq)
                .releaseDate(date)
                .features(Arrays.stream(features.split(",")).collect(Collectors.toList())).build();

        prodReleases.add(release);
    }
    @ReadOperation
    public List<ProdRelease> getAllReleases(){
        return prodReleases;

    }
    @ReadOperation
    public ProdRelease getReleaseByCRQ(@Selector String crq){
        return prodReleases.stream().filter(prodRelease -> prodRelease.getCrq().equals(crq))
                .findAny().get();
    }
    @DeleteOperation
    public void deleteRelease(@Selector String crq){

        prodReleases.remove(getReleaseByCRQ(crq));
    }
}
