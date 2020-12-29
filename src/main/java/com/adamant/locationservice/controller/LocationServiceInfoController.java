package com.adamant.locationservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.info.BuildProperties;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class LocationServiceInfoController {

    private final Environment environment;

    private final BuildProperties buildProperties;

    @GetMapping(value = "/")
    public @ResponseBody
    ResponseEntity<Map<String, Object>> welcome() {
        String[] profiles = environment.getActiveProfiles();
        String currentProfile = (profiles.length > 0) ? profiles[0] : "DEV";

        return ResponseEntity.ok(Map.of(
                "application", buildProperties.getName(),
                "version", buildProperties.getVersion(),
                "env", currentProfile));
    }
}
