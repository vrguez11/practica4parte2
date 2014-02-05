package pokercartas;

import java.util.Random;

public class BarajaFrancesa {

    private CartaFrancesa[] baraja;
    private int posicionSiguienteCartaReparto;
    private static final int MAX_NUMERO = 13;
    private static final int NUM_PALOS = 4;
    private static final int NUM_COMODINES = 2;
    public static final int NUM_CARTAS = MAX_NUMERO*NUM_PALOS+NUM_COMODINES;
            
    public BarajaFrancesa() {
        baraja = new CartaFrancesa[NUM_CARTAS];
        posicionSiguienteCartaReparto = 0;
        int[] listaNumCartas = new int[NUM_CARTAS];
        for(int i=0; i<NUM_CARTAS; i++) {
            listaNumCartas[i] = i;
        }
        for(int i=0; i<NUM_CARTAS; i++) {
            baraja[i] = numToCarta(listaNumCartas[i]);
        }
    }
    
    public void barajar() {
        posicionSiguienteCartaReparto = 0;
        int[] listaNumCartas = new int[NUM_CARTAS];
        Random random = new Random();
        for(int i=0; i<NUM_CARTAS; i++) {
            boolean numRepetido;
            int nuevoNum;
            do {
                numRepetido = false;
                nuevoNum = random.nextInt(NUM_CARTAS);
                for(int j=0; j<i; j++) {
                    if(nuevoNum==listaNumCartas[j]) {
                        numRepetido = true;
                    }
                }
            } while(numRepetido);
            listaNumCartas[i] = nuevoNum;
        }    
        for(int i=0; i<NUM_CARTAS; i++) {
            baraja[i] = numToCarta(listaNumCartas[i]);
        }
    }
    
    @Override
    public String toString() {
        String retorno = "";
        for(int i=0; i<NUM_CARTAS; i++) {
            retorno += baraja[i].toString() + "\n";
        }
        return retorno;
    }
    
    public CartaFrancesa nextCarta() {
        if(posicionSiguienteCartaReparto<NUM_CARTAS) {
            return baraja[posicionSiguienteCartaReparto++];
        } else {
            return null;
        }
    }
    
    public CartaFrancesa numToCarta(int num) {
        if(num<0 || num>=NUM_CARTAS) {
            return null;
        } else {
            int palo = num/MAX_NUMERO;
            int numCarta = num%MAX_NUMERO;
            CartaFrancesa carta = new CartaFrancesa(palo, numCarta);
            return carta;
        }
    }
}
