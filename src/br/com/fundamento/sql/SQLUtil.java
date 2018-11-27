/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.sql;

public class SQLUtil {

    public static class Produto {

        public static final String NOME = "produto";
        public static final String COL_NOME_PRODUTO = "nome";
        public static final String COL_FABRICANTE = "fabricante";
        public static final String COL_QUANTIDADE_ESTOQUE = "quantidade_estoque";
        public static final String COL_QUANTIDADE_MINIMA = "quantidade_minina";
        public static final String COL_PRECO_COMPRA = "preco_compra";
        public static final String COL_ID_ESTOQUE = "id_estoque";
        public static final String COL_FORNECEDOR_ID = "id_fornecedor";

        public static final String INSERT = "insert into " + NOME + "(" + COL_NOME_PRODUTO + ","
                + COL_FABRICANTE + ","
                + COL_QUANTIDADE_ESTOQUE + ","
                + COL_QUANTIDADE_MINIMA + ","
                + COL_PRECO_COMPRA + ","
                + COL_ID_ESTOQUE + ","
                + COL_FORNECEDOR_ID + "" + ") values (?,?,?,?,?,?,?) ";
    }

    public static class Fornecedor {

        public static final String NOME = "fornecedor";
        public static final String COL_NOME_FORNECEDOR = "nome_fantasia";
        public static final String COL_RAZAO_SOCIAl = "razao_social";
        public static final String COL_CNPJ = "cnpj";
        public static final String COL_ENDERECO = "id_endereco";
         public static final String COL_ID_CONTATO = "id_contato";

        public static final String INSERT = "insert into " + NOME + "(" + COL_NOME_FORNECEDOR + ","
                + COL_RAZAO_SOCIAl + ","
                + COL_CNPJ + ","
                + COL_ENDERECO +"," 
                + COL_ID_CONTATO + "" + ") values (?,?,?,?,?) returning id";
    }

    public static class Medico {

        public static final String NOME = "medico";
        public static final String COL_NOME = "nome";
        public static final String COL_SEXO = "sexo";
        public static final String COL_RG = "rg";
        public static final String COL_ID_CONSULTORIO = "id_consultorio";
        public static final String COL_DATA_CPF = "cpf";
        public static final String COL_DATA_NASCIMENTO = "data_nascimento";
        public static final String COL_DATA_CADASTRO = "data_cadastro";
          public static final String COL_ID_LOGIN = "id_login";
            public static final String COL_ENDERECO = "id_endereco";
             public static final String COL_ID_CONTATO = "id_contato";

        public static final String INSERT = "insert into " + NOME + "(" + COL_NOME + ","
                + COL_SEXO + ","
                + COL_RG + ","
                + COL_ID_CONSULTORIO + ","
                + COL_DATA_CPF + ","
                + COL_DATA_NASCIMENTO + ","
                + COL_DATA_CADASTRO + ","
                 +COL_ID_LOGIN + ","
                + COL_ENDERECO + ","
                + COL_ID_CONTATO + "" + ") values (?,?,?,?,?,?,?,?,?,?) returning id";
    }

    public static class Consulta {

        public static final String NOME = "consulta";
        public static final String COL_DATA_HORA = "data_hora";
        public static final String COL_TIPO = "tipo";
        public static final String COL_AGENDAMENTO = "agendamento";
        public static final String COL_ID_PACIENTE = "id_paciente";
        public static final String COL_ID_MEDICO = "id_medico";
        public static final String COL_ID_CONSULTORIO = "id_consultorio";
        public static final String COL_ID_PAGAMENTO = "id_pagamento";

        public static final String INSERT = "insert into " + NOME + "(" + COL_TIPO + ","
                + COL_AGENDAMENTO + ","
                + COL_ID_PACIENTE + ","
                + COL_ID_MEDICO + ","
                + COL_ID_CONSULTORIO + ","
                + COL_ID_PAGAMENTO + ","
                + COL_DATA_HORA + "" + ") values (?,?,?,?,?,?,?) returning id";
    }

    public static class Funcionario {

        public static final String NOME = "funcionario";
        public static final String COL_NOME = "nome";
        public static final String COL_ID_CAIXA = "id_caixa";
        public static final String COL_CPF = "cpf";
        public static final String COL_SALARIO = "salario";
       public static final String COL_FUNCAO = "funcao";
       public static final String COL_DATA_NASCIMENTO = "data_nascimento";
        public static final String COL_ID_LOGIN = "id_login";
        public static final String COL_ID_ENDERECO = "id_endereco";
         public static final String COL_ID_CONTATO = "id_contato";

        public static final String INSERT = "insert into " + NOME + "(" + COL_NOME + ","
                + COL_ID_CAIXA + ","
                + COL_CPF + ","
                + COL_SALARIO + ","
                + COL_FUNCAO + ","
                + COL_DATA_NASCIMENTO + ","
                + COL_ID_LOGIN + ","
                + COL_ID_ENDERECO +","
                + COL_ID_CONTATO + "" + ") values (?,?,?,?,?,?,?,?,?) returning id";
    }

    public static class Tarefa {

        public static final String NOME = "tarefa";
        public static final String COL_DATA_INICIO = "data_inicio";
        public static final String COL_DATA_TERMINO = "data_termino";
        public static final String COL_DESCRICAO = "descricao";
        public static final String COL_PRIORIDADE = "prioridade";
        public static final String COL_STATUS = "status";
        public static final String COL_ID_FUNCIONARIO = "id_funcionario";

        public static final String INSERT = "insert into " + NOME + "(" + COL_DESCRICAO + ","
                + COL_PRIORIDADE + ","
                + COL_STATUS + ","
                + COL_ID_FUNCIONARIO + ","
                + COL_DATA_INICIO + ","
                + COL_DATA_TERMINO + "" + ") values (?,?,?,?,?,?) returning id";
    }

    public static class Endereco {

        public static final String NOME_TABELA = "endereco";
        public static final String COL_CEP = "cep";
        public static final String COL_RUA = "rua";
        public static final String COL_NUMERO = "numero";
        public static final String COL_BAIRRO = "bairro";
        public static final String COL_MUNICIPIO = "municipio";
        public static final String COL_ESTADO = "estado";
        

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_CEP + ","
                + COL_RUA + ","
                + COL_BAIRRO + ","
                + COL_NUMERO +","
                + COL_MUNICIPIO + ","
                + COL_ESTADO + "" + " ) values (?,?,?,?,?,?) returning id";
    }

    public static class Contato {

        public static final String NOME_TABELA = "contato";
        public static final String COL_EMAIL = "email";
        public static final String COL_TELEFONE = "telefone";
         public static final String COL_CELULAR = "celular";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_EMAIL + ","
                + COL_TELEFONE + ","
                + COL_CELULAR + "" + " ) values (?,?,?) returning id ";
    }

    public static class Login {

        public static final String NOME_TABELA = "login";
        public static final String COL_LOGIN = "usuario";
        public static final String COL_SENHA = "senha";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_LOGIN + ","
                + COL_SENHA + "" + " ) values (?,?) returning id ";
    }

    public static class Estoque {

        public static final String NOME_TABELA = "estoque";
        public static final String COL_DESCRICAO = "descricao";
        public static final String COL_ID_CONSULTORIO = "id_consultorio";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_DESCRICAO +  ","
                + COL_ID_CONSULTORIO + "" + " ) values (?,?) returning id";
    }


    public static class Paciente {

        public static final String NOME_TABELA = "paciente";
        public static final String COL_NOME = "nome";
        public static final String COL_DATA_NASCIMENTO = "data_nascimento";
        public static final String COL_DATA_CADASTRO = "data_cadastro";
        public static final String COL_CPF = "cpf";
        public static final String COL_SEXO = "sexo";
        public static final String COL_RG = "rg";
        public static final String COL_PRONTUARIO_ID = "id_prontuario";
        public static final String COL_ENDERECO_ID = "id_endereco";
        public static final String COL_ID_CONTATO = "id_contato";
        public static final String COL_CONVENIO = "convenio";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_NOME + ","
                + COL_CPF + ","
                + COL_SEXO + ","
                + COL_DATA_NASCIMENTO + ","
                + COL_DATA_CADASTRO + ","
                + COL_RG + ","
                + COL_PRONTUARIO_ID + ","
                + COL_ENDERECO_ID + "," 
                + COL_ID_CONTATO + ","
                + COL_CONVENIO + "" + " ) values (?,?,?,?,?,?,?,?,?,?) returning id";
    
    
    
    
    
    public static String selectPorBusca(String busca) {
 return "select *from "+ NOME_TABELA +" where "+COL_NOME +" like '%"+busca+"%' or " + COL_CPF+" like '%"+busca+"%' or " + 
         COL_SEXO +" like '%"+busca+"%'" ;
    }
    
    }
    
    
    
    

    public static class Pagamento {

        public static final String NOME_TABELA = "pagamento";
        public static final String COL_VALOR_TOTAL = "valor_total";
        public static final String COL_STATUS = "status";
        public static final String COL_FORMA_PAGAMENTO = "forma_pagamento";
        public static final String COL_QUANTIDADE_PARCELAS = "quantidade_parcelas";
        public static final String COL_CAIXA_ID = "id_caixa";
        public static final String COL_DATA_VENCIMENTO = "data_vencimento";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_VALOR_TOTAL + ","
                + COL_STATUS + ","
                + COL_FORMA_PAGAMENTO + ","
                + COL_QUANTIDADE_PARCELAS + ","
                + COL_CAIXA_ID + ","
                + COL_DATA_VENCIMENTO + "" + " ) values (?,?,?,?,?,?) returning id";
    }

    public static class Prontuario {

        public static final String NOME_TABELA = "prontuario";
        public static final String COL_EXAMES = "exames";
        public static final String COL_RECEITAS = "receitas";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_EXAMES + ","
                + COL_RECEITAS + "" + " ) values (?,?) returning id";
    }

    public static class Caixa {

        public static final String NOME_TABELA = "caixa";
        public static final String COL_STATUS = "status";
        public static final String COL_NUMERO = "numero";
        public static final String COL_VALOR_ABERTURA = "valor_abertura";
        public static final String COL_VALOR_FECHAMENTO = "valor_fechamento";
        public static final String COL_LUCRO_DIARIO = "lucro_diario";
        public static final String COL_DATA = "data";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_STATUS + ","
                + COL_NUMERO + ","
                + COL_VALOR_ABERTURA + ","
                + COL_VALOR_FECHAMENTO + ","
                + COL_LUCRO_DIARIO + ","
                + COL_DATA + "" + " ) values (?,?,?,?,?,?) returning id";
    }

    public static class Relatorio {

        public static final String NOME_TABELA = "relatorio";
        public static final String COL_DESCRICAO = "descricao";
        public static final String COL_RELATORIO = "relatorio";
        public static final String COL_FUNCIONARIO_ID = "id_funcionario";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_DESCRICAO + ","
                + COL_RELATORIO + ","
                + COL_FUNCIONARIO_ID + "" + " ) values (?,?,?) returning id";
    }

    public static class SaidaEstoque {

        public static final String NOME_TABELA = "saida_estoque";
        public static final String COL_NOME = "nome";
        public static final String COL_FABRICANTE = "fabricante";
        public static final String COL_QUANTIDADE_SAIDA = "quantidade_saida";
        public static final String COL_ID_ESTOQUE = "id_estoque";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_NOME + ","
                + COL_FABRICANTE + ","
                + COL_QUANTIDADE_SAIDA + ","
                + COL_ID_ESTOQUE + "" + " ) values (?,?,?,?) returning id";
    }

    public static class Especializacao {

        public static final String NOME_TABELA = "especializacao";
        public static final String COL_DESCRICAO = "descricao";
        public static final String COL_HORARIO_DISPONIVEL = "horario_disponivel";
        public static final String COL_SALARIO = "salario";
        public static final String COL_ID_MEDICO = "id_medico";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_DESCRICAO + ","
                + COL_SALARIO + ","
                + COL_ID_MEDICO + ","
                + COL_HORARIO_DISPONIVEL + "" + " ) values (?,?,?,?) returning id";
    }

    public static class Parcela {

        public static final String NOME_TABELA = "parcela";
        public static final String COL_VALOR = "valor";
        public static final String COL_DATA_VENCIMENTO = "data_vencimento";
        public static final String COL_STATUS = "status";
        public static final String COL_NUMERO = "numero";
        public static final String COL_PARCELA_UNICA = "parcela_unica";
        public static final String COL_ID_PAGAMENTO = "id_pagamento";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_VALOR + ","
                + COL_STATUS + ","
                + COL_NUMERO + ","
                + COL_PARCELA_UNICA + ","
                + COL_ID_PAGAMENTO + ","
                + COL_DATA_VENCIMENTO + "" + " ) values (?,?,?,?,?,?) returning id";
    }

    public static class Consultorio {

        public static final String NOME = "consultorio";
        public static final String COL_NOME_fANTASIA = "nome_fantasia";
        public static final String COL_RAZAO_SOCIAl = "razao_social";
        public static final String COL_CNPJ = "cnpj";
        public static final String COL_ID_ENDERECO = "id_endereco";
        public static final String COL_ID_CONTATO = "id_contato";

        public static final String INSERT = "insert into " + NOME + "(" + COL_NOME_fANTASIA + ","
                + COL_RAZAO_SOCIAl + ","
                + COL_CNPJ +","
                + COL_ID_ENDERECO + ","
                + COL_ID_CONTATO + "" + ") values (?,?,?,?,?) returning id";
    }


    public static String selectAll(String nomeTabela) {
        return "select * from " + nomeTabela;
    }

    
    public static String selectById(String nomeTabela, int id) {
        return "select * from " + nomeTabela + " where id = " + id;
    }

}
