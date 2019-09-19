package restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bean.LoginBean;
import service.LoginDao;

@RestController
@RequestMapping("/loginresource")

public class LoginRestController {

	@Autowired
	LoginDao logindao;

	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public String insert(@RequestBody LoginBean login) {
		String status=logindao.LoginRepository(login);
		return status;
	}
}