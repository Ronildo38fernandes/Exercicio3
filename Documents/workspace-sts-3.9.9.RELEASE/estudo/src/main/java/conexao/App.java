package conexao;

import java.sql.*;
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );
        DAO com = new DAO();
        com.atualizarPessoa(1, "Beatriz", "Sartorio");
        
        
        
    }
}
