package com.project.Xpace.controller;

import com.project.Xpace.model.SpaceRequest;

public class SpaceRequestController {


    private SpaceRequestController request;

    public SpaceRequestController(SpaceRequestService service){
        this.request=service;
    }
}
