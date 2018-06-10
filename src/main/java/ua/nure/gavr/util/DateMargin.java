/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.nure.gavr.util;

import java.util.Date;

/**
 *
 * @author testtest
 */
public class DateMargin {

    private final Date startDate;
    private final Date endDate;

    public DateMargin(Date startDate, Date endDate) {
	this.startDate = startDate;
	this.endDate = endDate;
    }

    public Date getStartDate() {
	return startDate;
    }

    public Date getEndDate() {
	return endDate;
    }

}
