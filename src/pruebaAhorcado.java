import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class pruebaAhorcado {
  public static void main(String[] args) {

    String secreto = getPalabra();
    char [] cubreGuion = getGuiones(secreto);

    boolean finJuego = false;
    Scanner in = new Scanner(System.in);
    int intentos=3;

    do {
      System.out.println("Tienes "+intentos+" intentos");
      System.out.println(cubreGuion);
      System.out.println("Introduce una letra");
      char letra = in.next().charAt(0);
      boolean acierto = false;
      for(int i=0; i<secreto.length();i++){
       if (letra==secreto.charAt(i)){
         cubreGuion[i]=letra;
         acierto=true;
       }
      }
      if(!acierto){
        System.out.println("No acerto ninguna");
        --intentos;
        if(intentos==0){
          System.out.println("Intentos Agotados");
          finJuego=true;
                }
      } else{
        boolean victoria = !hayGuion(cubreGuion);
        if(victoria){
          System.out.println("Juego acabado");
          finJuego=true;
        } //if se comprueba si no hay guiones
      }
    } while (!finJuego);
    // String palabra1 = "carro", palabra2 = "peligroso", palabra3 = "Elemento nuevo";
     // ArrayList<secretoAhorcado> palabraSecreta = new ArrayList<>();
  }
  static String getPalabra(){
    String[] palabras = {"hola mundo", "elemento nuevo", "destripando la historia"};
    int indice = numeroAleatorioEnRango(0, palabras.length - 1);
    return palabras[indice];
  }
  static char [] getGuiones(String palabras){
    int longitudSecreto = palabras.length();
    char[] cubreGuion = new char[longitudSecreto];
    for (int i = 0; i < cubreGuion.length; i++) {
      if (palabras.charAt(i)==' '){
        cubreGuion[i]=' ';
      }
      else{
      cubreGuion[i] = '-';}
    }
    return cubreGuion;
  }

  static boolean hayGuion(char[] arreglo){
    for (char c:arreglo){
     if (c=='-'){        return true;          }
    }
    return false;
  }
  public static int numeroAleatorioEnRango(int minimo, int maximo) {
    // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
    return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
  }
}
