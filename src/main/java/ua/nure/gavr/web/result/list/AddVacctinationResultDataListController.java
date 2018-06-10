/**
 *
 */
package ua.nure.gavr.web.result.list;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.nure.gavr.data.VacctinationWrapper;
import ua.nure.gavr.model.Institution;
import ua.nure.gavr.web.abstractclasses.AbstractListController;

/**
 * @author gavr
 *
 */

@Controller
@RequestMapping(value = "/addvacresdatalist")
public class AddVacctinationResultDataListController extends AbstractListController<AddVacctinationResultDataListCommand, VacctinationWrapper> {

	private static final String VIEW_NAME = "addvacresdatalist";

	@Override
	protected AddVacctinationResultDataListCommand createCommand() {
		return new AddVacctinationResultDataListCommand();
	}

	@Override
	protected String getViewName() {
		return VIEW_NAME;
	}

	@Override
	protected List<VacctinationWrapper> getWrapperList(
			AddVacctinationResultDataListCommand command,
			Institution institution) {
		return vacctinationService.findVacctination(
				institution.getIdInstitution(), getDateType(command),
				getVactinationTypes(command));
	}



}
