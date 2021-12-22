package com.wdg.pattern.structure.decorator;

/**
 *  @Description 构件装饰类：抽象装饰类
 *  
 *  @author wudiguang
 *  @Date 2021/12/2
 */ 
public class ComponentDecorator extends Component{
    private Component component;
    public ComponentDecorator(Component component){
        this.component = component;
    }
    @Override
    public void display() {
        component.display();
    }
}
