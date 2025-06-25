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
import in.co.loan.granting.system.dto.AssignBGVerificationDTO;
import in.co.loan.granting.system.dto.AssignLoanVerificationDTO;
import in.co.loan.granting.system.dto.UpdateLoanVerificationDTO;
import in.co.loan.granting.system.dto.UserDTO;
import in.co.loan.granting.system.exception.DuplicateRecordException;
import in.co.loan.granting.system.form.UpdateLoanVerificationForm;
import in.co.loan.granting.system.service.ApplyLoanServiceInt;
import in.co.loan.granting.system.service.AssignBGVerificationServiceInt;
import in.co.loan.granting.system.service.AssignLoanVerificationServiceInt;
import in.co.loan.granting.system.service.UpdateLoanVerificationServiceInt;
import in.co.loan.granting.system.service.UserServiceInt;
import in.co.loan.granting.system.util.DataUtility;




@Controller
@RequestMapping("/ctl/updateLoanVerification")
public class UpdateLoanVerificationCtl extends BaseCtl {

	@Autowired
	private UpdateLoanVerificationServiceInt service;
	
	@Autowired
	private ApplyLoanServiceInt applyLoanService;
	
	@Autowired
	private AssignLoanVerificationServiceInt assignLoanService;
	
	@Autowired
	private UserServiceInt userService;
	
	@ModelAttribute
	public void preload(Model model) {
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("Approved", "Approved");
		map2.put("Rejected", "Rejected");
		model.addAttribute("typestatusList", map2);
	}

	@GetMapping()
	public String display(@RequestParam(required = false) Long id, Long aId, @ModelAttribute("form") UpdateLoanVerificationForm form,
			HttpSession session, Model model) {
		if (form.getId() > 0) {
			UpdateLoanVerificationDTO bean = service.findBypk(id);
			form.populate(bean);
		}
		aId=DataUtility.getLong(String.valueOf(aId));
		if(aId>0) {
			session.setAttribute("aId", aId);
		}
		return "updateLoanVerification";
	}
	
	@PostMapping
	public String submit(@Valid @ModelAttribute("form") UpdateLoanVerificationForm form, BindingResult bindingResult,
			HttpSession session, Model model,HttpServletRequest request) {
		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/updateLoanVerification";
		}
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				
				if (bindingResult.hasErrors()) {
					return "updateLoanVerification";
				}
				UpdateLoanVerificationDTO bean = (UpdateLoanVerificationDTO) populateDTO(form.getDTO(),request);
				AssignLoanVerificationDTO lDto=assignLoanService.findBypk(DataUtility.getLong(String.valueOf(session.getAttribute("aId"))));
				bean.setLoanOfficerName(lDto.getLoanOfficerName());
				bean.setLoanOfficerId(lDto.getLoanOfficerId());
				bean.setLoan(lDto.getLoan());
				bean.setLoanRequestId(lDto.getLoanRequestId());
				bean.setLoanId(lDto.getLoanId());
				bean.setReport(form.getReport().getBytes());
				if (bean.getId() > 0) {
					service.update(bean);
					model.addAttribute("success", "Loan  Apply Successfully!!!!");
				} else {
					service.add(bean);
					model.addAttribute("success", "Loan Apply  Successfully!!!!");
				}
				ApplyLoanDTO apLoan=lDto.getLoan();
				apLoan.setStatus(bean.getStatus());
				applyLoanService.update(apLoan);
				return "updateLoanVerification";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "updateLoanVerification";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "updateLoanVerification";
	}

	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") UpdateLoanVerificationForm form,
			@RequestParam(required = false) String operation, Long hid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/updateLoanVerification/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} else if (OP_NEW.equals(operation)) {
			return "redirect:/ctl/updateLoanVerification";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					UpdateLoanVerificationDTO dto = new UpdateLoanVerificationDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		UpdateLoanVerificationDTO dto = (UpdateLoanVerificationDTO) form.getDTO();
			
		
		UserDTO uDto = (UserDTO) session.getAttribute("user");

		if (uDto.getRoleId() == 3) {
			dto.setLoanOfficerId(uDto.getId());
		}
		
		List<UpdateLoanVerificationDTO> list = service.search(dto, pageNo, pageSize);
		List<UpdateLoanVerificationDTO> totallist = service.search(dto);
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
		return "updateLoanVerificationList";
	}
	
	
	@GetMapping("/getFile")
	public void getStudentPhoto(HttpServletResponse response, @RequestParam long id) throws Exception {
		Blob blb=service.getFile(id);
		byte[] bytes = blb.getBytes(1, (int) blb.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	}
	

}
