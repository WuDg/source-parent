package com.wdg.eventbus;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * @author wu diguang
 */
public class MessageEvent {

    private String message;

    public MessageEvent(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    @Override
    public String toString() {
        return "MessageEvent{" +
                "message='" + message + '\'' +
                '}';
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent1(MessageEvent event) {
        System.out.println("Event1: " + event);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent2(MessageEvent event) {
        System.out.println("Event2: " + event);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent3(MessageEvent event) {
        System.out.println("Event3: " + event);
    }
}
