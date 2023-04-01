package com.ecommerceserver.core.domain;

import lombok.Value;

@Value
public class Identity {
    Long number;

    public static Identity none() {
        return new Identity(Long.MIN_VALUE);
    }
}
