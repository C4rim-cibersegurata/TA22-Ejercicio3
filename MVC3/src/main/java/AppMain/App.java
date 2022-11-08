package AppMain;

import controllers.*;
import models.*;
import views.*;

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
        
        //----------VISTA-----------------------
        PanelFormularios pf = new PanelFormularios();
        PanelOpciones po = new PanelOpciones();
        ClienteFrame cf = new ClienteFrame(po, pf);
        
        ControladorVista cv = new ControladorVista(cf, po, pf);
        
        cv.iniciarVista();
        
    }
}
