package com.project.Api_spring.Exception;

import java.time.LocalDateTime;
import lombok.Getter;


@Getter 
public class ErroResponse {

    private LocalDateTime timestamp;
    private int status;
    private String erro;
    private String mensagem;
 

    public ErroResponse(int status , String erro , String mensagem, String caminho){
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.erro = erro;
        this.mensagem = mensagem;
        
    }   
        public LocalDateTime getTimestamp() { return timestamp; }
        public int getStatus() { return status; }
        public String getErro() { return erro; }
        public String getMensagem() { return mensagem; }
        
    }


    

