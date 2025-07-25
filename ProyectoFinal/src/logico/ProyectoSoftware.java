package logico;

public class ProyectoSoftware {
	private String nombre;
    private ArrayList<ColaboradorTech> colaboradores;
    private ArrayList<Cliente> clientesRelaciones;
    private LocalDate fechaInicio;
    private LocalDate fechaFinalizacion;
    
    public ProyectoSoftware(String nombre) {
        this.nombre = nombre;
        this.colaboradores = new ArrayList<>();
        this.clientesRelaciones = new ArrayList<>();
        this.fechaInicio = LocalDate.now();
        this.fechaFinalizacion = LocalDate.now().plusDays(90);
    }
    
    public ProyectoSoftware(String nombre, LocalDate fechaInicio, LocalDate fechaFinalizacion) {
        this.nombre = nombre;
        this.colaboradores = new ArrayList<>();
        this.clientesRelaciones = new ArrayList<>();
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
    }
    
    public long calcularDiasRestantesProyecto() {
        LocalDate hoy = LocalDate.now();
        if (hoy.isBefore(fechaFinalizacion)) {
            return java.time.temporal.ChronoUnit.DAYS.between(hoy, fechaFinalizacion);
        } else if (hoy.isEqual(fechaFinalizacion)) {
            return 0;
        } else {
            return java.time.temporal.ChronoUnit.DAYS.between(fechaFinalizacion, hoy) * -1; 
        }
    }
    
    public String getEstadoProyecto() {
        long diasRestantes = calcularDiasRestantesProyecto();
        if (diasRestantes > 0) {
            return String.format("EN DESARROLLO - %d d�as restantes", diasRestantes);
        } else if (diasRestantes == 0) {
            return "FINALIZACI�N HOY";
        } else {
            return String.format("PROYECTO RETRASADO - %d d�as de retraso", Math.abs(diasRestantes));
        }
    }
    
    public String agregarColaborador(ColaboradorTech colaborador) {
        colaboradores.add(colaborador);
        return "Colaborador " + colaborador.getNombre() + " agregado al proyecto " + nombre;
    }
    
    public String agregarCliente(Cliente cliente) {
        clientesRelaciones.add(cliente);
        return "Cliente " + cliente.getNombre() + " asociado al proyecto " + nombre;
    }
    
    public boolean estaSaturado() {
        return colaboradores.size() >= 10; 
    }
    
    public String getResumenProyecto() {
        StringBuilder resumen = new StringBuilder();
        resumen.append("=== PROYECTO: ").append(nombre).append(" ===\n");
        resumen.append("Estado: ").append(estaSaturado() ? "SATURADO" : "DISPONIBLE").append("\n");
        resumen.append("Fechas: ").append(fechaInicio).append(" - ").append(fechaFinalizacion).append("\n");
        resumen.append("Progreso: ").append(getEstadoProyecto()).append("\n");
        resumen.append("Colaboradores (").append(colaboradores.size()).append("):\n");
        
        for (ColaboradorTech colaborador : colaboradores) {
            resumen.append("- ").append(colaborador.mostrarResumen()).append("\n");
        }
        
        resumen.append("Clientes asociados (").append(clientesRelaciones.size()).append("):\n");
        for (Cliente cliente : clientesRelaciones) {
            resumen.append("- ").append(cliente.getDatosCliente()).append("\n");
        }
        
        return resumen.toString();
    }
    
   
    public String getNombre() { return nombre; }
    public ArrayList<ColaboradorTech> getColaboradores() { return colaboradores; }
    public ArrayList<Cliente> getClientesRelaciones() { return clientesRelaciones; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public LocalDate getFechaFinalizacion() { return fechaFinalizacion; }
    
    
    public void setFechaFinalizacion(LocalDate fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }
}
