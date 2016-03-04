package com.github.vlsidlyarevich.JSFSpringSecXML.web.controller;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.Serializable;


@ManagedBean
@RequestScoped
public class AuthentificationBean implements Serializable {


    public String doLogin() throws IOException,ServletException{

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/j_spring_security_check");
        dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
        FacesContext.getCurrentInstance().responseComplete();
        return null;
    }

    public String doLogout(){

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/pages/logout.xhtml";
    }

    public void redirect(String url) throws IOException {
        ExternalContext ctx = FacesContext.getCurrentInstance()
                .getExternalContext();
        if (url.startsWith("http://") || url.startsWith("https://")
                || url.startsWith("/")) {
            ctx.redirect(url);
        } else {
            ctx.redirect(ctx.getRequestContextPath() + "/" + url);
        }
    }

}
