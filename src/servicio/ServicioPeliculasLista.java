package servicio;

import dominio.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ServicioPeliculasLista implements IServicioPeliculas{

    private final List<Pelicula> peliculas;

    public ServicioPeliculasLista(){
        this.peliculas = new ArrayList<>();
    }

    @Override
    public void listarPeliculas() {
        System.out.println("Listado de Peliculas...");
        peliculas.forEach(System.out::println
        );
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Se agregó la pelicula: " + pelicula);
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        //Regresa el indice de la pelicula encontrada en la lista
        var indice = peliculas.indexOf(pelicula);
        if(indice == -1)
            System.out.println("No se encontró la pelicula: " + pelicula);
        else
            System.out.println("Pelicula encontrada en el indice: " + indice);
    }

    public static void main(String[] args) {
        //se crea el objeto de tipo pelicula
        var pelicula1 = new Pelicula("500 días con ella");
        var pelicula2 = new Pelicula("superman");
        //Se crea el servicio
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();
        //Se agregan las peliculas a la lista
        servicioPeliculas.agregarPelicula(pelicula1);
        servicioPeliculas.agregarPelicula(pelicula2);
        //Se enlistan las peliculas
        servicioPeliculas.listarPeliculas();
        //Para buscar una pelicula se implementa el metodo equals y hashCode
        servicioPeliculas.buscarPelicula(new Pelicula("supercool"));
    }
}
