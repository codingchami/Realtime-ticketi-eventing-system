//package com.iitcw.TicketingSystem.Advisor;
//
//import org.springframework.data.crossstore.ChangeSetPersister;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//public class ExceptionHandler {
//    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<StandardResponse> notFoundExceptionHandler(ChangeSetPersister.NotFoundException e){
//        return new ResponseEntity<StandardResponse>(
//                new StandardResponse(404,"Error Occured",e.getMessage()), HttpStatus.NOT_FOUND
//        );
//    }
//}
