package principal;
import views.VentanaPrincipal;

public class Principal {
    public static void main(String[] args) {
        iniciar();
    }
    public static void iniciar(){
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.setVisible(true);
    }
}
