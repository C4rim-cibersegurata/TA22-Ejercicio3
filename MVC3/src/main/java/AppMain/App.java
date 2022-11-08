package AppMain;

import controllers.*;
import models.*;

public class App 
{
    public static void main( String[] args )
    {
    	//--------------MODELO ------------------
        ConexionSQL csql = new ConexionSQL();
        Cientificos c = new Cientificos();
        Proyectos p = new Proyectos();
        Asignado a = new Asignado();

        ControladorDB cdb = new ControladorDB(csql, c, p, a);
        cdb.iniciarDB();
    }
}
