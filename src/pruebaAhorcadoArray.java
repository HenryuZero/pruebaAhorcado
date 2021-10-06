import java.util.*;

import secretoAhorcado.secretoAhorcado;

public class pruebaAhorcadoArray {
  static Scanner in = new Scanner(System.in);
  static ArrayList<secretoAhorcado> secretoArray = new ArrayList<>();
  static secretoAhorcado escondido;
  static private String palabraAdivinar ;
  static char [] cubreGuion;
  static int intentos=3;
  public static final String REGEX_LETRAS = "[a-zA-Z\\s]*";

  public enum Mensajes {
    MENSAJE_BIENVENIDA("Bienvenido. Elija la opción que desee realizar"),
    MENSAJE_ERROR("Error, favor de introducir valores válidos"),
    MENSAJE_INSERCION("Palabra(s) a introducir: "),
    MENSAJE_DERROTA("Intentos Agotados"),
    MENSAJE_FIN_DE_JUEGO("Juego acabado");

    private final String MESSAGE_CONTENT;
    Mensajes(String MESSAGE_CONTENT) {
      this.MESSAGE_CONTENT = MESSAGE_CONTENT;
    }
    public String getMESSAGE_CONTENT() {
      return MESSAGE_CONTENT;
    }
  }

  public static void main(String[] args) {
    llenandoArray();
    Inicio();
    }
  private static void Inicio(){
    int eleccion = 0;
    System.out.println(Mensajes.MENSAJE_BIENVENIDA.getMESSAGE_CONTENT());
    System.out.println(menu.OPCION_1.getNUMBEROPT() + menu.OPCION_1.getNAMEOPT());
    System.out.println(menu.OPCION_2.getNUMBEROPT() + menu.OPCION_2.getNAMEOPT());
    System.out.println(menu.OPCION_3.getNUMBEROPT() + menu.OPCION_3.getNAMEOPT());
    System.out.println(menu.OPCION_4.getNUMBEROPT() + menu.OPCION_4.getNAMEOPT());
    try {
      eleccion = in.nextInt();
      switch (eleccion) {
        case 1:
          jugar();
          break;
        case 2:
          introducir();
          break;
        case 3:
          listar();
          break;
        case 4:
          System.exit(0); break;
        default:
          System.out.println("Favor de introducir un número válido");
          Inicio();
          break;
      }
    } catch (InputMismatchException e) {
      System.out.println(Mensajes.MENSAJE_ERROR.getMESSAGE_CONTENT());
      in.nextLine();
    }
    if (eleccion >= 0) {
      Inicio();
    }
  }
  private static void jugar(){
    palabraAdivinar = getPalabra();
    cubreGuion = getGuiones(palabraAdivinar);
    boolean finJuego = false;
    do {
      System.out.println("Tienes "+intentos+" intentos");
      System.out.println(cubreGuion);
      System.out.println("Introduce una letra");
      char letra = in.next().charAt(0);
      boolean acierto = false;
      for(int i=0; i<palabraAdivinar.length();i++){
        char p1 =Character.toLowerCase(letra);
        char p2= Character.toLowerCase(palabraAdivinar.charAt(i));
        if (p1==p2){
          cubreGuion[i]=palabraAdivinar.charAt(i);
          acierto=true;
        }
      }
      if(!acierto){
        System.out.println("No acerto ninguna");
        --intentos;
        if(intentos==0){
          System.out.println(Mensajes.MENSAJE_DERROTA.getMESSAGE_CONTENT());
          finJuego=true;
        }
      } else{
        boolean victoria = !hayGuion(cubreGuion);//se comprueba si ya no hay guiones
        if(victoria){
          System.out.println(Mensajes.MENSAJE_FIN_DE_JUEGO.getMESSAGE_CONTENT());
          finJuego=true;
        }
      }
    } while (!finJuego);
  }

  private static void introducir(){
    escondido = new secretoAhorcado();
    do {
      System.out.print(Mensajes.MENSAJE_INSERCION.getMESSAGE_CONTENT());
      in.nextLine();
      escondido.setWord(in.nextLine());
    } while (!escondido.getWord().matches(REGEX_LETRAS));
    secretoArray.add(escondido);
  }

  public static int numeroAleatorioEnRango() {
    Random rand = new Random();
    int nAleatorio = rand.nextInt(secretoArray.size());
    return nAleatorio;
  }
  static String getPalabra(){
    int indice=0;
    indice = numeroAleatorioEnRango();
    System.out.println(indice);
    String getFrase=secretoArray.get(indice).getWord();
    return getFrase;
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
  private static void llenandoArray(){
    escondido = new secretoAhorcado();
      escondido.setWord ("hola mundo");
    secretoArray.add(escondido);
    /*  escondido.setWord ("elemento nuevo");
    secretoArray.add(escondido);
      escondido.setWord ("destripando la historia");
    secretoArray.add(escondido);*/
  }

  public static void listar(){
   secretoArray.forEach(
           ahorcadoDTO -> {
             System.out.println(ahorcadoDTO);
           });
  }
}
