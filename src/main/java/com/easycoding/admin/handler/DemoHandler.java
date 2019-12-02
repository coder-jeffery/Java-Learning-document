package com.easycoding.admin.handler;

import java.lang.ref.WeakReference;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * @author chunming.jiang
 * @Description //TODO $
 * @date $ 2019/11/26$
 **/
public class DemoHandler<T> extends Handler {

    protected WeakReference<T> ref;

    public DemoHandler(T cla){
        ref = new WeakReference<T>(cla);
    }

    public T getRef(){
        return  ref!=null ? ref.get():null;
    }

    @Override
    public void publish(LogRecord record) {
    }

    @Override
    public void flush() {
    }

    @Override
    public void close() throws SecurityException {

    }
}
