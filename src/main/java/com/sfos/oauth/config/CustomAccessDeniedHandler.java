package com.sfos.oauth.config;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sfos.oauth.base.GlobalConstant;
import com.sfos.oauth.base.ResponseResult;
import com.sfos.oauth.utils.ClientIpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 默认登录校验
 *
 * 校验内容报文头api-login：apiLogin
 */
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Value("${access.denied.url:/403}")
    String accessDeniedUrl = "/403";

    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response, AccessDeniedException e) throws IOException {
        //服务器地址
        String toUrl = ClientIpUtil.getFullRequestUrl(request);

        boolean isAjax = "XMLHttpRequest".equals(request
            .getHeader("X-Requested-With")) || "apiLogin".equals(request
            .getHeader("api-login"));
        if (isAjax) {
            response.setHeader("Content-Type", "application/json;charset=UTF-8");
            try {
                ResponseResult<Object> responseMessage = new ResponseResult<>();
                responseMessage.setStatus(GlobalConstant.ERROR_DENIED);
                responseMessage.setMessage(toUrl);
                ObjectMapper objectMapper = new ObjectMapper();
                JsonGenerator jsonGenerator = objectMapper.getFactory().createGenerator(response.getOutputStream(),
                    JsonEncoding.UTF8);
                objectMapper.writeValue(jsonGenerator, responseMessage);
            } catch (Exception ex) {
                throw new HttpMessageNotWritableException("Could not write JSON: " + ex.getMessage(), ex);
            }
        } else {
            response.sendRedirect(accessDeniedUrl);
        }
    }
}
