package br.ifba.ads.inter.game.validation;



public class ValidadorCadastro {
    
public String confirmaERRO(String login, String senha, String confirma, String frase, boolean confirmacao){

   if(campoVazioLogin(login)==true){
   return "Campo Login vazio!";
   }
   
   else if (confirmacao){
   return "LOGIN JÁ CADATRADO!";
   }
   
   else if(campoVazioSenha(senha)==true){
   return "Campo Senha vazio!";
   }     
   
   else if(tamanhoMax(senha)==true){
   return "Senha muito grande! MAX 6";
   }
   
   else if(tamanhoMin(senha)==true){
   return "Senha muito pequena! MIN 4";
   }
   
   else if(campoVazioConfirmacao(confirma)==true){
   return "Campo Confirmar Senha vazio!";
   }
           
   else if(confereSenhas(senha, confirma) == true)
   {
   return "Senhas não conferem!";
   }
   
   else if(campoVazioFrase(frase)==true){
   return "Campo Frase Recuperação vazio!";
   }
   
   else
   return null;
}
    
public String confirmaERRO(String login, String senha, boolean confirmacao){

   if(campoVazioLogin(login)==true){
   return "Campo Login vazio!";
   }
   
   else if(campoVazioSenha(senha)==true){
   return "Campo Senha vazio!";
   }  
   
   else if (confirmacao){
   return "LOGIN OU SENHA INVÁLIDA";
   }
   
   
  
   
 
   
   else
   return null;
}
    
public String confirmaERRO(String senha, String confirma){

    
   if(campoVazioSenha(senha)==true){
   return "Campo Senha Nova vazio!";
   }  
   
   else if(tamanhoMax(senha)==true){
   return "Senha Nova muito grande! MAX 6";
   }
   
   else if(tamanhoMin(senha)==true){
   return "Senha Nova muito pequena! MIN 4";
   }
   else if(campoVazioSenha(confirma)==true){
   return "Campo Senha Antigo vazio!";
   }  
   
   else if(confereSenhas(senha, confirma) == true)
   {
   return "Senhas não conferem!";
   }

   else
   return null;
}


public String confirmaERROBD(boolean confirma){

    if(confirma == true)
   {
   return "Senha inválida!";
   }

   else
   return null;
}

public boolean confereSenhas(String senha, String confirma){
    if(senha.toString().equals(confirma.toString()) )
        return false;
    
    else return true;
}

public boolean tamanhoMax(String senha){

    if(senha.toString().length()>6)
        return true;    
    
    else  return false;
}

public boolean tamanhoMin(String senha){
 if(senha.toString().length()<4)
        return true;    
    
    else  return false;}

public boolean campoVazioLogin(String login){
    if( (login.isEmpty() == true) || (login == null))
     return true;
    
    else return false;
    
}

public boolean campoVazioSenha( String senha){
if( (senha.isEmpty() == true) || (senha == null))
     return true;
    
    else return false;
    
}

public boolean campoVazioConfirmacao(String confirmacao){
if( (confirmacao.isEmpty() == true) || (confirmacao == null))
     return true;
    
    else return false;

}

public boolean campoVazioFrase( String frase){
if( (frase.isEmpty() == true) || (frase == null))
     return true;
    
    else return false;
}

public boolean existeJogador(boolean compara){
    if(compara)
            return true;
    else
        return false;

}




}
