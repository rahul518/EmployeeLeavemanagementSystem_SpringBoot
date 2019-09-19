package interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import bean.LoginBean;

public interface LoginInterface extends JpaRepository<LoginBean, String> {
}