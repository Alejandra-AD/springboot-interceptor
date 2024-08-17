package com.curso.springboot.app.interceptor.springboot_interceptor.interceptors;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component("timeInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);

     @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
                logger.info("Entrando interceptor preHandle...." + " " + ((HandlerMethod) handler).getMethod().getName());
                long start = System.currentTimeMillis();
                request.setAttribute("start",start);

                /* 
                Map <String, String> json  = new HashMap();
                json.put("error", "no tiene acceso a este recurso.");
                json.put("date", new Date().toString());

                ObjectMapper mapper = new ObjectMapper();
                String jsonString = mapper.writeValueAsString(json);
                //siempre que se requiera devolver en la respuesta una estructura json se utiliza el "aplication/json"
                response.setContentType("application/json");
                response.setStatus(401);
                response.getWriter().write(jsonString);

                return false;*/

                return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
                HandlerMethod handlerController = (HandlerMethod) handler;
                long end = System.currentTimeMillis();
                long start = (long) request.getAttribute("start");
                long result = end - start;

                logger.info("Saliendo interceptor postHandle...." + " " + handlerController.getMethod().getName()) ;
                logger.info("el tiempo transcurrido es de "+ result + " milisegundos");

    }

   
    

}
