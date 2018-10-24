package com.message;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;

import javax.ejb.Stateless;

@Stateless
public class IndexAction extends ActionSupport {

    @Action("/")
    public String execute() throws Exception {
        return SUCCESS;
    }
}
