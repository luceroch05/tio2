import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javax.swing.table.DefaultTableModel;

public class tabla {
    long dias ;

    
     DefaultTableModel modelo;
    public tabla(DefaultTableModel modelo) {
        this.modelo=modelo;
    }

    
    public void agregandofilas(String nombres,String direccion,String telefono,String dni, String nacimiento) {
    //calcular dias happy
    LocalDate fechahappy, fechahappyActual,fechanow;
    DateTimeFormatter entrafecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
   // DateTimeFormatter salidafecha= DateTimeFormatter.ofPattern("dd/MM");

        
        fechahappy = LocalDate.parse(nacimiento, entrafecha);
        fechanow = LocalDate.now();
        
        // Obtener cumpleaños del año actual
        fechahappyActual = LocalDate.of(fechanow.getYear(), fechahappy.getMonth(), fechahappy.getDayOfMonth());
        dias=ChronoUnit.DAYS.between(fechahappyActual, fechanow);

        
        

       modelo.addRow(new Object[]{nombres,direccion,telefono,dni,nacimiento,dias});
    }

    
}
