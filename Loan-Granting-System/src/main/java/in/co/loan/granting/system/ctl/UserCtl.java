package in.co.loan.granting.system.ctl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

import in.co.loan.granting.system.dto.UserDTO;
import in.co.loan.granting.system.exception.DuplicateRecordException;
import in.co.loan.granting.system.form.OfficerForm;
import in.co.loan.granting.system.form.UserForm;
import in.co.loan.granting.system.service.UserServiceInt;
import in.co.loan.granting.system.util.DataUtility;




@Controller
@RequestMapping("/ctl/user")
public class UserCtl extends BaseCtl {

	@Autowired
	private UserServiceInt service;
	
	@ModelAttribute
	public void preload(Model model) {
	}

	@GetMapping()
	public String display(@RequestParam(required = false) Long id, Long pId, @ModelAttribute("form") UserForm form,
			HttpSession session, Model model) {
		if (form.getId() > 0) {
			UserDTO bean = service.findBypk(id);
			form.populate(bean);
		}
		return "user";
	}
	
	
	@GetMapping("/status")
	public String updateStatus(@RequestParam(required = false) Long id, String status,
			@ModelAttribute("form") OfficerForm form, HttpSession session, Model model) {
		try {
			id = DataUtility.getLong(String.valueOf(id));
			if (id > 0) {
				UserDTO dto = service.findBypk(id);
				dto.setStatus(status);
				service.update(dto);
			}
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}
		return "redirect:/ctl/user/search";
	}
	

	@PostMapping
	public String submit(@Valid @ModelAttribute("form") UserForm form, BindingResult bindingResult,
			HttpSession session, Model model,HttpServletRequest request) {
		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/user";
		}
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				if (bindingResult.hasErrors()) {
					return "user";
				}
				UserDTO bean = (UserDTO) populateDTO(form.getDTO(),request);
				if (bean.getId() > 0) {
					service.update(bean);
					model.addAttribute("success", "User update Successfully!!!!");
				} else {
					service.add(bean);
					model.addAttribute("success", "User Added Successfully!!!!");
				}
				return "user";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "user";
		}
		return "";
	}

	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") UserForm form,
			@RequestParam(required = false) String operation, Long hid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/user/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} else if (OP_NEW.equals(operation)) {
			return "redirect:/ctl/user";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					UserDTO dto = new UserDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		UserDTO dto = (UserDTO) form.getDTO();
			dto.setRoleId(2L);
			
		List<UserDTO> list = service.search(dto, pageNo, pageSize);
		List<UserDTO> totallist = service.search(dto);
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
		return "userList";
	}
	

}
