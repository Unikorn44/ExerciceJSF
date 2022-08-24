package fr.m2i.backed;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class RouteBean implements Serializable {
	
	@Inject
	@ManagedProperty(value="#{param.pageId}")
	private String pageId;
	
	private static final long serialVersionUID = 1L;
	
	public String page() {
		
		if(pageId.equals("index")) {
			
			return "index";
		}
		if(pageId.equals("login")) {
			
			return "login";
		}
		if(pageId.equals("about")) {
			
			return "about";
		}
		if(pageId.equals("admin")) {
			
			return "admin";
		}
		System.out.println("Nope");
		return "/about?faces-redirect=true";
	}

}
