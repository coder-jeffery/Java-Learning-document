package com.easycoding.demo.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
/**
 * @author chunming.jiang
 * @Description //TODO $
 * @date $ 2019/11/26$
 **/
@Component
public class ListenerDemo implements ApplicationListener<EventDemo> {

    @Override
    public void onApplicationEvent(EventDemo eventDemo){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("收到了：" + eventDemo.getSource() + "消息;时间：" + eventDemo.getTimestamp());
        System.out.println("消息：" + eventDemo.getId() + ":" + eventDemo.getMessage());
    }
}
