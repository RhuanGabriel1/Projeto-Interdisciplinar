package com.example.imed.Controllers.Adm;
import android.content.Context;
import android.widget.Toast;
import com.example.imed.Database.ClasseDAO;


public class AdmLoginController {
    
    private String login;
    private String password;
    private ClasseDAO dao ;
    private Context context;

    public AdmLoginController(String login, String password, Context context) {
        this.login = login;
        this.password = password;
        this.context = context;
        this.dao = new ClasseDAO(context);
    }

    public boolean makeLogin(){
        try{
            if(dao.obterLoginAdm(login)[0].toString().equals(password)){
                Toast.makeText(context, "Login efetuado com sucesso", Toast.LENGTH_SHORT).show();
                return true;
            }else{
                Toast.makeText(context, "Dados incorretos!", Toast.LENGTH_SHORT).show();
                return false;
            }
        }catch (NullPointerException e){
            Toast.makeText(context, "Dados incorretos!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
