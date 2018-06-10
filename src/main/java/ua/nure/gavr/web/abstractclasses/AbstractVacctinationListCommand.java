/**
 *
 */
package ua.nure.gavr.web.abstractclasses;

import java.util.List;

import ua.nure.gavr.model.Vacctination;

/**
 * @author gavr
 *
 */
public abstract class AbstractVacctinationListCommand<T> extends AbstractCommand {

	private List<Vacctination> vacctinationList;
	private List<T> wrapperList;
	private List<Integer> vacctinationIds;
	private List<String> dateTypeCodes;
	private String dateType;

	public List<Vacctination> getVacctinationList() {
		return vacctinationList;
	}
	public void setVacctinationList(List<Vacctination> vacctinationList) {
		this.vacctinationList = vacctinationList;
	}
	public List<T> getWrapperList() {
		return wrapperList;
	}
	public void setWrapperList(List<T> wrapperList) {
		this.wrapperList = wrapperList;
	}
	public List<Integer> getVacctinationIds() {
		return vacctinationIds;
	}
	public void setVacctinationIds(List<Integer> vacctinationIds) {
		this.vacctinationIds = vacctinationIds;
	}
	public List<String> getDateTypeCodes() {
		return dateTypeCodes;
	}
	public void setDateTypeCodes(List<String> dateTypeCodes) {
		this.dateTypeCodes = dateTypeCodes;
	}
	public String getDateType() {
		return dateType;
	}
	public void setDateType(String dateType) {
		this.dateType = dateType;
	}


}
