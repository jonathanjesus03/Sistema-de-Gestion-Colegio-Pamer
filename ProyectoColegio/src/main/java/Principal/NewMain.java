/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Principal;

import Controlador.ControlLogin;
import Vista.FrmLogin;

/**
 *
 * @author cr075
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
      // FlatGradiantoDeepOceanIJTheme.setup(); //con esto le implementamos el estilo y después clean and build al proyecto
       FrmLogin log=new FrmLogin();
       ControlLogin contr=new ControlLogin(log);
    }
    
}
