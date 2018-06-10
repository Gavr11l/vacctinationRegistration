/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.nure.gavr.data;

/**
 *
 * @author testtest
 */
public enum DateType {

	CURRENT_DAY("Дневной"), CURRENT_MONTH("Помесячный"), CURRENT_QUARTER(
			"Квартальный"), CURRENT_HALF_YEAR("Полугодовой"), CURRENT_YEAR(
			"Годовой");

	private DateType(String name) {
		this.name = name;
	}

	private final String name;

	public String getName() {
		return name;
	}

	public static DateType parse(String dateType) {
		for (DateType dt : values()) {
			if(dt.name.equals(dateType)) return dt;

		}
		return CURRENT_DAY;
	}
}
