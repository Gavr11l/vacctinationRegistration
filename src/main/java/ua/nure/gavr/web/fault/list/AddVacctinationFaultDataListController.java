/**
 *
 */
package ua.nure.gavr.web.fault.list;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.nure.gavr.data.CalendarPlanWrapper;
import ua.nure.gavr.model.Institution;
import ua.nure.gavr.web.abstractclasses.AbstractListController;

/**
 * @author gavr
 *
 */
@Controller
@RequestMapping(value = "/addvacfdatalist")
public class AddVacctinationFaultDataListController extends AbstractListController<AddVacctinationFaultDataListCommand, CalendarPlanWrapper> {

	private static final String VIEW_NAME = "addvacfdatalist";

	@Override
	protected AddVacctinationFaultDataListCommand createCommand() {
		return new AddVacctinationFaultDataListCommand();
	}

	@Override
	protected String getViewName() {
		return VIEW_NAME;
	}

	@Override
	protected List<CalendarPlanWrapper> getWrapperList(AddVacctinationFaultDataListCommand command, Institution institution) {
		return vacctinationService.findPlannedVacctinationsWithoutFaultAndRenouncement(
						institution.getIdInstitution(), getDateType(command), getVactinationTypes(command));
	}
}