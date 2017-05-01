package com.dipen.rest;

import com.dipen.model.MyDate;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

/**
 * Created by dipen on 5/1/2017.
 */
@Provider
public class MyDateConverterProvider implements ParamConverterProvider {
    @Override
    public <T> ParamConverter<T> getConverter(Class<T> aClass, Type type, Annotation[] annotations) {
        if(aClass.getName().equals(MyDate.class.getName()))
        {
            return new ParamConverter<T>() {
                @Override
                public T fromString(String s) {
                    Calendar requestedDate = Calendar.getInstance();

                    if(s.equals("tomorrow"))
                    {
                        requestedDate.add(Calendar.DATE,1);
                    }
                    else if(s.equals("yesterday"))
                    {
                        requestedDate.add(Calendar.DATE,-1);
                    }
                    MyDate myDate = new MyDate();
                    myDate.setDay(requestedDate.get(Calendar.DATE));
                    myDate.setMonth(requestedDate.get(Calendar.MONTH));
                    myDate.setYear(requestedDate.get(Calendar.YEAR));

                    return aClass.cast(myDate);
                }

                @Override
                public String toString(T t) {
                    if(t == null)
                        return null;

                    return  t.toString();
                }
            };
        }
        return null;
    }
}
