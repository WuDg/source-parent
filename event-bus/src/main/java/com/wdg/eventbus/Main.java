package com.wdg.eventbus;

import org.greenrobot.eventbus.EventBus;

/**
 * @author wu diguang
 */
public class Main {

    public static void main(String[] args) {
        MessageEvent event = new MessageEvent("Hello World~~~");
        EventBus.getDefault().register(event);
        EventBus.getDefault().post(event);
        EventBus.getDefault().unregister(event);
    }
}