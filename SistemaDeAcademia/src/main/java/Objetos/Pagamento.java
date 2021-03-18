/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/*
Deyvison Gregório Dias 201835017
Deiverson Mourão Alves Pedroso 201965123A
Pedro Henrique Almeida Cardoso Reis 201835039
*/
 public interface Pagamento {

  public  abstract  double retornaValorPagamento(Cliente cliente);

     public abstract void pagar(Cliente cliente);

}
