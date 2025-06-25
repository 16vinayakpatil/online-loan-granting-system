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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.loan.granting.system.dto.ApplyLoanDTO;
import in.co.loan.granting.system.dto.UserDTO;
import in.co.loan.granting.system.exception.DuplicateRecordException;
import in.co.loan.granting.system.form.ApplyLoanForm;
import in.co.loan.granting.system.service.ApplyLoanServiceInt;
import in.co.loan.granting.system.util.DataUtility;




@Controller
@RequestMapping("/ctl/applyLoan")
public class ApplyLoanCtl extends BaseCtl {

	@Autowired
	private ApplyLoanServiceInt service;
	
	@ModelAttribute
	public void preload(Model model) {
		
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("3 Month", "3 Month");
		map2.put("6 Month", "6 Month");
		map2.put("9 Month", "9 Month");
		map2.put("12 Month", "12 Month");
		map2.put("Other", "Other");
		model.addAttribute("emiOp", map2);
		
		HashMap<String, String> map3 = new HashMap<String, String>();
		map3.put("Approved", "Approved");
		map3.put("Rejected", "Rejected");
		model.addAttribute("typestatusList", map3);
		
		
	}

	@GetMapping()
	public String display(@RequestParam(required = false) Long id, Long pId, @ModelAttribute("form") ApplyLoanForm form,
			HttpSession session, Model model) {
		if (form.getId() > 0) {
			ApplyLoanDTO bean = service.findBypk(id);
			form.populate(bean);
		}
		return "applyLoan";
	}
	
	

	@PostMapping
	public String submit(@Valid @ModelAttribute("form") ApplyLoanForm form, BindingResult bindingResult,
			HttpSession session, Model model,HttpServletRequest request) {
		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/applyLoan";
		}
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				
				if (bindingResult.hasErrors()) {
					return "applyLoan";
				}
				
				ApplyLoanDTO bean = (ApplyLoanDTO) populateDTO(form.getDTO(),request);
				bean.setResume(form.getResume().getBytes());
				bean.setProjectPlan(form.getProjectPlan().getBytes());
				bean.setPersonalCreditReport(form.getPersonalCreditReport().getBytes());
				bean.setBusinessCreditReport(form.getBusinessCreditReport().getBytes());
				bean.setFinancialStatement(form.getFinancialStatement().getBytes());
				bean.setBankStatement(form.getBankStatement().getBytes());
				bean.setStatus(" While processing");
				bean.setDate(new Date());
				UserDTO uDto=(UserDTO)session.getAttribute("user");
				bean.setUserId(uDto.getId());
				bean.setRequestLoanId(DataUtility.getRandomInvoice());
				if (bean.getId() > 0) {
					service.update(bean);
					model.addAttribute("success", "Loan  Apply Successfully!!!!");
				} else {
					service.add(bean);
					model.addAttribute("success", "Loan Apply  Successfully!!!!");
				}
				return "applyLoan";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "applyLoan";
		} catch (IOException e) {
			model.addAttribute("error", e.getMessage());
			return "applyLoan";
		}
		return "applyLoan";
	}

	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") ApplyLoanForm form,
			@RequestParam(required = false) String operation, Long lid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/applyLoan/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} else if (OP_NEW.equals(operation)) {
			return "redirect:/ctl/applyLoan";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					ApplyLoanDTO dto = new ApplyLoanDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		ApplyLoanDTO dto = (ApplyLoanDTO) form.getDTO();
		lid=DataUtility.getLong(String.valueOf(lid));
		if(lid>0) {
			dto.setId(lid);
		}
		
		UserDTO uDto=(UserDTO)session.getAttribute("user");
		
		if(uDto.getRoleId()==2) {
			dto.setUserId(uDto.getId());
		}
		
		
		List<ApplyLoanDTO> list = service.search(dto, pageNo, pageSize);
		List<ApplyLoanDTO> totallist = service.search(dto);
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
		return "applyLoanList";
	}
	
	

	@GetMapping("/getFile")
	public void getStudentPhoto(HttpServletResponse response, @RequestParam long id,String fieldName) throws Exception {
		Blob blb=service.getFile(id, fieldName);
		byte[] bytes = blb.getBytes(1, (int) blb.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	}
	

}
