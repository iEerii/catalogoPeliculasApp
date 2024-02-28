package servicio;

import dominio.Pelicula;

import java.io.*;

public class ServicioPeliculasArchivo implements IServicioPeliculas{
    private final String NOMBRE_ARCHIVO = "peliculas.txt";
    public ServicioPeliculasArchivo(){
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            //Para no crear dos veces un archivo existente
            if(archivo.exists()){
                System.out.println("El archivo ya existe");
            } else {
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se ha guardado correctamente");
            }
        }catch (Exception e){
            System.out.println("Ocurrio  un error al abrir el archivo" + e.getMessage());
        }
    }
    @Override
    public void listarPeliculas() {
        //Para abrir el archivo que se cerró anteriormente
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            System.out.println("Listado de Peliculas");
            //Se abre el archivo para lectura
            var entrada = new BufferedReader(new FileReader(archivo));
            //Lectura linea por linea
            String linea;
            linea = entrada.readLine();
            //Para leer todas las lineas
            while(linea != null){
                var pelicula = new Pelicula(linea);
                System.out.println(pelicula);
                //Se vuelve a escribir la siguiente linea antes de terminar el ciclo
                linea = entrada.readLine();
            }
            entrada.close();
        }catch(Exception e){
            System.out.println("Ocurrio un error al leer el archivo" + e.getMessage());
        }
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        boolean anexar = false;
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            //Se verifica la existencia del archivo
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            //Agregar la pelicula(toString)
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se agrego al archivo" + pelicula);
        } catch (Exception e){
            System.out.println("Ocurrio un error al agregar pelicula" + e.getMessage());
        }
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {

    }
}
