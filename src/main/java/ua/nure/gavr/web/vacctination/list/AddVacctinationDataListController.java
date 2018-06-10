/**
 *
 */
package ua.nure.gavr.web.vacctination.list;

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
@RequestMapping(value = "/addvacdatalist")
public class AddVacctinationDataListController extends AbstractListController<AddVacctinationDataListCommand, CalendarPlanWrapper> {

	private static final String VIEW_NAME = "addvacdatalist";

	@Override
	protected AddVacctinationDataListCommand createCommand() {
		return new AddVacctinationDataListCommand();
	}

	@Override
	protected String getViewName() {
		return VIEW_NAME;
	}

	@Override
	protected List<CalendarPlanWrapper> getWrapperList(
			AddVacctinationDataListCommand command, Institution institution) {
		return vacctinationService
				.findPlannedVacctinationsWithoutFaultAndRenouncement(
						institution.getIdInstitution(), getDateType(command),
						getVactinationTypes(command));
	}
}