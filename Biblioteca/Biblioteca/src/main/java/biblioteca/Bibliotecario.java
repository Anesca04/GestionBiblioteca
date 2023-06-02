package biblioteca;

/**
 * La clase Bibliotecario representa a un bibliotecario en la biblioteca.
 * Hereda los atributos y métodos de la clase Usuario.
 * Además, agrega atributos específicos para el horario de trabajo, sueldo y número de teléfono del bibliotecario.
 * Proporciona métodos para acceder y modificar esta información.
 * También implementa el método toString() para obtener una representación en cadena del bibliotecario.
 * 
 * Esta clase es parte de un programa de gestión de bibliotecas.
 * 
 * @author manbolq
 */
public class Bibliotecario extends Usuario {
    private String horario;       // Horario de trabajo del bibliotecario
    private int sueldo;           // Sueldo del bibliotecario
    private String numTelefono;   // Número de teléfono del bibliotecario
    
    /**
     * Constructor sin parámetros de la clase Bibliotecario.
     * Inicializa los atributos con valores predeterminados.
     * Llama al constructor sin parámetros de la clase padre (Usuario) usando la palabra clave super().
     */
    public Bibliotecario() {
        super();
        this.horario = "";
        this.sueldo = 0;
        this.numTelefono = "";
    }
    
    /**
     * Constructor de la clase Bibliotecario.
     * Inicializa los atributos con los valores especificados.
     * Llama al constructor de la clase padre (Usuario) usando la palabra clave super().
     * 
     * @param nombre Nombre del bibliotecario
     * @param dni DNI del bibliotecario
     * @param edad Edad del bibliotecario
     * @param horario Horario de trabajo del bibliotecario
     * @param sueldo Sueldo del bibliotecario
     * @param numTelefono Número de teléfono del bibliotecario
     */
    public Bibliotecario(String nombre, String dni, int edad, String horario, int sueldo, String numTelefono) {
        super(nombre, dni, edad);
        this.horario = horario;
        this.sueldo = sueldo;
        this.numTelefono = numTelefono;
    }
    
    /**
     * Getter para obtener el horario de trabajo del bibliotecario.
     * 
     * @return El horario de trabajo del bibliotecario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * Getter para obtener el sueldo del bibliotecario.
     * 
     * @return El sueldo del bibliotecario
     */
    public int getSueldo() {
        return sueldo;
    }

    /**
     * Getter para obtener el número de teléfono del bibliotecario.
     * 
     * @return El número de teléfono del bibliotecario
     */
    public String getNumTelefono() {
        return numTelefono;
    }
    
    /**
     * Setter para modificar el horario de trabajo del bibliotecario.
     * 
     * @param horario El nuevo horario de trabajo del bibliotecario
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * Setter para modificar el sueldo del bibliotecario.
     * 
     * @param sueldo El nuevo sueldo del bibliotecario
     */
    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    /**
     * Setter para modificar el número de teléfono del bibliotecario.
     * 
     * @param numTelefono El nuevo número de teléfono del bibliotecario
     */
    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }
    
    /**
     * Método toString() que devuelve una representación en cadena del bibliotecario.
     * La representación incluye la información del bibliotecario y los atributos adicionales (horario, sueldo, número de teléfono).
     * 
     * @return Una cadena que representa al bibliotecario
     */
    @Override
    public String toString() {
        String res = super.toString();  // Llama al método toString() de la clase padre (Usuario)
        res += "\nHorario: " + horario;
        res += "\nSueldo: " + sueldo;
        res += "\nNum. Telefono: " + numTelefono;
        
        return res;
    }
}