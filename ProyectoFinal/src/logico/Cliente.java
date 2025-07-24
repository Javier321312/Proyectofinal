package logico;

public class Cliente {
private String nombre;
	    private String contacto;
	    
	    public Cliente(String nombre, String contacto) {
	        this.nombre = nombre;
	        this.contacto = contacto;
	    }
	    
	    public String agregarProyecto(String nombreProyecto) {
	        return "Proyecto '" + nombreProyecto + "' agregado para cliente: " + nombre;
	    }
	    
	    public String getCalidadProyectos() {
	        return "Evaluando calidad de proyectos para cliente: " + nombre;
	    }
	    
	    public String getDatosCliente() {
	        return String.format("Cliente: %s - Contacto: %s", nombre, contacto);
	    }
	    
	 
	    public String getNombre() { return nombre; }
	    public String getContacto() { return contacto; }
}
