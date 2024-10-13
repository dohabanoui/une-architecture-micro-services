package org.sdia.billingservice.entities;

import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name = "fullBill", types = Bill.class)
public interface BillProjection {
    Long getId();
    Date getBillingDate();
    Long getCustomerID();
}
