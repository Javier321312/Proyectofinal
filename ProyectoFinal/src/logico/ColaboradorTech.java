package logico;

public class ColaboradorTech {
	private String id;
    private String nombre;
    private String apellidos;
    private String email;
    private char sexo;
    private int edad;
    private String fechaIngreso;
    private String proyectoAsignado;
    
    public ColaboradorTech(String id, String nombre, String apellidos, String email, 
            char sexo, int edad, String fechaIngreso, String proyectoAsignado) {
    	
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.sexo = sexo;
        this.edad = edad;
        this.fechaIngreso = fechaIngreso;
        this.proyectoAsignado = proyectoAsignado;
  }

}
