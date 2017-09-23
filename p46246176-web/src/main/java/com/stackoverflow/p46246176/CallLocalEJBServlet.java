package com.stackoverflow.p46246176;


import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stackoverflow.p46246176.business.EjbOneLocal;
import com.stackoverflow.p46246176.business.EjbOneLocalHome;


public class CallLocalEJBServlet extends HttpServlet {

    private static final long serialVersionUID = -1164128954676291541L;
    
    private EjbOneLocalHome ejbOneLocalHome;
    
    @Override
    public void init() throws ServletException {
        try {
            Context initialContext = new InitialContext();
            ejbOneLocalHome = (EjbOneLocalHome) initialContext.lookup("java:comp/env/ejb/ejbOne");
        } catch (NamingException e) {
            throw new ServletException("Failed to lookup EjbOneLocalHome", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            EjbOneLocal ejbOneLocal = ejbOneLocalHome.create();
            resp.getWriter().write(ejbOneLocal.sayHello());
        } catch (javax.ejb.CreateException e) {
            throw new ServletException("Failed to create EjbOneLocal reference", e);
        }
    }
}
