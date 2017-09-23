package com.stackoverflow.p46246176.business;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

public interface EjbTwoLocalHome extends EJBLocalHome {

    EjbTwoLocal create() throws CreateException;
    
}
