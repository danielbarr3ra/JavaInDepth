package com.semanticsquare.jvm;

import java.lang.reflect.Method;

public class SimpleUnitTester {
    
    public int execute(Class clazz) throws Exception {
        int failedCount = 0;
        
        // your code
        Object object = null;
        object = clazz.newInstance();
        for (Method m : clazz.getDeclaredMethods()) {
        	if (m.toString().startsWith("test") || m.getReturnType() == boolean.class) {
        		Object result = m.invoke(object);
        		if (((Boolean)result) == false) {
        			failedCount ++;
        		}
        	}
        }
        
        return failedCount;
    }
    
}