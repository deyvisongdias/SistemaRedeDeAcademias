/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author deive
 */
 public interface Pagamento {

  public  abstract  double retornaValorPagamento(Cliente cliente);

     public abstract void pagar(Cliente cliente);

}
