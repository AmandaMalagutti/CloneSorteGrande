/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sorteGrande;

/**
 *
 * @author 3610
 */
public class Resultado {
    private int id;
    private String resultado;
    private String tipo;

    public Resultado(int id, String resultado, String tipo) {
        this.id = id;
        this.resultado = resultado;
        this.tipo = tipo;
    }

       
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
