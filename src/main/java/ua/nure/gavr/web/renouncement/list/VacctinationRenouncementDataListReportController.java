/**
 *
 */
package ua.nure.gavr.web.renouncement.list;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.nure.gavr.data.DateType;
import ua.nure.gavr.data.RenouncementWrapper;
import ua.nure.gavr.model.Institution;
import ua.nure.gavr.rtf.RenouncementReport;
import ua.nure.gavr.web.abstractclasses.AbstractListController;

/**
 * @author gavr
 *
 */
@Controller
@RequestMapping(value = "/renrep")
public class VacctinationRenouncementDataListReportController extends AbstractListController<VacctinationRenouncementDataListReportCommand, RenouncementWrapper> {

	private static final String VIEW_NAME = "renrep";

	@Override
	protected String getViewName() {
		return VIEW_NAME;
	}

	@Override
	protected List<RenouncementWrapper> getWrapperList(VacctinationRenouncementDataListReportCommand command, Institution institution) {
		return vacctinationService.findRecouncementVacctination(institution.getIdInstitution(), getDateType(command), getVactinationTypes(command));
	}

	@Override
	protected VacctinationRenouncementDataListReportCommand createCommand() {
		return new VacctinationRenouncementDataListReportCommand();
	}

	@RequestMapping(method = RequestMethod.GET,  params = {"action=report"})
	public void handleGet(HttpServletResponse response,
			@ModelAttribute(COMMAND_NAME) VacctinationRenouncementDataListReportCommand command, BindingResult bindingResult) throws IOException {
		Institution institution = command.getInstitution();
		command.setWrapperList(getWrapperList(command, institution));
		response.setContentType("text/rtf");
		response.setHeader("Content-Disposition", "attachment;filename=rtfAtestado.rtf");

		RenouncementReport.instanceOf(messageSource, command.getMedEmployee(), institution, command.getWrapperList(),
				DateType.parse(command.getDateType())).buildReport(response.getWriter());

	}
}
