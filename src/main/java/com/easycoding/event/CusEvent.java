package com.easycoding.event;

import java.util.EventObject;
/**
 * @author chunming.jiang
 * @Description //TODO $
 * @date $ 2019/11/27$
 **/
public class CusEvent extends EventObject {

    private static final long serialVersionUID = 1L;
    private Object source;

    public CusEvent(Object source){
        super(source);
        this.source = source;
    }

    public Object getSource(){
        return source;
    }

    public void setSource(Object source){
        this.source = source;
    }

}
