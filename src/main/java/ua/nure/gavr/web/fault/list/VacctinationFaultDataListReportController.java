/**
 *
 */
package ua.nure.gavr.web.fault.list;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.nure.gavr.data.DateType;
import ua.nure.gavr.data.FaultWrapper;
import ua.nure.gavr.model.Institution;
import ua.nure.gavr.rtf.FaultReport;
import ua.nure.gavr.web.abstractclasses.AbstractListController;

/**
 * @author gavr
 *
 */
@Controller
@RequestMapping(value = "/falrep")
public class VacctinationFaultDataListReportController extends AbstractListController<VacctinationFaultDataListReportCommand, FaultWrapper>{

	private static final String VIEW_NAME = "falrep";


	@Override
	protected String getViewName() {
		return VIEW_NAME;
	}

	@Override
	protected List<FaultWrapper> getWrapperList(
			VacctinationFaultDataListReportCommand command, Institution institution) {
		return vacctinationService.findFaultVacctination(institution.getIdInstitution(), getDateType(command), getVactinationTypes(command));
	}

	@Override
	protected VacctinationFaultDataListReportCommand createCommand() {
		return new VacctinationFaultDataListReportCommand();
	}

	@RequestMapping(method = RequestMethod.GET,  params = {"action=report"})
	public void handleGet(HttpServletResponse response,
			@ModelAttribute(COMMAND_NAME) VacctinationFaultDataListReportCommand command, BindingResult bindingResult) throws IOException {
		Institution institution = command.getInstitution();
		command.setWrapperList(getWrapperList(command, institution));
		response.setContentType("text/rtf");
		response.setHeader("Content-Disposition", "attachment;filename=rtfAtestado.rtf");

		FaultReport.instanceOf(messageSource, command.getMedEmployee(), institution, command.getWrapperList(),
				DateType.parse(command.getDateType())).buildReport(response.getWriter());

	}


}
