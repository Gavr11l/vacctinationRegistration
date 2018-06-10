/**
 *
 */
package ua.nure.gavr.web.abstractclasses;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.nure.gavr.data.DateType;
import ua.nure.gavr.model.Institution;
import ua.nure.gavr.model.Vacctination;
import ua.nure.gavr.service.VacctinationService;
import ua.nure.gavr.web.SessionHelper;

/**
 * @author gavr
 *
 */
public abstract class AbstractListController<T extends AbstractVacctinationListCommand<L>, L> {

	protected static final String COMMAND_NAME = "command";

	@Autowired
	protected VacctinationService vacctinationService;
	@Autowired
	protected MessageSource messageSource;

	@ModelAttribute(COMMAND_NAME)
	public T createCommand(HttpSession session) {
		T command = createCommand();
		SessionHelper.fillCommand(session, command);

		List<Vacctination> vacctinationList = vacctinationService.findVaccinations();
		command.setVacctinationList(vacctinationList);
		List<String> dateTypeCodes = new ArrayList<String>();
		for (DateType dateType  : DateType.values()) {
			dateTypeCodes.add(dateType.name());
		}
		command.setDateTypeCodes(dateTypeCodes);

		return command;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String handleGet(@ModelAttribute(COMMAND_NAME) T command, BindingResult bindingResult) {
		Institution institution = command.getInstitution();
		command.setWrapperList(getWrapperList(command, institution));
		return getViewName();
	}

	protected abstract String getViewName();

	protected abstract List<L> getWrapperList(T command, Institution institution);

	protected abstract T createCommand();


	protected List<Integer> getVactinationTypes(T command) {
		List<Integer> retList = new ArrayList<Integer>();
		List<Integer> vacctinationIds = command.getVacctinationIds();
		if(vacctinationIds != null && !vacctinationIds.isEmpty()) {
			retList.addAll(vacctinationIds);
		} else {
			retList.addAll(command.getVacctinationList().stream()
					.map(m -> m.getIdVacctination()).collect(Collectors.toList()));
		}
		return retList;
	}


	protected DateType getDateType(T command) {
		if(StringUtils.hasLength(command.getDateType())) {
			return DateType.valueOf(command.getDateType());
		}
		return DateType.CURRENT_YEAR;
	}

}
