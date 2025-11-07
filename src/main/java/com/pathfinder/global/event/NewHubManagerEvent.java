package com.pathfinder.global.event;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NewHubManagerEvent {
    private String username;
    private String email;
    private Long hubId;
    private String deliveryManagerType;
}