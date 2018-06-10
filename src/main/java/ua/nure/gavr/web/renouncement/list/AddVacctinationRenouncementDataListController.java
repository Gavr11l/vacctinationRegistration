/**
 *
 */
package ua.nure.gavr.web.renouncement.list;

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
@RequestMapping(value = "/addvacrdatalist")
public class AddVacctinationRenouncementDataListController extends AbstractListController<AddVacctinationRenouncementDataListCommand, CalendarPlanWrapper> {

	private static final String VIEW_NAME = "addvacrdatalist";

	@Override
	protected AddVacctinationRenouncementDataListCommand createCommand() {
		return new AddVacctinationRenouncementDataListCommand();
	}

	@Override
	protected String getViewName() {
		return VIEW_NAME;
	}

	@Override
	protected List<CalendarPlanWrapper> getWrapperList(AddVacctinationRenouncementDataListCommand command,
			Institution institution) {
		return vacctinationService.findPlannedVacctinationsWithoutFaultAndRenouncement(
						institution.getIdInstitution(), getDateType(command), getVactinationTypes(command));
	}
}
