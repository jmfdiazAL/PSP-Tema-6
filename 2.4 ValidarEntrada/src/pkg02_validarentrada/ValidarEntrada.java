/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg02_validarentrada;

/**
 *
 * @author ramon
 */
import java.io.*;
import java.util.regex.*;

public class ValidarEntrada {

    public ValidarEntrada() {
        String dni_cliente = new String();
        Pattern pat = null;
        Matcher mat = null;

        // para leer del teclado
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Introduce tu NIF (Formato 00000000-A):");
            dni_cliente = reader.readLine();

            pat = Pattern.compile("[0-9]{8}-[a-zA-Z]");
            mat = pat.matcher(dni_cliente);

            System.out.println("\nfind() => Comprueba si existe alguna coincidencia con la expresión regular:\n");
            
            // Comprobar si hay alguna coincidencia con el formato del NIF:
            // por ejemplo si introduces 12345678-ABCCBB12121212
            // hay una coincidencia ya que contiene 12345678-A que es correcto
            if (mat.find()) {
                System.out.println("Existe alguna coincidencia con el formato NIF, pero no podemos asegurar que sea correcto!!  " + dni_cliente);
            } else {
                System.out.println("El NIF está mal  " + dni_cliente);
            }
            
            
            System.out.println("\nmatches() => Comprueba si coincide exactamente la expresión regular:\n");
            
            // Para hacerlo bien hay que usar matches(), de esta forma nos aseguramos
            // que el patrón es exactamente igual al de la expresión regular
            // en este caso solo admite un NIF válido
            if (mat.matches()) {
                System.out.println("El NIF es correcto!!  " + dni_cliente);
            } else {
                System.out.println("El NIF está mal  " + dni_cliente);
            }
            

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] arg) {
        new ValidarEntrada();
    }

}
