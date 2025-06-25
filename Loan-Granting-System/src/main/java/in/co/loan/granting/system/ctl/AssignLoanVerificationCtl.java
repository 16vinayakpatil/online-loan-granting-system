package in.co.loan.granting.system.ctl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.loan.granting.system.dto.ApplyLoanDTO;
import in.co.loan.granting.system.dto.AssignLoanVerificationDTO;
import in.co.loan.granting.system.dto.UserDTO;
import in.co.loan.granting.system.exception.DuplicateRecordException;
import in.co.loan.granting.system.form.AssignLoanVerificationForm;
import in.co.loan.granting.system.service.ApplyLoanServiceInt;
import in.co.loan.granting.system.service.AssignLoanVerificationServiceInt;
import in.co.loan.granting.system.service.UserServiceInt;




@Controller
@RequestMapping("/ctl/assignLoanVerification")
public class AssignLoanVerificationCtl extends BaseCtl {

	@Autowired
	private AssignLoanVerificationServiceInt service;
	
	@Autowired
	private ApplyLoanServiceInt applyLoanService;
	
	@Autowired
	private UserServiceInt userService;
	
	@ModelAttribute
	public void preload(Model model) {
		model.addAttribute("loanList", applyLoanService.list());
		UserDTO dto=new UserDTO();
		dto.setRoleId(3L);
		model.addAttribute("loanOfList",userService.search(dto));
	}

	@GetMapping()
	public String display(@RequestParam(required = false) Long id, Long pId, @ModelAttribute("form") AssignLoanVerificationForm form,
			HttpSession session, Model model) {
		if (form.getId() > 0) {
			AssignLoanVerificationDTO bean = service.findBypk(id);
			form.populate(bean);
		}
		return "assignLoanVerification";
	}
	
	@PostMapping
	public String submit(@Valid @ModelAttribute("form") AssignLoanVerificationForm form, BindingResult bindingResult,
			HttpSession session, Model model,HttpServletRequest request) {
		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/assignLoanVerification";
		}
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				
				if (bindingResult.hasErrors()) {
					return "assignLoanVerification";
				}
				AssignLoanVerificationDTO bean = (AssignLoanVerificationDTO) populateDTO(form.getDTO(),request);
				ApplyLoanDTO lDto=applyLoanService.findBypk(bean.getLoanId());
				UserDTO uDto=userService.findBypk(bean.getLoanOfficerId());
				bean.setLoanOfficerName(uDto.getFirstName()+" "+uDto.getLastName());
				bean.setLoanOfficer(uDto);
				bean.setLoan(lDto);
				bean.setLoanRequestId(lDto.getRequestLoanId());
				if (bean.getId() > 0) {
					service.update(bean);
					model.addAttribute("success", "Loan  Apply Successfully!!!!");
				} else {
					service.add(bean);
					model.addAttribute("success", "Loan Apply  Successfully!!!!");
				}
				lDto.setStatus("Assigned to Loan verification");
				applyLoanService.update(lDto);
				return "assignLoanVerification";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "assignLoanVerification";
		} 
		return "assignLoanVerification";
	}

	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") AssignLoanVerificationForm form,
			@RequestParam(required = false) String operation, Long hid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/assignLoanVerification/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} else if (OP_NEW.equals(operation)) {
			return "redirect:/ctl/assignLoanVerification";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					AssignLoanVerificationDTO dto = new AssignLoanVerificationDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		AssignLoanVerificationDTO dto = (AssignLoanVerificationDTO) form.getDTO();
			
		UserDTO uDto = (UserDTO) session.getAttribute("user");

		if (uDto.getRoleId() == 3) {
			dto.setLoanOfficerId(uDto.getId());
		}
		
		List<AssignLoanVerificationDTO> list = service.search(dto, pageNo, pageSize);
		List<AssignLoanVerificationDTO> totallist = service.search(dto);
		model.addAttribute("list", list);

		if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation)) {
			model.addAttribute("error", "Record not found");
		}

		int listsize = list.size();
		int total = totallist.size();
		int pageNoPageSize = pageNo * pageSize;

		form.setPageNo(pageNo);
		form.setPageSize(pageSize);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("listsize", listsize);
		model.addAttribute("total", total);
		model.addAttribute("pagenosize", pageNoPageSize);
		model.addAttribute("form", form);
		return "assignLoanVerificationList";
	}
	

}
