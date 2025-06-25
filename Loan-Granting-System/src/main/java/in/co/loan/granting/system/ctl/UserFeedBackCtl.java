package in.co.loan.granting.system.ctl;

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

import in.co.loan.granting.system.dto.FeedBackDTO;
import in.co.loan.granting.system.dto.UserFeedBackDTO;
import in.co.loan.granting.system.exception.DuplicateRecordException;
import in.co.loan.granting.system.form.UserFeedBackForm;
import in.co.loan.granting.system.service.FeedBackServiceInt;
import in.co.loan.granting.system.service.UserFeedBackServiceInt;
import in.co.loan.granting.system.util.DataUtility;




@Controller
@RequestMapping("/ctl/userFeedBack")
public class UserFeedBackCtl extends BaseCtl {

	@Autowired
	private UserFeedBackServiceInt service;
	
	@Autowired
	private FeedBackServiceInt feedBackService;
	
	@ModelAttribute
	public void preload(Model model) {
	}

	@GetMapping()
	public String display(@RequestParam(required = false) Long id, Long fId, @ModelAttribute("form") UserFeedBackForm form,
			HttpSession session, Model model) {
		if (form.getId() > 0) {
			UserFeedBackDTO bean = service.findBypk(id);
			form.populate(bean);
		}
		fId=DataUtility.getLong(String.valueOf(fId));
		if(fId>0) {
			session.setAttribute("fId", fId);
		}else {
			return"redirect:/ctl/feedBack/search";
		}
		return "userFeedBack";
	}
	

	@PostMapping
	public String submit(@Valid @ModelAttribute("form") UserFeedBackForm form, BindingResult bindingResult,
			HttpSession session, Model model,HttpServletRequest request) {
		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/userFeedBack";
		}
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				if (bindingResult.hasErrors()) {
					return "UserFeedBack";
				}
				UserFeedBackDTO bean = (UserFeedBackDTO) populateDTO(form.getDTO(),request);
				FeedBackDTO fDto=feedBackService.findBypk(DataUtility.getLong(String.valueOf(session.getAttribute("fId"))));
				bean.setQuestion(fDto.getQuestion());
				if (bean.getId() > 0) {
					service.update(bean);
					model.addAttribute("success", "UserFeedBack update Successfully!!!!");
				} else {
					service.add(bean);
					model.addAttribute("success", "UserFeedBack Added Successfully!!!!");
				}
				return "userFeedBack";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "userFeedBack";
		}
		return "";
	}

	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") UserFeedBackForm form,
			@RequestParam(required = false) String operation, Long hid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/userFeedBack/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} else if (OP_NEW.equals(operation)) {
			return "redirect:/ctl/UserFeedBack";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					UserFeedBackDTO dto = new UserFeedBackDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		UserFeedBackDTO dto = (UserFeedBackDTO) form.getDTO();
			hid=DataUtility.getLong(String.valueOf(hid));
			
		List<UserFeedBackDTO> list = service.search(dto, pageNo, pageSize);
		List<UserFeedBackDTO> totallist = service.search(dto);
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
		return "userFeedBackList";
	}
	

}
