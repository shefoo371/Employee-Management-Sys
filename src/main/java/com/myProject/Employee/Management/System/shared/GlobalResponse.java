package com.myProject.Employee.Management.System.shared;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GlobalResponse<T> {
   public final static String SUCCESS = "success";
   public final static String ERROR = "error";

   private final String status;
   private final T data;
   private final List<ErrorRecord> errors;

   public record ErrorRecord(String message){}

    public GlobalResponse( T data) {
       this.data = data;
       this.status = "success";
       this.errors = null;
    }

    public GlobalResponse(List<ErrorRecord> errors) {
       this.status = ERROR;
       this.errors = errors;
       this.data = null;
    }
}


