/**
 *
 */
package ua.nure.gavr.web.addcalendarplandata;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.nure.gavr.data.CalendarPlanWrapper;
import ua.nure.gavr.model.Institution;
import ua.nure.gavr.model.PatientCalendarPlan;
import ua.nure.gavr.model.Vacctination;
import ua.nure.gavr.service.VacctinationService;
import ua.nure.gavr.web.abstractclasses.AbstractListController;

/**
 * @author gavr
 *
 */
@Controller
@RequestMapping("/addcpdata")
public class AddCalendarPlanDataController extends AbstractListController<AddCalendarPlanDataCommand, CalendarPlanWrapper>{
	private static final String COMMAND_NAME = "command";
	private static final String VIEW_NAME = "addcpdata";
	@Autowired
	private VacctinationService vacctinationService;
	@Autowired
	private AddCalendarPlanDataValidator validator;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		webDataBinder.addValidators(validator);
	}


	private void fillCommandData(AddCalendarPlanDataCommand command) {
		Institution institution = command.getInstitution();
		command.setPatientList(vacctinationService.findPatients(institution.getIdInstitution(), getYear(command)));
		command.setYearList(vacctinationService.findYear());

		List<CalendarPlanWrapper> calendarPlanWrapperList = vacctinationService
				.findPlannedVacctinationsCP(institution.getIdInstitution(),
						getVactinationTypes(command),
						getYear(command));
		command.setWrapperList(calendarPlanWrapperList);
		command.setVacctinationList2(getVactinationList2(command));
	}

	private Integer getYear(AddCalendarPlanDataCommand command) {
		return command.getYear();
	}

	private List<Vacctination> getVactinationList2(
			AddCalendarPlanDataCommand command) {
		List<Vacctination> retList = new ArrayList<Vacctination>();
		List<Integer> vacctinationIds = command.getVacctinationIds();
		if(vacctinationIds != null && !vacctinationIds.isEmpty()) {
			for (Vacctination vacctination : command.getVacctinationList()) {
				if(vacctinationIds.contains(vacctination.getIdVacctination())) {
					retList.add(vacctination);
				}
			}
		} else {
			retList.addAll(command.getVacctinationList());
		}
		return retList;
	}

	@Override
	@RequestMapping(method = RequestMethod.GET)
	public String handleGet(
			@ModelAttribute(COMMAND_NAME) AddCalendarPlanDataCommand command, BindingResult bindingResult) {
		fillCommandData(command);
		command.setVacctinationDate(new Date());
		if(command.getPcpid() != null) {
			PatientCalendarPlan calendarPlan = vacctinationService.findPatientCalendarPlan(command.getPcpid());
			if(calendarPlan !=null) {
				command.setPatientId(calendarPlan.getIdPatient());
				command.setVacctinationId(calendarPlan.getIdVacctination());
				command.setVacctinationDate(calendarPlan.getVacctinationDate());
				command.setEditMode(true);
			}
		}

		return VIEW_NAME;
	}

	@RequestMapping(method = RequestMethod.POST, params = {"action=back"})
	public String handleBack(@ModelAttribute(COMMAND_NAME) AddCalendarPlanDataCommand command) {
		return "redirect:mainform";
	}

	@RequestMapping(method = RequestMethod.POST, params = {"action=add"})
	public String handleAdd(HttpSession session, @Valid @ModelAttribute(COMMAND_NAME) AddCalendarPlanDataCommand command, BindingResult  bindingResult) {
		if(!bindingResult.hasErrors()) {
			PatientCalendarPlan patientCalendarPlan = new PatientCalendarPlan();

			patientCalendarPlan.setVacctinationDate(command.getVacctinationDate());
			patientCalendarPlan.setIdPatient(command.getPatientId());
			patientCalendarPlan.setIdVacctination(command.getVacctinationId());

			vacctinationService.savePatientCalendarPlan(patientCalendarPlan);
			command.setAddSuccessfull(Boolean.TRUE);

		}
		fillCommandData(command);
		return VIEW_NAME;
	}
	@RequestMapping(method = RequestMethod.POST, params = {"action=edit"})
	public String handleEdit(HttpSession session, @Valid @ModelAttribute(COMMAND_NAME) AddCalendarPlanDataCommand command, BindingResult  bindingResult) {
		if(!bindingResult.hasErrors()) {
			PatientCalendarPlan patientCalendarPlan = vacctinationService.findPatientCalendarPlan(command.getPcpid());

			patientCalendarPlan.setVacctinationDate(command.getVacctinationDate());
			patientCalendarPlan.setIdPatient(command.getPatientId());
			patientCalendarPlan.setIdVacctination(command.getVacctinationId());

			vacctinationService.updatePatientCalendarPlan(patientCalendarPlan);
			command.setAddSuccessfull(Boolean.TRUE);

		}
		fillCommandData(command);
		return VIEW_NAME;
	}


	@Override
	protected AddCalendarPlanDataCommand createCommand() {
		return new AddCalendarPlanDataCommand();
	}


	@Override
	protected String getViewName() {
		throw new IllegalAccessError("Method should not be invoked");
	}


	@Override
	protected List<CalendarPlanWrapper> getWrapperList(
			AddCalendarPlanDataCommand command, Institution institution) {
		throw new IllegalAccessError("Method should not be invoked");
	}
}
