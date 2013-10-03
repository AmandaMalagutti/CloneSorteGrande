/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sorteGrande;

import conexao.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.jws.WebService;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 3610
 */
@WebService(serviceName = "SorteGrande")
public class SorteGrande {

    private Conexao conect;

    /**
     * This is a sample web service operation
     */
    private boolean existeElemento(int v[], int elemento) {
        for (int i = 0; i < v.length; i++) {
            if (v[i] == elemento) {
                return true;
            }
        }
        return false;
    }

    public String quina(int qtNumeros) {
        int v[] = new int[qtNumeros];
        int valorMax = 80, valorSorteado, i = 0;
        String resp = "";
        if (!(qtNumeros == 5 || qtNumeros == 6 || qtNumeros == 7)) {
            return "Erro, na quina deve-se marcar 5, 6 ou 7 numeros "
                    + "(sao 80 disponiveis).";
        }
        do {
            valorSorteado = 1 + (int) (Math.random() * valorMax);
            if (!existeElemento(v, valorSorteado)) {
                v[i] = valorSorteado;
                i++;
            }
        } while (i < qtNumeros);

        Arrays.sort(v);
        for (i = 0; i < qtNumeros; i++) {
            resp += v[i] + " ";
        }

        return "Os numeros da sorte sao: " + resp;
    }

    public String megaSena(int qtNumeros) {
        int v[] = new int[qtNumeros];
        int valorMax = 60, valorSorteado, i = 0;
        String resp = "";
        if (qtNumeros < 6) {
            return "Erro, na mega sena deve-se marcar de 6 a 15 numeros "
                    + " (sao 60 disponiveis).";
        }
        if (qtNumeros > 15) {
            return "Erro, quantidade de numeros marcados deve ser inferior a 15";
        }
        do {
            valorSorteado = 1 + (int) (Math.random() * valorMax);
            if (!existeElemento(v, valorSorteado)) {
                v[i] = valorSorteado;
                i++;
            }
        } while (i < qtNumeros);
        Arrays.sort(v);
        for (i = 0; i < qtNumeros; i++) {
            resp += v[i] + " ";
        }
        return "Os numeros da sorte sao: " + resp;
    }

    public String getListaResultado(int tipo) {
        String resultados_str = "";
        try {
            conect.iniciarConexao();
            Statement stm = conect.getConnection().createStatement();
            ResultSet rs;
            
            switch (tipo){
                case 1:
                    rs = stm.executeQuery("SELECT id,data,result_mega as result FROM resultados ORDER BY id DESC limit 5");
                break;
                case 2:
                    rs = stm.executeQuery("SELECT id,data,result_quina as result FROM resultados ORDER BY id DESC limit 5");
                break;
                default:
                   return "Tipo invalido para a funcao getListaResultado(tipo)"; 
            }
            while(rs.next()){
                resultados_str = resultados_str + "Data: " + rs.getString("data") + "Numeros: " + rs.getString("result") + " // ";
            }
            conect.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(SorteGrande.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultados_str;
    }
}
