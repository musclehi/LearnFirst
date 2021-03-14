package com.vivo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 容器bean获取工具
 * 注意了, 这个工具使用的时候还是要注入到容器的, 不要范基本错误
 */
public class SpringBeanUtil implements ApplicationContextAware {
	private static ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		synchronized (SpringBeanUtil.class) {
			if (null == SpringBeanUtil.context) {
				SpringBeanUtil.context = context;
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		return (T) context.getBean(name);
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name, Object... arg1) {
		return (T) context.getBean(name, arg1);
	}

	public static <T> T getBean(Class<T> clazz) {
		return context.getBean(clazz);
	}

	public static <T> T getBean(String name, Class<T> clazz) {
		return context.getBean(name, clazz);
	}
}
