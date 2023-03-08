package com.dev.springbootmongorestapi.responses;

import com.dev.springbootmongorestapi.exceptions.CustomErrorException;
import com.dev.springbootmongorestapi.exceptions.ProfileException;
import com.dev.springbootmongorestapi.exceptions.ValidationCode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandlerResponse {
    public static ResponseEntity<Object> generateResponse(HttpStatus status ,int statusNumber , String message, Object obj) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("timestamp", new Date());
            map.put("status", status.value());
            map.put("success", statusNumber);
            map.put("message", message);
            map.put("data", obj);
            return new ResponseEntity<>(map,status);
        } catch (CustomErrorException e) {
            map.put("timestamp", new Date());
            map.put("status", status.value());
            map.put("success", statusNumber);
            map.put("message", e.getMessage());
            map.put("data", null);
            throw new ProfileException(e.getMessage(),null);
        }
    }

    public static ResponseEntity<Object> generateResponse(HttpStatus status,HttpHeaders headers  ,int statusNumber , String message, Object obj) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("timestamp", new Date());
            map.put("status", status.value());
            map.put("success", statusNumber);
            map.put("message", message);
            map.put("data", obj);
            headers.add(String.valueOf(new GenericInfo<String>()), String.valueOf(new GenericInfo<String>()));
            return ResponseEntity.accepted().headers(headers).body(obj);
        } catch (CustomErrorException e) {
            map.put("timestamp", new Date());
            map.put("status", status.value());
            map.put("success", statusNumber);
            map.put("message", e.getMessage());
            map.put("data", null);
            throw new ProfileException(e.getMessage(),null);
        }
    }




   /* public static ResponseEntity<Object> generateResponse(HttpStatus status , int statusNumber , String message, List<Object> objs) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("timestamp", new Date());
            map.put("status", status.value());
            map.put("success", statusNumber);
            map.put("message", message);
            map.put("data", objs);
        } catch (CustomErrorException e) {
            throw new ProfileException(e.getMessage(),ValidationCode.CREATE_FAILED);
        }
        return new ResponseEntity<Object>(map, status);
    }*/

}
