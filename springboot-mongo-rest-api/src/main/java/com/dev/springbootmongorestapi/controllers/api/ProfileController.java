package com.dev.springbootmongorestapi.controllers.api;

import com.dev.springbootmongorestapi.controllers.urls.ProfileURL;
import com.dev.springbootmongorestapi.dtos.ProfileDTO;
import com.dev.springbootmongorestapi.entities.Profile;
import com.dev.springbootmongorestapi.exceptions.CustomErrorException;
import com.dev.springbootmongorestapi.exceptions.ValidationCode;
import com.dev.springbootmongorestapi.mappers.IProfileMapper;
import com.dev.springbootmongorestapi.responses.ErrorResponse;
import com.dev.springbootmongorestapi.responses.HandlerResponse;
import com.dev.springbootmongorestapi.services.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

@CrossOrigin
@RestController
@ControllerAdvice
@RequestMapping(value = ProfileURL.ORG_URL)
public class ProfileController {

    @Autowired
    @Qualifier("profileServiceImpl")
    private IProfileService iProfileService;

    @Autowired
    @Qualifier("profileMapperImpl")
    private IProfileMapper iProfileMapper;


    @GetMapping
    public ResponseEntity<Object> viewAll(){
        try{
            List<Profile> list = this.iProfileService.all();
            List<ProfileDTO> listDto = this.iProfileMapper.convertFromListProfileToListProfileDto(list);
            return HandlerResponse.generateResponse(HttpStatus.FOUND, ValidationCode.FOUND.getCodeNumber(100),"Success",listDto);
        }catch (CustomErrorException e){
             handleNullPointerExceptions(e);
        }
        return null;
    }

    @PostMapping(value = ProfileURL.ADD_URL)
    public ResponseEntity<Object> create(@RequestBody ProfileDTO profileDTO){
        try {
            Profile profile = this.iProfileMapper.convertFromProfileDtoToProfile(profileDTO);
            Profile profileResult = this.iProfileService.save(profile);
            return HandlerResponse.generateResponse(HttpStatus.CREATED,ValidationCode.CREATED.getCodeNumber(200),"Success",profileResult);
        }catch (CustomErrorException e){
            handleExceptions(e);
        }
        return null;
    }


    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleNullPointerExceptions(Exception ex){
        HttpStatus status = HttpStatus.NOT_FOUND; // 404
        return new ResponseEntity<>(new ErrorResponse(status,ex.getMessage()),status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleExceptions(Exception exc){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 500
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        exc.printStackTrace();
        String stackTrace = printWriter.toString();
        return new ResponseEntity<>(new ErrorResponse(status,exc.getMessage(),stackTrace),status);
    }

    @ExceptionHandler(CustomErrorException.class)
    public ResponseEntity<ErrorResponse> handleCustomErrorExceptions(Exception e) {
        // casting the generic Exception e to CustomErrorException
        CustomErrorException customErrorException = (CustomErrorException) e;

        HttpStatus status = customErrorException.getStatus();

        // converting the stack trace to String
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        customErrorException.printStackTrace(printWriter);
        String stackTrace = stringWriter.toString();

        return new ResponseEntity<>(
                new ErrorResponse(
                        status,
                        customErrorException.getMessage(),
                        stackTrace,
                        customErrorException.getData()
                ),
                status
        );
    }
}
