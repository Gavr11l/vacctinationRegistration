/**
 *
 */
package ua.nure.gavr.web.result.list;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.nure.gavr.data.DateType;
import ua.nure.gavr.data.VacctinationWrapper;
import ua.nure.gavr.model.Institution;
import ua.nure.gavr.rtf.InstitutionReport;
import ua.nure.gavr.web.abstractclasses.AbstractListController;

/**
 * @author gavr
 *
 */

@Controller
@RequestMapping(value = "/vacrep")
public class AddVacctinationResultDataListReportController extends AbstractListController<AddVacctinationResultDataListCommand, VacctinationWrapper> {

	private static final String VIEW_NAME = "vacrep";

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

	@RequestMapping(method = RequestMethod.GET,  params = {"action=report"})
	public void handleGet(HttpServletResponse response,
			@ModelAttribute(COMMAND_NAME) AddVacctinationResultDataListCommand command, BindingResult bindingResult) throws IOException {
		Institution institution = command.getInstitution();
		command.setWrapperList(getWrapperList(command, institution));
		response.setContentType("text/rtf");
		response.setHeader("Content-Disposition", "attachment;filename=rtfAtestado.rtf");

		InstitutionReport.instanceOf(messageSource, command.getMedEmployee(), institution, command.getWrapperList(),
				DateType.parse(command.getDateType())).buildReport(response.getWriter());

	}



}
