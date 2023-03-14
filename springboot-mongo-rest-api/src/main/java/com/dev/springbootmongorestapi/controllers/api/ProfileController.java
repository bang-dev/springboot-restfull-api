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
import io.swagger.annotations.*;
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
@Api(value = "ProfileController", description = "Operations pertaining to Profile Controller")
public class ProfileController {

    @Autowired
    @Qualifier("profileServiceImpl")
    private IProfileService iProfileService;

    @Autowired
    @Qualifier("profileMapperImpl")
    private IProfileMapper iProfileMapper;


    @ApiOperation(value = "Returns all profile", notes = "This endpoint returns a profile info",response = String.class)
    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Bearer access token", required = true, paramType = "header"),
            @ApiImplicitParam(name = "X-Client-ID", value = "Client ID", required = true, paramType = "header")
    })
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

    @ApiOperation(value = "Returns a new profile", notes = "This endpoint returns a greeting message to new profile.",response = String.class)
    @PostMapping(value = ProfileURL.ADD_URL)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found")
    })
   /* @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved user"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })*/
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Bearer access token", required = true, paramType = "header"),
            @ApiImplicitParam(name = "X-Client-ID", value = "Client ID", required = true, paramType = "header")
    })
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
