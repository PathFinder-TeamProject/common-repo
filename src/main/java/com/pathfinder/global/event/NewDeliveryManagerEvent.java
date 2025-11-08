package com.pathfinder.global.event;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NewDeliveryManagerEvent {
    private String username;
    private Long hubId;
    private String deliveryManagerType;
}