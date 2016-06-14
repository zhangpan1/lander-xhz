package com.eversec.xhz.listener;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * frame:事件源。发生事件的对象
 * WindowListener:监听器。（对应着事件源的某些内容）
 * WindowEvent:事件对象。封装事件源（getSource）
 * @author zhangp
 *
 */
public class FrameDemo {
	public static void main(String[] args) {
		Frame f = new Frame("我的小窗");
		f.setSize(400, 300);
		f.addWindowListener(new WindowAdapter(){//注册具体的监听器

			@Override
			public void windowClosing(WindowEvent e) {
			Frame f1 =(Frame)e.getSource();//
			f1.dispose();
			}
			
		});
		f.setVisible(true);
		
	}
}
