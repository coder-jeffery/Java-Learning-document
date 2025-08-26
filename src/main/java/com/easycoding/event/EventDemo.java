package com.easycoding.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;
/**
 * @author chunming.jiang
 * @Description //TODO $
 * @date $ 2019/11/26$
 **/
@Data
public class EventDemo extends ApplicationEvent {

    private Long id;
    private String message;

    public EventDemo(Object source, Long id, String message) {
        super(source);
        this.id = id;
        this.message = message;
    }
}
