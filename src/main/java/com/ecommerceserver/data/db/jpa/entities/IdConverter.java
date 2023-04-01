package com.ecommerceserver.data.db.jpa.entities;

import com.ecommerceserver.core.domain.Identity;

public final class IdConverter {

    public static Long convertId(Identity id) {
        if (id != null && id.getNumber() != Long.MIN_VALUE) {
            return id.getNumber();
        }
        return null;
    }
}
