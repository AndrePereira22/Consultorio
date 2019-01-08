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
        public static final String COL_PRECO_COMPRA = "preco_compra";
        public static final String COL_ID_ESTOQUE = "id_estoque";
        public static final String COL_FORNECEDOR_ID = "id_fornecedor";

        public static final String INSERT = "insert into " + NOME + "(" + COL_NOME_PRODUTO + ","
                + COL_FABRICANTE + ","
                + COL_QUANTIDADE_ESTOQUE + ","
                + COL_PRECO_COMPRA + ","
                + COL_ID_ESTOQUE + ","
                + COL_FORNECEDOR_ID + "" + ") values (?,?,?,?,?,?) ";

        public static String selectPorBusca(String busca) {
            return "select *from " + NOME + " where ativo=true and (" + COL_NOME_PRODUTO + " like '%" + busca + "%' or " + COL_FABRICANTE + " like '%" + busca + "%' )";
        }

        public static final String updateProduto(String novonome, String novoFabricante, int novaQuantidade, Double novoPreco, int id_estoque, int id_for, int id_parametro) {
            return "UPDATE produto SET  nome ='" + novonome + "', fabricante='" + novoFabricante + "', quantidade_estoque=" + novaQuantidade + ", preco_compra=" + novoPreco + ", id_estoque=" + id_estoque + ", id_fornecedor=" + id_for + " WHERE id = " + id_parametro;

        }

        public static String buscarPorEstoque(String discricao) {
            return "select *from produto p, estoque e where p.id_estoque=e.id and e.descricao='" + discricao + "'";
        }

        public static String desativar(int id) {
            return "UPDATE produto SET ativo=false  WHERE id =" + id + "";
        }
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
                + COL_ENDERECO + ","
                + COL_ID_CONTATO + "" + ") values (?,?,?,?,?) returning id";

        public static String selectPorBusca(String busca) {
            return "select *from " + NOME + " where  ativo=true and (" + COL_RAZAO_SOCIAl + " like '%" + busca + "%' or " + COL_NOME_FORNECEDOR + " like '%" + busca + "%' or "
                    + COL_CNPJ + " like '%" + busca + "%')";
        }

        public static final String updateFornecedor(String novoRazao, String novoCnpj, String novoNome_fantasia, int id_parametro) {
            return "update fornecedor SET razao_social ='" + novoRazao + "',cnpj ='" + novoCnpj + "',nome_fantasia ='" + novoNome_fantasia + "'  WHERE id =" + id_parametro;

        }

        public static String desativar(int id) {
            return "UPDATE fornecedor SET ativo=false  WHERE id =" + id + "";
        }

    }

    public static class Medico {

        public static final String NOME = "medico";
        public static final String COL_NOME = "nome";
        public static final String COL_SEXO = "sexo";
        public static final String COL_RG = "rg";
        public static final String COL_DATA_CPF = "cpf";
        public static final String COL_DATA_NASCIMENTO = "data_nascimento";
        public static final String COL_DATA_CADASTRO = "data_cadastro";
        public static final String COL_CONSELHO = "conselho";
        public static final String COL_NUMERO = "numero";
        public static final String COL_ID_LOGIN = "id_login";
        public static final String COL_ENDERECO = "id_endereco";
        public static final String COL_ID_CONTATO = "id_contato";
        public static final String COL_ID_ESPECIALIZACAO = "id_especializacao";

        public static final String INSERT = "insert into " + NOME + "(" + COL_NOME + ","
                + COL_SEXO + ","
                + COL_RG + ","
                + COL_DATA_CPF + ","
                + COL_DATA_NASCIMENTO + ","
                + COL_DATA_CADASTRO + ","
                + COL_CONSELHO + ","
                + COL_NUMERO + ","
                + COL_ID_LOGIN + ","
                + COL_ENDERECO + ","
                + COL_ID_CONTATO + ","
                + COL_ID_ESPECIALIZACAO + "" + ") values (?,?,?,?,?,?,?,?,?,?,?,?) returning id";

        public static String selectPorBusca(String busca) {
            return "select *from " + NOME + " where ativo=true and ( " + COL_NOME + " like '%" + busca + "%' or " + COL_DATA_CPF + " like '%" + busca + "%' or "
                    + COL_SEXO + " like '%" + busca + "%')";
        }

        public static String buscarMedico(String busca) {
            return "select *from " + NOME + " where ativo=true and ( " + COL_NOME + " like '%" + busca + "%')";
        }

        public static final String updateMedico(String novoNome, String novoCpf, String novoRg, int id_parametro) {
            return "update medico SET nome ='" + novoNome + "', cpf='" + novoCpf + "', rg='" + novoRg + "'   WHERE id =" + id_parametro;

        }

        public static String BuscaMedico(String usuario, String senha) {
            return "select  m.id,m.nome,m.sexo,m.rg,m.cpf,m.data_nascimento,m.data_cadastro,m.conselho,m.numero, m.id_login,m.id_endereco,m.id_contato,m.id_especializacao from medico m, login l where  m.id_login=l.id and l.usuario='" + usuario + "' and l.senha='" + senha + "'";
        }

        public static String desativar(int id) {
            return "UPDATE medico SET ativo=false  WHERE id =" + id;
        }
    }

    public static class Consulta {

        public static final String NOME = "consulta";
        public static final String COL_DATA = "data";
        public static final String COL_HORA = "hora";
        public static final String COL_TIPO = "tipo";
        public static final String COL_ID_PACIENTE = "id_paciente";
        public static final String COL_ID_MEDICO = "id_medico";
        public static final String COL_ID_PAGAMENTO = "id_pagamento";

        public static final String INSERT = "insert into " + NOME + "(" + COL_TIPO + ","
                + COL_DATA + ","
                + COL_HORA + ","
                + COL_ID_PACIENTE + ","
                + COL_ID_MEDICO + ","
                + COL_ID_PAGAMENTO + "" + ") values (?,?,?,?,?,?) returning id";

        public static String selectPorBusca(String busca) {
            return "select *from " + NOME + " where ativo=true and ( " + COL_DATA + " like '%" + busca + "%')";
        }

        public static final String updateConsulta(String novoTipo, String novaData, String novaHora, int id_parametro, int id_medico) {
            return "update consulta SET tipo ='" + novoTipo + "', data='" + novaData + "', hora='" + novaHora + "',id_medico='" + id_medico + "'   WHERE id =" + id_parametro;

        }

        public static final String selectPorMedico(String nome, String data) {
            return "select c.id,c.tipo, c.data, c.hora, c.id_paciente,c.id_medico from consulta c ,medico m where c.id_medico=m.id and m.nome='" + nome + "' and c.data='" + data + "'";
        }

        public static String desativar(int id) {
            return "UPDATE consulta SET ativo=false  WHERE id =" + id;
        }
    }

    public static class Funcionario {

        public static final String NOME = "funcionario";
        public static final String COL_NOME = "nome";
        public static final String COL_CPF = "cpf";
        public static final String COL_SALARIO = "salario";
        public static final String COL_FUNCAO = "funcao";
        public static final String COL_DATA_NASCIMENTO = "data_nascimento";
        public static final String COL_ID_LOGIN = "id_login";
        public static final String COL_ID_ENDERECO = "id_endereco";
        public static final String COL_ID_CONTATO = "id_contato";

        public static final String INSERT = "insert into " + NOME + "(" + COL_NOME + ","
                + COL_CPF + ","
                + COL_SALARIO + ","
                + COL_FUNCAO + ","
                + COL_DATA_NASCIMENTO + ","
                + COL_ID_LOGIN + ","
                + COL_ID_ENDERECO + ","
                + COL_ID_CONTATO + "" + ") values (?,?,?,?,?,?,?,?) returning id";

        public static String selectPorBusca(String busca) {
            return "select *from " + NOME + " where ativo=true and ( " + COL_NOME + " like '%" + busca + "%' or " + COL_FUNCAO + " like '%" + busca + "%' or "
                    + COL_CPF + " like '%" + busca + "%')";
        }

        public static String BuscarFuncionario(String usuario) {
            return "select  * from funcionario f, login l  where ativo=true and ( f.id_login=l.id and l.usuario='" + usuario + "')";
        }

        public static final String updateFuncionario(String novoNome, String novoCpf, double novoSalario, String novaFuncao, int id_parametro) {
            return "update funcionario SET nome ='" + novoNome + "', cpf='" + novoCpf + "', salario=" + novoSalario + ", funcao='" + novaFuncao + "'  WHERE id =" + id_parametro;

        }

        public static String BuscaFuncionario(String usuario, String senha) {
            return "select  f.id,f.nome,f.cpf,f.salario,f.funcao,f.data_nascimento,f.id_login,f.id_endereco,f.id_contato from funcionario f, login l where  f.id_login=l.id and l.usuario='" + usuario + "' and l.senha='" + senha + "'";
        }

        public static String desativar(int id) {
            return "UPDATE funcionario SET ativo=false  WHERE id =" + id + "";
        }
    }

    public static class Tarefa {

        public static final String NOME = "tarefa";
        public static final String COL_DATA_INICIO = "data_inicio";
        public static final String COL_DATA_TERMINO = "data_termino";
        public static final String COL_DESCRICAO = "descricao";
        public static final String COL_PRIORIDADE = "prioridade";
        public static final String COL_STATUS = "status";
        public static final String COL_ID_CONSULTORIO = "id_consultorio";

        public static final String INSERT = "insert into " + NOME + "(" + COL_DESCRICAO + ","
                + COL_PRIORIDADE + ","
                + COL_STATUS + ","
                + COL_DATA_INICIO + ","
                + COL_DATA_TERMINO + ","
                + COL_ID_CONSULTORIO + "" + ") values (?,?,?,?,?,?) returning id";

        public static String selectPorBusca(String busca) {
            return "select *from " + NOME + " where ativo=true and  (" + COL_DESCRICAO + " like '%" + busca + "%' or " + COL_DATA_TERMINO + " like '%" + busca + "%')";
        }

        public static final String updateTarefa(String novaDescricao, int novaPrioridade, boolean novoStatus, String novaDataTermino, int id_parametro) {
            return "UPDATE tarefa SET  descricao='" + novaDescricao + "', prioridade='" + novaPrioridade + "', status='" + novoStatus + "', data_termino='" + novaDataTermino + "'  WHERE id =" + id_parametro;

        }

        public static String desativar(int id) {
            return "UPDATE tarefa SET ativo=false  WHERE id =" + id + "";
        }
    }

    public static class Endereco {

        public static final String NOME_TABELA = "endereco";
        public static final String COL_CEP = "cep";
        public static final String COL_RUA = "rua";
        public static final String COL_NUMERO = "numero";
        public static final String COL_BAIRRO = "bairro";
        public static final String COL_MUNICIPIO = "municipio";
        public static final String COL_ESTADO = "estado";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_RUA + ","
                + COL_CEP + ","
                + COL_BAIRRO + ","
                + COL_NUMERO + ","
                + COL_MUNICIPIO + ","
                + COL_ESTADO + "" + " ) values (?,?,?,?,?,?) returning id";

        public static String buscaEndereco(String tabela, String coluna, String busca) {
            return "select  e.cep,e.rua, e.bairro, e.numero, e.municipio, e.estado from "
                    + tabela + " c, endereco e  where  c.id_endereco=e.id and " + coluna + "='" + busca + "'";

        }

        public static final String updateEnd(String novoCep, String novoRua, String novoNumero, String novoBairro, String novoMunicipio, String novoEstado, int id_parametro) {
            return "UPDATE endereco SET  cep='" + novoCep + "', rua='" + novoRua + "', numero='" + novoNumero + "', bairro='" + novoBairro + "', municipio='" + novoMunicipio
                    + "', estado ='" + novoEstado + "' WHERE id =" + id_parametro;

        }

        public static String desativar(int id) {
            return "UPDATE endereco SET ativo=false  WHERE id =" + id;
        }

    }

    public static class Contato {

        public static final String NOME_TABELA = "contato";
        public static final String COL_EMAIL = "email";
        public static final String COL_TELEFONE = "telefone";
        public static final String COL_CELULAR = "celular";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_EMAIL + ","
                + COL_TELEFONE + ","
                + COL_CELULAR + "" + " ) values (?,?,?) returning id ";

        public static String buscaContato(String tabela, String coluna, String busca) {
            return "select  e.email,e.telefone, e.celular from "
                    + tabela + " c, contato e  where  c.id_contato=e.id and " + coluna + "='" + busca + "'";

        }

        public static final String updateContato(String novoEmail, String novoTelefone, String novoCelular, int id_parametro) {
            return "UPDATE contato SET  email ='" + novoEmail + "', telefone='" + novoTelefone + "', celular='" + novoCelular + "' WHERE id = " + id_parametro;

        }

        public static String desativar(int id) {
            return "UPDATE contato SET ativo=false  WHERE id =" + id;
        }
    }

    public static class Login {

        public static final String NOME_TABELA = "login";
        public static final String COL_LOGIN = "usuario";
        public static final String COL_SENHA = "senha";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_LOGIN + ","
                + COL_SENHA + "" + " ) values (?,?) returning id ";

        public static String BuscaloginFuncionario(String busca) {
            return "select l.id, l.usuario,l.senha from funcionario f, login l " + " where  f.id_login=l.id and l.usuario='" + busca + "'";
        }

        public static String BuscaloginMedico(String paramentro, String busca) {
            return "select l.id, l.usuario,l.senha from medico m, login l " + " where  m.id_login=l.id and " + paramentro + "='" + busca + "'";
        }

        public static final String updateLoString(String novoUsuario, String novaSenha, int id_parametro) {
            return "UPDATE login SET  usuario ='" + novoUsuario + "', senha='" + novaSenha + "' WHERE id = " + id_parametro;

        }

        public static String desativar(int id) {
            return "UPDATE login SET ativo=false  WHERE id =" + id;
        }
    }

    public static class Estoque {

        public static final String NOME_TABELA = "estoque";
        public static final String COL_DESCRICAO = "descricao";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_DESCRICAO
                + "" + " ) values (?) returning id";
    }

    public static class Paciente {

        public static final String NOME_TABELA = "paciente";
        public static final String COL_NOME = "nome";
        public static final String COL_DATA_NASCIMENTO = "data_nascimento";
        public static final String COL_DATA_CADASTRO = "data_cadastro";
        public static final String COL_CPF = "cpf";
        public static final String COL_SEXO = "sexo";
        public static final String COL_RG = "rg";
        public static final String COL_ID_PRONTUARIO = "id_prontuario";
        public static final String COL_ENDERECO_ID = "id_endereco";
        public static final String COL_ID_CONTATO = "id_contato";
        public static final String COL_CONVENIO = "convenio";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_NOME + ","
                + COL_CPF + ","
                + COL_SEXO + ","
                + COL_DATA_NASCIMENTO + ","
                + COL_DATA_CADASTRO + ","
                + COL_RG + ","
                + COL_CONVENIO + ","
                + COL_ENDERECO_ID + ","
                + COL_ID_CONTATO + "" + " ) values (?,?,?,?,?,?,?,?,?) returning id";

        public static String selectPorBusca(String busca) {
            return "select *from " + NOME_TABELA + " where ativo=true and ( " + COL_NOME + " like '%" + busca + "%' or " + COL_CPF + " like '%" + busca + "%' or "
                    + COL_SEXO + " like '%" + busca + "%')";
        }

        public static final String buscarPaciente(String busca) {
            return " select * from  Paciente p where ativo=true and ( p.nome='" + busca + "'  )";

        }

        public static final String updatePaciente(String novoNome, String novoCpf, String novoRg, String novoConvenio, int id_parametro) {
            return "update paciente SET nome ='" + novoNome + "', cpf='" + novoCpf + "', rg='" + novoRg + "' , convenio='" + novoConvenio + "'  WHERE id =" + id_parametro;

        }

        public static String desativar(int id) {
            return "UPDATE paciente SET ativo=false  WHERE id =" + id;
        }

    }

    public static class Pagamento {

        public static final String NOME_TABELA = "pagamento";
        public static final String COL_VALOR_TOTAL = "valor_total";
        public static final String COL_STATUS = "status";
        public static final String COL_FORMA_PAGAMENTO = "forma_pagamento";
        public static final String COL_QUANTIDADE_PARCELAS = "quantidade_parcelas";
        public static final String COL_CAIXA_ID = "id_caixa";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_VALOR_TOTAL + ","
                + COL_STATUS + ","
                + COL_FORMA_PAGAMENTO + ","
                + COL_QUANTIDADE_PARCELAS + ","
                + COL_CAIXA_ID + "" + " ) values (?,?,?,?,?) returning id";

        public static final String buscarpagamento() {
            return " select  p.id,p.valor_total,p.forma_pagamento,p.quantidade_parcelas,t.nome from pagamento  p,consulta c, paciente t where p.ativo=true and (  c.id_pagamento=p.id and c.id_paciente=t.id and p.status=false)";
        }

        public static final String updatePagamento(double valor, String forma, int quantidade, int id) {
            return "update pagamento SET valor_total =" + valor + ", forma_pagamento ='" + forma + "', quantidade_parcelas =" + quantidade + " WHERE id =" + id;

        }

        public static String desativar(int id) {
            return "UPDATE pagamento SET ativo=false  WHERE id =" + id + "";
        }
    }

    public static class Prontuario {

        public static final String NOME_TABELA = "prontuario";
        public static final String COL_EXAMES = "exames";
        public static final String COL_RECEITAS = "receitas";
        public static final String COL_DATA = "data";
        public static final String COL_SINTOMAS = "sintomas";
        public static final String COL_ID_PACIENTE = "id_paciente";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_EXAMES + ","
                + COL_RECEITAS + ","
                + COL_DATA + ","
                + COL_SINTOMAS + ","
                + COL_ID_PACIENTE + "" + " ) values (?,?,?,?,?) returning id";

        public static final String buscaProntuario(String busca) {
            return "select p.id,p.exames,p.receitas from prontuario p, paciente e where ativo=true ( e.id_prontuario=p.id and e.nome='" + busca + "')";
        }

        public static final String prontuarioPaciente(int id) {
            return "select *from prontuario p where p.id_paciente=" + id;
        }
            public static final String updateProntuario(String novoReceita, String novoSintomas, String novoExames, int id_parametro) {
            return "update prontuario SET receitas ='" + novoReceita + "', sintomas='" + novoSintomas + "', exames='" + novoExames + "'   WHERE id =" + id_parametro;

        }

        public static String desativar(int id) {
            return "UPDATE prontuario SET ativo=false  WHERE id =" + id;
        }
    }

    public static class Caixa {

        public static final String NOME_TABELA = "caixa";
        public static final String COL_STATUS = "status";
        public static final String COL_NUMERO = "numero";
        public static final String COL_VALOR_ABERTURA = "valor_abertura";
        public static final String COL_VALOR_FECHAMENTO = "valor_fechamento";
        public static final String COL_LUCRO_DIARIO = "lucro_diario";
        public static final String COL_DATA = "data";
        public static final String COL_ID_FUNCIONARIO = "id_funcionario";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_STATUS + ","
                + COL_NUMERO + ","
                + COL_VALOR_ABERTURA + ","
                + COL_VALOR_FECHAMENTO + ","
                + COL_LUCRO_DIARIO + ","
                + COL_DATA + ","
                + COL_ID_FUNCIONARIO + "" + " ) values (?,?,?,?,?,?,?) returning id";
        
        public static final String caixaPorData(String data) {
            return "select c.id, c.status,c.numero,c.valor_abertura, c.valor_fechamento,c.lucro_diario,c.data,c.id_funcionario from caixa c  where c.data='"+data+"'";
        }
    }

    public static class Relatorio {

        public static final String NOME_TABELA = "relatorio";
        public static final String COL_DESCRICAO = "descricao";
        public static final String COL_RELATORIO = "relatorio";
        public static final String COL_ID_CONSULTORIO = "id_consultorio";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_DESCRICAO + ","
                + COL_RELATORIO + ","
                + COL_ID_CONSULTORIO + "" + " ) values (?,?,?) returning id";
    }

    public static class SaidaEstoque {

        public static final String NOME_TABELA = "saida_estoque";
        public static final String COL_DATA = "data";
        public static final String COL_QUANTIDADE_SAIDA = "quantidade_saida";
        public static final String COL_ID_PRODUTO = "id_produto";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_DATA + ","
                + COL_QUANTIDADE_SAIDA + ","
                + COL_ID_PRODUTO + "" + " ) values (?,?,?) returning id";

    }

    public static class EntradaEstoque {

        public static final String NOME_TABELA = "entrada_estoque";
        public static final String COL_DATA = "data";
        public static final String COL_QUANTIDADE_ENTRADA = "quantidade";
        public static final String COL_ID_PRODUTO = "id_produto";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_DATA + ","
                + COL_QUANTIDADE_ENTRADA + ","
                + COL_ID_PRODUTO + "" + " ) values (?,?,?) returning id";

    }

    public static class ContaPagar {

        public static final String NOME_TABELA = "conta_pagar";
        public static final String COL_VENCIMENTO = "vencimento";
        public static final String COL_DESCRICAO = "descricao";
        public static final String COL_VALOR = "valor";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_VENCIMENTO + ","
                + COL_DESCRICAO + ","
                + COL_VALOR + "" + " ) values (?,?,?) returning id";

        public static String desativar(int id) {
            return "UPDATE conta_pagar SET ativo=false  WHERE id =" + id;
        }

    }

    public static class Especializacao {

        public static final String NOME_TABELA = "especializacao";
        public static final String COL_DESCRICAO = "descricao";
        public static final String COL_HORARIO_DISPONIVEL = "horario_disponivel";
        public static final String COL_SALARIO = "salario";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_DESCRICAO + ","
                + COL_SALARIO + ","
                + COL_HORARIO_DISPONIVEL + "" + " ) values (?,?,?) returning id";

        public static final String buscarEspecializacao(String busca) {
            return "select e.id,e.descricao, e.salario, e.horario_disponivel  from  especializacao e, medico m  where  (  m.id_especializacao=e.id and m.nome='" + busca + "')";
        }

        public static final String updateEspecializacao(String novaDescricao, Double novoSalario, String novoHorario, int id) {
            return "update especializacao SET descricao ='" + novaDescricao + "',salario =" + novoSalario + ",horario_disponivel ='" + novoHorario + "'  WHERE id=" + id;

        }

        public static String desativar(int id) {
            return "UPDATE especializacao SET ativo=false  WHERE id =" + id;
        }

    }

    public static class Parcela {

        public static final String NOME_TABELA = "parcela";
        public static final String COL_VALOR = "valor";
        public static final String COL_DATA_VENCIMENTO = "data_vencimento";
        public static final String COL_STATUS = "pago";
        public static final String COL_NUMERO = "numero";
        public static final String COL_ID_PAGAMENTO = "id_pagamento";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_VALOR + ","
                + COL_STATUS + ","
                + COL_NUMERO + ","
                + COL_DATA_VENCIMENTO + ","
                + COL_ID_PAGAMENTO + "" + " ) values (?,?,?,?,?) returning id";

        public static final String busacarParcelas(int id) {
            return "select * from  parcela pa where pa.id_pagamento=" + id + "";
        }

        public static final String updateParcela(boolean status, int id) {
            return "update parcela SET pago ='" + status + "'  WHERE id =" + id;

        }
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
                + COL_CNPJ + ","
                + COL_ID_ENDERECO + ","
                + COL_ID_CONTATO + "" + ") values (?,?,?,?,?) returning id";

        public static String BuscaConsultorio() {
            return " select * from " + NOME + " where id = (select max(id) from consultorio)";

        }

        public static final String updateConsultorio(String novoRazao, String novoCnpj, String novoNome_fantasia) {
            return "update consultorio SET razao_social ='" + novoRazao + "',cnpj ='" + novoCnpj + "',nome_fantasia ='" + novoNome_fantasia + "'  WHERE id =1";

        }

    }

    public static String selectAll(String nomeTabela) {
        return "select * from " + nomeTabela + " where ativo=true";
    }

    public static String selectById(String nomeTabela, int id) {
        return "select * from " + nomeTabela + " where id = " + id + " and ativo=true";
    }

}
