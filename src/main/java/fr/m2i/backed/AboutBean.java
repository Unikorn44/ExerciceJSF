package fr.m2i.backed;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AboutBean {

	//injection LoginBean via service 
	@Inject
	private LoginBean lb;
	
	private String message = "You haz in a secret page !";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String pageAbout() {
		return "/pages/about?faces-redirect=true";
	}
	
	//utilisation injection 
	public String afficheNom() {
		return "Bienvenue" + lb.getLogin();
	}
	
}
